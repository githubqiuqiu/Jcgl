package com.edu.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.edu.model.Homecontent;
import com.edu.model.Notice;
import com.edu.service.impl.MinServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class NoticeAction extends ActionSupport {
	private Homecontent home = new Homecontent();
	public Homecontent getHome() {
		return home;
	}
	public void setHome(Homecontent home) {
		this.home = home;
	}
	private List list;
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	private int count;
	private Notice notice;
	private MinServiceImpl minService;
	public Notice getNotice() {
		return notice;
	}
	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	public MinServiceImpl getMinService() {
		return minService;
	}
	public void setMinService(MinServiceImpl minService) {
		this.minService = minService;
	}
	public String sel() {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		res.setCharacterEncoding("utf-8");
		
		int page = Integer.parseInt(req.getParameter("page"));
		int rows = Integer.parseInt(req.getParameter("rows"));
		String ntitle = req.getParameter("ntitle");
		
		list = minService.selnotice(page, rows, ntitle);
		count = list.size();
		
		Map map = new HashMap<>();
		map.put("total", count);
		map.put("rows", list);
		
		String str = JSON.toJSONString(map);
		PrintWriter pw = null;
		try {
			pw = res.getWriter();
			pw.print(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String add() {
		Notice n = new Notice();
		n.setNcontent(notice.getNcontent());
		n.setNdate(notice.getNdate());
		n.setNtitle(notice.getNtitle());
		minService.addnotice(n);
		return SUCCESS;
	}
	public String del() {
		HttpServletRequest req = ServletActionContext.getRequest();
		int nid = Integer.parseInt(req.getParameter("nid"));
		minService.delnotice(nid);
		return SUCCESS;
	}
	public String editsel() {
		HttpServletRequest req = ServletActionContext.getRequest();
		int nid = Integer.parseInt(req.getParameter("nid"));
		notice = minService.selonernotice(nid);
		return SUCCESS;
	}
	public String edit() {
		Notice n = new Notice();
		n.setNcontent(notice.getNcontent());
		n.setNdate(notice.getNdate());
		n.setNid(notice.getNid());
		n.setNtitle(notice.getNtitle());
		minService.edit(n);
		return SUCCESS;
	}
	public String selone() {
		HttpServletRequest req = ServletActionContext.getRequest();
		int nid = Integer.parseInt(req.getParameter("nid"));
		notice = minService.selonernotice(nid);
		return SUCCESS;
	}
	public String selall() {
		list = minService.selnotice();
		return SUCCESS;
	}
}
