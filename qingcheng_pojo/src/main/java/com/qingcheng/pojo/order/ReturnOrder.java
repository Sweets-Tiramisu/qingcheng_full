package com.qingcheng.pojo.order;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * returnOrder实体类
 * @author Administrator
 *
 */
@Table(name="tb_return_order")
public class ReturnOrder implements Serializable{

	@Id
	private Long id;//服务单号


	

	private Long orderId;//订单号

	private java.util.Date applyTime;//申请时间

	private Long userId;//用户ID

	private String userAccount;//用户账号

	private String linkman;//联系人

	private String linkmanMobile;//联系人手机

	private String type;//类型

	private Integer returnMoney;//退款金额

	private String isReturnFreight;//是否退运费

	private String status;//申请状态

	private java.util.Date disposeTime;//处理时间

	private Integer returnCause;//退货退款原因

	private String evidence;//凭证图片

	private String description;//问题描述

	private String remark;//处理备注

	private Integer adminId;//管理员id

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public java.util.Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(java.util.Date applyTime) {
		this.applyTime = applyTime;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getLinkmanMobile() {
		return linkmanMobile;
	}
	public void setLinkmanMobile(String linkmanMobile) {
		this.linkmanMobile = linkmanMobile;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Integer getReturnMoney() {
		return returnMoney;
	}
	public void setReturnMoney(Integer returnMoney) {
		this.returnMoney = returnMoney;
	}

	public String getIsReturnFreight() {
		return isReturnFreight;
	}
	public void setIsReturnFreight(String isReturnFreight) {
		this.isReturnFreight = isReturnFreight;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public java.util.Date getDisposeTime() {
		return disposeTime;
	}
	public void setDisposeTime(java.util.Date disposeTime) {
		this.disposeTime = disposeTime;
	}

	public Integer getReturnCause() {
		return returnCause;
	}
	public void setReturnCause(Integer returnCause) {
		this.returnCause = returnCause;
	}

	public String getEvidence() {
		return evidence;
	}
	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}


	
}
