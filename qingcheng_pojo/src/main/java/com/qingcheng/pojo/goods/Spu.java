package com.qingcheng.pojo.goods;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * spu实体类
 * @author Administrator
 *
 */
@Table(name="tb_spu")
public class Spu implements Serializable{

	@Id
	private String id;//主键


	

	private String sn;//货号

	private String name;//SPU名

	private String caption;//副标题

	private Integer brandId;//品牌ID

	private Integer category1Id;//一级分类

	private Integer category2Id;//二级分类

	private Integer category3Id;//三级分类

	private Integer templateId;//模板ID

	private Integer freightId;//运费模板id

	private String image;//图片

	private String images;//图片列表

	private String saleService;//售后服务

	private String introduction;//介绍

	private String specItems;//规格列表

	private String paraItems;//参数列表

	private Integer saleNum;//销量

	private Integer commentNum;//评论数

	private String isMarketable;//是否上架

	private String isEnableSpec;//是否启用规格

	private String isDelete;//是否删除

	private String status;//审核状态

	
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

	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}

	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public Integer getCategory1Id() {
		return category1Id;
	}
	public void setCategory1Id(Integer category1Id) {
		this.category1Id = category1Id;
	}

	public Integer getCategory2Id() {
		return category2Id;
	}
	public void setCategory2Id(Integer category2Id) {
		this.category2Id = category2Id;
	}

	public Integer getCategory3Id() {
		return category3Id;
	}
	public void setCategory3Id(Integer category3Id) {
		this.category3Id = category3Id;
	}

	public Integer getTemplateId() {
		return templateId;
	}
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public Integer getFreightId() {
		return freightId;
	}
	public void setFreightId(Integer freightId) {
		this.freightId = freightId;
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

	public String getSaleService() {
		return saleService;
	}
	public void setSaleService(String saleService) {
		this.saleService = saleService;
	}

	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getSpecItems() {
		return specItems;
	}
	public void setSpecItems(String specItems) {
		this.specItems = specItems;
	}

	public String getParaItems() {
		return paraItems;
	}
	public void setParaItems(String paraItems) {
		this.paraItems = paraItems;
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

	public String getIsMarketable() {
		return isMarketable;
	}
	public void setIsMarketable(String isMarketable) {
		this.isMarketable = isMarketable;
	}

	public String getIsEnableSpec() {
		return isEnableSpec;
	}
	public void setIsEnableSpec(String isEnableSpec) {
		this.isEnableSpec = isEnableSpec;
	}

	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	
}
