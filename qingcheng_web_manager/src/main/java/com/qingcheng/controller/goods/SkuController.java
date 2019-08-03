package com.qingcheng.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.entity.PageResult;
import com.qingcheng.entity.Result;
import com.qingcheng.pojo.goods.Sku;
import com.qingcheng.service.goods.SkuService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/sku")
public class SkuController {

    @Reference(timeout = 30000)
    private SkuService skuService;

    @GetMapping("/findAll")
    public List<Sku> findAll(){
        return skuService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Sku> findPage(int page, int size){
        return skuService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Sku> findList(@RequestBody Map<String,Object> searchMap){
        return skuService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Sku> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  skuService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Sku findById(String id){
        return skuService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Sku sku){
        skuService.add(sku);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Sku sku){
        skuService.update(sku);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String id){
        skuService.delete(id);
        return new Result();
    }


    @GetMapping("/importToEs")
    public Result importToEs(){
        skuService.importToEs();
        return new Result();
    }

}
