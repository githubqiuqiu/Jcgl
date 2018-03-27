package com.edu.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.edu.bean.AccountantfinanceBean;
import com.edu.bean.AdultapplyBean;
import com.edu.bean.AdultfinanceBean;
import com.edu.bean.ArtfinanceBean;
import com.edu.bean.DistanceapplyBean;
import com.edu.bean.DistancefinanceBean;
import com.edu.bean.ProfessionfinanceBean;
import com.edu.bean.StateapplyBean;
import com.edu.bean.StatefinanceBean;
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

public class EditAction extends ActionSupport{
	private Role role;
	private QiuService qiuService;
	private User user;
	private Organization organization;
	private Adultapply adult;
	private Schedule schedule;
	private String desp;
	
	
	private AdultapplyBean adultapplybean;
	private StateapplyBean stateapplybean;
	private DistanceapplyBean distanceapplybean;
	private AdultfinanceBean adultfinancebean;
	private AccountantfinanceBean accountantfinancebean;
	private ArtfinanceBean artfinancebean;
	private ProfessionfinanceBean profinancebean;
	private StatefinanceBean statefinancebean;
	private DistancefinanceBean disfinancebean;
	
	
	public String getDesp() {
		return desp;
	}

	public void setDesp(String desp) {
		this.desp = desp;
	}

	public DistancefinanceBean getDisfinancebean() {
		return disfinancebean;
	}

	public void setDisfinancebean(DistancefinanceBean disfinancebean) {
		this.disfinancebean = disfinancebean;
	}

	public StatefinanceBean getStatefinancebean() {
		return statefinancebean;
	}

	public void setStatefinancebean(StatefinanceBean statefinancebean) {
		this.statefinancebean = statefinancebean;
	}

	public ProfessionfinanceBean getProfinancebean() {
		return profinancebean;
	}

	public void setProfinancebean(ProfessionfinanceBean profinancebean) {
		this.profinancebean = profinancebean;
	}

	public ArtfinanceBean getArtfinancebean() {
		return artfinancebean;
	}

	public void setArtfinancebean(ArtfinanceBean artfinancebean) {
		this.artfinancebean = artfinancebean;
	}

	public AccountantfinanceBean getAccountantfinancebean() {
		return accountantfinancebean;
	}

	public void setAccountantfinancebean(AccountantfinanceBean accountantfinancebean) {
		this.accountantfinancebean = accountantfinancebean;
	}

	public AdultfinanceBean getAdultfinancebean() {
		return adultfinancebean;
	}

	public void setAdultfinancebean(AdultfinanceBean adultfinancebean) {
		this.adultfinancebean = adultfinancebean;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public DistanceapplyBean getDistanceapplybean() {
		return distanceapplybean;
	}

	public void setDistanceapplybean(DistanceapplyBean distanceapplybean) {
		this.distanceapplybean = distanceapplybean;
	}

	public StateapplyBean getStateapplybean() {
		return stateapplybean;
	}

	public void setStateapplybean(StateapplyBean stateapplybean) {
		this.stateapplybean = stateapplybean;
	}

	public AdultapplyBean getAdultapplybean() {
		return adultapplybean;
	}

	public void setAdultapplybean(AdultapplyBean adultapplybean) {
		this.adultapplybean = adultapplybean;
	}

	public Adultapply getAdult() {
		return adult;
	}

	public void setAdult(Adultapply adult) {
		this.adult = adult;
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
	
	//保存role表的编辑到数据库
	public String editrole() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		qiuService.saverole(role);
		
		if(desp.equals(role.getDescription())) {//如果没有修改权限
			return null;
		}
		else {//如果修改了权限
			
			//根据角色id查询该角色的所有权限 (先把权限全部赋1清空该用户所有权限  然后再根据修改后的权限名称给该用户赋权)
			List<Userjurisdiction> list=qiuService.seluserjurbyrid(role.getId());
			for (int i = 0; i < list.size(); i++) {
				Userjurisdiction u=list.get(i);
				//把当前修改的角色的权限全部清空  然后在根据该角色的新权限给角色赋权
				qiuService.deljurbyid(u.getId());
			}
			
			//根据角色给用户重新赋权
			if(role.getDescription().equals("最高权限")) {//超级管理员
				for (int i = 0; i < list.size(); i++) {
					Userjurisdiction u=list.get(i);
					qiuService.addjur(u.getId(), 0);
				}
			}
			
			if(role.getDescription().equals("中权限")) {//财务(除了没有角色管理权限 和部门管理权限 和用户管理权限 外其他都有)
				for (int i = 0; i < list.size(); i++) {
					Userjurisdiction u=list.get(i);
					if(u.getJid()==1||u.getJid()==2||u.getJid()==3) {//角色管理 部门 用户管理
						qiuService.addjur(u.getId(), 1);
					}
					else {//其他有权限
						qiuService.addjur(u.getId(), 0);
					}
				}
			}
			
			if(role.getDescription().equals("低权限")) {//聚成管理(除了没有角色管理权限和用户  部门管理权限和报表权限外  其他都有)
				for (int i = 0; i < list.size(); i++) {
					Userjurisdiction u=list.get(i);
					if(u.getJid()==1||u.getJid()==2||u.getJid()==3||u.getJid()==26||u.getJid()==27) {
						qiuService.addjur(u.getId(), 1);//无权限的部分
					}
					else {
						qiuService.addjur(u.getId(), 0);
					}
					
				}
			}
			
			if(role.getDescription().equals("最低权限")) {//合作老师  只能看到报名和缴费和文件上传 和工作助手
				for (int i = 0; i < list.size(); i++) {
					Userjurisdiction u=list.get(i);
					//有权限
					if(u.getJid()==4||u.getJid()==5||u.getJid()==6||u.getJid()==7||u.getJid()==8||u.getJid()==9||u.getJid()==10||u.getJid()==19||u.getJid()==20||u.getJid()==21||u.getJid()==22||u.getJid()==23||u.getJid()==24||u.getJid()==25) {
						qiuService.addjur(u.getId(), 0);
					}
					else {
						qiuService.addjur(u.getId(), 1);//无权限的部分
					}
					
				}
			}
			
			return null;		
		}
	}
	
	//保存user表的编辑到数据库
	public String edituser() {
		System.out.println("进了user编辑");
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		//System.out.println("userid="+user.getId()+"  "+user.getLoginname()+"  "+user.getName()+"  "+user.getPassword()+"  "+user.getSex()+"  "+user.getAge()+"  "+user.getPhone()+"  "+user.getUsertype()+"  "+user.getStatus()+"  "+user.getOrganizationid()+"  "+user.getCreatetime()+"  "+user.getRid() );
		
		
		
		//给密码加密
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
	           //System.out.println("newpwd="+newpwd);
	        } catch (NoSuchAlgorithmException e) {  
	            e.printStackTrace();  
	            return "";  
	        } 
	     
	   //根据用户ID查询密码是否一致
	   String fpwd=qiuService.selpwd(user.getId());
	   
	   
	   if(fpwd.equals(user.getPassword())) {//如果没该密码
		   user.setPassword(user.getPassword());
	   }
	   else {
		   user.setPassword(newpwd);
	   }
	     
	
		
		
		qiuService.savauser(user);
	
		return null;
	}
	
	//保存organization表的编辑到数据库
	public String editdep() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		
		qiuService.savedep(organization);
		
		return null;
	}
	
	//保存adultapply编辑后成人高考报名表信息到数据库
	public String editadult() {
		System.out.println("修改编辑");
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		Adultapply adu=new Adultapply();
		
		adu.setAid(adultapplybean.getAid());
		adu.setAstudentno(adultapplybean.getAstudentno());
		adu.setAname(adultapplybean.getAname());
		adu.setUserid(adultapplybean.getUserid());
		adu.setIdnumber(adultapplybean.getIdnumber());
		adu.setAphone(adultapplybean.getAphone());
		adu.setAtype(adultapplybean.getAtype());
		adu.setAcaid(adultapplybean.getAcaid());
		adu.setSpecid(adultapplybean.getSpecid());
		adu.setAgradation(adultapplybean.getAgradation());
		adu.setAsystem(adultapplybean.getAsystem());
		adu.setCityid(adultapplybean.getCityid());
		adu.setAdata(adultapplybean.getAdata());
		adu.setCountyid(adultapplybean.getCountyid());
		//保存编辑到数据库
		qiuService.saveeditadult(adu);

		//根据学生id查询成人高考缴费表的id
		List<Adultfinance> li=qiuService.seladuid(Integer.parseInt(adultapplybean.getAstudentno()));
		if(li!=null&&li.size()>0) {
			//根据成考缴费表主键修改学生姓名
			qiuService.updateadultname(li.get(0).getFid(), adultapplybean.getAname());
		}
		
		
		
		//根据学生id查询成人高考文件上传表的主键id
		List<Stufile> list=qiuService.selstuid(Integer.parseInt(adultapplybean.getAstudentno()));
		
		if(list!=null&&list.size()>0) {
			//根据成考文件上传表主键修改学生姓名
			qiuService.updatestuname(list.get(0).getSfid(), adultapplybean.getAname());
		}
		
		
		return SUCCESS;
	}
	
	//保存stateapply编辑后的国家开放大学表信息到数据库
	public String editstate() {
		//System.out.println("进了修改资料");
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		Stateapply sta=new Stateapply();
		sta.setSid(stateapplybean.getSid());
		sta.setSstudentno(stateapplybean.getSstudentno());
		sta.setSname(stateapplybean.getSname());
		sta.setUserid(stateapplybean.getUserid());
		sta.setIdnumber(stateapplybean.getIdnumber());
		sta.setSphone(stateapplybean.getSphone());
		sta.setStype(stateapplybean.getStype());
		sta.setAcaid(stateapplybean.getAcaid());
		sta.setSpecid(stateapplybean.getSpecid());
		sta.setSgradation(stateapplybean.getSgradation());
		sta.setSsystem(stateapplybean.getSsystem());
		sta.setCityid(stateapplybean.getCityid());
		sta.setCountyid(stateapplybean.getCountyid());
		sta.setSdata(stateapplybean.getSdata());
		qiuService.saveeditstate(sta);
		
		//根据学生id查询国家开放缴费表的id
		List<Statefinance> li=qiuService.selstaid(Integer.parseInt(stateapplybean.getSstudentno()));
		if(li!=null&&li.size()>0) {
			//根据国家开放缴费表主键修改学生姓名
			qiuService.updatestatename(li.get(0).getFid(), stateapplybean.getSname());
		}
		return SUCCESS;
	}
	
	//保存编辑后的远程教育表到数据库
	public String editdistance() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		
		Distanceapply d=new Distanceapply();
		d.setDid(distanceapplybean.getDid());
		d.setDstudentno(distanceapplybean.getDstudentno());
		d.setDname(distanceapplybean.getDname());
		d.setUserid(distanceapplybean.getUserid());
		d.setIdnumber(distanceapplybean.getIdnumber());
		d.setDphone(distanceapplybean.getDphone());
		d.setDtype(distanceapplybean.getDtype());
		d.setAcaid(distanceapplybean.getAcaid());
		d.setSpecid(distanceapplybean.getSpecid());
		d.setDgradation(distanceapplybean.getDgradation());
		d.setDsystem(distanceapplybean.getDsystem());
		d.setCityid(distanceapplybean.getCityid());
		d.setCountyid(distanceapplybean.getCountyid());
		d.setDdata(distanceapplybean.getDdata());
		qiuService.saveeditdis(d);
		
		//根据学生id查询远程缴费表的id
		List<Distancefinance> li=qiuService.seldisid(Integer.parseInt(distanceapplybean.getDstudentno()));
		if(li!=null&&li.size()>0) {
			//根据国家开放缴费表主键修改学生姓名
			qiuService.updatedisname(li.get(0).getFid(), distanceapplybean.getDname());
		}
		
		return SUCCESS;
	}
	
	//编辑工作助手信息到数据库
	public String editschedule() {
		
		qiuService.saveschedule(schedule);

		return SUCCESS;
	}
	
	//编辑成人高考缴费表到数据库
	public String editadultfinance() {
		
		qiuService.editadultfinance(adultfinancebean);
		return null;
	}
	
	//编辑会计缴费表到数据库
	public String editaccfinance() {
		qiuService.editaccfinance(accountantfinancebean);
		return null;
	}
	
	//编辑艺考缴费表到数据库
	public String editartfinance() {
		
		qiuService.editartfinance(artfinancebean);
		return null;
	}
	
	//编辑职考缴费表信息到数据库
	public String editprofinance() {
		qiuService.editprofinance(profinancebean);
		return null;
	}
	
	//编辑国家开放缴费表到数据库
	public String editstatefinance() {
		qiuService.editstatefinance(statefinancebean);
		return null;
	}
	
	//编辑远程缴费表信息到数据库
	public String editdisfinance() {
		qiuService.editdisfinance(disfinancebean);
		return null;
	}
	
}
