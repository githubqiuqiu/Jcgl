package com.edu.model;

import java.io.Serializable;
/**
 * 
 * @author 	Min
 *	工作助手       sid主键
 *			userid用户
 *			stitle主题
 *			scontent内容
 *			sdate创建日期
 *			sfinishdate完成日期
 *			sflag标志 0未完成  1完成
 */
public class Schedule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer sid;
	private Integer userid;
	private String stitle;
	private String scontent;
	private String sdate;
	private String sfinishdate;
	private Integer sflag;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getStitle() {
		return stitle;
	}
	public void setStitle(String stitle) {
		this.stitle = stitle;
	}
	public String getScontent() {
		return scontent;
	}
	public void setScontent(String scontent) {
		this.scontent = scontent;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getSfinishdate() {
		return sfinishdate;
	}
	public void setSfinishdate(String sfinishdate) {
		this.sfinishdate = sfinishdate;
	}
	public Integer getSflag() {
		return sflag;
	}
	public void setSflag(Integer sflag) {
		this.sflag = sflag;
	}
	
	//用户表
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
