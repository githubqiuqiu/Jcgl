package com.edu.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Specialty implements Serializable {
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
	
	//与院校专业表一对多
	private Set<Acaspe> acaspes = new HashSet<>();
	public Set<Acaspe> getAcaspes() {
		return acaspes;
	}
	public void setAcaspes(Set<Acaspe> acaspes) {
		this.acaspes = acaspes;
	}
}
