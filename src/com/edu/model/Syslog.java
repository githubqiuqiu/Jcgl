package com.edu.model;

import java.io.Serializable;
/**
 * 
 * @author Min
 *	登陆日志表   id主键
 *			loginname登录名
 *			rolename角色名
 *			optcontent内容
 *			clientip ip地址
 *			createtime 时间
 */
public class Syslog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String loginname;
	private String rolename;
	private String optcontent;
	private String clientip;
	private String createtime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getOptcontent() {
		return optcontent;
	}
	public void setOptcontent(String optcontent) {
		this.optcontent = optcontent;
	}
	public String getClientip() {
		return clientip;
	}
	public void setClientip(String clientip) {
		this.clientip = clientip;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
}
