package com.qingcheng.pojo.order;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * order实体类
 * @author Administrator
 *
 */
@Table(name="tb_order")
public class Order implements Serializable{

	@Id
	private String id;//订单id


	

	private Integer totalNum;//数量合计

	private Integer totalMoney;//金额合计

	private Integer preMoney;//优惠金额

	private Integer postFee;//邮费

	private Integer payMoney;//实付金额

	private String payType;//支付类型，1、在线支付、0 货到付款

	private java.util.Date createTime;//订单创建时间

	private java.util.Date updateTime;//订单更新时间

	private java.util.Date payTime;//付款时间

	private java.util.Date consignTime;//发货时间

	private java.util.Date endTime;//交易完成时间

	private java.util.Date closeTime;//交易关闭时间

	private String shippingName;//物流名称

	private String shippingCode;//物流单号

	private String username;//用户名称

	private String buyerMessage;//买家留言

	private String buyerRate;//是否评价

	private String receiverContact;//收货人

	private String receiverMobile;//收货人手机

	private String receiverAddress;//收货人地址

	private String sourceType;//订单来源：1:web，2：app，3：微信公众号，4：微信小程序  5 H5手机页面

	private String transactionId;//交易流水号

	private String orderStatus;//订单状态

	private String payStatus;//支付状态

	private String consignStatus;//发货状态

	private String isDelete;//是否删除

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public Integer getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Integer totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Integer getPreMoney() {
		return preMoney;
	}
	public void setPreMoney(Integer preMoney) {
		this.preMoney = preMoney;
	}

	public Integer getPostFee() {
		return postFee;
	}
	public void setPostFee(Integer postFee) {
		this.postFee = postFee;
	}

	public Integer getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(Integer payMoney) {
		this.payMoney = payMoney;
	}

	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	public java.util.Date getPayTime() {
		return payTime;
	}
	public void setPayTime(java.util.Date payTime) {
		this.payTime = payTime;
	}

	public java.util.Date getConsignTime() {
		return consignTime;
	}
	public void setConsignTime(java.util.Date consignTime) {
		this.consignTime = consignTime;
	}

	public java.util.Date getEndTime() {
		return endTime;
	}
	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}

	public java.util.Date getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(java.util.Date closeTime) {
		this.closeTime = closeTime;
	}

	public String getShippingName() {
		return shippingName;
	}
	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public String getShippingCode() {
		return shippingCode;
	}
	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getBuyerMessage() {
		return buyerMessage;
	}
	public void setBuyerMessage(String buyerMessage) {
		this.buyerMessage = buyerMessage;
	}

	public String getBuyerRate() {
		return buyerRate;
	}
	public void setBuyerRate(String buyerRate) {
		this.buyerRate = buyerRate;
	}

	public String getReceiverContact() {
		return receiverContact;
	}
	public void setReceiverContact(String receiverContact) {
		this.receiverContact = receiverContact;
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}
	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getSourceType() {
		return sourceType;
	}
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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

	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}


	
}
