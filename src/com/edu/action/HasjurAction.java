package com.edu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.edu.model.User;
import com.edu.model.Userjurisdiction;
import com.edu.service.QiuService;
import com.edu.service.impl.QiuServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class HasjurAction extends ActionSupport{
	private Integer jid;
	private List listuserjur;
	private QiuService qiuService;
	private Userjurisdiction userjurisdiction;
	
	
	public Userjurisdiction getUserjurisdiction() {
		return userjurisdiction;
	}

	public void setUserjurisdiction(Userjurisdiction userjurisdiction) {
		this.userjurisdiction = userjurisdiction;
	}

	public QiuService getQiuService() {
		return qiuService;
	}

	public void setQiuService(QiuService qiuService) {
		this.qiuService = qiuService;
	}

	public List getListuserjur() {
		return listuserjur;
	}

	public void setListuserjur(List listuserjur) {
		this.listuserjur = listuserjur;
	}
	
	public Integer getJid() {
		return jid;
	}

	public void setJid(Integer jid) {
		this.jid = jid;
	}

	//判断是否有角色管理权限
	public String hasjur() {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=request.getSession();
		
		User u=(User) session.getAttribute("user");
		int rid=u.getRid();
		listuserjur =qiuService.hasjur(rid, jid);
		
		userjurisdiction=(Userjurisdiction) listuserjur.get(0);
		
		if(listuserjur != null && listuserjur.size() > 0&&userjurisdiction.getFlag()==0) {//说明有权限
			//System.out.println("成功");
			return SUCCESS;
		}
		else {
			//System.out.println("失败");
			return ERROR;
		}
	}
	
	/*//判断用户是否有用户管理权限
	public String hasuserjur() {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=request.getSession();
		
		User u=(User) session.getAttribute("user");
		int rid=u.getRid();
		listuserjur =qiuService.hasjur(rid, jid);
		
		userjurisdiction=(Userjurisdiction) listuserjur.get(0);
		
		if(listuserjur != null && listuserjur.size() > 0&&userjurisdiction.getFlag()==0) {//说明有权限
			System.out.println("成功");
			return SUCCESS;
		}
		else {
			System.out.println("失败");
			return ERROR;
		}
	}
	
	//判断用户是否有部门管理权限
	public String hasdepjur() {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=request.getSession();
		
		User u=(User) session.getAttribute("user");
		int rid=u.getRid();
		listuserjur =qiuService.hasjur(rid, jid);
		userjurisdiction=(Userjurisdiction) listuserjur.get(0);
		if(listuserjur != null && listuserjur.size() > 0&&userjurisdiction.getFlag()==0) {//说明有权限
			System.out.println("成功");
			return SUCCESS;
		}
		else {
			System.out.println("失败");
			return ERROR;
		}
	}
	
	//判断用户是否有成考报名权限
	public String hasadultjur() {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=request.getSession();
		
		User u=(User) session.getAttribute("user");
		int rid=u.getRid();
		listuserjur =qiuService.hasjur(rid, jid);
		userjurisdiction=(Userjurisdiction) listuserjur.get(0);
		if(listuserjur != null && listuserjur.size() > 0&&userjurisdiction.getFlag()==0) {//说明有权限
			System.out.println("成功");
			return SUCCESS;
		}
		else {
			System.out.println("失败");
			return ERROR;
		}
	}
	
	//判断用户是否有会计报名权限
		public String hasaccjur() {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
			HttpSession session=request.getSession();
			
			User u=(User) session.getAttribute("user");
			int rid=u.getRid();
			listuserjur =qiuService.hasjur(rid, jid);
			userjurisdiction=(Userjurisdiction) listuserjur.get(0);
			if(listuserjur != null && listuserjur.size() > 0&&userjurisdiction.getFlag()==0) {//说明有权限
				System.out.println("成功");
				return SUCCESS;
			}
			else {
				System.out.println("失败");
				return ERROR;
			}
		}
	
		//判断用户是否有国家开放大学报名权限
		public String hasstatejur() {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
			HttpSession session=request.getSession();
			
			User u=(User) session.getAttribute("user");
			int rid=u.getRid();
			listuserjur =qiuService.hasjur(rid, jid);
			userjurisdiction=(Userjurisdiction) listuserjur.get(0);
			if(listuserjur != null && listuserjur.size() > 0&&userjurisdiction.getFlag()==0) {//说明有权限
				System.out.println("成功");
				return SUCCESS;
			}
			else {
				System.out.println("失败");
				return ERROR;
			}
		}*/
	
	
}
