package com.edu.model;

import java.io.Serializable;
/**
 * 
 * @author Min
 *	公告表  nid 主键
 *		ntitle 名称
 *		ncontent 内容
 *		ndate 日期
 *		nflag 标志 0公告 1 简章
 */
public class Notice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer nid;
	private String ntitle;
	private String ncontent;
	private String ndate; 
	private Integer nflag;
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public String getNdate() {
		return ndate;
	}
	public void setNdate(String ndate) {
		this.ndate = ndate;
	}
	public Integer getNflag() {
		return nflag;
	}
	public void setNflag(Integer nflag) {
		this.nflag = nflag;
	}
}
