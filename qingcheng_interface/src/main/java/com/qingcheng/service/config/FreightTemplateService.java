package com.qingcheng.service.config;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.config.FreightTemplate;

import java.util.*;

/**
 * freightTemplate业务逻辑层
 */
public interface FreightTemplateService {


    public List<FreightTemplate> findAll();


    public PageResult<FreightTemplate> findPage(int page, int size);


    public List<FreightTemplate> findList(Map<String,Object> searchMap);


    public PageResult<FreightTemplate> findPage(Map<String,Object> searchMap,int page, int size);


    public FreightTemplate findById(Integer id);

    public void add(FreightTemplate freightTemplate);


    public void update(FreightTemplate freightTemplate);


    public void delete(Integer id);

}
