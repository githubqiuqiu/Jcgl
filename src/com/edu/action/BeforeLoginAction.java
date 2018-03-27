package com.edu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.edu.model.Schedule;
import com.edu.model.User;
import com.edu.service.QiuService;
import com.opensymphony.xwork2.ActionSupport;

public class BeforeLoginAction extends ActionSupport{
	private List listschedule;
	private QiuService qiuService;
	
	public List getListschedule() {
		return listschedule;
	}

	public void setListschedule(List listschedule) {
		this.listschedule = listschedule;
	}

	public QiuService getQiuService() {
		return qiuService;
	}

	public void setQiuService(QiuService qiuService) {
		this.qiuService = qiuService;
	}

	@Override
	public String execute() throws Exception {

		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		res.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		
		
		
		if(session.getAttribute("user")==null){//没有登录 跳到登录界面
			return LOGIN;
		}
		else{//登入了  直接跳到后台界面
			
			User u=(User) session.getAttribute("user");
			
			listschedule=qiuService.selschedulebyuid(u.getId());
			//查询该用户的工作日程
			for (int i = 0; i < listschedule.size(); i++) {
				Schedule s=(Schedule) listschedule.get(i);
				s.setStitle(i+1+"");
			}
			return SUCCESS;
		}
	}
	
}
