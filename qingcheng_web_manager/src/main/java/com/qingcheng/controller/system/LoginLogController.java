package com.qingcheng.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.entity.PageResult;
import com.qingcheng.entity.Result;
import com.qingcheng.pojo.system.LoginLog;
import com.qingcheng.service.system.LoginLogService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/loginLog")
public class LoginLogController {

    @Reference
    private LoginLogService loginLogService;

    @GetMapping("/findAll")
    public List<LoginLog> findAll(){
        return loginLogService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<LoginLog> findPage(int page, int size){
        return loginLogService.findPage(page, size);
    }

    /**
     * 查询当前登录人的登录日志
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/findPageByLogin")
    public PageResult<LoginLog> findPageByLogin(int page, int size){
        //添加条件
        String loginName = SecurityContextHolder.getContext().getAuthentication().getName();
        Map map=new HashMap();
        map.put("loginName",loginName);
        return loginLogService.findPage(map,page,size);
    }

    @PostMapping("/findList")
    public List<LoginLog> findList(@RequestBody Map<String,Object> searchMap){
        return loginLogService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<LoginLog> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  loginLogService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public LoginLog findById(Integer id){
        return loginLogService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody LoginLog loginLog){
        loginLogService.add(loginLog);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody LoginLog loginLog){
        loginLogService.update(loginLog);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer id){
        loginLogService.delete(id);
        return new Result();
    }

}
