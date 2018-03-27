package com.edu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.edu.dao.FengDao;
import com.edu.model.Accountantapply;
import com.edu.model.Accountantfinance;
import com.edu.model.Adultapply;
import com.edu.model.Adultfinance;
import com.edu.model.Artapply;
import com.edu.model.Artfinance;
import com.edu.model.Distanceapply;
import com.edu.model.Distancefinance;
import com.edu.model.Professionapply;
import com.edu.model.Professionfinance;
import com.edu.model.Stateapply;
import com.edu.model.Statefinance;

public class FengDaoImpl implements FengDao{
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
//插入成人教育数据
		@Override
		public boolean insert(Adultapply bean) {
	    System.out.println("这是将要插入的数据    astudentno："+bean.getAstudentno()+"  aname:"+bean.getAname()+"  userid:"+bean.getUserid()+"  idnumber:"+bean.getIdnumber()+"  aphone:"+bean.getAphone()+"  atype:"+bean.getAtype()+"  acaid:"+bean.getAcaid()+"  specid:"+bean.getSpecid()+"  agradation:"+bean.getAgradation()+"  asystem:"+bean.getAsystem()+"  cityid:"+bean.getCityid()+"  countyid:"+bean.getCountyid()+"  adata:"+bean.getAdata());
		System.out.println("到了Dao层  成人教育插入数据");		
		hibernateTemplate.save(bean);//插入语句
		 return true;
		}
		
//会计报名插入数据	
		@Override
		public boolean inAcco(Accountantapply bean) {
			System.out.println("到了Dao层  会计插入数据");	
			System.out.println("这是插入会计表的的数据   astudentno:"+bean.getAstudentno()+"   aname:"+bean.getAname()+"   userid:"+bean.getUserid()+"  aphone:"+bean.getAphone()+"  acontent:"+bean.getAcontent()+"  cityid:"+bean.getCityid()+"  countyid:"+bean.getCountyid()+"  adata:"+bean.getAdata());
			hibernateTemplate.save(bean);//插入语句
			return true;
		}

//艺考报名插入数据		
		@Override
		public boolean inArta(Artapply bean) {
			System.out.println("到了Dao层  艺考插入数据");	
			System.out.println("这是插入会计表的的数据   astudentno:"+bean.getAstudentno()+"   aname:"+bean.getAname()+"   userid:"+bean.getUserid()+"  aphone:"+bean.getAphone()+"  acontent:"+bean.getAcontent()+"  cityid:"+bean.getCityid()+"  countyid:"+bean.getCountyid()+"  adata:"+bean.getAdata());
			hibernateTemplate.save(bean);//插入语句
			return true;
		}
		
//职业资格插入数据		
		@Override
		public boolean inProf(Professionapply bean) {
			System.out.println("到了Dao层  职业资格插入数据");	
			System.out.println("这是插入职业表的的数据   astudentno:"+bean.getPstudentno()+"   aname:"+bean.getPname()+"   userid:"+bean.getUserid()+"  aphone:"+bean.getPphone()+"  acontent:"+bean.getPcontent()+"  cityid:"+bean.getCityid()+"  countyid:"+bean.getCountyid()+"  adata:"+bean.getPdata());
			hibernateTemplate.save(bean);//插入语句
			return true;
		}

//国家开放插入数据		
		@Override
		public boolean instat(Stateapply bean) {
			System.out.println("到了Dao层  国家开放插入数据");	
			System.out.println("这是插入国家开放表的数据   astudentno:"+bean.getSstudentno()+"   aname:"+bean.getSname()+"   userid:"+bean.getUserid()+"  aphone:"+bean.getSphone()+"  ssystem:"+bean.getSsystem()+"  cityid:"+bean.getCityid()+"  countyid:"+bean.getCountyid()+"  adata:"+bean.getSdata());
			hibernateTemplate.save(bean);//插入语句
			return true;
		}
//远程教育插入数据		
		@Override
		public boolean indist(Distanceapply bean) {
			System.out.println("到了Dao层  远程教育插入数据");	
			System.out.println("这是插入国家开放表的数据   astudentno:"+bean.getDstudentno()+"   aname:"+bean.getDname()+"   userid:"+bean.getUserid()+"  aphone:"+bean.getDphone()+"  ssystem:"+bean.getDsystem()+"  cityid:"+bean.getCityid()+"  countyid:"+bean.getCountyid()+"  adata:"+bean.getDdata());
			hibernateTemplate.save(bean);//插入语句
			return true;
		}
		
	//查询城市信息	
		@Override
		public List selectCS() {
			System.out.println("进来了Dao层 市级查询");
		List cs= hibernateTemplate.find("from City");
			return cs;
		}

	//根据市查询县
		@Override
		public List selectXC(Integer id) {
	    System.out.println("进来了Dao层 县级查询");
		List xc=hibernateTemplate.find("from County where cid="+id);	
			return xc;
		}

	//查询院校数据
		@Override
		public List selectAcad() {
			System.out.println("进来了Dao层 院校查询");
		List yx=hibernateTemplate.find("from Academy");	
			return yx; 
		}

	//根据院校查询专业	
		@Override
		public List selectSpe(Integer id) {
		System.out.println("进来了Dao专业查询");
		try {
	      	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	               public Object doInHibernate(Session session)  
	                        throws HibernateException, SQLException {  
	                   List list2 = session.createQuery("from Acaspe a inner join a.academy inner join a.specialty where a.acid="+id).list();  
	                   return list2;  
	               }});
	      	 
	           return list;  
	      	 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;

		 }
		
//查询所有成人教育表学生ID
		@Override
		public List selesid() {
		System.out.println("进来了Dao成人表数据查询");
			List xc=hibernateTemplate.find("from Adultapply");
			return xc;
		}

//插入成人教育缴费表		
		@Override
		public boolean insertfi(Adultfinance bean) {
			 System.out.println("这是将要插入的数据   sid："+bean.getSid()+"  sname:"+bean.getSname()+"  schoolid:"+bean.getSchoolid()+"  majorid:"+bean.getMajorid()+"  gradation:"+bean.getGradation()+"  gradation:"+bean.getGradation()+"  tid:"+bean.getTid()+"  needmoney:"+bean.getNeedmoney()+"  practicalmoney:"+bean.getPracticalmoney()+"  fdata:"+bean.getFdata()+"  fway:"+bean.getFway()+"  fstatu:"+bean.getFstatu());
				System.out.println("到了Dao层  成人教育缴费插入数据");		
				hibernateTemplate.save(bean);//插入语句
				 return true;
		}

//查询国家开放报名数据		
		@Override
		public List selestate() {
			List xc=hibernateTemplate.find("from Stateapply");
			return xc;
		}

//插入数据到国家开放缴费数据		
		@Override
		public boolean insertfista(Statefinance bean) {
			System.out.println("这是将要插入的数据   sid："+bean.getSid()+"  sname:"+bean.getSname()+"  schoolid:"+bean.getSchoolid()+"  majorid:"+bean.getMajorid()+"  gradation:"+bean.getGradation()+"  gradation:"+bean.getGradation()+"  tid:"+bean.getTid()+"  needmoney:"+bean.getNeedmoney()+"  practicalmoney:"+bean.getPracticalmoney()+"  fdata:"+bean.getFdata()+"  fway:"+bean.getFway()+"  fstatu:"+bean.getFstatu());
			System.out.println("到了Dao层  国家开放缴费插入数据");		
			hibernateTemplate.save(bean);//插入语句
			 return true;
		}

//查询远程教育报名数据		
		@Override
		public List selesdist() {
			List xc=hibernateTemplate.find("from Distanceapply");
			return xc;
		}
//插入数据到远程缴费表
		@Override
		public boolean insertdist(Distancefinance bean) {
			System.out.println("这是将要插入的数据   sid："+bean.getSid()+"  sname:"+bean.getSname()+"  schoolid:"+bean.getSchoolid()+"  majorid:"+bean.getMajorid()+"  gradation:"+bean.getGradation()+"  gradation:"+bean.getGradation()+"  tid:"+bean.getTid()+"  needmoney:"+bean.getNeedmoney()+"  practicalmoney:"+bean.getPracticalmoney()+"  fdata:"+bean.getFdata()+"  fway:"+bean.getFway()+"  fstatu:"+bean.getFstatu());
			System.out.println("到了Dao层  远程教育缴费插入数据");		
			hibernateTemplate.save(bean);//插入语句
			 return true;
		}
//----------------------------------------------------------------------------------------------------------缴费类型2
//会计查询报名数据		
		@Override
		public List selesAccdc() {
			System.out.println("到了Dao会计数据查询");
			List xc=hibernateTemplate.find("from Accountantapply");
			return xc;
		}

//会计缴费表插入数据		
		@Override
		public boolean insertAccoun(Accountantfinance bean) {
			System.out.println("这是将要插入会计缴费表的数据   sid："+bean.getSid()+"  sname:"+bean.getSname()+"  tid:"+bean.getTid()+"  needmoney:"+bean.getNeedmoney()+"  practicalmoney:"+bean.getPracticalmoney()+"  fdata:"+bean.getFdata()+"  fway:"+bean.getFway()+"  fstatu:"+bean.getFstatu());
			System.out.println("到了Dao层  会计缴费表插入数据");		
			hibernateTemplate.save(bean);//插入语句
			 return true;
		}

//艺考查询学生编号数据		
		@Override
		public List selesArtfi() {
			System.out.println("到了Dao艺考数据查询");
			List xc=hibernateTemplate.find("from Artapply");
			return xc;
		}

//艺考缴费插入数据
		@Override
		public boolean insertArtfi(Artfinance bean) {
			System.out.println("这是将要插入艺考缴费表的数据   sid："+bean.getSid()+"  sname:"+bean.getSname()+"  tid:"+bean.getTid()+"  needmoney:"+bean.getNeedmoney()+"  practicalmoney:"+bean.getPracticalmoney()+"  fdata:"+bean.getFdata()+"  fway:"+bean.getFway()+"  fstatu:"+bean.getFstatu());
			System.out.println("到了Dao层  艺考缴费表插入数据");		
			hibernateTemplate.save(bean);//插入语句
			 return true;
		}

//查询职业资格报名数据		
		@Override
		public List seleProfe() {
			System.out.println("到了Dao职业资格数据查询");
			List xc=hibernateTemplate.find("from Professionapply");
			return xc;
		}
//插入职业资格缴费表
		@Override
		public boolean insertProfes(Professionfinance bean) {
			System.out.println("这是将要插入职业资格缴费表的数据   sid："+bean.getSid()+"  sname:"+bean.getSname()+"  tid:"+bean.getTid()+"  needmoney:"+bean.getNeedmoney()+"  practicalmoney:"+bean.getPracticalmoney()+"  fdata:"+bean.getFdata()+"  fway:"+bean.getFway()+"  fstatu:"+bean.getFstatu());
			System.out.println("到了Dao层  职业资格缴费表插入数据");		
			hibernateTemplate.save(bean);//插入语句
			 return true;
		}

		

		

		

		


		
		
}
