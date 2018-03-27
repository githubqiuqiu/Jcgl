package com.edu.bean;

import java.io.Serializable;

/**
 * 
 * @author Min
 *	组织机构表(部门表)   id主键
 *			name组织名
 *			address地址
 *			code编号
 *			icon图标
 *			seq排序
 *			createtime时间
 */
public class OrganizationBean implements Serializable{
	private Integer id;
	private String name;
	private String address;
	private String code;
	private String icon;
	private Integer seq;
	private String createtime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	
	
}
