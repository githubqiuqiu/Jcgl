package com.edu.bean;

import java.io.Serializable;

public class ArtapplyBean implements Serializable{
	private int id;//用户id
	private String name;//用户名
	private int cid;//城市id
	private String cname;//城市名
	private int coid;//县城id
	private String coname;//县城名
	private Integer aid;//会计id
	private String astudentno;//学生编号
	private String aname;//名字
	private String aphone;//电话
	private String acontent;//学习内容
	private String adata;//报名时间
	private boolean selected;
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCoid() {
		return coid;
	}
	public void setCoid(int coid) {
		this.coid = coid;
	}
	public String getConame() {
		return coname;
	}
	public void setConame(String coname) {
		this.coname = coname;
	}
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
	public String getAphone() {
		return aphone;
	}
	public void setAphone(String aphone) {
		this.aphone = aphone;
	}
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	public String getAdata() {
		return adata;
	}
	public void setAdata(String adata) {
		this.adata = adata;
	}
}
