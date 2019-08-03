package com.qingcheng.pojo.order;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * orderLog实体类
 * @author Administrator
 *
 */
@Table(name="tb_order_log")
public class OrderLog implements Serializable{

	@Id
	private String id;//ID


	

	private String operater;//操作员

	private java.util.Date operateTime;//操作时间

	private String orderId;//订单ID

	private String orderStatus;//订单状态

	private String payStatus;//付款状态

	private String consignStatus;//发货状态

	private String remarks;//备注

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getOperater() {
		return operater;
	}
	public void setOperater(String operater) {
		this.operater = operater;
	}

	public java.util.Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(java.util.Date operateTime) {
		this.operateTime = operateTime;
	}

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getConsignStatus() {
		return consignStatus;
	}
	public void setConsignStatus(String consignStatus) {
		this.consignStatus = consignStatus;
	}

	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	
}
