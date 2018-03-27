package com.edu.bean;

import java.io.Serializable;

public class ScheduleBean implements Serializable{
	private Integer sid;//主键
	private Integer userid;//用户id
	private String stitle;//主题
	private String scontent;//内容
	private String sdate;//创建日期
	private String sfinishdate;//完成日期
	private Integer sflag;//标志
	
	//用户名称
	private String username;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getStitle() {
		return stitle;
	}

	public void setStitle(String stitle) {
		this.stitle = stitle;
	}

	public String getScontent() {
		return scontent;
	}

	public void setScontent(String scontent) {
		this.scontent = scontent;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	
	public String getSfinishdate() {
		return sfinishdate;
	}

	public void setSfinishdate(String sfinishdate) {
		this.sfinishdate = sfinishdate;
	}

	public Integer getSflag() {
		return sflag;
	}

	public void setSflag(Integer sflag) {
		this.sflag = sflag;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
