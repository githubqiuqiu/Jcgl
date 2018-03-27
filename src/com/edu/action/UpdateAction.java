package com.edu.action;

import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.edu.service.QiuService;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport{
	private QiuService qiuService;
	private String nowpwd;
	private String newpwd;
	private String againpwd;
	private Integer uid;
	
	public QiuService getQiuService() {
		return qiuService;
	}
	public void setQiuService(QiuService qiuService) {
		this.qiuService = qiuService;
	}
	public String getNowpwd() {
		return nowpwd;
	}
	public void setNowpwd(String nowpwd) {
		this.nowpwd = nowpwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getAgainpwd() {
		return againpwd;
	}
	public void setAgainpwd(String againpwd) {
		this.againpwd = againpwd;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	//后台修改当前用户登入密码
	public String updateuserpwd() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		res.setCharacterEncoding("utf-8");
		
		String jmymm="";
	
	     try {  
	            // 得到一个信息摘要器  
	            MessageDigest digest = MessageDigest.getInstance("md5");  
	            byte[] result = digest.digest(nowpwd.getBytes());  
	            StringBuffer buffer = new StringBuffer();  
	            // 把没一个byte 做一个与运算 0xff;  
	            for (byte b : result) {  
	                // 与运算  
	                int number = b & 0xff;// 加盐  
	                String str = Integer.toHexString(number);  
	                if (str.length() == 1) {  
	                    buffer.append("0");  
	                }  
	                buffer.append(str);  
	            }  
	  
	            // 标准的md5加密后的结果  
	            jmymm= buffer.toString();  
	           System.out.println("newpwd="+newpwd);
	        } catch (NoSuchAlgorithmException e) {  
	            e.printStackTrace();  
	            return "";  
	        }  
	     
	     	
	 	String xinpwd=newpwd;
	 	 try {  
	            // 得到一个信息摘要器  
	            MessageDigest digest = MessageDigest.getInstance("md5");  
	            byte[] result = digest.digest(newpwd.getBytes());  
	            StringBuffer buffer = new StringBuffer();  
	            // 把没一个byte 做一个与运算 0xff;  
	            for (byte b : result) {  
	                // 与运算  
	                int number = b & 0xff;// 加盐  
	                String str = Integer.toHexString(number);  
	                if (str.length() == 1) {  
	                    buffer.append("0");  
	                }  
	                buffer.append(str);  
	            }  
	  
	            // 标准的md5加密后的结果  
	            xinpwd= buffer.toString();  
	          // System.out.println("newpwd="+newpwd);
	        } catch (NoSuchAlgorithmException e) {  
	            e.printStackTrace();  
	            return "";  
	        }  
	     
	     
		
		//先判断用户的密码正不正确
		String pwd=qiuService.seluserpwd(uid);
		String message="";
		if(pwd.equals(jmymm)) {//如果输入的密码正确
			//修改用户密码
			qiuService.updatepwd(uid, xinpwd);
			message="1";
			//移除session
			session.removeAttribute("user");
		}
		else {
			message="2";
		}
		try {
			PrintWriter pw=res.getWriter();
			pw.print(message);
		} catch (Exception e) {
			
		}
		return null;
	}
	
	
	
	
	
}
