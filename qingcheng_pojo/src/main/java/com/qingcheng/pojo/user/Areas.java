package com.qingcheng.pojo.user;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * areas实体类
 * @author Administrator
 *
 */
@Table(name="tb_areas")
public class Areas implements Serializable{

	@Id
	private String areaid;//区域ID


	

	private String area;//区域名称

	private String cityid;//城市ID

	
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}

	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}


	
}
