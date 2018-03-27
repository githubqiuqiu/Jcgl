package com.edu.model;

import java.io.Serializable;
import java.util.Set;

/**
 * 
 * @author Min
 * 学校表               aid 主键
 * 			aschool 学校名
 * 			amajor 	空字段
 * 			aflag 	排序
 */
public class Academy implements Serializable{
	private Integer aid; 
	private String aschool;
	private String amajor;
	private Integer aflag;
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAschool() {
		return aschool;
	}
	public void setAschool(String aschool) {
		this.aschool = aschool;
	}
	public String getAmajor() {
		return amajor;
	}
	public void setAmajor(String amajor) {
		this.amajor = amajor;
	}
	public Integer getAflag() {
		return aflag;
	}
	public void setAflag(Integer aflag) {
		this.aflag = aflag;
	}
	
	//与院校专业表一对多
	private Set<Acaspe> acaspes;
	public Set<Acaspe> getAcaspes() {
		return acaspes;
	}
	public void setAcaspes(Set<Acaspe> acaspes) {
		this.acaspes = acaspes;
	}
}
