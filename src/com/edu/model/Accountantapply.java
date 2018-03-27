package com.edu.model;

import java.io.Serializable;
/**
 * 
 * @author Min
 *会计培训表      	aid主键
 *			astudentno学号
 *			aname姓名
 *			userid用户id
 *			aphone电话
 *			acontent学习内容
 *			cityid城市id
 *			county县城id
 *			adata报名时间
 */
public class Accountantapply implements Serializable {
	private Integer aid;
	private String astudentno;
	private String aname;
	private Integer userid;
	private String aphone;
	private String acontent;
	private Integer cityid;
	private Integer countyid;
	private String adata;
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAstudentno() {
		return astudentno;
	}
	public void setAstudentno(String astudentno) {
		this.astudentno = astudentno;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getAphone() {
		return aphone;
	}
	public void setAphone(String aphone) {
		this.aphone = aphone;
	}
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	public Integer getCityid() {
		return cityid;
	}
	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}
	public Integer getCountyid() {
		return countyid;
	}
	public void setCountyid(Integer countyid) {
		this.countyid = countyid;
	}
	public String getAdata() {
		return adata;
	}
	public void setAdata(String adata) {
		this.adata = adata;
	}
	//与用户表多对一
	private User user;
	//与缴费表一对一
	private Accountantfinance accountantfinance;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Accountantfinance getAccountantfinance() {
		return accountantfinance;
	}
	public void setAccountantfinance(Accountantfinance accountantfinance) {
		this.accountantfinance = accountantfinance;
	}
	//与城市表多对一
	private City city;
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	//与县城表多对一
	private County county ;
	public County getCounty() {
		return county;
	}
	public void setCounty(County county) {
		this.county = county;
	}
	
}
