package com.qingcheng.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.qingcheng.pojo.goods.Sku;
import com.qingcheng.service.goods.ImportSku;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ImportSkuImpl implements ImportSku {



    @Autowired
    private RestHighLevelClient restHighLevelClient;


    public void importSkuList(List<Sku> skuList) {
        System.out.println("开始导入索引库");
        //2.构建BulkRequest
        BulkRequest bulkRequest = new BulkRequest();
        for (Sku sku : skuList) {
            if("1".equals(sku.getStatus())){
                IndexRequest indexRequest = new IndexRequest("sku", "doc", sku.getId().toString());
                Map skuMap=new HashMap();
                skuMap.put("name",sku.getName());
                skuMap.put("brandName",sku.getBrandName());
                skuMap.put("categoryName",sku.getCategoryName());
                skuMap.put("image",sku.getImage());
                skuMap.put("price",sku.getPrice());
                skuMap.put("createTime",sku.getCreateTime());
                skuMap.put("saleNum",sku.getSaleNum());
                skuMap.put("commentNum",sku.getCommentNum());
                skuMap.put("spec", JSON.parseObject(sku.getSpec(),Map.class) );
                indexRequest.source(skuMap);
                bulkRequest.add(indexRequest);
            }
        }
        //BulkResponse BulkResponse= restHighLevelClient.bulk(bulkRequest);  同步调用方式
        //异步调用方式
        restHighLevelClient.bulkAsync(bulkRequest,new ActionListener<BulkResponse>() {

            public void onResponse(BulkResponse bulkResponse) {
                //成功
                System.out.println("导入成功"+bulkResponse.status());
            }

            public void onFailure(Exception e) {
                //失败
                System.out.println("导入失败"+e.getMessage());
            }
        });
        System.out.println("调用完成");
    }
}
