package com.qingcheng.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qingcheng.dao.AreasMapper;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.user.Areas;
import com.qingcheng.service.user.AreasService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class AreasServiceImpl implements AreasService {

    @Autowired
    private AreasMapper areasMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Areas> findAll() {
        return areasMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Areas> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Areas> areass = (Page<Areas>) areasMapper.selectAll();
        return new PageResult<Areas>(areass.getTotal(),areass.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Areas> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return areasMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Areas> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Areas> areass = (Page<Areas>) areasMapper.selectByExample(example);
        return new PageResult<Areas>(areass.getTotal(),areass.getResult());
    }

    /**
     * 根据Id查询
     * @param areaid
     * @return
     */
    public Areas findById(String areaid) {
        return areasMapper.selectByPrimaryKey(areaid);
    }

    /**
     * 新增
     * @param areas
     */
    public void add(Areas areas) {
        areasMapper.insert(areas);
    }

    /**
     * 修改
     * @param areas
     */
    public void update(Areas areas) {
        areasMapper.updateByPrimaryKeySelective(areas);
    }

    /**
     *  删除
     * @param areaid
     */
    public void delete(String areaid) {
        areasMapper.deleteByPrimaryKey(areaid);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Areas.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 区域ID
            if(searchMap.get("areaid")!=null && !"".equals(searchMap.get("areaid"))){
                criteria.andLike("areaid","%"+searchMap.get("areaid")+"%");
            }
            // 区域名称
            if(searchMap.get("area")!=null && !"".equals(searchMap.get("area"))){
                criteria.andLike("area","%"+searchMap.get("area")+"%");
            }
            // 城市ID
            if(searchMap.get("cityid")!=null && !"".equals(searchMap.get("cityid"))){
                criteria.andLike("cityid","%"+searchMap.get("cityid")+"%");
            }


        }
        return example;
    }

}
