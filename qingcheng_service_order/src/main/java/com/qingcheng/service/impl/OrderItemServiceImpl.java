package com.qingcheng.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qingcheng.dao.OrderItemMapper;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.order.OrderItem;
import com.qingcheng.service.order.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<OrderItem> findAll() {
        return orderItemMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<OrderItem> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<OrderItem> orderItems = (Page<OrderItem>) orderItemMapper.selectAll();
        return new PageResult<OrderItem>(orderItems.getTotal(),orderItems.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<OrderItem> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return orderItemMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<OrderItem> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<OrderItem> orderItems = (Page<OrderItem>) orderItemMapper.selectByExample(example);
        return new PageResult<OrderItem>(orderItems.getTotal(),orderItems.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public OrderItem findById(String id) {
        return orderItemMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param orderItem
     */
    public void add(OrderItem orderItem) {
        orderItemMapper.insert(orderItem);
    }

    /**
     * 修改
     * @param orderItem
     */
    public void update(OrderItem orderItem) {
        orderItemMapper.updateByPrimaryKeySelective(orderItem);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(String id) {
        orderItemMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(OrderItem.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // ID
            if(searchMap.get("id")!=null && !"".equals(searchMap.get("id"))){
                criteria.andLike("id","%"+searchMap.get("id")+"%");
            }
            // SPU_ID
            if(searchMap.get("spuId")!=null && !"".equals(searchMap.get("spuId"))){
                criteria.andLike("spuId","%"+searchMap.get("spuId")+"%");
            }
            // SKU_ID
            if(searchMap.get("skuId")!=null && !"".equals(searchMap.get("skuId"))){
                criteria.andLike("skuId","%"+searchMap.get("skuId")+"%");
            }
            // 订单ID
            if(searchMap.get("orderId")!=null && !"".equals(searchMap.get("orderId"))){
                criteria.andLike("orderId","%"+searchMap.get("orderId")+"%");
            }
            // 商品名称
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
            }
            // 图片地址
            if(searchMap.get("image")!=null && !"".equals(searchMap.get("image"))){
                criteria.andLike("image","%"+searchMap.get("image")+"%");
            }
            // 是否退货
            if(searchMap.get("isReturn")!=null && !"".equals(searchMap.get("isReturn"))){
                criteria.andLike("isReturn","%"+searchMap.get("isReturn")+"%");
            }

            // 1级分类
            if(searchMap.get("categoryId1")!=null ){
                criteria.andEqualTo("categoryId1",searchMap.get("categoryId1"));
            }
            // 2级分类
            if(searchMap.get("categoryId2")!=null ){
                criteria.andEqualTo("categoryId2",searchMap.get("categoryId2"));
            }
            // 3级分类
            if(searchMap.get("categoryId3")!=null ){
                criteria.andEqualTo("categoryId3",searchMap.get("categoryId3"));
            }
            // 单价
            if(searchMap.get("price")!=null ){
                criteria.andEqualTo("price",searchMap.get("price"));
            }
            // 数量
            if(searchMap.get("num")!=null ){
                criteria.andEqualTo("num",searchMap.get("num"));
            }
            // 总金额
            if(searchMap.get("money")!=null ){
                criteria.andEqualTo("money",searchMap.get("money"));
            }
            // 实付金额
            if(searchMap.get("payMoney")!=null ){
                criteria.andEqualTo("payMoney",searchMap.get("payMoney"));
            }
            // 重量
            if(searchMap.get("weight")!=null ){
                criteria.andEqualTo("weight",searchMap.get("weight"));
            }
            // 运费
            if(searchMap.get("postFee")!=null ){
                criteria.andEqualTo("postFee",searchMap.get("postFee"));
            }

        }
        return example;
    }

}
