package com.qingcheng.pojo.order;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * preferential实体类
 * @author Administrator
 *
 */
@Table(name="tb_preferential")
public class Preferential implements Serializable{

	@Id
	private Integer id;//ID


	

	private Integer buyMoney;//消费金额

	private Integer preMoney;//优惠金额

	private Integer categoryId;//品类ID

	private java.util.Date startTime;//活动开始日期

	private java.util.Date endTime;//活动截至日期

	private String state;//状态

	private String type;//类型1不翻倍 2翻倍

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBuyMoney() {
		return buyMoney;
	}
	public void setBuyMoney(Integer buyMoney) {
		this.buyMoney = buyMoney;
	}

	public Integer getPreMoney() {
		return preMoney;
	}
	public void setPreMoney(Integer preMoney) {
		this.preMoney = preMoney;
	}

	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public java.util.Date getStartTime() {
		return startTime;
	}
	public void setStartTime(java.util.Date startTime) {
		this.startTime = startTime;
	}

	public java.util.Date getEndTime() {
		return endTime;
	}
	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


	
}
