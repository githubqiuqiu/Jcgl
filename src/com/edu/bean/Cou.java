package com.edu.bean;

import java.io.Serializable;

//陶峰县级数据存储
public class Cou implements Serializable{
	private Integer coid;
	private String coname;
	private Integer cid;
	
	public Integer getCoid() {
		return coid;
	}
	public void setCoid(Integer coid) {
		this.coid = coid;
	}
	public String getConame() {
		return coname;
	}
	public void setConame(String coname) {
		this.coname = coname;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
}
