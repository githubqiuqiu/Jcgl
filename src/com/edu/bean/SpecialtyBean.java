package com.edu.bean;

import java.io.Serializable;

public class SpecialtyBean implements Serializable{
	private Integer sid;
	private String sname;
	private String selected;
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
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	
	
}
