package com.qingcheng.service.impl;

import com.qingcheng.service.goods.*;
import com.qingcheng.util.CacheKey;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Init implements InitializingBean {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SkuService skuService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private BrandService brandService;

    @Autowired
    private SpecService specService;

    public void afterPropertiesSet() throws Exception {
        System.out.println("---缓存预热----");
        categoryService.saveCategoryTreeToRedis();
        skuService.saveAllPriceToRedis();
        skuService.importToEs();

        //品牌列表缓存预热
        if(!redisTemplate.hasKey( CacheKey.BRAND_LIST )){
            specService.saveToRedis();
        }
        //规格列表缓存预热
        if(!redisTemplate.hasKey( CacheKey.SPEC_LIST )){
            specService.saveToRedis();
        }

    }
}
