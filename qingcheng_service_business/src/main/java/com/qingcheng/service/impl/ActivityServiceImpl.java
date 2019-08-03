package com.qingcheng.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qingcheng.dao.ActivityMapper;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.business.Activity;
import com.qingcheng.service.business.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Activity> findAll() {
        return activityMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Activity> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Activity> activitys = (Page<Activity>) activityMapper.selectAll();
        return new PageResult<Activity>(activitys.getTotal(),activitys.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Activity> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return activityMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Activity> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Activity> activitys = (Page<Activity>) activityMapper.selectByExample(example);
        return new PageResult<Activity>(activitys.getTotal(),activitys.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public Activity findById(Integer id) {
        return activityMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param activity
     */
    public void add(Activity activity) {
        activityMapper.insert(activity);
    }

    /**
     * 修改
     * @param activity
     */
    public void update(Activity activity) {
        activityMapper.updateByPrimaryKeySelective(activity);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(Integer id) {
        activityMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Activity.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 活动标题
            if(searchMap.get("title")!=null && !"".equals(searchMap.get("title"))){
                criteria.andLike("title","%"+searchMap.get("title")+"%");
            }
            // 状态
            if(searchMap.get("status")!=null && !"".equals(searchMap.get("status"))){
                criteria.andLike("status","%"+searchMap.get("status")+"%");
            }
            // 活动内容
            if(searchMap.get("content")!=null && !"".equals(searchMap.get("content"))){
                criteria.andLike("content","%"+searchMap.get("content")+"%");
            }

            // ID
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }

        }
        return example;
    }

}
