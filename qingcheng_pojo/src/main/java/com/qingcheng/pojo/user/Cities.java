package com.qingcheng.pojo.user;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * cities实体类
 * @author Administrator
 *
 */
@Table(name="tb_cities")
public class Cities implements Serializable{

	@Id
	private String cityid;//城市ID


	

	private String city;//城市名称

	private String provinceid;//省份ID

	
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}


	
}
