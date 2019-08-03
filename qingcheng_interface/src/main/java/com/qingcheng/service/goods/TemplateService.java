package com.qingcheng.service.goods;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Template;

import java.util.*;

/**
 * template业务逻辑层
 */
public interface TemplateService {


    public List<Template> findAll();


    public PageResult<Template> findPage(int page, int size);


    public List<Template> findList(Map<String,Object> searchMap);


    public PageResult<Template> findPage(Map<String,Object> searchMap,int page, int size);


    public Template findById(Integer id);

    public void add(Template template);


    public void update(Template template);


    public void delete(Integer id);

}
