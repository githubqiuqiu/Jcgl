package com.edu.bean;

import java.io.Serializable;

public class CountyBean implements Serializable{
	private Integer coid;//县/区id
	private String coname;//县/区名称
	private Integer cid;//城市id
	private String selected;//判断选中
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
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	
	
}
