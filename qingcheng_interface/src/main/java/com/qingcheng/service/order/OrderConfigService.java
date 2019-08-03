package com.qingcheng.service.order;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.order.OrderConfig;

import java.util.*;

/**
 * orderConfig业务逻辑层
 */
public interface OrderConfigService {


    public List<OrderConfig> findAll();


    public PageResult<OrderConfig> findPage(int page, int size);


    public List<OrderConfig> findList(Map<String,Object> searchMap);


    public PageResult<OrderConfig> findPage(Map<String,Object> searchMap,int page, int size);


    public OrderConfig findById(Integer id);

    public void add(OrderConfig orderConfig);


    public void update(OrderConfig orderConfig);


    public void delete(Integer id);

}
