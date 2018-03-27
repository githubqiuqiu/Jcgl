package com.edu.action;

import com.edu.model.User;
import com.edu.service.QiuService;
import com.opensymphony.xwork2.ActionSupport;

public class ResertAction extends ActionSupport{
	private User user;
	private QiuService qiuService;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public QiuService getQiuService() {
		return qiuService;
	}
	public void setQiuService(QiuService qiuService) {
		this.qiuService = qiuService;
	}
	
	
	//重置用户密码方法
	public String resertpwd() {
		qiuService.resertpwd(user.getId());
		return null;
	}
	
}
