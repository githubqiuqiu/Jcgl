package com.edu.bean;

public class ArtfinanceBean {
	private Integer fid;//主键
	private Integer sid;//学生id
	private String sname;//学生姓名
	private Integer tid;//合作老师id
	private Integer needmoney;//需交金额
	private Integer practicalmoney;//实交金额
	private String fdata;//缴费时间
	private String fway;//缴费方式
	private Integer fstatu;//缴费状态
	private Integer ftest1;//预留字段1
	private String ftest2;//预留字段2
	
	private String username;//老师名称

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getNeedmoney() {
		return needmoney;
	}

	public void setNeedmoney(Integer needmoney) {
		this.needmoney = needmoney;
	}

	public Integer getPracticalmoney() {
		return practicalmoney;
	}

	public void setPracticalmoney(Integer practicalmoney) {
		this.practicalmoney = practicalmoney;
	}

	public String getFdata() {
		return fdata;
	}

	public void setFdata(String fdata) {
		this.fdata = fdata;
	}

	public String getFway() {
		return fway;
	}

	public void setFway(String fway) {
		this.fway = fway;
	}

	public Integer getFstatu() {
		return fstatu;
	}

	public void setFstatu(Integer fstatu) {
		this.fstatu = fstatu;
	}

	public Integer getFtest1() {
		return ftest1;
	}

	public void setFtest1(Integer ftest1) {
		this.ftest1 = ftest1;
	}

	public String getFtest2() {
		return ftest2;
	}

	public void setFtest2(String ftest2) {
		this.ftest2 = ftest2;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
