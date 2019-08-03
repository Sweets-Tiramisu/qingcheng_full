package com.qingcheng.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qingcheng.dao.ProvincesMapper;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.user.Provinces;
import com.qingcheng.service.user.ProvincesService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class ProvincesServiceImpl implements ProvincesService {

    @Autowired
    private ProvincesMapper provincesMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Provinces> findAll() {
        return provincesMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Provinces> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Provinces> provincess = (Page<Provinces>) provincesMapper.selectAll();
        return new PageResult<Provinces>(provincess.getTotal(),provincess.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Provinces> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return provincesMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Provinces> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Provinces> provincess = (Page<Provinces>) provincesMapper.selectByExample(example);
        return new PageResult<Provinces>(provincess.getTotal(),provincess.getResult());
    }

    /**
     * 根据Id查询
     * @param provinceid
     * @return
     */
    public Provinces findById(String provinceid) {
        return provincesMapper.selectByPrimaryKey(provinceid);
    }

    /**
     * 新增
     * @param provinces
     */
    public void add(Provinces provinces) {
        provincesMapper.insert(provinces);
    }

    /**
     * 修改
     * @param provinces
     */
    public void update(Provinces provinces) {
        provincesMapper.updateByPrimaryKeySelective(provinces);
    }

    /**
     *  删除
     * @param provinceid
     */
    public void delete(String provinceid) {
        provincesMapper.deleteByPrimaryKey(provinceid);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Provinces.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 省份ID
            if(searchMap.get("provinceid")!=null && !"".equals(searchMap.get("provinceid"))){
                criteria.andLike("provinceid","%"+searchMap.get("provinceid")+"%");
            }
            // 省份名称
            if(searchMap.get("province")!=null && !"".equals(searchMap.get("province"))){
                criteria.andLike("province","%"+searchMap.get("province")+"%");
            }


        }
        return example;
    }

}
