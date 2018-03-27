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
import com.edu.bean.OrganizationBean;
import com.edu.model.Organization;
import com.edu.service.impl.MinServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class DepartmentAction extends ActionSupport {
	
	private MinServiceImpl minService;
	
	public MinServiceImpl getMinService() {
		return minService;
	}
	public void setMinService(MinServiceImpl minService) {
		this.minService = minService;
	}
	private List<Organization> list = new ArrayList<>();
	
	public List<Organization> getList() {
		return list;
	}
	public void setList(List<Organization> list) {
		this.list = list;
	}
	private int i;
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	private String str;
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	@Override
	public String execute() throws Exception {
//		System.out.println("123123123!");
		// TODO Auto-generated method stub
		HttpServletResponse res = ServletActionContext.getResponse();
		HttpServletRequest req = ServletActionContext.getRequest();
		
	  	String page = req.getParameter("page");
	  	String rows = req.getParameter("rows");
		
		int pag = Integer.parseInt(page);
		int row = Integer.parseInt(rows);
	  	
		res.setCharacterEncoding("utf-8");
	  	list = minService.seldep(pag,row);
	  	i = minService.line();
	  	
	  	List<OrganizationBean> list1=new ArrayList<>();
	  	for (int i = 0; i < list.size(); i++) {
			Organization o=list.get(i);
			OrganizationBean ob=new OrganizationBean();
			ob.setId(o.getId());
			ob.setName(o.getName());
			ob.setAddress(o.getAddress());
			ob.setSeq(o.getSeq());
			ob.setCreatetime(o.getCreatetime());
			ob.setCode(o.getCode());
			ob.setIcon(o.getIcon());
			list1.add(ob);
		}
	  	

	  	
	  	Map map = new HashMap<>();
	  	map.put("total", i);
	  	map.put("rows", list1);
	  	
	  	str = JSON.toJSONString(map);
	  	PrintWriter pw = res.getWriter();
	  	pw.print(str);
	  	System.out.println(str);
	  	return null;
	}

	
}
