package com.edu.model;

import java.io.Serializable;

/**
fid  int(11) NOT NULL AUTO_INCREMENT ,  -- 主键
sid int(11) not null,		-- 学生id
sname varchar(30) not null,    -- 学生姓名
schoolid int(11) not null,   -- 学校名称
majorid int(11) not null,  -- 专业id
gradation varchar(30) not null, -- 层次
tid int(11) not null,    -- 合作老师id
needmoney int(11) not null, -- 需交金额
practicalmoney int(11) not null, -- 实交金额
fdata  varchar(50)  null,-- 缴费时间
fway varchar(20) not null, -- 缴费方式
fstatu int(11) not null,  -- 缴费状态
ftest1 int(11) null, -- 预留字段（int）
ftest2 varchar(11) null, -- 预留字段(varchar) 
 * */

//成人高考缴费表
public class Adultfinance implements Serializable{
	private Integer fid;//主键
	private Integer sid;//学生id
	private String sname;//学生姓名
	private Integer schoolid;//学校id
	private Integer majorid;//专业id
	private String gradation;//层次
	private Integer tid;//合作老师id
	private Integer needmoney;//需交金额
	private Integer practicalmoney;//实交金额
	private String fdata;//缴费时间
	private String fway;//缴费方式
	private Integer fstatu;//缴费状态
	private Integer ftest1;//预留字段1
	private String ftest2;//预留字段2
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
	public Integer getSchoolid() {
		return schoolid;
	}
	public void setSchoolid(Integer schoolid) {
		this.schoolid = schoolid;
	}
	public Integer getMajorid() {
		return majorid;
	}
	public void setMajorid(Integer majorid) {
		this.majorid = majorid;
	}
	public String getGradation() {
		return gradation;
	}
	public void setGradation(String gradation) {
		this.gradation = gradation;
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
	
	//院校表(多个学生对应一个院校)
	private Academy academy;
	public Academy getAcademy() {
		return academy;
	}
	public void setAcademy(Academy academy) {
		this.academy = academy;
	}
	
	//专业表(多个学生对应一个专业)
	private Specialty specialty;
	public Specialty getSpecialty() {
		return specialty;
	}
	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
	
	//用户表(多个学生对应一个老师)
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
