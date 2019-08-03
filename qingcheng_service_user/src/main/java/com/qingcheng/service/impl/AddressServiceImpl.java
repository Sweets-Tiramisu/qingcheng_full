package com.qingcheng.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qingcheng.dao.AddressMapper;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.user.Address;
import com.qingcheng.service.user.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Address> findAll() {
        return addressMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Address> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Address> addresss = (Page<Address>) addressMapper.selectAll();
        return new PageResult<Address>(addresss.getTotal(),addresss.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Address> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return addressMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Address> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Address> addresss = (Page<Address>) addressMapper.selectByExample(example);
        return new PageResult<Address>(addresss.getTotal(),addresss.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public Address findById(Integer id) {
        return addressMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param address
     */
    public void add(Address address) {
        addressMapper.insert(address);
    }

    /**
     * 修改
     * @param address
     */
    public void update(Address address) {
        addressMapper.updateByPrimaryKeySelective(address);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(Integer id) {
        addressMapper.deleteByPrimaryKey(id);
    }

    public List<Address> findByUsername(String username) {
        Example example=new Example(Address.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        return addressMapper.selectByExample(example);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Address.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 用户名
            if(searchMap.get("username")!=null && !"".equals(searchMap.get("username"))){
                criteria.andLike("username","%"+searchMap.get("username")+"%");
            }
            // 省
            if(searchMap.get("provinceid")!=null && !"".equals(searchMap.get("provinceid"))){
                criteria.andLike("provinceid","%"+searchMap.get("provinceid")+"%");
            }
            // 市
            if(searchMap.get("cityid")!=null && !"".equals(searchMap.get("cityid"))){
                criteria.andLike("cityid","%"+searchMap.get("cityid")+"%");
            }
            // 县/区
            if(searchMap.get("areaid")!=null && !"".equals(searchMap.get("areaid"))){
                criteria.andLike("areaid","%"+searchMap.get("areaid")+"%");
            }
            // 电话
            if(searchMap.get("phone")!=null && !"".equals(searchMap.get("phone"))){
                criteria.andLike("phone","%"+searchMap.get("phone")+"%");
            }
            // 详细地址
            if(searchMap.get("address")!=null && !"".equals(searchMap.get("address"))){
                criteria.andLike("address","%"+searchMap.get("address")+"%");
            }
            // 联系人
            if(searchMap.get("contact")!=null && !"".equals(searchMap.get("contact"))){
                criteria.andLike("contact","%"+searchMap.get("contact")+"%");
            }
            // 是否是默认 1默认 0否
            if(searchMap.get("isDefault")!=null && !"".equals(searchMap.get("isDefault"))){
                criteria.andLike("isDefault","%"+searchMap.get("isDefault")+"%");
            }
            // 别名
            if(searchMap.get("alias")!=null && !"".equals(searchMap.get("alias"))){
                criteria.andLike("alias","%"+searchMap.get("alias")+"%");
            }

            // id
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }

        }
        return example;
    }

}
