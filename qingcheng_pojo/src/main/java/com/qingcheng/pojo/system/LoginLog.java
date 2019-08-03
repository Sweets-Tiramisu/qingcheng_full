package com.qingcheng.pojo.system;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * loginLog实体类
 * @author Administrator
 *
 */
@Table(name="tb_login_log")
public class LoginLog implements Serializable{

	@Id
	private Integer id;//id


	

	private String loginName;//login_name

	private String ip;//ip

	private String browserName;//browser_name

	private String location;//地区

	private java.util.Date loginTime;//登录时间

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getBrowserName() {
		return browserName;
	}
	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public java.util.Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(java.util.Date loginTime) {
		this.loginTime = loginTime;
	}


	
}
