package com.qingcheng.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qingcheng.dao.FreightTemplateMapper;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.config.FreightTemplate;
import com.qingcheng.service.config.FreightTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class FreightTemplateServiceImpl implements FreightTemplateService {

    @Autowired
    private FreightTemplateMapper freightTemplateMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<FreightTemplate> findAll() {
        return freightTemplateMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<FreightTemplate> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<FreightTemplate> freightTemplates = (Page<FreightTemplate>) freightTemplateMapper.selectAll();
        return new PageResult<FreightTemplate>(freightTemplates.getTotal(),freightTemplates.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<FreightTemplate> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return freightTemplateMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<FreightTemplate> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<FreightTemplate> freightTemplates = (Page<FreightTemplate>) freightTemplateMapper.selectByExample(example);
        return new PageResult<FreightTemplate>(freightTemplates.getTotal(),freightTemplates.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public FreightTemplate findById(Integer id) {
        return freightTemplateMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param freightTemplate
     */
    public void add(FreightTemplate freightTemplate) {
        freightTemplateMapper.insert(freightTemplate);
    }

    /**
     * 修改
     * @param freightTemplate
     */
    public void update(FreightTemplate freightTemplate) {
        freightTemplateMapper.updateByPrimaryKeySelective(freightTemplate);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(Integer id) {
        freightTemplateMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(FreightTemplate.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 模板名称
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
            }
            // 计费方式
            if(searchMap.get("type")!=null && !"".equals(searchMap.get("type"))){
                criteria.andLike("type","%"+searchMap.get("type")+"%");
            }

            // ID
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }

        }
        return example;
    }

}
