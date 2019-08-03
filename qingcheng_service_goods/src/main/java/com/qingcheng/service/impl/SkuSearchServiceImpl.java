package com.qingcheng.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qingcheng.dao.BrandMapper;
import com.qingcheng.dao.SpecMapper;
import com.qingcheng.service.goods.SkuSearchService;
import com.qingcheng.util.CacheKey;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SkuSearchServiceImpl implements SkuSearchService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private SpecMapper specMapper;

    @Autowired
    private RedisTemplate redisTemplate;


    public Map search(Map<String,String> searchMap) {

        //1.封装查询请求
        SearchRequest searchRequest=new SearchRequest("sku");
        searchRequest.types("doc"); //设置查询的类型

        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();//布尔查询构建器

        //1.1 关键字搜索
        MatchQueryBuilder matchQueryBuilder= QueryBuilders.matchQuery("name",searchMap.get("keywords"));
        boolQueryBuilder.must(matchQueryBuilder);
        //1.2 商品分类过滤
        if(searchMap.get("category")!=null){
            TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("categoryName", searchMap.get("category"));
            boolQueryBuilder.filter(termQueryBuilder);
        }
        //1.3 品牌过滤
        if(searchMap.get("brand")!=null){
            TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("brandName", searchMap.get("brand"));
            boolQueryBuilder.filter(termQueryBuilder);
        }
        //1.4 规格过滤
        for(String key: searchMap.keySet() ){
            if( key.startsWith("spec.") ){//如果是规格参数
                TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery(key+".keyword", searchMap.get(key));
                boolQueryBuilder.filter(termQueryBuilder);
            }
        }
        //1.5 价格过滤
        if(searchMap.get("price")!=null ){
            String[] price = searchMap.get("price").split("-");
            if(!price[0].equals("0")){ //最低价格不等于0
                RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("price").gte(price[0] + "00");
                boolQueryBuilder.filter(rangeQueryBuilder);
            }
            if(!price[1].equals("*")){ //如果价格由上限
                RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("price").lte(price[1] + "00");
                boolQueryBuilder.filter(rangeQueryBuilder);
            }
        }
        searchSourceBuilder.query(boolQueryBuilder);

        //分页
        Integer pageNo =  Integer.parseInt( searchMap.get("pageNo") );//页码
        Integer pageSize=30;//页大小
        int fromIndex= (pageNo-1) *pageSize;  //计算开始索引

        searchSourceBuilder.from(fromIndex);//开始索引设置
        searchSourceBuilder.size(pageSize);//每页记录数设置

        //排序
        String sort = searchMap.get("sort");//排序字段
        String sortOrder = searchMap.get("sortOrder");//排序规则
        if(!"".equals(sort)){
            searchSourceBuilder.sort(sort, SortOrder.valueOf(sortOrder));
        }

        //高亮设置
        HighlightBuilder highlightBuilder=new HighlightBuilder();
        highlightBuilder.field("name").preTags("<font style='color:red'>").postTags("</font>");
        searchSourceBuilder.highlighter(highlightBuilder);

        searchRequest.source(searchSourceBuilder);

        //聚合查询（商品分类）
        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("sku_category").field("categoryName");
        searchSourceBuilder.aggregation(termsAggregationBuilder);

        //2.封装查询结果
        Map resultMap=new HashMap();
        try {
            SearchResponse searchResponse  = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits searchHits = searchResponse.getHits();
            long totalHits = searchHits.getTotalHits();
            System.out.println("记录数："+totalHits);
            SearchHit[] hits = searchHits.getHits();

            //2.1 商品列表
            List<Map<String,Object>> resultList=new ArrayList<Map<String, Object>>();
            for(SearchHit hit:hits){
                Map<String, Object> skuMap = hit.getSourceAsMap();

                //name高亮处理
                Map<String, HighlightField> highlightFields = hit.getHighlightFields();
                HighlightField name = highlightFields.get("name");
                Text[] fragments = name.fragments();
                skuMap.put("name",fragments[0].toString());//用高亮的内容替换原内容
                resultList.add(skuMap);
            }
            resultMap.put("rows",resultList);

            //2.2 商品分类列表
            Aggregations aggregations = searchResponse.getAggregations();
            Map<String, Aggregation> aggregationMap = aggregations.getAsMap();
            Terms terms = (Terms) aggregationMap.get("sku_category");

            List<? extends Terms.Bucket> buckets =  terms.getBuckets();
            List<String> categoryList=new ArrayList();
            for( Terms.Bucket bucket:buckets ){
                categoryList.add(bucket.getKeyAsString());
            }
            resultMap.put("categoryList",categoryList);

            String categoryName = "";//商品分类名称
            if (searchMap.get("category") == null) { // 如果没有分类条件
                if (categoryList.size() > 0) {
                    categoryName = categoryList.get(0);//提取分类列表的第一个分类
                }
            } else {
                categoryName = searchMap.get("category");//取出参数中的分类
            }
            //2.3 品牌列表
            if(searchMap.get("brand")==null) {
                //List<Map> brandList = brandMapper.findListByCategoryName(categoryName);//查询品牌列表
                List<Map> brandList =(List<Map>)  redisTemplate.boundHashOps( CacheKey.BRAND_LIST ).get(categoryName  );//从缓存查询品牌列表
                resultMap.put("brandList", brandList);
            }

            //2.4 规格列表
            //List<Map> specList = specMapper.findListByCategoryName(categoryName);//规格列表
            List<Map> specList =(List<Map>)  redisTemplate.boundHashOps( CacheKey.SPEC_LIST ).get(categoryName  );//从缓存查询规格列表
            for(Map spec:specList){
                String[] options = ((String) spec.get("options")).split(",");//规格选项列表
                spec.put("options",options);
            }
            resultMap.put("specList",specList);

            //2.5 页码
            long totalCount = searchHits.getTotalHits();  //总记录数
            long pageCount = (totalCount%pageSize==0 )?totalCount/pageSize:(totalCount/pageSize+1);//总页数
            resultMap.put("totalPages",pageCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultMap;
    }



}
