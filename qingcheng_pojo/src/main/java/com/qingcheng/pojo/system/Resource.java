package com.qingcheng.pojo.system;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * resource实体类
 * @author Administrator
 *
 */
@Table(name="tb_resource")
public class Resource implements Serializable{

	@Id
	private Integer id;//id


	

	private String resKey;//res_key

	private String resName;//res_name

	private Integer parentId;//parent_id

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getResKey() {
		return resKey;
	}
	public void setResKey(String resKey) {
		this.resKey = resKey;
	}

	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}

	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}


	
}
