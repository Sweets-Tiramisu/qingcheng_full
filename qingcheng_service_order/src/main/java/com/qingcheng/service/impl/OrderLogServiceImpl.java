package com.qingcheng.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qingcheng.dao.OrderLogMapper;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.order.OrderLog;
import com.qingcheng.service.order.OrderLogService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class OrderLogServiceImpl implements OrderLogService {

    @Autowired
    private OrderLogMapper orderLogMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<OrderLog> findAll() {
        return orderLogMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<OrderLog> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<OrderLog> orderLogs = (Page<OrderLog>) orderLogMapper.selectAll();
        return new PageResult<OrderLog>(orderLogs.getTotal(),orderLogs.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<OrderLog> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return orderLogMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<OrderLog> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<OrderLog> orderLogs = (Page<OrderLog>) orderLogMapper.selectByExample(example);
        return new PageResult<OrderLog>(orderLogs.getTotal(),orderLogs.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public OrderLog findById(String id) {
        return orderLogMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param orderLog
     */
    public void add(OrderLog orderLog) {
        orderLogMapper.insert(orderLog);
    }

    /**
     * 修改
     * @param orderLog
     */
    public void update(OrderLog orderLog) {
        orderLogMapper.updateByPrimaryKeySelective(orderLog);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(String id) {
        orderLogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(OrderLog.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // ID
            if(searchMap.get("id")!=null && !"".equals(searchMap.get("id"))){
                criteria.andLike("id","%"+searchMap.get("id")+"%");
            }
            // 操作员
            if(searchMap.get("operater")!=null && !"".equals(searchMap.get("operater"))){
                criteria.andLike("operater","%"+searchMap.get("operater")+"%");
            }
            // 订单状态
            if(searchMap.get("orderStatus")!=null && !"".equals(searchMap.get("orderStatus"))){
                criteria.andLike("orderStatus","%"+searchMap.get("orderStatus")+"%");
            }
            // 付款状态
            if(searchMap.get("payStatus")!=null && !"".equals(searchMap.get("payStatus"))){
                criteria.andLike("payStatus","%"+searchMap.get("payStatus")+"%");
            }
            // 发货状态
            if(searchMap.get("consignStatus")!=null && !"".equals(searchMap.get("consignStatus"))){
                criteria.andLike("consignStatus","%"+searchMap.get("consignStatus")+"%");
            }
            // 备注
            if(searchMap.get("remarks")!=null && !"".equals(searchMap.get("remarks"))){
                criteria.andLike("remarks","%"+searchMap.get("remarks")+"%");
            }


        }
        return example;
    }

}
