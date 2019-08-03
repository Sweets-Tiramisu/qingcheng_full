package com.qingcheng.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.entity.Result;
import com.qingcheng.pojo.order.Order;
import com.qingcheng.pojo.user.Address;
import com.qingcheng.service.order.CartService;
import com.qingcheng.service.order.OrderService;
import com.qingcheng.service.user.AddressService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Reference
    private CartService cartService;

    @GetMapping("/findCartList")
    public List<Map<String,Object>> findCartList(){
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        List<Map<String, Object>> cartList = cartService.findCartList(username);
        return cartList;
    }

    @GetMapping("/addItem")
    public Result addItem(String skuId,Integer num){
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        cartService.addItem(username,skuId,num);
        return  new Result();
    }


    @GetMapping("/buy")
    public void buy(HttpServletResponse response,String skuId,Integer num) throws IOException {
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        cartService.addItem(username,skuId,num);
        response.sendRedirect("/cart.html");
    }


    @GetMapping("/updateChecked")
    public Result updateChecked(String skuId,boolean checked){
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        cartService.updateChecked(username,skuId,checked);
        return new Result();
    }


    /**
     * 删除选中的购物车
     * @return
     */
    @GetMapping("/deleteCheckedCart")
    public Result deleteCheckedCart(){
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        cartService.deleteCheckedCart(username);
        return new Result();
    }

    /**
     * 计算当前购物车优惠金额
     * @return
     */
    @GetMapping("/preferential")
    public Map preferential(){
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        int preferential = cartService.preferential(username);
        Map map=new HashMap();
        map.put("preferential",preferential);
        return map;
    }

    /**
     * 获取刷新单价后的购物车列表
     * @return
     */
    @GetMapping("/findNewOrderItemList")
    public List<Map<String,Object>> findNewOrderItemList(){
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        return cartService.findNewOrderItemList(username);
    }

    @Reference
    private AddressService addressService;

    /**
     * 根据登录用户查询地址列表
     * @return
     */
    @GetMapping("/findAddressList")
    public List<Address> findAddressList(){
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        return addressService.findByUsername(username);
    }

    @Reference
    private OrderService orderService;

    /**
     * 保存订单
      * @param order
     * @return
     */
    @PostMapping("/saveOrder")
    public Map<String,Object> saveOrder(@RequestBody Order order ){
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        order.setUsername(username);
        return  orderService.add(order);
    }


}
