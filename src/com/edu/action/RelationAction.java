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
import com.edu.model.Relation;
import com.edu.service.impl.MinServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class RelationAction extends ActionSupport {
	private List list;
	private int count;
	private Relation relation;
	private MinServiceImpl minService;
	public Relation getRelation() {
		return relation;
	}
	public void setRelation(Relation relation) {
		this.relation = relation;
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
		String rcontent = req.getParameter("rcontent");
		
		list = minService.selrelation(page, rows, rcontent);
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
		Relation r = new Relation();
		r.setRcontent(relation.getRcontent());
		r.setReffect(relation.getReffect());
		r.setRphone(relation.getRphone());
		r.setRqq(relation.getRqq());
		minService.addrelation(r);
		return SUCCESS;
	}
	public String del() {
		HttpServletRequest req = ServletActionContext.getRequest();
		int rid = Integer.parseInt(req.getParameter("rid"));
		minService.delrelation(rid);
		return SUCCESS;
	}
	public String editsel() {
		HttpServletRequest req = ServletActionContext.getRequest();
		int rid = Integer.parseInt(req.getParameter("rid"));
		relation = minService.selonerelation(rid);
		return SUCCESS;
	}
	public String edit() {
		Relation r = new Relation();
		r.setRcontent(relation.getRcontent());
		r.setReffect(relation.getReffect());
		r.setRid(relation.getRid());
		r.setRphone(relation.getRphone());
		r.setRqq(relation.getRqq());
		minService.edit(r);
		return SUCCESS;
	}
	public String selall() {
		list = minService.selrelation();
		return SUCCESS;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
}
