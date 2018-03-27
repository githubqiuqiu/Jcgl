package com.edu.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.edu.bean.FinanceBean;
import com.edu.model.Accountantfinance;
import com.edu.model.Adultfinance;
import com.edu.model.Artfinance;
import com.edu.model.Distancefinance;
import com.edu.model.Professionapply;
import com.edu.model.Professionfinance;
import com.edu.model.Statefinance;
import com.edu.model.User;
import com.edu.service.MinService;
import com.edu.service.impl.MinServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class AllFinance extends ActionSupport {
	private MinServiceImpl minService;
	private List<FinanceBean> list = new ArrayList<FinanceBean>();
	private FinanceBean bean = new FinanceBean();

	public MinServiceImpl getMinService() {
		return minService;
	}
	public void setMinService(MinServiceImpl minService) {
		this.minService = minService;
	}
	public List<FinanceBean> getList() {
		return list;
	}
	public void setList(List<FinanceBean> list) {
		this.list = list;
	}
	public FinanceBean getBean() {
		return bean;
	}
	public void setBean(FinanceBean bean) {
		this.bean = bean;
	}
	@Override
	public String execute() throws Exception {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session = req.getSession();
		User  u =(User) session.getAttribute("teacher");
		int userid = u.getId();
		
		List l1 = minService.selaccbytid(userid);
		for(int i=0;i<l1.size();i++) {
			Accountantfinance a =(Accountantfinance) l1.get(i);
			FinanceBean bean = new FinanceBean();
			bean.setFid(a.getFid());
			bean.setFdata(a.getFdata());
			bean.setFstatu(a.getFstatu());
			bean.setFtest1(a.getFtest1());
			bean.setFtest2(u.getName());
			bean.setFway(a.getFway());
			bean.setNeedmoney(a.getNeedmoney());
			bean.setPracticalmoney(a.getPracticalmoney());
			bean.setSid(a.getSid());
			bean.setSname(a.getSname());
			bean.setTid(a.getTid());
			list.add(bean);
		}
		List l2 = minService.selartbytid(userid);
		for(int i=0;i<l2.size();i++) {
			Artfinance a =(Artfinance) l2.get(i);
			FinanceBean bean = new FinanceBean();
			bean.setFid(a.getFid());
			bean.setFdata(a.getFdata());
			bean.setFstatu(a.getFstatu());
			bean.setFtest1(a.getFtest1());
			bean.setFtest2(u.getName());
			bean.setFway(a.getFway());
			bean.setNeedmoney(a.getNeedmoney());
			bean.setPracticalmoney(a.getPracticalmoney());
			bean.setSid(a.getSid());
			bean.setSname(a.getSname());
			bean.setTid(a.getTid());
			list.add(bean);
		}
		List l3 = minService.seldisbytid(userid);
		for(int i=0;i<l3.size();i++) {
			Distancefinance a =(Distancefinance) l3.get(i);
			FinanceBean bean = new FinanceBean();
			bean.setFid(a.getFid());
			bean.setFdata(a.getFdata());
			bean.setFstatu(a.getFstatu());
			bean.setFtest1(a.getFtest1());
			bean.setFtest2(u.getName());
			bean.setFway(a.getFway());
			bean.setNeedmoney(a.getNeedmoney());
			bean.setPracticalmoney(a.getPracticalmoney());
			bean.setSid(a.getSid());
			bean.setSname(a.getSname());
			bean.setTid(a.getTid());
			list.add(bean);
		}
		List l4 = minService.selprobytid(userid);
		for(int i=0;i<l4.size();i++) {
			Professionfinance a =(Professionfinance) l4.get(i);
			FinanceBean bean = new FinanceBean();
			bean.setFid(a.getFid());
			bean.setFdata(a.getFdata());
			bean.setFstatu(a.getFstatu());
			bean.setFtest1(a.getFtest1());
			bean.setFtest2(u.getName());
			bean.setFway(a.getFway());
			bean.setNeedmoney(a.getNeedmoney());
			bean.setPracticalmoney(a.getPracticalmoney());
			bean.setSid(a.getSid());
			bean.setSname(a.getSname());
			bean.setTid(a.getTid());
			list.add(bean);
		}
		List l5 = minService.selstabytid(userid);
		for(int i=0;i<l5.size();i++) {
			Statefinance a =(Statefinance) l5.get(i);
			FinanceBean bean = new FinanceBean();
			bean.setFid(a.getFid());
			bean.setFdata(a.getFdata());
			bean.setFstatu(a.getFstatu());
			bean.setFtest1(a.getFtest1());
			bean.setFtest2(u.getName());
			bean.setFway(a.getFway());
			bean.setNeedmoney(a.getNeedmoney());
			bean.setPracticalmoney(a.getPracticalmoney());
			bean.setSid(a.getSid());
			bean.setSname(a.getSname());
			bean.setTid(a.getTid());
			list.add(bean);
		}
		List l6 = minService.seladubytid(userid);
		for(int i=0;i<l6.size();i++) {
			Adultfinance a =(Adultfinance) l6.get(i);
			FinanceBean bean = new FinanceBean();
			bean.setFid(a.getFid());
			bean.setFdata(a.getFdata());
			bean.setFstatu(a.getFstatu());
			bean.setFtest1(a.getFtest1());
			bean.setFtest2(u.getName());
			bean.setFway(a.getFway());
			bean.setNeedmoney(a.getNeedmoney());
			bean.setPracticalmoney(a.getPracticalmoney());
			bean.setSid(a.getSid());
			bean.setSname(a.getSname());
			bean.setTid(a.getTid());
			list.add(bean);
		}
		return SUCCESS;
	}
}
