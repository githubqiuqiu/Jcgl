package com.edu.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.edu.dao.MinDao;
import com.edu.model.User;
import com.edu.service.MinService;
import com.edu.service.impl.MinServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class TloginAction extends ActionSupport {
	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	private String p2;
	public String getP2() {
		return p2;
	}
	public void setP2(String p2) {
		this.p2 = p2;
	}
	private MinServiceImpl minService;
	private User user;
	public MinServiceImpl getMinService() {
		return minService;
	}
	public void setMinService(MinServiceImpl minService) {
		this.minService = minService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String execute() throws Exception {
		HttpServletRequest req = ServletActionContext.getRequest();
		String name = user.getLoginname();
		String pwd = user.getPassword();
		//判断账号是否存在
		User u = null;
		
		
		//把当前账号加密与数据库判断
		 try {  
	            // 得到一个信息摘要器  
	            MessageDigest digest = MessageDigest.getInstance("md5");  
	            byte[] result = digest.digest(pwd.getBytes());  
	            StringBuffer buffer = new StringBuffer();  
	            // 把没一个byte 做一个与运算 0xff;  
	            for (byte b : result) {  
	                // 与运算  
	                int number = b & 0xff;// 加盐  
	                String stri = Integer.toHexString(number);  
	                if (stri.length() == 1) {  
	                    buffer.append("0");  
	                }  
	                buffer.append(stri);  
	            }  
	  
	            // 标准的md5加密后的结果  
	            pwd= buffer.toString();  
	         
	        } catch (NoSuchAlgorithmException e) {  
	            e.printStackTrace();  
	            return "";  
	        }
		
		
		List list = minService.selteancher(name, pwd);
		//System.out.println(list);
		if(list.size()!=0) {//账号存在
			System.out.println("账号存在");
			for(int i=0;i<list.size();i++) {
				u = (User) list.get(i);
			}
			//保存到session中
			HttpSession session = req.getSession();
			session.setAttribute("teacher", u);
			return SUCCESS;
		}else {
			msg = "yes";
			System.out.println("账号不存在");
			return ERROR;
		}
		
	}
	//退出登陆
	public String loginout() {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session = req.getSession();
		session.removeAttribute("teacher");
		return SUCCESS;
	}
	//修改密码
	public String editpassword() {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session = req.getSession();
		user =(User) session.getAttribute("teacher");
		System.out.println("新密码"+p2);
		user.setPassword(p2);
		minService.updateuser(user);
		List l = minService.selteancher(user.getName(), user.getPassword());
		session.removeAttribute("teacher");
		for(int i=0;i<l.size();i++) {
			User u =(User) l.get(i);
			session.setAttribute("teacher", u);
		}
		return SUCCESS;
	}
}
