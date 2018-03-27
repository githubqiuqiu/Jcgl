package com.edu.action;


import java.io.IOException; 
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.edu.bean.Cou;
import com.edu.bean.Spe;
import com.edu.model.Academy;
import com.edu.model.Adultapply;
import com.edu.model.Adultfinance;
import com.edu.model.Distanceapply;
import com.edu.model.Distancefinance;
import com.edu.model.Specialty;
import com.edu.model.Stateapply;
import com.edu.model.Statefinance;
import com.edu.service.impl.FengServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

import oracle.net.aso.l;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import org.dom4j.Document;   
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;   
import org.dom4j.Element;   


public class UserAction1 extends ActionSupport{
	private String name;//姓名
	private Integer zname;//专业
	private String sfz;//身份证
	private Integer yx;//报考院校
	private String sjh;//手机号
	private String xzc;//选择层次
	private Integer city;//市区
	private Integer County;//县城
	private String yzm;//验证码
	 private Integer csb;//县级判断值
	 private Integer yxz;//院校判断值
	 private Integer lsc;//招生判断值
	 private Integer needmoney;//需缴金额
	private List ls;//城市返回值
	private List xs;//县级返回值
	private List ys;//院校返回值
	
	private String json;//县级返回值
	
	private	FengServiceImpl dtdd;//调用Service层

	
	public Integer getLsc() {
		return lsc;
	}
	public void setLsc(Integer lsc) {
		this.lsc = lsc;
	}
	public Integer getYxz() {
		return yxz;
	}
	public void setYxz(Integer yxz) {
		this.yxz = yxz;
	}
	public List getYs() {
		return ys;
	}
	public void setYs(List ys) {
		this.ys = ys;
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
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	public List getXs() {
		return xs;
	}
	public void setXs(List xs) {
		this.xs = xs;
	}
	public Integer getCsb() {
		return csb;
	}
	public void setCsb(Integer csb) {
		this.csb = csb;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getZname() {
		return zname;
	}
	public void setZname(Integer zname) {
		this.zname = zname;
	}
	public String getSfz() {
		return sfz;
	}
	public FengServiceImpl getDtdd() {
		return dtdd;
	}
	public void setDtdd(FengServiceImpl dtdd) {
		this.dtdd = dtdd;
	}
	public void setSfz(String sfz) {
		this.sfz = sfz;
	}
	public Integer getYx() {
		return yx;
	}
	public void setYx(Integer yx) {
		this.yx = yx;
	}
	public String getSjh() {
		return sjh;
	}
	public void setSjh(String sjh) {
		this.sjh = sjh;
	}
	public String getXzc() {
		return xzc;
	}
	public void setXzc(String xzc) {
		this.xzc = xzc;
	}
	public String getYzm() {
		return yzm;
	}
	public void setYzm(String yzm) {
		this.yzm = yzm;
	}
	
	
	
	public List getLs() {
		return ls;
	}
	public void setLs(List ls) {
		this.ls = ls;
	}
//短信发送----------------------------------------------------------------------------
	public String dxyz() {
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpServletResponse res=ServletActionContext.getResponse();
		System.out.println("进来了短信发送action");
		
	    String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
		HttpClient client = new HttpClient(); 
		PostMethod method = new PostMethod(Url);

		client.getParams().setContentCharset("GBK");
		method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");

		int mobile_code = (int)((Math.random()*9+1)*100000);
		System.out.println("验证码="+mobile_code);
	    String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");

		NameValuePair[] data = {//提交短信
			    new NameValuePair("account", "C28875231"), //查看用户名是登录用户中心->验证码短信->产品总览->APIID
			    new NameValuePair("password", "32704bdebbdfa39f008754e218a2004e"),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
			    //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
			    new NameValuePair("mobile", sjh), 
			    new NameValuePair("content", content),
		};
		method.setRequestBody(data);

		try {
			client.executeMethod(method);
			
			String SubmitResult =method.getResponseBodyAsString();

			//System.out.println(SubmitResult);

			Document doc = DocumentHelper.parseText(SubmitResult);
			Element root = doc.getRootElement();

			String code = root.elementText("code");
			String msg = root.elementText("msg");
			String smsid = root.elementText("smsid");

			System.out.println(code);
			System.out.println(msg);
			System.out.println(smsid);

			 if("2".equals(code)){
				System.out.println("短信提交成功");
			}

		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			PrintWriter pw=res.getWriter();
			pw.println(mobile_code);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	
//首页轮播判读方法---------------------------------------------------------------
	
	public String wheel() throws IOException {
		System.out.println("进来了action");
		HttpServletRequest request=ServletActionContext.getRequest();//请求对象	
		HttpServletResponse response=ServletActionContext.getResponse();//响应对象
		HttpSession session=request.getSession();	
		
		
		
		
			//判断值
			Integer pd=(Integer) session.getAttribute("pdad");
			System.out.println("页面判断值: "+pd);
			
			if(pd==null) {
				System.out.println("进来了第一次判断值");
				session.setAttribute("pdad", 1);//第一次登录判断值
				return ERROR;
			}else{
			System.out.println("跳到主页");
			return SUCCESS;//跳到主页
		}
		
		
	}
//成人高考后台验证方法--------------------------------------------------------------------------------------------------------
	public String data2() {
		Adultapply cbean=new Adultapply();//成人教育表
		Adultfinance bean=new Adultfinance();//成人教育缴费表
		
		HttpServletRequest request=ServletActionContext.getRequest();//请求对象	
		HttpServletResponse response=ServletActionContext.getResponse();//响应对象
		HttpSession session=request.getSession();
		session.removeAttribute("yzfh2");//移除返回记录		
		
        String yzma=(String) session.getAttribute("verCode");
        System.out.println("老师招生编号: "+lsc);
        int sjs=Radoms();
        System.out.println("随机数是："+sjs);
       if(yzma.equals(yzm.toLowerCase())||yzma.equals(yzm.toUpperCase())){ 	
        	System.out.println("数据提交成功");
        	
        //获取当前时间
        	Date date=new Date();
        	DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	String time=format.format(date);	
        	session.setAttribute("yzfh2", 11);//插入成功
        	
        //学号ID 随机数生成学号
        	int ssd=Radoms();
        //数据库中获取到学生学号
        	List<Adultapply> xss=dtdd.selectssid();
        	for(int i=0; i<xss.size();i++){
        		Adultapply ss=xss.get(i);
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
        	
        	
//成人教育报名数据--------------------------------------------------       	
        	cbean.setAstudentno(sidd);//学号
        	cbean.setAname(name);//姓名
        	cbean.setUserid(i);//用户id
        	cbean.setIdnumber(sfz);//身份证
        	cbean.setAphone(sjh);//电话
        	cbean.setAtype(0);//分类
        	cbean.setAcaid(yx);//报考院校
        	cbean.setSpecid(zname);//报考专业
        	cbean.setAgradation(xzc);//报考层次
        	cbean.setAsystem("三年");//学期制
        	cbean.setCityid(city);//城市ID
        	cbean.setCountyid(County);//县城ID
        	cbean.setAdata(time);//报名时间
        	//插入数据到成人教育报名表
        	boolean fhz=dtdd.insertinto(cbean);
        	
//成人教育缴费数据-----------------------------------------------------------------------------        	
        	
        	//判断需缴金额
        	if(xzc.equals("专达本")){
        		needmoney=8000;
        	}else if(xzc.equals("高达本")){
        		needmoney=10000;
        	}else if(xzc.equals("高达专")){
        		needmoney=6000;
        	}
        	
        	bean.setSid(ssd);//学号
        	bean.setSname(name);//学生姓名
        	bean.setSchoolid(yx);//学校ID
        	bean.setMajorid(zname);//专业ID
        	bean.setGradation(xzc);//层次
        	
        	
        	
        	bean.setTid(i);//老师ID
        	bean.setNeedmoney(needmoney);//需缴金额
        	bean.setPracticalmoney(0);//实缴金额        	
        	bean.setFstatu(0);//缴费状态
       //插入数据到成人教育缴费表
        	dtdd.insertltfinace(bean);
        	
        	
        	
       }else {
        	System.out.println("验证码错误!");
        	session.setAttribute("yzfh2", 1);
        }
		return SUCCESS;  	
	}
	
	//城市查询
	public String city() {	
		HttpServletRequest request=ServletActionContext.getRequest();//请求对象	
		HttpServletResponse response=ServletActionContext.getResponse();//响应对象
        
		//城市查询返回值
		ls=dtdd.selectcity();
		System.out.println("这是返回城市集合的大小"+ls.size());      
		//院校返回值
		ys=dtdd.selectAcademy();
		System.out.println("这是返回院校集合大小"+ys.size());
		
        request.setAttribute("lsc",1);//老师招生测试

		return SUCCESS;
		
	}
	
//国家开放报名后台验证方法--------------------------------------------------------------------------------------------------------	
	public String data4() {
		Stateapply cbean=new Stateapply();//国家开放bean4
		Statefinance bean=new Statefinance();//国家开放缴费表
		
		HttpServletRequest request=ServletActionContext.getRequest();//请求对象	
		HttpServletResponse response=ServletActionContext.getResponse();//响应对象
		HttpSession session=request.getSession();
		
		session.removeAttribute("yzfh2");//移除返回记录
		
		
        String yzma=(String) session.getAttribute("verCode");//页面验证码        
        System.out.println("老师招生编号: "+lsc);
        
       if(yzma.equals(yzm.toLowerCase())||yzma.equals(yzm.toUpperCase())){ 	
        	System.out.println("数据提交成功");
        	//获取当前时间
        	Date date=new Date();
        	DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	String time=format.format(date);	
        	session.setAttribute("yzfh2", 11);
        	
        	//学号ID 随机数生成学号
        	int ssd=Radoms();
        //数据库中获取到学生学号
        	List<Stateapply> xss=dtdd.selectstid();
        	for(int i=0; i<xss.size();i++){
        		Stateapply ss=xss.get(i);
        		String ast=ss.getSstudentno();//学生学号
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
        	
        	cbean.setSstudentno(sidd);//学号
        	cbean.setSname(name);//姓名
        	cbean.setUserid(i);//用户id
        	cbean.setIdnumber(sfz);//身份证
        	cbean.setSphone(sjh);//电话
        	cbean.setStype(0);//分类
        	cbean.setAcaid(yx);//报考院校
        	cbean.setSpecid(zname);//报考专业
        	cbean.setSgradation(xzc);//报考层次
        	cbean.setSsystem("三年");//学期制
        	cbean.setCityid(city);//城市ID
        	cbean.setCountyid(County);//县城ID
        	cbean.setSdata(time);//报名时间
        	//插入数据到国家开放报名表
        	boolean fhz=dtdd.inserstate(cbean);
        	
//插入数据到 国家开放缴费表----------------------------------------------       	

        	//判断需缴金额
        	if(xzc.equals("专达本")){
        		needmoney=8000;
        	}else if(xzc.equals("高达本")){
        		needmoney=10000;
        	}else if(xzc.equals("高达专")){
        		needmoney=6000;
        	}
        	
        	bean.setSid(ssd);//学号
        	bean.setSname(name);//学生姓名
        	bean.setSchoolid(yx);//学校ID
        	bean.setMajorid(zname);//专业ID
        	bean.setGradation(xzc);//层次
        	bean.setTid(i);//老师ID
        	bean.setNeedmoney(needmoney);//需缴金额
        	bean.setPracticalmoney(0);//实缴金额        	
        	bean.setFstatu(0);//缴费状态
        	boolean ss=dtdd.insertstfinace(bean);//调用方法插入
       }else {
        	System.out.println("验证码错误!");
        	session.setAttribute("yzfh2", 1);
        }
		return SUCCESS;  	
	}
	
//远程教育报名后台验证方法--------------------------------------------------------------------------------------------------------	
		public String data5() {
			Distanceapply cbean=new Distanceapply();//远程教育bean4
			Distancefinance bean=new Distancefinance();//远程教育缴费表
			
			HttpServletRequest request=ServletActionContext.getRequest();//请求对象	
			HttpServletResponse response=ServletActionContext.getResponse();//响应对象
			HttpSession session=request.getSession();
			
			session.removeAttribute("yzfh2");//移除返回记录
			
			
	        String yzma=(String) session.getAttribute("verCode");//页面验证码        
	        System.out.println("老师招生编号: "+lsc);
	        
	       if(yzma.equals(yzm.toLowerCase())||yzma.equals(yzm.toUpperCase())){ 	
	        	System.out.println("数据提交成功");
	        	//获取当前时间
	        	Date date=new Date();
	        	DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        	String time=format.format(date);	
	        	session.setAttribute("yzfh2", 11);
	        	
	        	//学号ID 随机数生成学号
	        	int ssd=Radoms();
	        //数据库中获取到学生学号
	        	List<Distanceapply> xss=dtdd.selectstDist();
	        	for(int i=0; i<xss.size();i++){
	        		Distanceapply ss=xss.get(i);
	        		String ast=ss.getDstudentno();//学生学号
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
	        	
	        	cbean.setDstudentno(sidd);//学号
	        	cbean.setDname(name);//姓名
	        	cbean.setUserid(i);//用户id
	        	cbean.setIdnumber(sfz);//身份证
	        	cbean.setDphone(sjh);//电话
	        	cbean.setDtype(0);//分类
	        	cbean.setAcaid(yx);//报考院校
	        	cbean.setSpecid(zname);//报考专业
	        	cbean.setDgradation(xzc);//报考层次
	        	cbean.setDsystem("三年");//学期制
	        	cbean.setCityid(city);//城市ID
	        	cbean.setCountyid(County);//县城ID
	        	cbean.setDdata(time);//报名时间
	        	//插入数据到成人教育报名表
	        	boolean fhz=dtdd.inserdista(cbean);
	        	
//插入到远程教育缴费表数据-----------------------------------------------------------------	        	
	        
	        	//判断需缴金额
	        	if(xzc.equals("专达本")){
	        		needmoney=8000;
	        	}else if(xzc.equals("高达本")){
	        		needmoney=10000;
	        	}else if(xzc.equals("高达专")){
	        		needmoney=6000;
	        	}
	        	
	        	bean.setSid(ssd);//学号
	        	bean.setSname(name);//学生姓名
	        	bean.setSchoolid(yx);//学校ID
	        	bean.setMajorid(zname);//专业ID
	        	bean.setGradation(xzc);//层次
	        	bean.setTid(i);//老师ID
	        	bean.setNeedmoney(needmoney);//需缴金额
	        	bean.setPracticalmoney(0);//实缴金额        	
	        	bean.setFstatu(0);//缴费状态
	        	boolean ss=dtdd.insertDistan(bean);//调用方法插入
	       }else {
	        	System.out.println("验证码错误!");
	        	session.setAttribute("yzfh2", 1);
	        }
			return SUCCESS;  	
		}
	
	
	
//根据市查询县	
	public String County() {
		HttpServletRequest request=ServletActionContext.getRequest();//请求对象	
		HttpServletResponse response=ServletActionContext.getResponse();//响应对象
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

   //县级关联查询判断
		if(csb!=null){
		List<Cou> jh=new ArrayList<Cou>();//县集合数据
		xs=dtdd.selectcounty(csb);
		System.out.println("集合返回:"+xs);	
		for(int i=0; i<xs.size(); i++){ 
		com.edu.model.County c=(com.edu.model.County) xs.get(i);	
		Cou cc=new Cou();
		cc.setCid(c.getCid());
		cc.setCoid(c.getCoid());	
		cc.setConame(c.getConame());
		jh.add(cc);
		}
				
		json=JSON.toJSONString(jh);
		System.out.println("json"+json);
		System.out.println("这是返回县城集合大小"+jh.size());	
		try {
			PrintWriter pw = response.getWriter();
			pw.print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		}						
		return null;
	}
	
	
//根据院校查询专业
	public String Acaspe() {
		HttpServletRequest request=ServletActionContext.getRequest();//请求对象	
		HttpServletResponse response=ServletActionContext.getResponse();//响应对象
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(yxz!=null){
			System.out.println("院校ID: "+yxz);
			List<Spe> spe=new ArrayList<Spe>();//县集合数据
			xs=dtdd.selectASP(yxz);
			System.out.println(xs.size());
			
			for(int i=0; i<xs.size(); i++){ 
			Object[] o = (Object[])xs.get(i);

			com.edu.model.Acaspe a1=new com.edu.model.Acaspe();//院校表
			Academy a2=new Academy(); //学校表
			Specialty a3=new Specialty();//专业表
		    a1=(com.edu.model.Acaspe) o[0];
			a2=(Academy) o[1];
			a3=(Specialty) o[2];
	//设值		
			Spe c=new Spe();//创建自定义专业bean存储
			c.setSid(a3.getSid());
			c.setSname(a3.getSname());
			c.setSort(a3.getSort());
            spe.add(c); //存储在集合
			}
			
					
			json=JSON.toJSONString(spe);
			System.out.println("这是返回专业集合大小"+spe.size());	
			try {
				PrintWriter pw = response.getWriter();
				pw.print(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return null;
	}
	
	
//生成随机数-----------------------------------------------------------------------------------
public int Radoms(){
        Random rand = new Random();
        int fhz=rand.nextInt((999999)+1);
        return fhz;
}
	
}
