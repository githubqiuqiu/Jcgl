package com.edu.model;

import java.io.Serializable;

public class Distanceapply implements Serializable{
	private Integer did;
	private String  dstudentno;
	private String dname;
	private Integer userid;
	private String idnumber;
	private String dphone;
	private Integer dtype;
	private Integer acaid;
	private Integer specid;
	private String dgradation;
	private String dsystem;
	private Integer cityid;
	private Integer countyid;
	private String ddata;
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDstudentno() {
		return dstudentno;
	}
	public void setDstudentno(String dstudentno) {
		this.dstudentno = dstudentno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
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
	public String getDphone() {
		return dphone;
	}
	public void setDphone(String dphone) {
		this.dphone = dphone;
	}
	public Integer getDtype() {
		return dtype;
	}
	public void setDtype(Integer dtype) {
		this.dtype = dtype;
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
	public String getDgradation() {
		return dgradation;
	}
	public void setDgradation(String dgradation) {
		this.dgradation = dgradation;
	}
	public String getDsystem() {
		return dsystem;
	}
	public void setDsystem(String dsystem) {
		this.dsystem = dsystem;
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
	public String getDdata() {
		return ddata;
	}
	public void setDdata(String ddata) {
		this.ddata = ddata;
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
