package com.qingcheng.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.entity.PageResult;
import com.qingcheng.entity.Result;
import com.qingcheng.pojo.user.Cities;
import com.qingcheng.service.user.CitiesService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/cities")
public class CitiesController {

    @Reference
    private CitiesService citiesService;

    @GetMapping("/findAll")
    public List<Cities> findAll(){
        return citiesService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Cities> findPage(int page, int size){
        return citiesService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Cities> findList(@RequestBody Map<String,Object> searchMap){
        return citiesService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Cities> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  citiesService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Cities findById(String cityid){
        return citiesService.findById(cityid);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Cities cities){
        citiesService.add(cities);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Cities cities){
        citiesService.update(cities);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String cityid){
        citiesService.delete(cityid);
        return new Result();
    }

}
