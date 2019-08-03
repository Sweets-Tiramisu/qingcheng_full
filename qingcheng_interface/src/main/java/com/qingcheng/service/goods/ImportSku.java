package com.qingcheng.service.goods;

import com.qingcheng.pojo.goods.Sku;

import java.util.List;

public interface ImportSku {
    /**
     * 导入sku数据到es
     */
    public void importSkuList(List<Sku> sku);


}
