package com.edu.model;

import java.io.Serializable;
/**
 * 
 * @author Min
 *院校专业表      asid主键
 *			acid院校id
 *			sid专业id
 */
public class Acaspe implements Serializable{
	private Integer asid;
	private Integer acid;
	private Integer sid;
	public Integer getAsid() {
		return asid;
	}
	public void setAsid(Integer asid) {
		this.asid = asid;
	}
	public Integer getAcid() {
		return acid;
	}
	public void setAcid(Integer acid) {
		this.acid = acid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	//与专业表多对一
	private Specialty specialty;
	public Specialty getSpecialty() {
		return specialty;
	}
	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
	//与院校表 多对一
	private Academy academy;
	public Academy getAcademy() {
		return academy;
	}
	public void setAcademy(Academy academy) {
		this.academy = academy;
	}
	
}
