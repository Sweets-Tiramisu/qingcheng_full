package com.qingcheng.pojo.goods;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * sku实体类
 * @author Administrator
 *
 */
@Table(name="tb_sku")
public class Sku implements Serializable{

	@Id
	private String id;//商品id


	

	private String sn;//商品条码

	private String name;//SKU名称

	private Integer price;//价格（分）

	private Integer num;//库存数量

	private Integer alertNum;//库存预警数量

	private String image;//商品图片

	private String images;//商品图片列表

	private Integer weight;//重量（克）

	private java.util.Date createTime;//创建时间

	private java.util.Date updateTime;//更新时间

	private String spuId;//SPUID

	private Integer categoryId;//类目ID

	private String categoryName;//类目名称

	private String brandName;//品牌名称

	private String spec;//规格

	private Integer saleNum;//销量

	private Integer commentNum;//评论数

	private String status;//商品状态 1-正常，2-下架，3-删除

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
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

	public Integer getAlertNum() {
		return alertNum;
	}
	public void setAlertNum(Integer alertNum) {
		this.alertNum = alertNum;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}

	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
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

	public String getSpuId() {
		return spuId;
	}
	public void setSpuId(String spuId) {
		this.spuId = spuId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Integer getSaleNum() {
		return saleNum;
	}
	public void setSaleNum(Integer saleNum) {
		this.saleNum = saleNum;
	}

	public Integer getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	
}
