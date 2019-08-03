package com.qingcheng.pojo.user;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * provinces实体类
 * @author Administrator
 *
 */
@Table(name="tb_provinces")
public class Provinces implements Serializable{

	@Id
	private String provinceid;//省份ID


	

	private String province;//省份名称

	
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}

	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}


	
}
