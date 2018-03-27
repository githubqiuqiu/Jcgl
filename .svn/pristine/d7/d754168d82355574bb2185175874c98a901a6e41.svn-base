package com.edu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class RemoveUserAction extends ActionSupport{
	
	@Override
	public String execute() throws Exception {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		res.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		
		
		
		session.removeAttribute("user");
		return SUCCESS;
	}
}
