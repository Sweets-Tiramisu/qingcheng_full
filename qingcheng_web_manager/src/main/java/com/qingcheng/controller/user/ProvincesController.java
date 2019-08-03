package com.qingcheng.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.entity.PageResult;
import com.qingcheng.entity.Result;
import com.qingcheng.pojo.user.Provinces;
import com.qingcheng.service.user.ProvincesService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/provinces")
public class ProvincesController {

    @Reference
    private ProvincesService provincesService;

    @GetMapping("/findAll")
    public List<Provinces> findAll(){
        return provincesService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Provinces> findPage(int page, int size){
        return provincesService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Provinces> findList(@RequestBody Map<String,Object> searchMap){
        return provincesService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Provinces> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  provincesService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Provinces findById(String provinceid){
        return provincesService.findById(provinceid);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Provinces provinces){
        provincesService.add(provinces);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Provinces provinces){
        provincesService.update(provinces);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String provinceid){
        provincesService.delete(provinceid);
        return new Result();
    }

}
