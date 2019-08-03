package com.qingcheng.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.service.goods.SkuSearchService;
import com.qingcheng.util.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Map;

@Controller
public class SearchController {

    @Reference
    private SkuSearchService skuSearchService;

    @GetMapping("/search")
    public String search(Model model,@RequestParam Map<String, String> searchMap ) throws Exception {
        //字符集处理(解决中文乱码问题)
        searchMap=WebUtil.convertCharsetToUTF8(searchMap);

        // 页码容错 没有页码，默认为1
        if(searchMap.get("pageNo")==null){
            searchMap.put("pageNo","1");
        }

        // 页面传递给后端 两个参数  sort:排序字段  sortOrder  排序规则（升序/降序）
        if(searchMap.get("sort")==null){  //排序字段
            searchMap.put("sort","");
        }
        if(searchMap.get("sortOrder")==null){ //排序规则
            searchMap.put("sortOrder","DESC");
        }


        Map result = skuSearchService.search(searchMap);
        model.addAttribute("result",result);

        //url处理
        StringBuffer url=new StringBuffer("/search.do?");
        for(String key:searchMap.keySet()){
            url.append("&"+key+"="+searchMap.get(key) );
        }
        model.addAttribute("url",url);


        model.addAttribute("searchMap",searchMap);

        //页码
        int pageNo=  Integer.parseInt( searchMap.get("pageNo") );
        model.addAttribute("pageNo",pageNo);

        Long totalPages=  (Long) result.get("totalPages");//得到总页数

        int startPage=1;//开始页码
        int endPage =totalPages.intValue();//截至代码

        if(totalPages>5){
            startPage=pageNo-2;
            if(startPage<1){
                startPage=1;
            }
            endPage=startPage+4;
        }

        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);

        return "search";
    }

}
