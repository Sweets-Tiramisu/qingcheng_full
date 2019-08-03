package com.qingcheng.pojo.order;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * orderConfig实体类
 * @author Administrator
 *
 */
@Table(name="tb_order_config")
public class OrderConfig implements Serializable{

	@Id
	private Integer id;//ID


	

	private Integer orderTimeout;//正常订单超时时间（分）

	private Integer seckillTimeout;//秒杀订单超时时间（分）

	private Integer takeTimeout;//自动收货（天）

	private Integer serviceTimeout;//售后期限

	private Integer commentTimeout;//自动五星好评

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderTimeout() {
		return orderTimeout;
	}
	public void setOrderTimeout(Integer orderTimeout) {
		this.orderTimeout = orderTimeout;
	}

	public Integer getSeckillTimeout() {
		return seckillTimeout;
	}
	public void setSeckillTimeout(Integer seckillTimeout) {
		this.seckillTimeout = seckillTimeout;
	}

	public Integer getTakeTimeout() {
		return takeTimeout;
	}
	public void setTakeTimeout(Integer takeTimeout) {
		this.takeTimeout = takeTimeout;
	}

	public Integer getServiceTimeout() {
		return serviceTimeout;
	}
	public void setServiceTimeout(Integer serviceTimeout) {
		this.serviceTimeout = serviceTimeout;
	}

	public Integer getCommentTimeout() {
		return commentTimeout;
	}
	public void setCommentTimeout(Integer commentTimeout) {
		this.commentTimeout = commentTimeout;
	}


	
}
