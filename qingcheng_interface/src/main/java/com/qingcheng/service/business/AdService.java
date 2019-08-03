package com.qingcheng.service.business;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.business.Ad;

import java.util.*;

/**
 * ad业务逻辑层
 */
public interface AdService {


    public List<Ad> findAll();


    public PageResult<Ad> findPage(int page, int size);


    public List<Ad> findList(Map<String,Object> searchMap);


    public PageResult<Ad> findPage(Map<String,Object> searchMap,int page, int size);


    public Ad findById(Integer id);

    public void add(Ad ad);


    public void update(Ad ad);


    public void delete(Integer id);


    public List<Ad> findByPosition(String position);


    /**
     * 将某个位置的广告存入缓存
     * @param position
     */
    public void saveAdToRedisByPosition(String position);


    /**
     * 将全部广告数据存入缓存
     */
    public void saveAllAdToRedis();


}
