package com.edu.model;

import java.io.Serializable;
/**
 * 
 * @author Min
 *	联系方式表  	rid主键
 *			rqq qq
 *			rphone 电话
 *			rcontent 名称
 *			reffect 负责类型
 */
public class Relation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer rid;
	private String rqq;
	private String rphone;
	private String rcontent;
	private String reffect;
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRqq() {
		return rqq;
	}
	public void setRqq(String rqq) {
		this.rqq = rqq;
	}
	public String getRphone() {
		return rphone;
	}
	public void setRphone(String rphone) {
		this.rphone = rphone;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getReffect() {
		return reffect;
	}
	public void setReffect(String reffect) {
		this.reffect = reffect;
	}

}
