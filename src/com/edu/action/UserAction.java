package com.edu.action;
 
import java.io.IOException; 
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.edu.model.Accountantapply;
import com.edu.model.Accountantfinance;
import com.edu.model.Artapply;
import com.edu.model.Artfinance;
import com.edu.model.Professionapply;
import com.edu.model.Professionfinance;
import com.edu.model.Stateapply;
import com.edu.service.impl.FengServiceImpl;

import com.opensymphony.xwork2.ActionSupport;



public class UserAction extends ActionSupport{
    private String name;//姓名 
    private String sjh;//手机号
	private String nrx;//学习内容
	private Integer city;//城市
	private Integer County;//县镇
	   private Integer csb;//市级判断值
	   private Integer lsc;//招生老师 
       private String yzm; //验证码 
       private List ls;//市返回值
       private	FengServiceImpl dtdd;//调用Service层
    
    
    
	public List getLs() {
		return ls;
	}

	public void setLs(List ls) {
		this.ls = ls;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public Integer getCounty() {
		return County;
	}

	public void setCounty(Integer county) {
		County = county;
	}

	public Integer getCsb() {
		return csb;
	}

	public void setCsb(Integer csb) {
		this.csb = csb;
	}

	public Integer getLsc() {
		return lsc;
	}

	public void setLsc(Integer lsc) {
		this.lsc = lsc;
	}

	public FengServiceImpl getDtdd() {
		return dtdd;
	}

	public void setDtdd(FengServiceImpl dtdd) {
		this.dtdd = dtdd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getSjh() {
		return sjh;
	}

	public void setSjh(String sjh) {
		this.sjh = sjh;
	}



	public String getNrx() {
		return nrx;
	}

	public void setNrx(String nrx) {
		this.nrx = nrx;
	}

	public String getYzm() {
		return yzm;
	}

	public void setYzm(String yzm) {
		this.yzm = yzm;
	}

	//城市查询
		public String city() {
			
			HttpServletRequest request=ServletActionContext.getRequest();//请求对象	
			HttpServletResponse response=ServletActionContext.getResponse();//响应对象
	        
			//城市查询返回值
			ls=dtdd.selectcity();
			System.out.println("这是返回城市集合的大小"+ls.size()); 
			
			request.setAttribute("lsc",1);//老师招生测试
			return SUCCESS;
			
		}
	
//会计资料填写判断----------------------------------------------------------------------------------------------------------------------------
	public String data() {
		Accountantapply bm=new Accountantapply();//会计表
		Accountantfinance bean=new Accountantfinance();//会计缴费表
				
		HttpServletRequest request=ServletActionContext.getRequest();//请求对象	
		HttpServletResponse response=ServletActionContext.getResponse();//响应对象
		HttpSession session=request.getSession();//session对象
		session.removeAttribute("yzfh");//移除返回记录
		
		
        String yzma=(String) session.getAttribute("verCode");
        //验证码判断
        if(yzma.equals(yzm.toLowerCase())||yzma.equals(yzm.toUpperCase())){ 	
        	System.out.println("数据提交成功");
        	session.setAttribute("yzfh", 11);
        	//获取当前时间
        	Date date=new Date();
        	DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	String time=format.format(date);
        	
        	//学号ID 随机数生成学号
        	int ssd=Radoms();
        	
        //数据库中获取到学生学号
        	List<Accountantapply> xss=dtdd.selectacdc();
        	for(int i=0; i<xss.size();i++){
        		Accountantapply ss=xss.get(i);
        		String ast=ss.getAstudentno();//学生学号
        		int astud=Integer.parseInt(ast);//转成int
        		if(ssd==astud) {//如有重复
        		ssd=Radoms();//重新生产
        		}
        	}
        	//学号转字符串
        	String sidd=String.valueOf(ssd);//转字符串
        	
        	String uid=(String) session.getAttribute("userid");
        	
        	//判断学生是否是通过老师提供的二维码来报名的
        	int i=1;
        	if(uid!=null) {
        		i=Integer.parseInt(uid);
        	}
        	
//会计报名表插入数据        	
        	bm.setAstudentno(sidd);//学号
        	bm.setAname(name);//姓名
        	bm.setUserid(i);//用户id
        	bm.setAphone(sjh);//电话
        	bm.setAcontent(nrx);//学习内容
        	bm.setCityid(city);//城市ID
        	bm.setCountyid(County);//县城ID
        	bm.setAdata(time);//报名时间
        	boolean fhz=dtdd.insertacc(bm);//插入数据库调用Service方法
        	
//插入到会计缴费表---------------------------------------------------------------       	
        	       	
        	bean.setSid(ssd);//学号
        	bean.setSname(name);//学生姓名        	
        	bean.setTid(i);//老师ID
        	bean.setNeedmoney(6000);//需缴金额
        	bean.setPracticalmoney(0);//实缴金额        	
        	bean.setFstatu(0);//缴费状态
        	boolean ss=dtdd.insertaccoun(bean);//调用方法插入
        	
        	request.setAttribute("xh",ssd); //学生学号---------------------------------
        }else {
        	System.out.println("会计提交验证码错误!");
        	session.setAttribute("yzfh", 1);
        }
		return SUCCESS;  	
}
	
	
	
	
//艺考资料填写判断----------------------------------------------------------------------------------------------------------------------------
		public String data2() {
			Artapply bm=new Artapply();//艺考表
			Artfinance bean=new Artfinance();//艺考缴费表
			
			HttpServletRequest request=ServletActionContext.getRequest();//请求对象	
			HttpServletResponse response=ServletActionContext.getResponse();//响应对象
			HttpSession session=request.getSession();
			session.removeAttribute("yzfh");//移除返回记录
		
	        String yzma=(String) session.getAttribute("verCode");
	        //验证码判断
	        if(yzma.equals(yzm.toLowerCase())||yzma.equals(yzm.toUpperCase())){ 	
	        	System.out.println("数据提交成功");
	        	session.setAttribute("yzfh", 11);
	        	//获取当前时间
	        	Date date=new Date();
	        	DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        	String time=format.format(date);
	        	
	        	//学号ID 随机数生成学号
	        	int ssd=Radoms();
	        	
	        //数据库中获取到学生学号
	        	List<Artapply> xss=dtdd.selectartapp();
	        	for(int i=0; i<xss.size();i++){
	        		Artapply ss=xss.get(i);
	        		String ast=ss.getAstudentno();//学生学号
	        		int astud=Integer.parseInt(ast);//转成int
	        		if(ssd==astud) {//如有重复
	        		ssd=Radoms();//重新生产
	        		}
	        	}
	        	//学号转字符串
	        	String sidd=String.valueOf(ssd);//转字符串
	        	
	        	String uid=(String) session.getAttribute("userid");
	        	
	        	//判断学生是否是通过老师提供的二维码来报名的
	        	int i=1;
	        	if(uid!=null) {
	        		i=Integer.parseInt(uid);
	        	}
	        	
//艺考报名插入数据------------------------------
	        	bm.setAstudentno(sidd);//学号
	        	bm.setAname(name);//姓名
	        	bm.setUserid(i);//用户id
	        	bm.setAphone(sjh);//电话
	        	bm.setAcontent(nrx);//学习内容
	        	bm.setCityid(city);//城市ID
	        	bm.setCountyid(County);//县城ID
	        	bm.setAdata(time);//报名时间
	        	boolean fhz=dtdd.insertaart(bm);//插入数据库调用Service方法
	        	
//艺考缴费插入数据------------------------------
	        	bean.setSid(ssd);//学号
	        	bean.setSname(name);//学生姓名        	
	        	bean.setTid(i);//老师ID
	        	bean.setNeedmoney(6000);//需缴金额
	        	bean.setPracticalmoney(0);//实缴金额        	
	        	bean.setFstatu(0);//缴费状态
	        	boolean ss=dtdd.insertartapply(bean);//调用方法插入
	        }else {
	        	System.out.println("艺考提交验证码错误!");
	        	session.setAttribute("yzfh", 1);
	        }
			return SUCCESS;  	
	}	

		
//职业资格资料填写判断----------------------------------------------------------------------------------------------------------------------------
				public String data3() {
					Professionapply bm=new Professionapply();//职业资格
					Professionfinance bean=new Professionfinance();//职业资格缴费表
					
					HttpServletRequest request=ServletActionContext.getRequest();//请求对象	
					HttpServletResponse response=ServletActionContext.getResponse();//响应对象
					HttpSession session=request.getSession();
					session.removeAttribute("yzfh");//移除返回记录
					
					
			        String yzma=(String) session.getAttribute("verCode");
			        //验证码判断
			        if(yzma.equals(yzm.toLowerCase())||yzma.equals(yzm.toUpperCase())){ 	
			        	System.out.println("数据提交成功");
			        	session.setAttribute("yzfh", 11);
			        	//获取当前时间
			        	Date date=new Date();
			        	DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        	String time=format.format(date);
			        	
			        	//学号ID 随机数生成学号
			        	int ssd=Radoms();
			        	
			        //数据库中获取到学生学号
			        	List<Professionapply> xss=dtdd.selectPro();
			        	for(int i=0; i<xss.size();i++){
			        		Professionapply ss=xss.get(i);
			        		String ast=ss.getPstudentno();//学生学号
			        		int astud=Integer.parseInt(ast);//转成int
			        		if(ssd==astud) {//如有重复
			        		ssd=Radoms();//重新生产
			        	}
			        	}
			        	//学号转字符串
			        	String sidd=String.valueOf(ssd);//转字符串
			        	
			        	String uid=(String) session.getAttribute("userid");
			        	
			        	//判断学生是否是通过老师提供的二维码来报名的
			        	int i=1;
			        	if(uid!=null) {
			        		i=Integer.parseInt(uid);
			        	}
//职业资格报名插入数据------------------------------------------			 
			        	bm.setPstudentno(sidd);//学号
			        	bm.setPname(name);//姓名
			        	bm.setUserid(i);//用户id
			        	bm.setPphone(sjh);//电话
			        	bm.setPcontent(nrx);//学习内容
			        	bm.setCityid(city);//城市ID
			        	bm.setCountyid(County);//县城ID
			        	bm.setPdata(time);//报名时间
			        	boolean fhz=dtdd.inserprofe(bm);//插入数据库调用Service方法
			        	
//职业资格缴费插入数据------------------------------------------			        	
			        	bean.setSid(ssd);//学号
			        	bean.setSname(name);//学生姓名        	
			        	bean.setTid(i);//老师ID
			        	bean.setNeedmoney(6000);//需缴金额
			        	bean.setPracticalmoney(0);//实缴金额        	
			        	bean.setFstatu(0);//缴费状态
			        	boolean ss=dtdd.insertPro(bean);//调用方法插入
			        }else {
			        	System.out.println("会计提交验证码错误!");
			        	session.setAttribute("yzfh", 1);
			        }
					return SUCCESS;  	
			}	

//生成随机数-----------------------------------------------------------------------------------
				public int Radoms(){
				        Random rand = new Random();
				        int fhz=rand.nextInt((999999)+1);
				        return fhz;
				}
}
