package com.edu.model;

import java.io.Serializable;

//成人教育报名表
public class Adultapply implements Serializable{
	private Integer aid;
	private String astudentno;
	private String aname;
	private Integer userid;
	private String idnumber;
	private String aphone;
	private Integer atype;
	private Integer acaid;
	private Integer specid;
	private String agradation;
	private String asystem;
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
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getAphone() {
		return aphone;
	}
	public void setAphone(String aphone) {
		this.aphone = aphone;
	}
	public Integer getAtype() {
		return atype;
	}
	public void setAtype(Integer atype) {
		this.atype = atype;
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
	public String getAgradation() {
		return agradation;
	}
	public void setAgradation(String agradation) {
		this.agradation = agradation;
	}
	public String getAsystem() {
		return asystem;
	}
	public void setAsystem(String asystem) {
		this.asystem = asystem;
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
