package com.edu.bean;

import java.io.Serializable;
//陶峰存储专业表信息bean
public class Spe implements Serializable{
	private Integer sid;
	private String sname;
	private Integer sort;
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
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
}
