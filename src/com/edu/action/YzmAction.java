package com.edu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.edu.common.VerifyCodeUtils;
import com.opensymphony.xwork2.ActionSupport;

public class YzmAction extends ActionSupport{
	//随机字符串
	private String verifyCode;

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpServletResponse res=ServletActionContext.getResponse();
		res.setHeader("Pragma", "No-cache"); 
        res.setHeader("Cache-Control", "no-cache"); 
        res.setDateHeader("Expires", 0); 
        res.setContentType("image/jpeg"); 
           
        //生成随机字串 
         verifyCode = VerifyCodeUtils.generateVerifyCode(4); 
        System.out.println("ver="+verifyCode);
        //存入会话session 
        HttpSession session = req.getSession(true); 
        //删除以前的
        session.removeAttribute("verCode");
        //转小写verifyCode.toLowerCase()
        session.setAttribute("verCode",verifyCode ); 
        //生成图片 
        int w = 150, h = 50; 
        VerifyCodeUtils.outputImage(w, h, res.getOutputStream(), verifyCode); 
		
		return null;
	}
	
}
