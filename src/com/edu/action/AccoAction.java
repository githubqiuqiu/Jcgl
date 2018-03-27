package com.edu.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.edu.bean.AccountantapplyBean;

import com.edu.model.Accountantapply;
import com.edu.model.City;
import com.edu.model.County;
import com.edu.model.User;
import com.edu.service.impl.MinServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class AccoAction extends ActionSupport {
	private List userlist;
	public List getUserlist() {
		return userlist;
	}

	public void setUserlist(List userlist) {
		this.userlist = userlist;
	}
	private List countylist;
	public List getCountylist() {
		return countylist;
	}

	public void setCountylist(List countylist) {
		this.countylist = countylist;
	}
	private List citylist;
	public List getCitylist() {
		return citylist;
	}

	public void setCitylist(List citylist) {
		this.citylist = citylist;
	}
	private AccountantapplyBean abean;
	public AccountantapplyBean getAbean() {
		return abean;
	}

	public void setAbean(AccountantapplyBean abean) {
		this.abean = abean;
	}
	private int count;
	private MinServiceImpl minService;

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
		
		String aname = req.getParameter("aname");
		String name = req.getParameter("name");
		String cname = req.getParameter("cname");
		
		System.out.println("aname="+aname);
		System.out.println("name="+name);
		System.out.println("cname="+cname);
		int page = Integer.parseInt(req.getParameter("page"));
		int rows = Integer.parseInt(req.getParameter("rows"));
		
		//判断当前用户类型
		HttpSession session = req.getSession();
		User user =(User) session.getAttribute("user");
		int utype = user.getRid();
		List list = new ArrayList<>();
		if(utype==1) {//管理员
			 list = minService.selaccountantapplydata(page, rows,aname,name,cname);
			 count = minService.selaccount(aname,name,cname);
		}else {//用户
			int userid = user.getId();
			list = minService.selaccountantapplydata(page, rows, aname, name, cname, userid);
			List l = minService.selacclist(aname, name, cname);
			int c = 0;
			for(int i=0;i<l.size();i++) {
				Object[] o =(Object[]) l.get(i);
				Accountantapply a = (Accountantapply)o[0];
				if(a.getUserid()==userid) {
					c++;
				}
			}
			count = c;
		}
		

		
		List list2 = new ArrayList<>();
		for(int i =0;i<list.size();i++) {
			Object[] o =(Object[]) list.get(i);
			Accountantapply a = (Accountantapply)o[0];
			User u = (User)o[1];
			City c = (City)o[2];
			County co = (County)o[3];
			
			AccountantapplyBean account = new AccountantapplyBean();
			account.setAid(a.getAid());
			account.setAcontent(a.getAcontent());
			account.setAdata(a.getAdata());
			account.setAname(a.getAname());
			account.setAphone(a.getAphone());
			account.setAstudentno(a.getAstudentno());
			account.setCid(c.getCid());
			account.setCname(c.getCname());
			account.setCoid(co.getCoid());
			account.setConame(co.getConame());
			account.setId(u.getId());
			account.setName(u.getName());
			
			list2.add(account);
		}
		
		Map map = new HashMap<>();
		map.put("total", count);
		map.put("rows", list2);

		String str = JSON.toJSONString(map);
		PrintWriter pw = null;
		try {
			pw = res.getWriter();
			pw.print(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		 System.out.println(str);
		return null;
	}
	public String seledit() {
		HttpServletRequest req = ServletActionContext.getRequest();
		System.out.println(req.getParameter("aid"));
		int aid = Integer.parseInt(req.getParameter("aid"));
		abean = minService.selone(aid);

		//查询所有城市
		citylist = minService.selallcity();
		//根据城市id查询县城
		countylist = minService.selcountybycity(abean.getCid());
		return SUCCESS;
	}
	public String selcounty() {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		res.setCharacterEncoding("utf-8");
		System.out.println(req.getParameter("cityid"));
		int cid = Integer.parseInt(req.getParameter("cityid"));
		
		//根据cid查询county
		countylist = minService.selcountybycity(cid);
		
		List l = new ArrayList<>();
		for(int i=0;i<countylist.size();i++) {
			County c =(County) countylist.get(i);
			AccountantapplyBean a = new AccountantapplyBean();
			a.setCid(c.getCid());
			a.setCoid(c.getCoid());
			a.setConame(c.getConame());
			if(i==0) {
				a.setSelected(true);
			}else {
				a.setSelected(false);
			}
			l.add(a);
		}
		
		String str = JSON.toJSONString(l);
		PrintWriter pw = null;
		try {
			pw = res.getWriter();
			pw.print(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(str);
		return null;
	}
	public String edit() {
		minService.edit(abean);
		//根据学生id查询学生名字
		String aname = minService.selaccname(abean.getAid());
		String name = abean.getName();
		if(!aname.equals(name)) {//修改了名字
			//修改缴费表信息
			minService.editaccf(Integer.parseInt(abean.getAstudentno()), aname);
		}
		return SUCCESS;
	}
	public String del() {
		HttpServletRequest req = ServletActionContext.getRequest();
		System.out.println(req.getParameter("aid"));
		int aid = Integer.parseInt(req.getParameter("aid"));
		minService.delaccount(aid);
		return SUCCESS;
	}
	public String beforeadd() {
		//查询出所有城市
		citylist = minService.selallcity();
		//查询所有用户
		userlist = minService.seluser();
		return SUCCESS;
	}
	public String add() {
		minService.acountadd(abean);
		minService.addaccountfiance(abean);
		return SUCCESS;
	}
	public String selcity() {
		citylist = minService.selallcity();
		return SUCCESS;
	}
}
