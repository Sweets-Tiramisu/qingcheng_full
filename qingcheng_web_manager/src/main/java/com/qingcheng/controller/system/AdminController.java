package com.qingcheng.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.entity.PageResult;
import com.qingcheng.entity.Result;
import com.qingcheng.pojo.system.Admin;
import com.qingcheng.service.system.AdminService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Reference
    private AdminService adminService;

    @GetMapping("/findAll")
    public List<Admin> findAll(){
        return adminService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Admin> findPage(int page, int size){
        return adminService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Admin> findList(@RequestBody Map<String,Object> searchMap){
        return adminService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Admin> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  adminService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Admin findById(Integer id){
        return adminService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Admin admin){
        adminService.add(admin);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Admin admin){
        adminService.update(admin);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer id){
        adminService.delete(id);
        return new Result();
    }

    @GetMapping("/updatePassword")
    public Result updatePassword(String oldPassword,String newPassword){
        //获取登录用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        //查询加密密码
        Admin admin = adminService.findAdminByUsername( username );
        if(admin==null ){
            return new Result( 1 ,"无此用户");
        }
        //密码校验
        boolean checkpw = BCrypt.checkpw( oldPassword, admin.getPassword() );
        if(checkpw){ //如果旧密码正确 ，执行修改
            admin.setPassword( BCrypt.hashpw( oldPassword, BCrypt.gensalt() )   );
            adminService.update( admin );
            return new Result(  );
        }else{
            return new Result( 1 ,"密码不正确");
        }
    }

}
