package com.edu.model;

import java.io.Serializable;

public class Professionapply implements Serializable {
	private Integer pid;
	private String pstudentno;
	private String pname;
	private Integer userid;
	private String pphone;
	private String pcontent;
	private Integer cityid;
	private Integer countyid;
	private String pdata;

	//与用户表多对一
	private User user;
	//与缴费表一对一
	private Professionfinance professionfinance;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPstudentno() {
		return pstudentno;
	}
	public void setPstudentno(String pstudentno) {
		this.pstudentno = pstudentno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getPphone() {
		return pphone;
	}
	public void setPphone(String pphone) {
		this.pphone = pphone;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
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
	public String getPdata() {
		return pdata;
	}
	public void setPdata(String pdata) {
		this.pdata = pdata;
	}
	public Professionfinance getProfessionfinance() {
		return professionfinance;
	}
	public void setProfessionfinance(Professionfinance professionfinance) {
		this.professionfinance = professionfinance;
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
