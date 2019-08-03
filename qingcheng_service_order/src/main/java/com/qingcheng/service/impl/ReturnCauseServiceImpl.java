package com.qingcheng.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qingcheng.dao.ReturnCauseMapper;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.order.ReturnCause;
import com.qingcheng.service.order.ReturnCauseService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class ReturnCauseServiceImpl implements ReturnCauseService {

    @Autowired
    private ReturnCauseMapper returnCauseMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<ReturnCause> findAll() {
        return returnCauseMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<ReturnCause> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<ReturnCause> returnCauses = (Page<ReturnCause>) returnCauseMapper.selectAll();
        return new PageResult<ReturnCause>(returnCauses.getTotal(),returnCauses.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<ReturnCause> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return returnCauseMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<ReturnCause> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<ReturnCause> returnCauses = (Page<ReturnCause>) returnCauseMapper.selectByExample(example);
        return new PageResult<ReturnCause>(returnCauses.getTotal(),returnCauses.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public ReturnCause findById(Integer id) {
        return returnCauseMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param returnCause
     */
    public void add(ReturnCause returnCause) {
        returnCauseMapper.insert(returnCause);
    }

    /**
     * 修改
     * @param returnCause
     */
    public void update(ReturnCause returnCause) {
        returnCauseMapper.updateByPrimaryKeySelective(returnCause);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(Integer id) {
        returnCauseMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(ReturnCause.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 原因
            if(searchMap.get("cause")!=null && !"".equals(searchMap.get("cause"))){
                criteria.andLike("cause","%"+searchMap.get("cause")+"%");
            }
            // 是否启用
            if(searchMap.get("status")!=null && !"".equals(searchMap.get("status"))){
                criteria.andLike("status","%"+searchMap.get("status")+"%");
            }

            // ID
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }
            // 排序
            if(searchMap.get("seq")!=null ){
                criteria.andEqualTo("seq",searchMap.get("seq"));
            }

        }
        return example;
    }

}
