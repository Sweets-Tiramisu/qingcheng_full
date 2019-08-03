package com.qingcheng.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qingcheng.dao.CategoryMapper;
import com.qingcheng.dao.SpecMapper;
import com.qingcheng.dao.TemplateMapper;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Category;
import com.qingcheng.pojo.goods.Spec;
import com.qingcheng.pojo.goods.Template;
import com.qingcheng.service.goods.SpecService;
import com.qingcheng.util.CacheKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service(interfaceClass = SpecService.class)
public class SpecServiceImpl implements SpecService {

    @Autowired
    private SpecMapper specMapper;

    @Autowired
    private TemplateMapper templateMapper;


    /**
     * 返回全部记录
     * @return
     */
    public List<Spec> findAll() {
        return specMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Spec> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Spec> specs = (Page<Spec>) specMapper.selectAll();
        return new PageResult<Spec>(specs.getTotal(),specs.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Spec> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return specMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Spec> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Spec> specs = (Page<Spec>) specMapper.selectByExample(example);
        return new PageResult<Spec>(specs.getTotal(),specs.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public Spec findById(Integer id) {
        return specMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param spec
     */
    @Transactional
    public void add(Spec spec) {
        specMapper.insert(spec);
        //将模板中的规格数量+1
        Template template = templateMapper.selectByPrimaryKey(spec.getTemplateId());
        template.setSpecNum( template.getSpecNum()+1 );
        templateMapper.updateByPrimaryKey(template);
    }

    /**
     * 修改
     * @param spec
     */
    public void update(Spec spec) {
        specMapper.updateByPrimaryKeySelective(spec);
    }

    /**
     *  删除
     * @param id
     */
    @Transactional
    public void delete(Integer id) {
        //将模板中的规格数量减一
        Spec spec = specMapper.selectByPrimaryKey(id);
        Template template = templateMapper.selectByPrimaryKey(spec.getTemplateId());
        template.setSpecNum( template.getSpecNum()-1 );
        templateMapper.updateByPrimaryKey(template);

        specMapper.deleteByPrimaryKey(id);
    }

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public void saveToRedis() {
        List<Category> categoryList = categoryMapper.selectAll();
        for(Category category:categoryList){
            List<Map> specList = specMapper.findListByCategoryName( category.getName() );
            redisTemplate.boundHashOps( CacheKey.SPEC_LIST ).put(  category.getName(), specList);
        }
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Spec.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 名称
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
            }
            // 规格选项
            if(searchMap.get("options")!=null && !"".equals(searchMap.get("options"))){
                criteria.andLike("options","%"+searchMap.get("options")+"%");
            }

            // ID
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }
            // 排序
            if(searchMap.get("seq")!=null ){
                criteria.andEqualTo("seq",searchMap.get("seq"));
            }
            // 模板ID
            if(searchMap.get("templateId")!=null ){
                criteria.andEqualTo("templateId",searchMap.get("templateId"));
            }

        }
        return example;
    }

}
