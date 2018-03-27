package com.edu.action;

import com.edu.model.Organization;
import com.edu.model.Role;
import com.edu.service.QiuService;
import com.opensymphony.xwork2.ActionSupport;

public class DelAction extends ActionSupport{
	private Role role;
	private Organization organization;
	private QiuService qiuService;
	private Integer id;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public QiuService getQiuService() {
		return qiuService;
	}

	public void setQiuService(QiuService qiuService) {
		this.qiuService = qiuService;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	//删除角色管理
	public String delrole() {
		//System.out.println(role.getId());
		qiuService.delrole(role.getId());
		return null;
	}
	
	//删除部门管理
	public String delorg() {
		qiuService.delorg(organization.getId());
		return null;
	}
	
	//删除成人报名表信息
	public String deladult() {
		qiuService.deladult(id);
		
		//级联删除成考缴费表信息和文件上传表信息
		
		
		
		return null;
	}
	
	//删除国家开放大学报名表信息
	public String delstate() {
		qiuService.delstate(id);
		return null;
	}
	
	//删除远程教育报名表信息
	public String deldis() {
		qiuService.deldis(id);
		return null;
	}
	
	//删除成人缴费表信息
	public String deladultfinance() {
		qiuService.deladultfinance(id);
		return null;
	}
	
	//删除国家开放大学缴费表信息
	public String delstatefinance() {
		qiuService.delstatefinance(id);
		return null;
	}
	
	//删除远程教育缴费表信息
	public String deldisfinance() {
		qiuService.deldisfinance(id);
		return null;
	}
	
	//删除会计缴费表信息
	public String delaccfinance() {
		qiuService.delaccfinance(id);
		return null;
	}
	
	//删除职考缴费表信息
	public String delprofinance() {
		qiuService.delprofinance(id);
		return null;
	}
	
	//删除艺考缴费表信息
	public String delartfinance() {
		qiuService.delartfinance(id);
		return null;
	}
	
	//删除工作助手信息
	public String delschedule() {
		qiuService.delschedule(id);
		return null;
	}
	
	
}
