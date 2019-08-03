package com.qingcheng.dao;

import com.qingcheng.pojo.goods.Sku;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface SkuMapper extends Mapper<Sku> {


    /**
     * 扣减库存方法
     * @param id
     * @param num
     */
    @Select("update tb_sku set num=num-#{num} where id=#{id}")
    public void deductionStock(@Param("id") String id, @Param("num") Integer num);

    /**
     * 添加销量
     * @param id
     * @param num
     */
    @Select("update tb_sku set sale_num=sale_num+#{num} where id=#{id}")
    public void addSaleNum(@Param("id") String id, @Param("num") Integer num );

}
