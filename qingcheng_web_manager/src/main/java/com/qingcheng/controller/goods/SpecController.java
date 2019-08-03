package com.qingcheng.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.entity.PageResult;
import com.qingcheng.entity.Result;
import com.qingcheng.pojo.goods.Spec;
import com.qingcheng.service.goods.SpecService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/spec")
public class SpecController {

    @Reference
    private SpecService specService;

    @GetMapping("/findAll")
    public List<Spec> findAll(){
        return specService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Spec> findPage(int page, int size){
        return specService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Spec> findList(@RequestBody Map<String,Object> searchMap){
        return specService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Spec> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  specService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Spec findById(Integer id){
        return specService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Spec spec){
        specService.add(spec);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Spec spec){
        specService.update(spec);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer id){
        specService.delete(id);
        return new Result();
    }

}
