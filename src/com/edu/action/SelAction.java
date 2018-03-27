package com.edu.action;

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
import com.alibaba.fastjson.JSONArray;
import com.edu.bean.AccountantfinanceBean;
import com.edu.bean.AdultapplyBean;
import com.edu.bean.AdultfinanceBean;
import com.edu.bean.ArtfinanceBean;
import com.edu.bean.CountyBean;
import com.edu.bean.DistanceapplyBean;
import com.edu.bean.DistancefinanceBean;
import com.edu.bean.OrganizationBean;
import com.edu.bean.ProfessionfinanceBean;
import com.edu.bean.ScheduleBean;
import com.edu.bean.SpecialtyBean;
import com.edu.bean.StateapplyBean;
import com.edu.bean.StatefinanceBean;
import com.edu.model.Academy;
import com.edu.model.Acaspe;
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

public class SelAction extends ActionSupport{
	private List listadu;
	private QiuService qiuService;
	private Integer listcount;
	private String json;
	private Map map;
	private List<User>listuser;
	private List<Academy> listacademy;
	private List listacaspe;
	private Integer academyid;
	private List<City> listcity;
	private List<SpecialtyBean> list1;
	private Integer cid;
	private List listcounty;
	private List liststate;
	private List listdistance;
	private List listadultfinance;
	private List liststatefinance;
	private List listdisfinance;
	private List listaccfinance;
	private List listprofinance;
	private List listartfinance;
	private List listschedule;
	private List liststufile;
	
	private String rolename;
	
	
	private List<Organization> listorg;
	private List<Role> listrole;
	
	//模糊查询的参数
	private String astudentno;
	private String aname;
	private String teacher;
	private String status;
	private String types;
	
	private String userid;
	private String stitle;
	private String sdate;
	private String finishdate;
	private String statu;
	private String name;
	private String id;
	
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List getListstufile() {
		return liststufile;
	}
	public void setListstufile(List liststufile) {
		this.liststufile = liststufile;
	}
	public List<Role> getListrole() {
		return listrole;
	}
	public void setListrole(List<Role> listrole) {
		this.listrole = listrole;
	}
	public List<Organization> getListorg() {
		return listorg;
	}
	public void setListorg(List<Organization> listorg) {
		this.listorg = listorg;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getStitle() {
		return stitle;
	}
	public void setStitle(String stitle) {
		this.stitle = stitle;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getFinishdate() {
		return finishdate;
	}
	public void setFinishdate(String finishdate) {
		this.finishdate = finishdate;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public List getListschedule() {
		return listschedule;
	}
	public void setListschedule(List listschedule) {
		this.listschedule = listschedule;
	}
	public List getListartfinance() {
		return listartfinance;
	}
	public void setListartfinance(List listartfinance) {
		this.listartfinance = listartfinance;
	}
	public List getListaccfinance() {
		return listaccfinance;
	}
	public void setListaccfinance(List listaccfinance) {
		this.listaccfinance = listaccfinance;
	}
	public List getListprofinance() {
		return listprofinance;
	}
	public void setListprofinance(List listprofinance) {
		this.listprofinance = listprofinance;
	}
	public List getListdisfinance() {
		return listdisfinance;
	}
	public void setListdisfinance(List listdisfinance) {
		this.listdisfinance = listdisfinance;
	}
	public List getListstatefinance() {
		return liststatefinance;
	}
	public void setListstatefinance(List liststatefinance) {
		this.liststatefinance = liststatefinance;
	}
	public List getListadultfinance() {
		return listadultfinance;
	}
	public void setListadultfinance(List listadultfinance) {
		this.listadultfinance = listadultfinance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public List getListdistance() {
		return listdistance;
	}
	public void setListdistance(List listdistance) {
		this.listdistance = listdistance;
	}
	public List getListstate() {
		return liststate;
	}
	public void setListstate(List liststate) {
		this.liststate = liststate;
	}
	public String getAstudentno() {
		return astudentno;
	}
	public void setAstudentno(String astudentno) {
		this.astudentno = astudentno;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public List getListcounty() {
		return listcounty;
	}
	public void setListcounty(List listcounty) {
		this.listcounty = listcounty;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public List<SpecialtyBean> getList1() {
		return list1;
	}
	public void setList1(List<SpecialtyBean> list1) {
		this.list1 = list1;
	}
	public List<City> getListcity() {
		return listcity;
	}
	public void setListcity(List<City> listcity) {
		this.listcity = listcity;
	}
	public List getListacaspe() {
		return listacaspe;
	}
	public void setListacaspe(List listacaspe) {
		this.listacaspe = listacaspe;
	}
	public Integer getAcademyid() {
		return academyid;
	}
	public void setAcademyid(Integer academyid) {
		this.academyid = academyid;
	}
	public List<Academy> getListacademy() {
		return listacademy;
	}
	public void setListacademy(List<Academy> listacademy) {
		this.listacademy = listacademy;
	}
	public List<User> getListuser() {
		return listuser;
	}
	public void setListuser(List<User> listuser) {
		this.listuser = listuser;
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
	public Integer getListcount() {
		return listcount;
	}
	public void setListcount(Integer listcount) {
		this.listcount = listcount;
	}
	public QiuService getQiuService() {
		return qiuService;
	}
	public void setQiuService(QiuService qiuService) {
		this.qiuService = qiuService;
	}
	
	public List getListadu() {
		return listadu;
	}
	public void setListadu(List listadu) {
		this.listadu = listadu;
	}
	//查询adultapply成人高考报名表
	public String seladultapply() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		res.setCharacterEncoding("utf-8");
		
		String page = req.getParameter("page");
		String rows = req.getParameter("rows");
		int i1=Integer.parseInt(page);
		int i2=Integer.parseInt(rows);
		//System.out.println("i1="+i1);
		//System.out.println("i2="+i2);
		
		//System.out.println("astudentno="+astudentno+"  aname="+aname+" teacher="+teacher);
		HttpSession session=req.getSession();
		User uu=(User) session.getAttribute("user");
		//得到当前用户的rid
		int id=uu.getRid();
		int uid=uu.getId();
		//根据当前用户的rid查询用户的角色
		rolename=qiuService.selrolename(id);
		
		if(rolename.equals("超级管理员")) {//超级管理员查询所有报名信息
			//总数据
			listadu=qiuService.seladu(i1, i2,astudentno,aname,teacher);
			//总数据条数
			listcount=qiuService.adultapplycount(astudentno,aname,teacher);
		}
		else {//其他管理员只能查询自己的学生报名信息
			//总数据
			listadu=qiuService.seladultbyuid(i1,i2,astudentno,aname,uid);
			//总数据条数
			listcount=qiuService.seladultapplycountbyuid(uid,astudentno,aname);
		}
		
		
		
		List<AdultapplyBean> list1=new ArrayList<>();
		for (int i = 0; i < listadu.size(); i++) {
			Object[] o = (Object[])listadu.get(i);
			
			Adultapply adu=new Adultapply();
			User u=new User();
			Academy aca=new Academy();
			Specialty spe=new Specialty();
			City c=new City();
			County co=new County();
			
			AdultapplyBean ab=new AdultapplyBean();
			
			adu=(Adultapply) o[0];
			u=(User) o[1];
			aca=(Academy) o[2];
			spe=(Specialty) o[3];
			c=(City) o[4];
			co=(County) o[5];
			
			ab.setAid(adu.getAid());
			ab.setAstudentno(adu.getAstudentno());
			ab.setAname(adu.getAname());
			ab.setUserid(adu.getUserid());
			ab.setIdnumber(adu.getIdnumber());
			ab.setAphone(adu.getAphone());
			ab.setAtype(adu.getAtype());
			ab.setAcaid(adu.getAcaid());
			ab.setSpecid(adu.getSpecid());
			ab.setAgradation(adu.getAgradation());
			ab.setAsystem(adu.getAsystem());
			ab.setCityid(adu.getCityid());
			ab.setCountyid(adu.getCountyid());
			ab.setAdata(adu.getAdata());
			
			ab.setUsername(u.getName());
			ab.setAcaname(aca.getAschool());
			ab.setSpecname(spe.getSname());
			ab.setCityname(c.getCname());
			ab.setCountyname(co.getConame());
			list1.add(ab);
		}
		map=new HashMap<>();
		map.put("total", listcount);
		map.put("rows", list1);
		json=JSON.toJSONString(map);//把map转换成json格式
		//System.out.println("json格式:"+json);
		//查询出所有老师
		listuser=qiuService.seluser();
		try {
			PrintWriter pw=res.getWriter();
			pw.println(json);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}
	
	//成人报名的添加窗口(查询所有老师)
	public String seladultteacher() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		res.setCharacterEncoding("utf-8");
		//查询出所有老师
		listuser=qiuService.seluser();
		
		//查询出所有学校
		listacademy=qiuService.selacademy();
		
		//查询出所有城市
		listcity=qiuService.selcity();
		
		return SUCCESS;
	}
	

	//成人报名的添加窗口(根据院校id查询该院校的所有专业)
	public String selsep() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		res.setCharacterEncoding("utf-8");
		listacaspe=qiuService.selacaspe(academyid);
		listcount=listacaspe.size();
		list1=new ArrayList<>();
		for (int i = 0; i < listacaspe.size(); i++) {
			Object[] object = (Object[])listacaspe.get(i);
			Acaspe acaspe=new Acaspe();
			Academy academy=new Academy();
			Specialty spe=new Specialty();
			
			acaspe=(Acaspe) object[0];
			academy=(Academy) object[1];
			spe=(Specialty) object[2];
			
			SpecialtyBean sb=new SpecialtyBean();
			sb.setSid(spe.getSid());
			sb.setSname(spe.getSname());
			if(i==0) {//让第一个专业框有值被选中
				sb.setSelected("true");
			}
			else {
				sb.setSelected("false");
			}
			
			list1.add(sb);
		}
		/*map=new HashMap<>();
		map.put("total", listcount);
		map.put("rows", list1);*/
		//String str=list1.toString();
		json=JSON.toJSONString(list1);//把map转换成json格式
		//System.out.println("专业json格式:"+json);
		
		try {
			PrintWriter pw=res.getWriter();
		
			pw.println(json);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}
	
	//根据城市id 查询县/区
	public String selcounty() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		res.setCharacterEncoding("utf-8");
		
		//根据城市id 查询县/区
		listcounty=qiuService.selcounty(cid);
		List<CountyBean> list1=new ArrayList<>();
		for (int i = 0; i < listcounty.size(); i++) {
			
			County  co=(County) listcounty.get(i);
			
			CountyBean cb=new CountyBean();
			cb.setCoid(co.getCoid());
			cb.setConame(co.getConame());
			cb.setCid(co.getCid());
			if(i==0) {
				cb.setSelected("true");
			}
			else {
				cb.setSelected("false");
			}
			list1.add(cb);
		}
		json=JSON.toJSONString(list1);//把map转换成json格式
		//System.out.println("县/区json格式:"+json);
		
		try {
			PrintWriter pw=res.getWriter();
		
			pw.println(json);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	

	//查询国家开放大学报名表信息
	public String selstateapply() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		res.setCharacterEncoding("utf-8");
		
		String page = req.getParameter("page");
		String rows = req.getParameter("rows");
		int i1=Integer.parseInt(page);
		int i2=Integer.parseInt(rows);
		
		HttpSession session=req.getSession();
		User uu=(User) session.getAttribute("user");
		//得到当前用户的rid
		int id=uu.getRid();
		int uid=uu.getId();
		//根据当前用户的rid查询用户的角色
		rolename=qiuService.selrolename(id);
		
		if(rolename.equals("超级管理员")) {//超级管理员查询所有报名信息
			//查出总数据
			liststate=qiuService.selstate(i1, i2, astudentno, aname, teacher);
			
			//总数据条数
			listcount=qiuService.stateapplycount(astudentno, aname, teacher);
		}
		else {//其他管理员只能查询自己的学生报名信息
			//总数据
			liststate=qiuService.selstatebyuid(i1,i2,astudentno,aname,uid);
			//总数据条数
			listcount=qiuService.selstateapplycountbyuid(uid,astudentno,aname);
		}
		
		List<StateapplyBean> list1=new ArrayList<>();
		for (int i = 0; i < liststate.size(); i++) {
			Object[] o = (Object[])liststate.get(i);
			
			Stateapply sta=new Stateapply();
			User u=new User();
			Academy aca=new Academy();
			Specialty spe=new Specialty();
			City c=new City();
			County co=new County();
			
			StateapplyBean sb=new StateapplyBean();
			
			sta=(Stateapply) o[0];
			u=(User) o[1];
			aca=(Academy) o[2];
			spe=(Specialty) o[3];
			c=(City) o[4];
			co=(County) o[5];
			
			sb.setSid(sta.getSid());
			sb.setSstudentno(sta.getSstudentno());
			sb.setSname(sta.getSname());
			sb.setUserid(sta.getUserid());
			sb.setIdnumber(sta.getIdnumber());
			sb.setSphone(sta.getSphone());
			sb.setStype(sta.getStype());
			sb.setAcaid(sta.getAcaid());
			sb.setSpecid(sta.getSpecid());
			sb.setSgradation(sta.getSgradation());
			sb.setSsystem(sta.getSsystem());
			sb.setCityid(sta.getCityid());
			sb.setCountyid(sta.getCountyid());
			sb.setSdata(sta.getSdata());
			
			sb.setUsername(u.getName());
			sb.setAcaname(aca.getAschool());
			sb.setSpecname(spe.getSname());
			sb.setCityname(c.getCname());
			sb.setCountyname(co.getConame());
			list1.add(sb);	
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
	
	//查询远程教育表的信息
	public String seldistance() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		res.setCharacterEncoding("utf-8");
		
		String page = req.getParameter("page");
		String rows = req.getParameter("rows");
		int i1=Integer.parseInt(page);
		int i2=Integer.parseInt(rows);
		
		HttpSession session=req.getSession();
		User uu=(User) session.getAttribute("user");
		//得到当前用户的rid
		int id=uu.getRid();
		int uid=uu.getId();
		//根据当前用户的rid查询用户的角色
		rolename=qiuService.selrolename(id);
		
		if(rolename.equals("超级管理员")) {//超级管理员查询所有报名信息
			//总数据
			listdistance=qiuService.seldis(i1, i2, astudentno, aname, teacher);
			
			//总数据条数
			listcount=qiuService.disapplycount(astudentno, aname, teacher);
		}
		else {//其他管理员只能查询自己的学生报名信息
			//总数据
			listdistance=qiuService.seldisbyuid(i1,i2,astudentno,aname,uid);
			//总数据条数
			listcount=qiuService.seldisapplycountbyuid(uid,astudentno,aname);
		}
		
		
		
		
		
		List<DistanceapplyBean> list1=new ArrayList<>();
		for (int i = 0; i < listdistance.size(); i++) {
			Object[] o = (Object[])listdistance.get(i);
			
			Distanceapply dis=new Distanceapply();
			User u=new User();
			Academy aca=new Academy();
			Specialty spe=new Specialty();
			City c=new City();
			County co=new County();
			
			DistanceapplyBean db=new DistanceapplyBean();
			
			dis=(Distanceapply) o[0];
			u=(User) o[1];
			aca=(Academy) o[2];
			spe=(Specialty) o[3];
			c=(City) o[4];
			co=(County) o[5];
			
			db.setDid(dis.getDid());;
			db.setDstudentno(dis.getDstudentno());;
			db.setDname(dis.getDname());;
			db.setUserid(dis.getUserid());
			db.setIdnumber(dis.getIdnumber());
			db.setDphone(dis.getDphone());;
			db.setDtype(dis.getDtype());;
			db.setAcaid(dis.getAcaid());
			db.setSpecid(dis.getSpecid());
			db.setDgradation(dis.getDgradation());;
			db.setDsystem(dis.getDsystem());;
			db.setCityid(dis.getCityid());
			db.setCountyid(dis.getCountyid());
			db.setDdata(dis.getDdata());;
			
			db.setUsername(u.getName());
			db.setAcaname(aca.getAschool());
			db.setSpecname(spe.getSname());
			db.setCityname(c.getCname());
			db.setCountyname(co.getConame());
			list1.add(db);
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
	
	
	//查询成人高考表的缴费信息
	public String seladultfinance() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		res.setCharacterEncoding("utf-8");
		
		String page = req.getParameter("page");
		String rows = req.getParameter("rows");
		int i1=Integer.parseInt(page);
		int i2=Integer.parseInt(rows);
		
		HttpSession session=req.getSession();
		User uu=(User) session.getAttribute("user");
		//得到当前用户的rid
		int id=uu.getRid();
		int uid=uu.getId();
		//根据当前用户的rid查询用户的角色
		rolename=qiuService.selrolename(id);
		
		if(rolename.equals("超级管理员")) {//超级管理员查询所有报名信息
			//查询成人高考缴费表的信息
			listadultfinance=qiuService.seladultfinance(i1, i2, astudentno, aname, teacher, status, types);
			
			//总数据条数
			listcount=qiuService.adultfinancecount(astudentno, aname, teacher, status, types);
		}
		else {//其他管理员只能查询自己的学生报名信息
			//总数据
			listadultfinance=qiuService.seladultfinancebyuid(i1,i2,astudentno,aname,status, types,uid);
			//总数据条数
			listcount=qiuService.seladultfinancecountbyuid(uid,astudentno,aname,status, types);
		}
		
		
		
		List<AdultfinanceBean> list1=new ArrayList<>();
		for (int i = 0; i < listadultfinance.size(); i++) {
			Object[] o = (Object[])listadultfinance.get(i);
			
			Adultfinance af=(Adultfinance) o[0];
			User u=(User) o[1];
			Academy a=(Academy) o[2];
			Specialty s=(Specialty) o[3];
			
			AdultfinanceBean ab=new AdultfinanceBean();
			ab.setFid(af.getFid());
			ab.setSid(af.getSid());
			ab.setSname(af.getSname());
			ab.setSchoolid(af.getSchoolid());
			ab.setMajorid(af.getMajorid());
			ab.setGradation(af.getGradation());
			ab.setTid(af.getTid());
			ab.setNeedmoney(af.getNeedmoney());
			ab.setPracticalmoney(af.getPracticalmoney());
			ab.setFdata(af.getFdata());
			ab.setFway(af.getFway());
			ab.setFstatu(af.getFstatu());
			
			ab.setUsername(u.getName());
			ab.setAcaname(a.getAschool());
			ab.setSpecname(s.getSname());
			list1.add(ab);
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
	
	//查询国家开放大学报名缴费表
	public String selstatefinance() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		res.setCharacterEncoding("utf-8");
		
		String page = req.getParameter("page");
		String rows = req.getParameter("rows");
		int i1=Integer.parseInt(page);
		int i2=Integer.parseInt(rows);
		
		HttpSession session=req.getSession();
		User uu=(User) session.getAttribute("user");
		//得到当前用户的rid
		int id=uu.getRid();
		int uid=uu.getId();
		//根据当前用户的rid查询用户的角色
		rolename=qiuService.selrolename(id);
		
		if(rolename.equals("超级管理员")) {//超级管理员查询所有报名信息
			//总数据
			liststatefinance=qiuService.selstatefinance(i1, i2, astudentno, aname, teacher, status, types);
			
			//总数据条数
			listcount=qiuService.statefinancecount(astudentno, aname, teacher, status, types);
		}
		else {//其他管理员只能查询自己的学生报名信息
			//总数据
			liststatefinance=qiuService.selstatefinancebyuid(i1,i2,astudentno,aname,status, types,uid);
			//总数据条数
			listcount=qiuService.selstatefinancecountbyuid(uid,astudentno,aname,status, types);
		}
		
		
		
		
		
		List<StatefinanceBean> list1=new ArrayList<>();
		for (int i = 0; i < liststatefinance.size(); i++) {
			Object[] o = (Object[])liststatefinance.get(i);
			
			Statefinance sf=(Statefinance) o[0];
			User u=(User) o[1];
			Academy a=(Academy) o[2];
			Specialty s=(Specialty) o[3];
			
			StatefinanceBean sb=new StatefinanceBean();
			sb.setFid(sf.getFid());
			sb.setSid(sf.getSid());
			sb.setSname(sf.getSname());
			sb.setSchoolid(sf.getSchoolid());
			sb.setMajorid(sf.getMajorid());
			sb.setGradation(sf.getGradation());
			sb.setTid(sf.getTid());
			sb.setNeedmoney(sf.getNeedmoney());
			sb.setPracticalmoney(sf.getPracticalmoney());
			sb.setFdata(sf.getFdata());
			sb.setFway(sf.getFway());
			sb.setFstatu(sf.getFstatu());
			
			sb.setUsername(u.getName());
			sb.setAcaname(a.getAschool());
			sb.setSpecname(s.getSname());
			list1.add(sb);
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
	
	//查询远程教育缴费表信息
	public String seldisfinance() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		res.setCharacterEncoding("utf-8");
		
		String page = req.getParameter("page");
		String rows = req.getParameter("rows");
		int i1=Integer.parseInt(page);
		int i2=Integer.parseInt(rows);
		
		HttpSession session=req.getSession();
		User uu=(User) session.getAttribute("user");
		//得到当前用户的rid
		int id=uu.getRid();
		int uid=uu.getId();
		//根据当前用户的rid查询用户的角色
		rolename=qiuService.selrolename(id);
		
		if(rolename.equals("超级管理员")) {//超级管理员查询所有报名信息
			//总数据
			listdisfinance=qiuService.seldisfinance(i1, i2, astudentno, aname, teacher, status, types);
			
			//总数据条数
			listcount=qiuService.disfinancecount(astudentno, aname, teacher, status, types);
		}
		else {//其他管理员只能查询自己的学生报名信息
			//总数据
			listdisfinance=qiuService.seldisfinancebyuid(i1,i2,astudentno,aname,status, types,uid);
			//总数据条数
			listcount=qiuService.seldisfinancecountbyuid(uid,astudentno,aname,status, types);
		}
		
		
		
		
		List<DistancefinanceBean> list1=new ArrayList<>();
		for (int i = 0; i < listdisfinance.size(); i++) {
			Object[] o = (Object[])listdisfinance.get(i);
			
			Distancefinance df=(Distancefinance) o[0];
			User u=(User) o[1];
			Academy a=(Academy) o[2];
			Specialty s=(Specialty) o[3];
			
			DistancefinanceBean db=new DistancefinanceBean();
			db.setFid(df.getFid());
			db.setSid(df.getSid());
			db.setSname(df.getSname());
			db.setSchoolid(df.getSchoolid());
			db.setMajorid(df.getMajorid());
			db.setGradation(df.getGradation());
			db.setTid(df.getTid());
			db.setNeedmoney(df.getNeedmoney());
			db.setPracticalmoney(df.getPracticalmoney());
			db.setFdata(df.getFdata());
			db.setFway(df.getFway());
			db.setFstatu(df.getFstatu());
			
			db.setUsername(u.getName());
			db.setAcaname(a.getAschool());
			db.setSpecname(s.getSname());
			list1.add(db);
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
	
	//查询会计缴费表
	public String selaccfinance() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		res.setCharacterEncoding("utf-8");
		
		String page = req.getParameter("page");
		String rows = req.getParameter("rows");
		int i1=Integer.parseInt(page);
		int i2=Integer.parseInt(rows);
		
		HttpSession session=req.getSession();
		User uu=(User) session.getAttribute("user");
		//得到当前用户的rid
		int id=uu.getRid();
		int uid=uu.getId();
		//根据当前用户的rid查询用户的角色
		rolename=qiuService.selrolename(id);
		
		if(rolename.equals("超级管理员")) {//超级管理员查询所有报名信息
			//总数据
			listaccfinance=qiuService.selaccfinance(i1, i2, astudentno, aname, teacher, status, types);
			//总数据条数
			listcount=qiuService.accfinancecount(astudentno, aname, teacher, status, types);
		}
		else {//其他管理员只能查询自己的学生报名信息
			//总数据
			listaccfinance=qiuService.selaccfinancebyuid(i1,i2,astudentno,aname,status, types,uid);
			//总数据条数
			listcount=qiuService.selaccfinancecountbyuid(uid,astudentno,aname,status,types);
		}
		
		
		
	
		
		List<AccountantfinanceBean> list1=new ArrayList<>();
		for (int i = 0; i < listaccfinance.size(); i++) {
			Object[] o = (Object[])listaccfinance.get(i);
			
			Accountantfinance a=(Accountantfinance) o[0];
			User u=(User) o[1];
			
			AccountantfinanceBean ab=new AccountantfinanceBean();
			ab.setFid(a.getFid());
			ab.setSid(a.getSid());
			ab.setSname(a.getSname());
			ab.setTid(a.getTid());
			ab.setNeedmoney(a.getNeedmoney());
			ab.setPracticalmoney(a.getPracticalmoney());
			ab.setFdata(a.getFdata());
			ab.setFway(a.getFway());
			ab.setFstatu(a.getFstatu());
			ab.setFtest1(a.getFtest1());
			ab.setFtest2(a.getFtest2());
			
			ab.setUsername(u.getName());
			list1.add(ab);
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
	
	//查询职考缴费表信息
	public String selprofinance() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		res.setCharacterEncoding("utf-8");
		
		String page = req.getParameter("page");
		String rows = req.getParameter("rows");
		int i1=Integer.parseInt(page);
		int i2=Integer.parseInt(rows);
		
		HttpSession session=req.getSession();
		User uu=(User) session.getAttribute("user");
		//得到当前用户的rid
		int id=uu.getRid();
		int uid=uu.getId();
		//根据当前用户的rid查询用户的角色
		rolename=qiuService.selrolename(id);
		
		if(rolename.equals("超级管理员")) {//超级管理员查询所有报名信息
			//总数据
			listprofinance=qiuService.selprofinance(i1, i2, astudentno, aname, teacher, status, types);
			//总数据条数
			listcount=qiuService.profinancecount(astudentno, aname, teacher, status, types);
		}
		else {//其他管理员只能查询自己的学生报名信息
			//总数据
			listprofinance=qiuService.selprofinancebyuid(i1,i2,astudentno,aname,status, types,uid);
			//总数据条数
			listcount=qiuService.selprofinancecountybyuid(uid,astudentno,aname,status, types);
		}
		
		
		
		
		List<ProfessionfinanceBean> list1=new ArrayList<>();
		for (int i = 0; i < listprofinance.size(); i++) {
			Object[] o = (Object[])listprofinance.get(i);
			Professionfinance p=(Professionfinance) o[0];
			User u=(User) o[1];
			
			ProfessionfinanceBean pb=new ProfessionfinanceBean();
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
			list1.add(pb);
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
	
	//查询艺考缴费表信息
	public String selartfinance() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		res.setCharacterEncoding("utf-8");
		
		String page = req.getParameter("page");
		String rows = req.getParameter("rows");
		int i1=Integer.parseInt(page);
		int i2=Integer.parseInt(rows);
		
		HttpSession session=req.getSession();
		User uu=(User) session.getAttribute("user");
		//得到当前用户的rid
		int id=uu.getRid();
		int uid=uu.getId();
		//根据当前用户的rid查询用户的角色
		rolename=qiuService.selrolename(id);
		
		if(rolename.equals("超级管理员")) {//超级管理员查询所有报名信息
			//总数据
			listartfinance=qiuService.selartfinance(i1, i2, astudentno, aname, teacher, status, types);
			
			//总数据条数
			listcount=qiuService.artfinancecount(astudentno, aname, teacher, status, types);
		}
		else {//其他管理员只能查询自己的学生报名信息
			//总数据
			listartfinance=qiuService.selartfinancebyuid(i1,i2,astudentno,aname,status, types,uid);
			//总数据条数
			listcount=qiuService.selartfinancecountbyuid(uid,astudentno,aname,status, types);
		}
		
		List<ArtfinanceBean> list1=new ArrayList<>();
		for (int i = 0; i < listartfinance.size(); i++) {
			Object[] o = (Object[])listartfinance.get(i);
			Artfinance a=(Artfinance) o[0];
			User u=(User) o[1];
			
			ArtfinanceBean ab=new ArtfinanceBean();
			ab.setFid(a.getFid());
			ab.setSid(a.getSid());
			ab.setSname(a.getSname());
			ab.setTid(a.getTid());
			ab.setNeedmoney(a.getNeedmoney());
			ab.setPracticalmoney(a.getPracticalmoney());
			ab.setFdata(a.getFdata());
			ab.setFway(a.getFway());
			ab.setFstatu(a.getFstatu());
			ab.setFtest1(a.getFtest1());
			ab.setFtest2(a.getFtest2());
			
			ab.setUsername(u.getName());
			list1.add(ab);
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
	
	// 超级管理员进工作助手前先查 所有用户
	public String selsche() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		User u=(User) session.getAttribute("user");
		
		listuser=qiuService.seluser();
		
		//根据用户查询当前用户是什么权限
		rolename=qiuService.selrolenamebyrid(u.getRid());
		System.out.println("角色名="+rolename);
		return SUCCESS;
	}
	
	
	//超级管理员查询所有员工的工作日志
	public String selschedule() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		
		
		res.setCharacterEncoding("utf-8");
		
		String page = req.getParameter("page");
		String rows = req.getParameter("rows");
		int i1=Integer.parseInt(page);
		int i2=Integer.parseInt(rows);
		
		HttpSession session=req.getSession();
		User uu=(User) session.getAttribute("user");
		//得到当前用户的rid
		int id=uu.getRid();
		int uid=uu.getId();
		//根据当前用户的rid查询用户的角色
		String name=qiuService.selrolename(id);
		
		if(name.equals("超级管理员")) {
			//总数据
			listschedule=qiuService.selschedule(i1, i2, userid, stitle, sdate, finishdate, statu);
			//总数据条数
			listcount=qiuService.schedulecount(userid, stitle, sdate, finishdate, statu);
		}
		else {
			//普通管理员看到的数据
			listschedule=qiuService.selsche(i1, i2, uid+"", stitle, sdate, finishdate, statu);
			//管理员能看到的总数据条数
			listcount=qiuService.schedulecounts(uid, stitle, sdate, finishdate, statu);
		}
		
		
		
	/*	//总数据条数
		listcount=listschedule.size();*/
		
		List<ScheduleBean> list1=new ArrayList<>();
		for (int i = 0; i < listschedule.size(); i++) {
			Object[] o = (Object[])listschedule.get(i);
			
			Schedule s=(Schedule) o[0];
			User u=(User) o[1];
			
			ScheduleBean sb=new ScheduleBean();
			sb.setSid(s.getSid());
			sb.setUserid(s.getUserid());
			sb.setStitle(s.getStitle());
			sb.setScontent(s.getScontent());
			sb.setSdate(s.getSdate());
			sb.setSfinishdate(s.getSfinishdate());
			sb.setSflag(s.getSflag());
			sb.setUsername(u.getName());
			list1.add(sb);
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
	
	//添加工作助手时  先查询所有用户
	public String addschedule() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		User u=(User) session.getAttribute("user");
		//根据用户的rid查询用户的
		String name=qiuService.selrolename(u.getRid());
		
		listuser=qiuService.seluser();
		
		if(name.equals("超级管理员")) {
			return SUCCESS;
		}
		else {
			return LOGIN;
		}
		
	}
	
	//添加用户时 先查询部门和角色表
	public String beforeadduser() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		res.setCharacterEncoding("utf-8");
		//总部门数据
		listorg=qiuService.selorgs();
		
		//总角色数据
		listrole=qiuService.selroles();
		
		return SUCCESS;
	}
	
	//查询学生文件上传表的信息
	public String selstufile() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		
		res.setCharacterEncoding("utf-8");
		String page = req.getParameter("page");
		String rows = req.getParameter("rows");
		int i1=Integer.parseInt(page);
		int i2=Integer.parseInt(rows);
		
		//System.out.println("id="+id);
		//System.out.println("name="+name);
		
		/*HttpSession session=req.getSession();
		User uu=(User) session.getAttribute("user");
		//得到当前用户的rid
		int ids=uu.getRid();
		int uid=uu.getId();
		//根据当前用户的rid查询用户的角色
		String names=qiuService.selrolename(ids);*/
		
		
		//返回总数据
		liststufile=qiuService.selstufile(i1,i2,id,name);
			
		//返回总数据条数
		listcount=qiuService.stufilecount(id,name);
		
		
		
	
		
		map=new HashMap<>();
		map.put("total", listcount);
		map.put("rows", liststufile);
		json=JSON.toJSONString(map);//把map转换成json格式
		System.out.println("json格式="+json);
		try {
			PrintWriter pw=res.getWriter();
			pw.println(json);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	//查询成人高考表的学生信息
	public String seladultstu() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		
		res.setCharacterEncoding("utf-8");
		String page = req.getParameter("page");
		String rows = req.getParameter("rows");
		int i1=Integer.parseInt(page);
		int i2=Integer.parseInt(rows);
		
		/*//查询成人高考表的信息
		//总数据
		listadu=qiuService.seladultstu(i1, i2);
		//总数据条数
		listcount=listadu.size();*/
		
		HttpSession session=req.getSession();
		User uu=(User) session.getAttribute("user");
		//得到当前用户的rid
		int id=uu.getRid();
		int uid=uu.getId();
		//根据当前用户的rid查询用户的角色
		rolename=qiuService.selrolename(id);
		
		if(rolename.equals("超级管理员")) {//超级管理员查询所有报名信息
			//总数据
			listadu=qiuService.seladultstu(i1, i2);
			//总数据条数
			listcount=qiuService.adultapplycount();
		}
		else {//其他管理员只能查询自己的学生报名信息
			//总数据
			listadu=qiuService.seladubyuid(i1,i2,uid);
			//总数据条数
			listcount=qiuService.seladultapplycountbyuid(uid);
		}
		
		List<AdultapplyBean> list1=new ArrayList<>();
		for (int i = 0; i < listadu.size(); i++) {
			Object[] o = (Object[])listadu.get(i);
			
			Adultapply adu=new Adultapply();
			User u=new User();
			Academy aca=new Academy();
			Specialty spe=new Specialty();
			City c=new City();
			County co=new County();
			
			AdultapplyBean ab=new AdultapplyBean();
			
			adu=(Adultapply) o[0];
			u=(User) o[1];
			aca=(Academy) o[2];
			spe=(Specialty) o[3];
			c=(City) o[4];
			co=(County) o[5];
			
			ab.setAid(adu.getAid());
			ab.setAstudentno(adu.getAstudentno());
			ab.setAname(adu.getAname());
			ab.setUserid(adu.getUserid());
			ab.setIdnumber(adu.getIdnumber());
			ab.setAphone(adu.getAphone());
			ab.setAtype(adu.getAtype());
			ab.setAcaid(adu.getAcaid());
			ab.setSpecid(adu.getSpecid());
			ab.setAgradation(adu.getAgradation());
			ab.setAsystem(adu.getAsystem());
			ab.setCityid(adu.getCityid());
			ab.setCountyid(adu.getCountyid());
			ab.setAdata(adu.getAdata());
			
			ab.setUsername(u.getName());
			ab.setAcaname(aca.getAschool());
			ab.setSpecname(spe.getSname());
			ab.setCityname(c.getCname());
			ab.setCountyname(co.getConame());
			list1.add(ab);
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
	
	// 获取文件上传时的学生id和name到action
	public String back() {
		
		name=qiuService.seladultname(Integer.parseInt(id));
		//System.out.println("name="+name);
		
		return SUCCESS;
	}
	
	//根据学生学号和姓名查询是否有该学生
	public String hasstu() {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		res.setCharacterEncoding("utf-8");
		List list=qiuService.hasstu(Integer.parseInt(id), name);
		listcount=list.size();
		
		List<AdultapplyBean> list1=new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Object[] o = (Object[])list.get(i);
			
			Adultapply adu=new Adultapply();
			User u=new User();
			Academy aca=new Academy();
			Specialty spe=new Specialty();
			City c=new City();
			County co=new County();
			
			AdultapplyBean ab=new AdultapplyBean();
			
			adu=(Adultapply) o[0];
			u=(User) o[1];
			aca=(Academy) o[2];
			spe=(Specialty) o[3];
			c=(City) o[4];
			co=(County) o[5];
			
			ab.setAid(adu.getAid());
			ab.setAstudentno(adu.getAstudentno());
			ab.setAname(adu.getAname());
			ab.setUserid(adu.getUserid());
			ab.setIdnumber(adu.getIdnumber());
			ab.setAphone(adu.getAphone());
			ab.setAtype(adu.getAtype());
			ab.setAcaid(adu.getAcaid());
			ab.setSpecid(adu.getSpecid());
			ab.setAgradation(adu.getAgradation());
			ab.setAsystem(adu.getAsystem());
			ab.setCityid(adu.getCityid());
			ab.setCountyid(adu.getCountyid());
			ab.setAdata(adu.getAdata());
			
			ab.setUsername(u.getName());
			ab.setAcaname(aca.getAschool());
			ab.setSpecname(spe.getSname());
			ab.setCityname(c.getCname());
			ab.setCountyname(co.getConame());
			list1.add(ab);
		}
		String str="";
		if(list1!=null&&list1.size()>0) {
			str="1";
		}
		else {
			str="2";
		}
		/*String jsons = JSONArray.toJSONString(str);*/
		//System.out.println("json格式:"+jsons);
		/*map=new HashMap<>();
		map.put("value", list1);
	
		json=JSON.toJSONString(map);//把map转换成json格式
		System.out.println("json格式:"+json);*/
		try {
			PrintWriter pw=res.getWriter();
			pw.print(str);
		} catch (Exception e) {
			
		}
		return null;
	}
	
	
}
