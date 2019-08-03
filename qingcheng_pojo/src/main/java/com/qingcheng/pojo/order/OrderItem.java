package com.qingcheng.pojo.order;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * orderItem实体类
 * @author Administrator
 *
 */
@Table(name="tb_order_item")
public class OrderItem implements Serializable{

	@Id
	private String id;//ID


	

	private Integer categoryId1;//1级分类

	private Integer categoryId2;//2级分类

	private Integer categoryId3;//3级分类

	private String spuId;//SPU_ID

	private String skuId;//SKU_ID

	private String orderId;//订单ID

	private String name;//商品名称

	private Integer price;//单价

	private Integer num;//数量

	private Integer money;//总金额

	private Integer payMoney;//实付金额

	private String image;//图片地址

	private Integer weight;//重量

	private Integer postFee;//运费

	private String isReturn;//是否退货

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Integer getCategoryId1() {
		return categoryId1;
	}
	public void setCategoryId1(Integer categoryId1) {
		this.categoryId1 = categoryId1;
	}

	public Integer getCategoryId2() {
		return categoryId2;
	}
	public void setCategoryId2(Integer categoryId2) {
		this.categoryId2 = categoryId2;
	}

	public Integer getCategoryId3() {
		return categoryId3;
	}
	public void setCategoryId3(Integer categoryId3) {
		this.categoryId3 = categoryId3;
	}

	public String getSpuId() {
		return spuId;
	}
	public void setSpuId(String spuId) {
		this.spuId = spuId;
	}

	public String getSkuId() {
		return skuId;
	}
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}

	public Integer getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(Integer payMoney) {
		this.payMoney = payMoney;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getPostFee() {
		return postFee;
	}
	public void setPostFee(Integer postFee) {
		this.postFee = postFee;
	}

	public String getIsReturn() {
		return isReturn;
	}
	public void setIsReturn(String isReturn) {
		this.isReturn = isReturn;
	}


	
}
