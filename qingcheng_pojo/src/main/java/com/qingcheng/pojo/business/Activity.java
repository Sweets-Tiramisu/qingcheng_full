package com.qingcheng.pojo.business;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * activity实体类
 * @author Administrator
 *
 */
@Table(name="tb_activity")
public class Activity implements Serializable{

	@Id
	private Integer id;//ID


	

	private String title;//活动标题

	private java.util.Date startTime;//开始时间

	private java.util.Date endTime;//结束时间

	private String status;//状态

	private String content;//活动内容

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	
}
