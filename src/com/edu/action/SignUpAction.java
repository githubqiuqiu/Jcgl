package com.edu.action;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.edu.model.Schedule;
import com.edu.model.Syslog;
import com.edu.model.User;
import com.edu.service.QiuService;
import com.edu.service.impl.MinServiceImpl;
import com.google.gson.Gson;

import com.opensymphony.xwork2.ActionSupport;

public class SignUpAction extends ActionSupport{
	private MinServiceImpl minService;
	public MinServiceImpl getMinService() {
		return minService;
	}
	public void setMinService(MinServiceImpl minService) {
		this.minService = minService;
	}
	private String loginname;
	private String pwd;
	private String yzm;
	private QiuService qiuService;
	private List<User> list;
	private String result;
	private List listschedule;

	
	
	public String getLoginname() {
		return loginname;
	}



	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public List getListschedule() {
		return listschedule;
	}



	public void setListschedule(List listschedule) {
		this.listschedule = listschedule;
	}

	public String getYzm() {
		return yzm;
	}



	public void setYzm(String yzm) {
		this.yzm = yzm;
	}

	public QiuService getQiuService() {
		return qiuService;
	}

	public void setQiuService(QiuService qiuService) {
		this.qiuService = qiuService;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}



	@Override
	public String execute() throws Exception {
		System.out.println("进了sign");
		/*System.out.println(user.getLoginname());
		System.out.println(user.getPassword());
		System.out.println(yzm);*/
		System.out.println("name="+loginname);
		System.out.println("pwd="+pwd);
		System.out.println("yzm="+yzm);
		
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		res.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		
		String str="";
		
		//获得验证码
		String getyzm=(String) session.getAttribute("verCode");
		//查询账号是否存在
		List<User> list1=new ArrayList<>();
		list1=qiuService.findUser(loginname);
		//System.out.println("list1="+list1);
		
		//System.out.println( "session"+session.getAttribute("user"));
		
			//判断验证码大小写都可以
			if((yzm.toLowerCase()).equals(getyzm.toLowerCase())||(yzm.toUpperCase()).equals(getyzm.toUpperCase())){
				//System.out.println("验证码正确");
				//判断账号是否存在
				if(list1 != null && list1.size() > 0){//账号存在
				
					//判断账号密码是否一致
					String jmpwd=pwd;
					
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
				            jmpwd= buffer.toString();  
				         
				        } catch (NoSuchAlgorithmException e) {  
				            e.printStackTrace();  
				            return "";  
				        }
					
					
					
					list=qiuService.selectUser(loginname, jmpwd);
			
					if(list != null && list.size() > 0){//登录成功
						
						
						//System.out.println("账号密码一致");
						User u=list.get(0);
						
						if(u.getStatus()==0) {//正常
							//保存登录用户到session
							session.setAttribute("user", u);
							str="1";
							
							//插入日志
							String s = "用户"+u.getLoginname()+"ip"+req.getRemoteAddr();
							Syslog syslog = new Syslog();
							syslog.setClientip(req.getRemoteAddr());
							syslog.setCreatetime(new Date().toLocaleString());
							syslog.setLoginname(u.getLoginname());
							syslog.setOptcontent(s+"类名："+this.getClass().getName()+"方法：login");
							syslog.setRolename(u.getName());
							minService.addsyslog(syslog);
						}
						else {//用户停用
							str="5";
						}
						
						
						
					}else {
						//req.setAttribute("mmmsg", "密码不正确");
						str="2";
						
					}
					
				}
				else{//账号不存在
					//req.setAttribute("zhmsg", "账号不存在");
					str="3";
				
				}
				
			}
			else{//验证码不正确
				str="4";
			}
			
			try {
				PrintWriter pw=res.getWriter();
				pw.print(str);
				//System.out.println("返回成功");
			} catch (Exception e) {
				
			}
			return null;
			
		}
		
	//进入后台
	public String tobackstage() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		res.setCharacterEncoding("utf-8");
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		User u=(User) session.getAttribute("user");
		
		listschedule=qiuService.selschedulebyuid(u.getId());
//		查询该用户的工作日程
		for (int i = 0; i < listschedule.size(); i++) {
			Schedule s=(Schedule) listschedule.get(i);
			s.setStitle(i+1+"");
		}
		
		return SUCCESS;
	}
		 
}
