package com.qingcheng.pojo.system;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * menu实体类
 * @author Administrator
 *
 */
@Table(name="tb_menu")
public class Menu implements Serializable{

	@Id
	private String id;//菜单ID


	

	private String name;//菜单名称

	private String icon;//图标

	private String url;//URL

	private String parentId;//上级菜单ID

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}


	
}
