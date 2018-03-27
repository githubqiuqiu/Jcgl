package com.edu.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.edu.bean.RoleBean;
import com.edu.bean.UserBean;
import com.edu.model.Role;
import com.edu.model.User;
import com.edu.service.QiuService;
import com.opensymphony.xwork2.ActionSupport;

public class FindRoleAction extends ActionSupport{
	private QiuService qiuService;
	private List list;
	private Integer listcount;
	private Map map;
	private String json;
	
	public QiuService getQiuService() {
		return qiuService;
	}
	public void setQiuService(QiuService qiuService) {
		this.qiuService = qiuService;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Integer getListcount() {
		return listcount;
	}
	public void setListcount(Integer listcount) {
		this.listcount = listcount;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	
	@Override
	public String execute() throws Exception {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		res.setCharacterEncoding("utf-8");
		
		String page = req.getParameter("page");
		String rows = req.getParameter("rows");
		int i1=Integer.parseInt(page);
		int i2=Integer.parseInt(rows);
		System.out.println("i1="+i1);
		System.out.println("i2="+i2);
		//返回总数据
		list=qiuService.showlist1(i1,i2);
	
		//返回数据条数
		listcount=qiuService.listcount1();
		
		System.out.println("list="+list);
		System.out.println("listcount="+listcount);
		
		
		List<RoleBean> list1=new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Role r=(Role) list.get(i);
			RoleBean rb=new RoleBean();
			rb.setId(r.getId());
			rb.setName(r.getName());
			rb.setSeq(r.getSeq());
			rb.setDescription(r.getDescription());
			rb.setStatus(r.getStatus());
			list1.add(rb);
		}
		
		

		map=new HashMap<>();
		map.put("total", listcount);
		map.put("rows", list1);
	
		json=JSON.toJSONString(map);//把map转换成json格式
		System.out.println("json格式:"+json);
		
		try {
			PrintWriter pw=res.getWriter();
			pw.println(json);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}
	
}
