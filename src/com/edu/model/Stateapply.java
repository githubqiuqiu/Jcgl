package com.edu.model;

import java.io.Serializable;

public class Stateapply implements Serializable{
	private Integer sid;
	private String  sstudentno;
	private String sname;
	private Integer userid;
	private String idnumber;
	private String sphone;
	private Integer stype;
	private Integer acaid;
	private Integer specid;
	private String sgradation;
	private String ssystem;
	private Integer cityid;
	private Integer countyid;
	private String sdata;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSstudentno() {
		return sstudentno;
	}
	public void setSstudentno(String sstudentno) {
		this.sstudentno = sstudentno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public Integer getStype() {
		return stype;
	}
	public void setStype(Integer stype) {
		this.stype = stype;
	}
	public Integer getAcaid() {
		return acaid;
	}
	public void setAcaid(Integer acaid) {
		this.acaid = acaid;
	}
	public Integer getSpecid() {
		return specid;
	}
	public void setSpecid(Integer specid) {
		this.specid = specid;
	}
	public String getSgradation() {
		return sgradation;
	}
	public void setSgradation(String sgradation) {
		this.sgradation = sgradation;
	}
	public String getSsystem() {
		return ssystem;
	}
	public void setSsystem(String ssystem) {
		this.ssystem = ssystem;
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
	public String getSdata() {
		return sdata;
	}
	public void setSdata(String sdata) {
		this.sdata = sdata;
	}
	
	//用户表(多个学生对应一个老师)
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	
	//城市表(多个学生对应一个城市)
	private City city;
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	//县城表(多个学生对应一个县城)
	private County county;
	public County getCounty() {
		return county;
	}
	public void setCounty(County county) {
		this.county = county;
	}
	
}
