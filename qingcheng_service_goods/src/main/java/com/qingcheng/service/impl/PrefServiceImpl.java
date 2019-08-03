package com.qingcheng.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qingcheng.dao.PrefMapper;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Pref;
import com.qingcheng.service.goods.PrefService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class PrefServiceImpl implements PrefService {

    @Autowired
    private PrefMapper prefMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Pref> findAll() {
        return prefMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Pref> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Pref> prefs = (Page<Pref>) prefMapper.selectAll();
        return new PageResult<Pref>(prefs.getTotal(),prefs.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Pref> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return prefMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Pref> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Pref> prefs = (Page<Pref>) prefMapper.selectByExample(example);
        return new PageResult<Pref>(prefs.getTotal(),prefs.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public Pref findById(Integer id) {
        return prefMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param pref
     */
    public void add(Pref pref) {
        prefMapper.insert(pref);
    }

    /**
     * 修改
     * @param pref
     */
    public void update(Pref pref) {
        prefMapper.updateByPrimaryKeySelective(pref);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(Integer id) {
        prefMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Pref.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 类型
            if(searchMap.get("type")!=null && !"".equals(searchMap.get("type"))){
                criteria.andLike("type","%"+searchMap.get("type")+"%");
            }
            // 状态
            if(searchMap.get("state")!=null && !"".equals(searchMap.get("state"))){
                criteria.andLike("state","%"+searchMap.get("state")+"%");
            }

            // ID
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }
            // 分类ID
            if(searchMap.get("cateId")!=null ){
                criteria.andEqualTo("cateId",searchMap.get("cateId"));
            }
            // 消费金额
            if(searchMap.get("buyMoney")!=null ){
                criteria.andEqualTo("buyMoney",searchMap.get("buyMoney"));
            }
            // 优惠金额
            if(searchMap.get("preMoney")!=null ){
                criteria.andEqualTo("preMoney",searchMap.get("preMoney"));
            }

        }
        return example;
    }

}
