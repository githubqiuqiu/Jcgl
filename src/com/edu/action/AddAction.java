package com.edu.action;

import java.security.MessageDigest;
import java.util.Date;

import com.edu.model.Adultapply;
import com.edu.model.Adultfinance;
import com.edu.model.Distanceapply;
import com.edu.model.Distancefinance;
import com.edu.model.Organization;
import com.edu.model.Role;
import com.edu.model.Schedule;
import com.edu.model.Stateapply;
import com.edu.model.Statefinance;
import com.edu.model.Stufile;
import com.edu.model.User;
import com.edu.model.Userjurisdiction;
import com.edu.service.QiuService;
import com.opensymphony.xwork2.ActionSupport;

import sun.security.util.Password;

import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  


public class AddAction extends ActionSupport{
	private QiuService qiuService;
	private Role role;
	private User user;
	private Organization organization;
	private Adultapply adultapply;
	private Stateapply stateapply;
	private Distanceapply distanceapply;
	private Schedule schedule;
	
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public Distanceapply getDistanceapply() {
		return distanceapply;
	}
	public void setDistanceapply(Distanceapply distanceapply) {
		this.distanceapply = distanceapply;
	}
	public Stateapply getStateapply() {
		return stateapply;
	}
	public void setStateapply(Stateapply stateapply) {
		this.stateapply = stateapply;
	}
	public Adultapply getAdultapply() {
		return adultapply;
	}
	public void setAdultapply(Adultapply adultapply) {
		this.adultapply = adultapply;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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



	
	public String addrole() {
		//保存角色管理信息到数据库
		qiuService.addrole(role);
		
		//查询刚刚插入数据库的id
		int ii=qiuService.selroleid();
		//根据rid查权限
		String jur=qiuService.selrolejur(ii);
		
		//插入权限表数据
		for (int i = 1; i < 28; i++) {
			Userjurisdiction u=new Userjurisdiction();
			
			//最高权限 所有都能看到
			if(jur.equals("最高权限")) {
				u.setRid(ii);
				u.setJid(i);
				u.setFlag(0);
				qiuService.addjur(u);
			}
			
			//中权限
			if(jur.equals("中权限")) {
				if(i==1||i==2||i==3) {//财务不能看到权限
					u.setRid(ii);
					u.setJid(i);
					u.setFlag(1);
					qiuService.addjur(u);
				}
				else {//其他都能看
					u.setRid(ii);
					u.setJid(i);
					u.setFlag(0);
					qiuService.addjur(u);
				}
			}
			
			//低权限
			if(jur.equals("低权限")) {
				if(i==1||i==2||i==3||i==26||i==27) {//聚成管理不能看到权限和报表
					u.setRid(ii);
					u.setJid(i);
					u.setFlag(1);
					qiuService.addjur(u);
				}
				else {//其他都能看
					u.setRid(ii);
					u.setJid(i);
					u.setFlag(0);
					qiuService.addjur(u);
				}
			}
			
			//最低权限
			if(jur.equals("最低权限")) {
				if(i==1||i==2||i==3||i==11||i==12||i==13||i==14||i==15||i==16||i==17||i==18||i==26||i==27) {
					u.setRid(ii);
					u.setJid(i);
					u.setFlag(1);
					qiuService.addjur(u);
				}
				else {//合作老师只能看到报名管理和财务管理和工作助手
					u.setRid(ii);
					u.setJid(i);
					u.setFlag(0);
					qiuService.addjur(u);
				}
			}
	
		}
		
		return SUCCESS;
	}
	
	public String adduser() {
		//保存用户管理信息到数据库
		user.setCreatetime(new Date().toLocaleString());
		//System.out.println("部门id="+user.getOrganizationid());
		//System.out.println("角色id="+user.getRid());
		String newpwd=user.getPassword();
		
	     try {  
	            // 得到一个信息摘要器  
	            MessageDigest digest = MessageDigest.getInstance("md5");  
	            byte[] result = digest.digest(user.getPassword().getBytes());  
	            StringBuffer buffer = new StringBuffer();  
	            // 把没一个byte 做一个与运算 0xff;  
	            for (byte b : result) {  
	                // 与运算  
	                int number = b & 0xff;// 加盐  
	                String str = Integer.toHexString(number);  
	                if (str.length() == 1) {  
	                    buffer.append("0");  
	                }  
	                buffer.append(str);  
	            }  
	  
	            // 标准的md5加密后的结果  
	            newpwd= buffer.toString();  
	           System.out.println("newpwd="+newpwd);
	        } catch (NoSuchAlgorithmException e) {  
	            e.printStackTrace();  
	            return "";  
	        }  
		user.setPassword(newpwd);
		qiuService.adduser(user);
		return SUCCESS;
	}
	
	//添加部门信息到数据库
	public String adddep() {
		organization.setCreatetime(new Date().toLocaleString());
		qiuService.adddep(organization);
		return SUCCESS;
	}
	
	//添加成人高考信息到数据库
	public String addadult() {
		
		adultapply.setAtype(0);
		adultapply.setAdata(new Date().toLocaleString());
		
		Adultfinance adultfinance=new Adultfinance();
		int i=Integer.parseInt(adultapply.getAstudentno());
	
		//添加成人高考缴费表到数据库
		adultfinance.setSid(i);
		adultfinance.setSname(adultapply.getAname());
		adultfinance.setSchoolid(adultapply.getAcaid());
		adultfinance.setMajorid(adultapply.getSpecid());
		adultfinance.setGradation(adultapply.getAgradation());
		adultfinance.setTid(adultapply.getUserid());
		  if(adultfinance.getGradation().equals("高达专")) {
			  adultfinance.setNeedmoney(6000);
		  }else if(adultfinance.getGradation().equals("高达本")) {
			  adultfinance.setNeedmoney(10000);
		  }
		  else {
			  adultfinance.setNeedmoney(8000);
		  }
		  
		  adultfinance.setPracticalmoney(0);
		  adultfinance.setFstatu(0);
		
		//System.out.println("astudentno="+adultapply.getAstudentno()+"aname="+adultapply.getAname()+"userid="+adultapply.getUserid()+"idnum="+adultapply.getIdnumber()+"aphone="+adultapply.getAphone()+"atype="+adultapply.getAtype()+"acaid="+adultapply.getAcaid()+"specid="+adultapply.getSpecid()+"agra="+adultapply.getAgradation()+"asys="+adultapply.getAsystem()+"cityid="+adultapply.getCityid()+"countyid="+adultapply.getCountyid()+"adate="+adultapply.getAdata());
		//保存数据到数据库
		qiuService.saveadult(adultapply);
		qiuService.addadultfinance(adultfinance);
		return SUCCESS;
	}
	
	//添加国家开放大学报名信息到数据库
	public String addstate() {
		stateapply.setStype(0);
		stateapply.setSdata(new Date().toLocaleString());
		
		Statefinance statefinance=new Statefinance();
		int i=Integer.parseInt(stateapply.getSstudentno());
		//添加国家开放大学缴费信息到数据库
		//添加成人高考缴费表到数据库
		statefinance.setSid(i);
		statefinance.setSname(stateapply.getSname());
		statefinance.setSchoolid(stateapply.getAcaid());
		statefinance.setMajorid(stateapply.getSpecid());
		statefinance.setGradation(stateapply.getSgradation());
		statefinance.setTid(stateapply.getUserid());
		  if(statefinance.getGradation().equals("高达专")) {
			  statefinance.setNeedmoney(6000);
		  }else if(statefinance.getGradation().equals("高达本")) {
			  statefinance.setNeedmoney(10000);
		  }
		  else {
			  statefinance.setNeedmoney(8000);
		  }
		  
		  statefinance.setPracticalmoney(0);
		  statefinance.setFstatu(0);
		
		
		//System.out.println("astudentno="+stateapply.getSstudentno()+"aname="+stateapply.getSname()+"userid="+stateapply.getUserid()+"idnum="+stateapply.getIdnumber()+"aphone="+stateapply.getSphone()+"atype="+stateapply.getStype()+"acaid="+stateapply.getAcaid()+"specid="+stateapply.getSpecid()+"agra="+stateapply.getSgradation()+"asys="+stateapply.getSsystem()+"cityid="+stateapply.getCityid()+"countyid="+stateapply.getCountyid()+"adate="+stateapply.getSdata());

		//保存数据到数据库
		qiuService.savestate(stateapply);
		qiuService.addstatefinance(statefinance);
		return SUCCESS;
	}
	
	//添加远程教育表信息到数据库
	public String adddistance() {
		distanceapply.setDtype(0);
		distanceapply.setDdata(new Date().toLocaleString());
		
		Distancefinance distancefinance=new Distancefinance();
		int i=Integer.parseInt(distanceapply.getDstudentno());
		distancefinance.setSid(i);
		distancefinance.setSname(distanceapply.getDname());
		distancefinance.setSchoolid(distanceapply.getAcaid());
		distancefinance.setMajorid(distanceapply.getSpecid());
		distancefinance.setGradation(distanceapply.getDgradation());
		distancefinance.setTid(distanceapply.getUserid());
		  if(distancefinance.getGradation().equals("高达专")) {
			  distancefinance.setNeedmoney(6000);
		  }else if(distancefinance.getGradation().equals("高达本")) {
			  distancefinance.setNeedmoney(10000);
		  }
		  else {
			  distancefinance.setNeedmoney(8000);
		  }
		  
		  distancefinance.setPracticalmoney(0);
		  distancefinance.setFstatu(0);
		
		
		qiuService.savedistance(distanceapply);
		qiuService.adddisfinance(distancefinance);
		return SUCCESS;
	}
	
	//添加工作助手信息到数据库
	public String scheduleadd() {
		schedule.setSdate(new Date().toLocaleString());
		schedule.setSflag(0);
		qiuService.addschedule(schedule);
		return null;
	}
	
	
	
}
