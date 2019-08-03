package com.qingcheng.controller.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.entity.PageResult;
import com.qingcheng.entity.Result;
import com.qingcheng.pojo.order.OrderConfig;
import com.qingcheng.service.order.OrderConfigService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/orderConfig")
public class OrderConfigController {

    @Reference
    private OrderConfigService orderConfigService;

    @GetMapping("/findAll")
    public List<OrderConfig> findAll(){
        return orderConfigService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<OrderConfig> findPage(int page, int size){
        return orderConfigService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<OrderConfig> findList(@RequestBody Map<String,Object> searchMap){
        return orderConfigService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<OrderConfig> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  orderConfigService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public OrderConfig findById(Integer id){
        return orderConfigService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody OrderConfig orderConfig){
        orderConfigService.add(orderConfig);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody OrderConfig orderConfig){
        orderConfigService.update(orderConfig);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer id){
        orderConfigService.delete(id);
        return new Result();
    }

}
