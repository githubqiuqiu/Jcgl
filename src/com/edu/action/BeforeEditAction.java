package com.edu.action;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.edu.bean.AccountantfinanceBean;
import com.edu.bean.AdultapplyBean;
import com.edu.bean.AdultfinanceBean;
import com.edu.bean.ArtfinanceBean;
import com.edu.bean.DistanceapplyBean;
import com.edu.bean.DistancefinanceBean;
import com.edu.bean.OrganizationBean;
import com.edu.bean.ProfessionfinanceBean;
import com.edu.bean.RoleBean;
import com.edu.bean.ScheduleBean;
import com.edu.bean.StateapplyBean;
import com.edu.bean.StatefinanceBean;
import com.edu.bean.UserBean;
import com.edu.model.Academy;
import com.edu.model.Accountantfinance;
import com.edu.model.Adultapply;
import com.edu.model.Adultfinance;
import com.edu.model.Artfinance;
import com.edu.model.City;
import com.edu.model.County;
import com.edu.model.Distanceapply;
import com.edu.model.Distancefinance;
import com.edu.model.Organization;
import com.edu.model.Professionfinance;
import com.edu.model.Role;
import com.edu.model.Schedule;
import com.edu.model.Specialty;
import com.edu.model.Stateapply;
import com.edu.model.Statefinance;
import com.edu.model.Stufile;
import com.edu.model.User;
import com.edu.service.QiuService;
import com.opensymphony.xwork2.ActionSupport;

public class BeforeEditAction extends ActionSupport{
	private String id;
	private QiuService qiuService;
	private Role role;
	private User user;
	private List list;
	private Organization organization;
	private List<OrganizationBean> listorg;
	private List<RoleBean> listrole;
	private Adultapply adultapply;
	private List listadult;
	private List liststate;
	private List listdistance;
	private List listschedule;
	private List listuser;
	
	private List listadultfinance;
	private List listaccfinance;
	private List listartfinance;
	private List listprofinance;
	private List liststatefinance;
	private List listdisfinance;
	private List<Academy> listacademy;
	private List<City> listcity;
	
	
	private List<AdultfinanceBean> lists;
	
	private AdultapplyBean ab;
	private AdultfinanceBean abs;
	private StateapplyBean sb;
	private DistanceapplyBean db;
	private ScheduleBean sche;
	private Stufile sf;
	private AccountantfinanceBean afb;
	private ArtfinanceBean art;
	private ProfessionfinanceBean pb;
	private StatefinanceBean sfb;
	private DistancefinanceBean dfb;
	private List listcounty;
	
	
	public List<Academy> getListacademy() {
		return listacademy;
	}

	public void setListacademy(List<Academy> listacademy) {
		this.listacademy = listacademy;
	}

	public List<City> getListcity() {
		return listcity;
	}

	public void setListcity(List<City> listcity) {
		this.listcity = listcity;
	}

	public List getListcounty() {
		return listcounty;
	}

	public void setListcounty(List listcounty) {
		this.listcounty = listcounty;
	}

	public List getListdisfinance() {
		return listdisfinance;
	}

	public void setListdisfinance(List listdisfinance) {
		this.listdisfinance = listdisfinance;
	}

	public DistancefinanceBean getDfb() {
		return dfb;
	}

	public void setDfb(DistancefinanceBean dfb) {
		this.dfb = dfb;
	}

	public List getListstatefinance() {
		return liststatefinance;
	}

	public void setListstatefinance(List liststatefinance) {
		this.liststatefinance = liststatefinance;
	}

	public StatefinanceBean getSfb() {
		return sfb;
	}

	public void setSfb(StatefinanceBean sfb) {
		this.sfb = sfb;
	}

	public List getListprofinance() {
		return listprofinance;
	}

	public void setListprofinance(List listprofinance) {
		this.listprofinance = listprofinance;
	}

	public ProfessionfinanceBean getPb() {
		return pb;
	}

	public void setPb(ProfessionfinanceBean pb) {
		this.pb = pb;
	}

	public List getListartfinance() {
		return listartfinance;
	}
	
	public void setListartfinance(List listartfinance) {
		this.listartfinance = listartfinance;
	}


	public ArtfinanceBean getArt() {
		return art;
	}


	public void setArt(ArtfinanceBean art) {
		this.art = art;
	}


	public AccountantfinanceBean getAfb() {
		return afb;
	}


	public void setAfb(AccountantfinanceBean afb) {
		this.afb = afb;
	}


	public List getListaccfinance() {
		return listaccfinance;
	}


	public void setListaccfinance(List listaccfinance) {
		this.listaccfinance = listaccfinance;
	}


	public AdultfinanceBean getAbs() {
		return abs;
	}


	public void setAbs(AdultfinanceBean abs) {
		this.abs = abs;
	}


	public List<AdultfinanceBean> getLists() {
		return lists;
	}


	public void setLists(List<AdultfinanceBean> lists) {
		this.lists = lists;
	}


	public List getListadultfinance() {
		return listadultfinance;
	}


	public void setListadultfinance(List listadultfinance) {
		this.listadultfinance = listadultfinance;
	}


	public Stufile getSf() {
		return sf;
	}


	public void setSf(Stufile sf) {
		this.sf = sf;
	}


	public List getListuser() {
		return listuser;
	}


	public void setListuser(List listuser) {
		this.listuser = listuser;
	}


	public ScheduleBean getSche() {
		return sche;
	}


	public void setSche(ScheduleBean sche) {
		this.sche = sche;
	}


	public List getListschedule() {
		return listschedule;
	}


	public void setListschedule(List listschedule) {
		this.listschedule = listschedule;
	}


	public DistanceapplyBean getDb() {
		return db;
	}


	public void setDb(DistanceapplyBean db) {
		this.db = db;
	}


	public List getListdistance() {
		return listdistance;
	}


	public void setListdistance(List listdistance) {
		this.listdistance = listdistance;
	}


	public StateapplyBean getSb() {
		return sb;
	}


	public void setSb(StateapplyBean sb) {
		this.sb = sb;
	}


	public List getListstate() {
		return liststate;
	}


	public void setListstate(List liststate) {
		this.liststate = liststate;
	}


	public AdultapplyBean getAb() {
		return ab;
	}


	public void setAb(AdultapplyBean ab) {
		this.ab = ab;
	}
	

	public List getListadult() {
		return listadult;
	}


	public void setListadult(List listadult) {
		this.listadult = listadult;
	}


	public Adultapply getAdultapply() {
		return adultapply;
	}


	public void setAdultapply(Adultapply adultapply) {
		this.adultapply = adultapply;
	}


	public List<RoleBean> getListrole() {
		return listrole;
	}


	public void setListrole(List<RoleBean> listrole) {
		this.listrole = listrole;
	}


	public List<OrganizationBean> getListorg() {
		return listorg;
	}


	public void setListorg(List<OrganizationBean> listorg) {
		this.listorg = listorg;
	}


	public Organization getOrganization() {
		return organization;
	}


	public void setOrganization(Organization organization) {
		this.organization = organization;
	}


	public List getList() {
		return list;
	}


	public void setList(List list) {
		this.list = list;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	private String json;
	
	
	public String getJson() {
		return json;
	}


	public void setJson(String json) {
		this.json = json;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public QiuService getQiuService() {
		return qiuService;
	}


	public void setQiuService(QiuService qiuService) {
		this.qiuService = qiuService;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	//编辑之前先查询role表的方法
	public String beforeroleedit() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		res.setCharacterEncoding("utf-8");
		
		int i=Integer.parseInt(id);
		role=qiuService.selrole(i);
		
		return SUCCESS;
	}
	
	//编辑前查询user表的方法
	public String beforeuseredit() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		
		
		res.setCharacterEncoding("utf-8");
		int i=Integer.parseInt(id);
		
		user=qiuService.seluser(i);
		listorg=qiuService.selorg();
		for (int j = 0; j < listorg.size(); j++) {
			OrganizationBean ob=listorg.get(j);
			//借用字段保存user表的部门id 到页面做下拉框的判断
			ob.setSeq(user.getOrganizationid());
			
		}
		
		
		listrole=qiuService.selrole();
		for (int j = 0; j < listrole.size(); j++) {
			RoleBean rb=listrole.get(j);
			//借用字段保存user表的角色id 到页面做下拉框的判断
			rb.setSeq(user.getRid());
		}
		
		
		return SUCCESS;
	}
	
	//编辑前查询organization表的方法
	public String beforedepedit() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		res.setCharacterEncoding("utf-8");
		int i=Integer.parseInt(id);
		organization=qiuService.selorg(i);
		
		return SUCCESS;
	}
	
	//编辑前查询成人高考报名表的方法
	public String beforeadultedit() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		res.setCharacterEncoding("utf-8");
		int i=Integer.parseInt(id);
		
		//根据学生id查成人高考报名表信息
		listadult=qiuService.seladult(i);
		
	
		Object []o=(Object[]) listadult.get(0);
		
		Adultapply a=(Adultapply) o[0];
		User u=(User) o[1];
		Academy aca=(Academy) o[2];
		Specialty spe=(Specialty) o[3];
		City city=(City)o[4];
		County county=(County)o[5];
		
		ab=new AdultapplyBean();
		ab.setAid(a.getAid());
		ab.setAstudentno(a.getAstudentno());
		ab.setAname(a.getAname());
		ab.setUserid(a.getUserid());
		ab.setIdnumber(a.getIdnumber());
		ab.setAphone(a.getAphone());
		ab.setAtype(a.getAtype());
		ab.setAcaid(a.getAcaid());
		ab.setSpecid(a.getSpecid());
		ab.setAgradation(a.getAgradation());
		ab.setAsystem(a.getAsystem());
		ab.setCityid(a.getCityid());
		ab.setCountyid(a.getCountyid());
		ab.setAdata(a.getAdata());
		
		ab.setUsername(u.getName());
		ab.setAcaname(aca.getAschool());
		ab.setSpecname(spe.getSname());
		ab.setCityname(city.getCname());
		ab.setCountyname(county.getConame());
		
		
		//查询出所有城市
		listcity=qiuService.selcity();
		
		//查询出所有县城
		listcounty=qiuService.selcounty(a.getCityid());
		
		return SUCCESS;
	}
	
	//编辑前先查询国家开放大学报名表
	public String beforestateedit() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		res.setCharacterEncoding("utf-8");
		int i=Integer.parseInt(id);
		
		//根据学生id查询国家开放大学报名表信息
		liststate=qiuService.selstate(i);
		
		Object []o=(Object[]) liststate.get(0);
		
		Stateapply sta=(Stateapply) o[0];
		User u=(User) o[1];
		Academy aca=(Academy) o[2];
		Specialty spe=(Specialty) o[3];
		City city=(City)o[4];
		County county=(County)o[5];
		
		sb=new StateapplyBean();
		sb.setSid(sta.getSid());;
		sb.setSstudentno(sta.getSstudentno());;
		sb.setSname(sta.getSname());
		sb.setUserid(sta.getUserid());
		sb.setIdnumber(sta.getIdnumber());
		sb.setSphone(sta.getSphone());;
		sb.setStype(sta.getStype());;
		sb.setAcaid(sta.getAcaid());
		sb.setSpecid(sta.getSpecid());
		sb.setSgradation(sta.getSgradation());;
		sb.setSsystem(sta.getSsystem());;
		sb.setCityid(sta.getCityid());
		sb.setCountyid(sta.getCountyid());
		sb.setSdata(sta.getSdata());
		
		sb.setUsername(u.getName());
		sb.setAcaname(aca.getAschool());
		sb.setSpecname(spe.getSname());
		sb.setCityname(city.getCname());
		sb.setCountyname(county.getConame());
		
		//查询出所有城市
		listcity=qiuService.selcity();
		
		//查询出所有县城
		listcounty=qiuService.selcounty(sta.getCityid());
		
		return SUCCESS;
	}
	
	//编辑前先根据学生id查询远程教育表
	public String beforedistanceedit() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		res.setCharacterEncoding("utf-8");
		int i=Integer.parseInt(id);
		//System.out.println("进了远程");
		
		//根据学生id查询国家开放大学报名表信息
		listdistance=qiuService.seldis(i);
		
		Object []o=(Object[]) listdistance.get(0);
		
		Distanceapply dis=(Distanceapply) o[0];
		User u=(User) o[1];
		Academy aca=(Academy) o[2];
		Specialty spe=(Specialty) o[3];
		City city=(City)o[4];
		County county=(County)o[5];
		
		db=new DistanceapplyBean();
		db.setDid(dis.getDid());
		db.setDstudentno(dis.getDstudentno());
		db.setDname(dis.getDname());
		db.setUserid(dis.getUserid());
		db.setIdnumber(dis.getIdnumber());
		db.setDphone(dis.getDphone());
		db.setDtype(dis.getDtype());
		db.setAcaid(dis.getAcaid());
		db.setSpecid(dis.getSpecid());
		db.setDgradation(dis.getDgradation());
		db.setDsystem(dis.getDsystem());
		db.setCityid(dis.getCityid());
		db.setCountyid(dis.getCountyid());
		db.setDdata(dis.getDdata());
		
		db.setUsername(u.getName());
		db.setAcaname(aca.getAschool());
		db.setSpecname(spe.getSname());
		db.setCityname(city.getCname());
		db.setCountyname(county.getConame());
		//查询出所有城市
		listcity=qiuService.selcity();
		
		//查询出所有县城
		listcounty=qiuService.selcounty(dis.getCityid());
		
		return SUCCESS;
	}
	
	//编辑工作助手前先查询
	public String beforescheduleedit() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		res.setCharacterEncoding("utf-8");
		int i=Integer.parseInt(id);
		
		User user=(User) session.getAttribute("user");
		int rid=user.getRid();
		
		//根据rid查当前登入用户的角色
		String name=qiuService.selrolename(rid);
		
		//根据sid查询出工作助手的数据
		listschedule=qiuService.selschedule(i);
		
		Object []o=(Object[]) listschedule.get(0);
		Schedule s=new Schedule();
		User u=new User();
		s=(Schedule) o[0];
		u=(User) o[1];
		
		sche=new ScheduleBean();
		sche.setSid(s.getSid());
		sche.setUserid(s.getUserid());
		sche.setStitle(s.getStitle());
		sche.setScontent(s.getScontent());
		sche.setSdate(s.getSdate());
		sche.setSfinishdate(s.getSfinishdate());
		sche.setSflag(s.getSflag());
		sche.setUsername(u.getName());
		//查询所有老师
		listuser=qiuService.seluser();
		for (int j = 0; j < listuser.size(); j++) {
			User uu=(User) listuser.get(j);
			//借用age字段保存用户id 然后在页面上判断哪个用户选中
			uu.setAge(sche.getUserid());
		}
		
		if(name.equals("超级管理员")) {
			return SUCCESS;
		}
		else {
			return LOGIN;
		}	
	}
	
	//编辑学生文件上传前先查询
	public String beforeeditfile() {
		List<Stufile> list=qiuService.selfilebyid(Integer.parseInt(id));
		sf=list.get(0);
		return SUCCESS;
	}
	
	//编辑前查询成人高考缴费表信息
	public String beforeadultfinanceedit() {
		listadultfinance=qiuService.seladultfinancebyfid(Integer.parseInt(id));	
			Object[] o = (Object[])listadultfinance.get(0);
			
			Adultfinance af=(Adultfinance) o[0];
			User u=(User) o[1];
			Academy a=(Academy) o[2];
			Specialty s=(Specialty) o[3];
			
			abs=new AdultfinanceBean();
			
			abs.setFid(af.getFid());
			abs.setSid(af.getSid());
			abs.setSname(af.getSname());
			abs.setSchoolid(af.getSchoolid());
			abs.setMajorid(af.getMajorid());
			abs.setGradation(af.getGradation());
			abs.setTid(af.getTid());
			abs.setNeedmoney(af.getNeedmoney());
			abs.setPracticalmoney(af.getPracticalmoney());
			abs.setFdata(af.getFdata());
			abs.setFway(af.getFway());
			abs.setFstatu(af.getFstatu());
			
			abs.setUsername(u.getName());
			abs.setAcaname(a.getAschool());
			abs.setSpecname(s.getSname());

		return SUCCESS;
	}
	
	//编辑前查询会计缴费表信息
	public String beforeaccedit() {
		listaccfinance=qiuService.selaccbyfid(Integer.parseInt(id));
		
		Object[] o = (Object[])listaccfinance.get(0);
		
		Accountantfinance a=(Accountantfinance) o[0];
		User u=(User) o[1];
		
		afb=new AccountantfinanceBean();
		afb.setFid(a.getFid());
		afb.setSid(a.getSid());
		afb.setSname(a.getSname());
		afb.setTid(a.getTid());
		afb.setNeedmoney(a.getNeedmoney());
		afb.setPracticalmoney(a.getPracticalmoney());
		afb.setFdata(a.getFdata());
		afb.setFway(a.getFway());
		afb.setFstatu(a.getFstatu());
		afb.setFtest1(a.getFtest1());
		afb.setFtest2(a.getFtest2());
		
		afb.setUsername(u.getName());
		return SUCCESS;
	}
	
	//编辑前查询艺考缴费表信息
	public String beforeartedit() {
		listartfinance=qiuService.selartfinancebyfid(Integer.parseInt(id));
		Object[] o = (Object[])listartfinance.get(0);
		Artfinance a=(Artfinance) o[0];
		User u=(User) o[1];
		
		art=new ArtfinanceBean();
		art.setFid(a.getFid());
		art.setSid(a.getSid());
		art.setSname(a.getSname());
		art.setTid(a.getTid());
		art.setNeedmoney(a.getNeedmoney());
		art.setPracticalmoney(a.getPracticalmoney());
		art.setFdata(a.getFdata());
		art.setFway(a.getFway());
		art.setFstatu(a.getFstatu());
		art.setFtest1(a.getFtest1());
		art.setFtest2(a.getFtest2());
		
		art.setUsername(u.getName());
		return SUCCESS;
	}
	
	//编辑前查询职考缴费表信息
	public String beforeproedit() {
		listprofinance=qiuService.selprofinancebyfid(Integer.parseInt(id));
		
		Object[] o = (Object[])listprofinance.get(0);
		Professionfinance p=(Professionfinance) o[0];
		User u=(User) o[1];
		
		pb=new ProfessionfinanceBean();
		pb.setFid(p.getFid());
		pb.setSid(p.getSid());
		pb.setSname(p.getSname());
		pb.setTid(p.getTid());
		pb.setNeedmoney(p.getNeedmoney());
		pb.setPracticalmoney(p.getPracticalmoney());
		pb.setFdata(p.getFdata());
		pb.setFway(p.getFway());
		pb.setFstatu(p.getFstatu());
		pb.setFtest1(p.getFtest1());
		pb.setFtest2(p.getFtest2());
		
		pb.setUsername(u.getName());
		return SUCCESS;
	}
	
	//编辑前查询国家开放大学缴费表
	public String beforestatefinanceedit() {
		liststatefinance=qiuService.selstatefinancebyfid(Integer.parseInt(id));
		
		Object[] o = (Object[])liststatefinance.get(0);
		
		Statefinance sf=(Statefinance) o[0];
		User u=(User) o[1];
		Academy a=(Academy) o[2];
		Specialty s=(Specialty) o[3];
		
		sfb=new StatefinanceBean();
		sfb.setFid(sf.getFid());
		sfb.setSid(sf.getSid());
		sfb.setSname(sf.getSname());
		sfb.setSchoolid(sf.getSchoolid());
		sfb.setMajorid(sf.getMajorid());
		sfb.setGradation(sf.getGradation());
		sfb.setTid(sf.getTid());
		sfb.setNeedmoney(sf.getNeedmoney());
		sfb.setPracticalmoney(sf.getPracticalmoney());
		sfb.setFdata(sf.getFdata());
		sfb.setFway(sf.getFway());
		sfb.setFstatu(sf.getFstatu());
		
		sfb.setUsername(u.getName());
		sfb.setAcaname(a.getAschool());
		sfb.setSpecname(s.getSname());
		
		return SUCCESS;
	}
	
	//编辑前查询远程缴费表信息
	public String beforedisedit() {
		listdisfinance=qiuService.seldisfinancebyfid(Integer.parseInt(id));
		Object[] o = (Object[])listdisfinance.get(0);
		
		Distancefinance df=(Distancefinance) o[0];
		User u=(User) o[1];
		Academy a=(Academy) o[2];
		Specialty s=(Specialty) o[3];
		
		dfb=new DistancefinanceBean();
		dfb.setFid(df.getFid());
		dfb.setSid(df.getSid());
		dfb.setSname(df.getSname());
		dfb.setSchoolid(df.getSchoolid());
		dfb.setMajorid(df.getMajorid());
		dfb.setGradation(df.getGradation());
		dfb.setTid(df.getTid());
		dfb.setNeedmoney(df.getNeedmoney());
		dfb.setPracticalmoney(df.getPracticalmoney());
		dfb.setFdata(df.getFdata());
		dfb.setFway(df.getFway());
		dfb.setFstatu(df.getFstatu());
		
		dfb.setUsername(u.getName());
		dfb.setAcaname(a.getAschool());
		dfb.setSpecname(s.getSname());
		return SUCCESS;
	}
	
	
	
	
}
