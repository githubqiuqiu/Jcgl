package com.edu.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;

import org.apache.struts2.ServletActionContext;

import com.edu.model.Schedule;
import com.edu.model.User;
import com.edu.service.impl.MinServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

import oracle.sql.DATE;

public class SelSchedule extends ActionSupport {
	private String stitle;
	private String scontent;
	private String data;
	public String getStitle() {
		return stitle;
	}
	public void setStitle(String stitle) {
		this.stitle = stitle;
	}
	public String getScontent() {
		return scontent;
	}
	public void setScontent(String scontent) {
		this.scontent = scontent;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	private Schedule schedule;
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	private MinServiceImpl minService;
	private List list;
	public MinServiceImpl getMinService() {
		return minService;
	}
	public void setMinService(MinServiceImpl minService) {
		this.minService = minService;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("查询工作助手");
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session = req.getSession();
		User u =(User) session.getAttribute("teacher");
		
		int userid = u.getId();
		list= minService.selsche(userid);
		return SUCCESS;
	}
	public String delsche() {
		HttpServletRequest req = ServletActionContext.getRequest();
		int sid = Integer.parseInt(req.getParameter("sid"));
		minService.delsche(sid);
		return SUCCESS;
	}
	public String editsche() {
		HttpServletRequest req = ServletActionContext.getRequest();
		int sid = Integer.parseInt(req.getParameter("sid"));
		minService.editsche(sid);
		return SUCCESS;
	}
	public String addsche() {
		System.out.println("进入日程添加!");
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session = req.getSession();
		User u =(User) session.getAttribute("teacher");
		
		//构造schedule对象
		Schedule s = new Schedule();
		s.setScontent(scontent);
		s.setStitle(stitle);
		s.setSdate(new Date().toLocaleString());
		s.setSfinishdate(null);
		s.setSflag(0);
		s.setUser(u);
		s.setUserid(u.getId());
		minService.addsche(s);
		list = minService.selsche(u.getId());
		
		data="{'firstName':'Brett'} ";
		
		return null;
	}

}
