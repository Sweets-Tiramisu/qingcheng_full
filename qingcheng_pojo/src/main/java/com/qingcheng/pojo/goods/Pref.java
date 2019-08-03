package com.qingcheng.pojo.goods;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * pref实体类
 * @author Administrator
 *
 */
@Table(name="tb_pref")
public class Pref implements Serializable{

	@Id
	private Integer id;//ID


	

	private Integer cateId;//分类ID

	private Integer buyMoney;//消费金额

	private Integer preMoney;//优惠金额

	private java.util.Date startTime;//活动开始日期

	private java.util.Date endTime;//活动截至日期

	private String type;//类型

	private String state;//状态

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCateId() {
		return cateId;
	}
	public void setCateId(Integer cateId) {
		this.cateId = cateId;
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

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}


	
}
