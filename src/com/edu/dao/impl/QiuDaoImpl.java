package com.edu.dao.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.edu.bean.AccountantfinanceBean;
import com.edu.bean.AdultapplyBean;
import com.edu.bean.AdultfinanceBean;
import com.edu.bean.ArtfinanceBean;
import com.edu.bean.DistancefinanceBean;
import com.edu.bean.OrganizationBean;
import com.edu.bean.ProfessionfinanceBean;
import com.edu.bean.RoleBean;
import com.edu.bean.StatefinanceBean;
import com.edu.dao.QiuDao;
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
import com.edu.model.Stateapply;
import com.edu.model.Statefinance;
import com.edu.model.Stufile;
import com.edu.model.User;
import com.edu.model.Userjurisdiction;

public class QiuDaoImpl implements QiuDao{
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	String hql="";
	
	//查询用户管理表
	public List<User> showlist(int begin,int row) {
         try {
        	 
        	/* hibernateTemplate.execute(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					session.createSQLQuery("select * from ");
					// List<Object[]> 
					  
					return null;
				}
        		 
        	 });*/
			
        	 //此语句还可以这样写(没有用到关联关系)
        	 //from User u,Role r,Organization o where u.rid=r.id and u.organizationid=o.id
        	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
                 public Object doInHibernate(Session session)  
                          throws HibernateException, SQLException {  
                     List list2 = session.createQuery("from User u inner join u.role inner join u.organization")  
                             .setFirstResult((begin-1)*row)  
                             .setMaxResults(row)  
                             .list();  
                     
                     
                     
                     return list2;  
                 }});
        	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//模糊查询查询用户管理模块的数据
	public List<User> showlistbyname(int begin, int row, String name) {
		try {
        	 //此语句还可以这样写(没有用到关联关系)
        	 //from User u,Role r,Organization o where u.rid=r.id and u.organizationid=o.id
        	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
                 public Object doInHibernate(Session session)  
          
                          throws HibernateException, SQLException {  
                     Query query = session.createQuery("from User u,Role r,Organization o where u.rid=r.id and u.organizationid=o.id and u.name like ?")  
                             .setFirstResult((begin-1)*row)  
                             .setMaxResults(row);  
                      query.setString(0, "%"+name+"%");
                     List<User> list2=query.list();        
                     return list2;  
                 }});
        	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	//查用户管理模块的总数据条数
	public int listcount() {
		Long count = (Long)hibernateTemplate.find("select count(*) from User").listIterator().next();
        return count.intValue();
	}
	
	//查用户管理模块的总数据条数   有模糊查询
	public int listcount(String name) {
		Long count = (Long)hibernateTemplate.find("select count(*) from User u where u.name like  '%"+name+"%' ").listIterator().next();
        return count.intValue();
	}
	

	//添加账号密码到数据库
	public void adddata(User u) {
		hibernateTemplate.save(u);
	}

	//根据用户名查询用户信息
	public List<User> findUser(String uname) {
		List<User> list=hibernateTemplate.find("from User u where loginname=?",uname);
		return list;
	}

	//判断账号密码是否匹配(根据账号密码查用户信息)
	public List<User> selectUser(String uname, String pwd) {
		List<User> list=hibernateTemplate.find("from User u where loginname=? and password=?",uname,pwd);
		return list;
	}

	//查询角色管理模块的总数据条数
	public int listcount1() {
		Long count = (Long)hibernateTemplate.find("select count(*) from Role").listIterator().next();
        return count.intValue();
	}

	//查询角色管理模块的总数据(带分页)
	public List<Role> showlist1(int begin, int row) {
		 try {
	         List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	               public Object doInHibernate(Session session)  
	                         throws HibernateException, SQLException {  
	                    List list2 = session.createQuery("from Role")  
	                             .setFirstResult((begin-1)*row)  
	                             .setMaxResults(row)  
	                             .list();                     
	                     return list2;  
	                 }});  
	             return list;  
	        	 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}

	//添加角色管理信息到数据库
	public void addrole(Role role) {
		hibernateTemplate.save(role);
	
	}

	//添加用户管理信息到数据库
	public void adduser(User user) {
		hibernateTemplate.save(user);
	}

	@Override
	public void adddep(Organization o) {
		hibernateTemplate.save(o);
	}

	//删除角色管理信息
	public void delrole(int id) {
		Role role=hibernateTemplate.get(Role.class, id);
		hibernateTemplate.delete(role);
	}

	//删除部门管理信息
	public void delorg(int id) {
		Organization o=hibernateTemplate.get(Organization.class, id);
		hibernateTemplate.delete(o);
	}

	//重置用户登录密码
	public void resertpwd(int id) {
		
		User u=hibernateTemplate.get(User.class, id);
		String newpwd="123456";
		   try {  
	            // 得到一个信息摘要器  
	            MessageDigest digest = MessageDigest.getInstance("md5");  
	            byte[] result = digest.digest(newpwd.getBytes());  
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
	            
	        }
		
		u.setPassword(newpwd);
		
		//System.out.println("id="+u.getId()+"name="+u.getLoginname()+"pwd="+u.getPassword());
		hibernateTemplate.update(u);
	
	}

	//根据id查询角色管理表的信息
	public Role selrole(int id) {
		Role role=hibernateTemplate.get(Role.class, id);
		return role;
	}

	
	//根据id查部门管理表的信息
	public Organization selorg(int id) {
		Organization o=hibernateTemplate.get(Organization.class, id);
		return o;
	}
	
	
	//根据id查询用户管理表的信息
	public User seluser(int id) {
		 /*try {
        	
	        //此语句还可以这样写(没有用到关联关系)
	        //from User u,Role r,Organization o where u.rid=r.id and u.organizationid=o.id
	        List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	               public Object doInHibernate(Session session)  
	                        throws HibernateException, SQLException {  
	          List list2 = session.createQuery("from User u inner join u.role inner join u.organization where u.id="+id).list();       
	                     return list2;  
	                 }});
	        	return list;
	        	  
			} catch (Exception e) {
				e.printStackTrace();
			}
			return  null;*/
		User u=hibernateTemplate.get(User.class, id);
		
		return u;
	}

	//保存编辑role表数据到数据库
	public void saverole(Role r) {
		Role ro=hibernateTemplate.get(Role.class, r.getId());
		ro.setId(r.getId());
		ro.setName(r.getName());
		ro.setSeq(r.getSeq());
		ro.setStatus(r.getStatus());
		ro.setDescription(r.getDescription());
		
		hibernateTemplate.update(ro);
	}

	//保存user表编辑到数据库
	public void savauser(User u) {
		User user=hibernateTemplate.get(User.class, u.getId());
		user.setId(u.getId());
		user.setLoginname(u.getLoginname());
		user.setName(u.getName());
		user.setPassword(u.getPassword());
		user.setSex(u.getSex());
		user.setAge(u.getAge());
		user.setPhone(u.getPhone());
		user.setUsertype(u.getUsertype());
		user.setStatus(u.getStatus());
		user.setOrganizationid(u.getOrganizationid());
		user.setCreatetime(u.getCreatetime());
		user.setRid(u.getRid());
		hibernateTemplate.update(user);
	}

	//保存organization表的编辑到数据库
	public void savedep(Organization o) {
		Organization og=hibernateTemplate.get(Organization.class, o.getId());
		og.setId(o.getId());
		og.setName(o.getName());
		og.setAddress(o.getAddress());
		og.setCode(o.getCode());
		og.setIcon(o.getIcon());
		og.setSeq(o.getSeq());
		og.setCreatetime(o.getCreatetime());
		
		hibernateTemplate.update(og);
	}

	//查询部门表 查所有部门
	public List<OrganizationBean> selorg() {
		 try {
	         List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	               public Object doInHibernate(Session session)  
	                         throws HibernateException, SQLException {  
	            	  
	                    List list2 = session.createQuery("from Organization")  
	                             .list(); 
	                    List<OrganizationBean> lists = new ArrayList<>();
	                    for(int i=0;i<list2.size();i++) {
	                    	Organization org = (Organization)list2.get(i);
	                    	
	                    	OrganizationBean ob = new OrganizationBean();
	                    	ob.setName(org.getName());
	                    	ob.setId(org.getId());
	                    	ob.setSeq(org.getSeq());
	                    	lists.add(ob);
	                    }
	                     return lists;  
	                 }});  
	             return list;  
	        	 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}

	//查询角色表 取出所有角色
	public List<RoleBean> selrole() {
		try {
	         List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	               public Object doInHibernate(Session session)  
	                         throws HibernateException, SQLException {  
	                    List list2 = session.createQuery("from Role")   
	                             .list();  
	                    
	                    List<RoleBean>lists=new ArrayList<>();
	                    
	                    for(int i=0;i<list2.size();i++) {
	                    	Role r=(Role)list2.get(i);
	                    	RoleBean rb=new RoleBean();
	                    	rb.setId(r.getId());
	                    	rb.setName(r.getName());
	                    	rb.setSeq(r.getSeq());
	                    	lists.add(rb);
	                    }
	                    
	                     return lists;  
	                 }});  
	             return list;  
	        	 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}

	//查询成人高考报名表信息
	public List<Adultapply> seladu(int begin,int row,String stuid,String stuname,String teachername) {
		
		//System.out.println("stuid="+stuid);
		//System.out.println("stuname="+stuname);
		//System.out.println("teachername="+teachername);
		 try {
			  	hql="from Adultapply a inner join a.user u inner join a.academy inner join a.specialty inner join a.city inner join a.county where 1=1 ";
			 
			 if(!stuid.equals("")) {//如果stuid不为空  模糊查询
				 hql+=" and a.astudentno='"+stuid+"'";
				// System.out.println("进了stuid");
			 }
			 if(!stuname.equals("")) {
				 hql+=" and a.aname like '%"+stuname+"%'";
				// System.out.println("进了stuname");
			 }
			 if(!teachername.equals("")) {
				 hql+=" and u.name like '%"+teachername+"%'";
				// System.out.println("进了teac");
			 }
			 
		
        	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
                 public Object doInHibernate(Session session)  
                          throws HibernateException, SQLException {  
                     List list2 = session.createQuery(hql)  
                             .setFirstResult((begin-1)*row)  
                             .setMaxResults(row)  
                             .list();  

                     return list2;  
                 }});
        	 
	             return list;  
	        	 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}

	//查询user表所有数据(查询所有老师)
	public List<User> seluser() {
		try {
        	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
                 public Object doInHibernate(Session session)  
                          throws HibernateException, SQLException {  
                     List list2 = session.createQuery("from User u  ")  
                           .list();  
                     return list2;  
                 }});
        	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//查询所有学校
	public List<Academy> selacademy() {
		try {
       	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
                public Object doInHibernate(Session session)  
                         throws HibernateException, SQLException {  
                    List list2 = session.createQuery("from Academy  ")  
                          .list();  
                    return list2;  
                }});
       	 
            return list;  
       	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//查询根据学校id查改学校的所有专业
	public List<Acaspe> selacaspe(int id) {
		try {
	       	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	                public Object doInHibernate(Session session)  
	                         throws HibernateException, SQLException {  
	                    List list2 = session.createQuery("from Acaspe a inner join a.academy inner join a.specialty where a.acid="+id)  
	                          .list();  
	                    return list2;  
	                }});
	       	 
	            return list;  
	       	 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}

	//查城市表的所有城市
	public List<City> selcity() {
		try {
	       	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	                public Object doInHibernate(Session session)  
	                         throws HibernateException, SQLException {  
	                    List list2 = session.createQuery("from City")  
	                          .list();  
	                    return list2;  
	                }});
	       	 
	            return list;  
	       	 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}

	//根据城市id查询县区
	public List<County> selcounty(int id) {
		try {
	       	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	                public Object doInHibernate(Session session)  
	                         throws HibernateException, SQLException {  
	                    List list2 = session.createQuery("from County c where c.cid="+id)  
	                          .list();  
	                    return list2;  
	                }});
	       	 
	            return list;  
	       	 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}

	//保存成人高考报名表到数据库
	public void saveadult(Adultapply adultapplybean) {
		hibernateTemplate.save(adultapplybean);
	}

	//编辑成人高考报名表前的查询
	public List<Adultapply> seladult(int id) {
		 try {
        	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
                 public Object doInHibernate(Session session)  
                          throws HibernateException, SQLException {  
                     List list2 = session.createQuery("from Adultapply a inner join a.user inner join a.academy inner join a.specialty inner join a.city inner join a.county where a.aid="+id)   
                             .list();  

                     return list2;  
                 }});
        	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//删除成人高考报名表的学生信息
	public void deladult(int id) {
		Adultapply a=hibernateTemplate.get(Adultapply.class, id);
		hibernateTemplate.delete(a);
	}

	//保存编辑后的成人高考表信息到数据库
	public void saveeditadult(Adultapply adultapplybean) {
		Adultapply adult=hibernateTemplate.get(Adultapply.class, adultapplybean.getAid());
		adult.setAid(adultapplybean.getAid());
		adult.setAstudentno(adultapplybean.getAstudentno());
		adult.setAname(adultapplybean.getAname());
		adult.setUserid(adultapplybean.getUserid());
		adult.setIdnumber(adultapplybean.getIdnumber());
		adult.setAphone(adultapplybean.getAphone());
		adult.setAtype(adultapplybean.getAtype());
		adult.setAcaid(adultapplybean.getAcaid());
		adult.setSpecid(adultapplybean.getSpecid());
		adult.setAsystem(adultapplybean.getAsystem());
		adult.setCityid(adultapplybean.getCityid());
		adult.setAdata(adultapplybean.getAdata());
		adult.setCountyid(adultapplybean.getCountyid());
		hibernateTemplate.update(adult);
	}

	//查询国家开放报名表信息
	public List<Stateapply> selstate(int begin, int row, String stuid, String stuname, String teachername) {
		try {
		  	hql="from Stateapply s inner join s.user u inner join s.academy inner join s.specialty inner join s.city inner join s.county where 1=1 ";
		 
		 if(!stuid.equals("")) {//如果stuid不为空  模糊查询
			 hql+=" and s.sstudentno='"+stuid+"'";
			// System.out.println("进了stuid");
		 }
		 if(!stuname.equals("")) {
			 hql+=" and s.sname like '%"+stuname+"%'";
			// System.out.println("进了stuname");
		 }
		 if(!teachername.equals("")) {
			 hql+=" and u.name like '%"+teachername+"%'";
			// System.out.println("进了teac");
		 }
		 
	
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .setFirstResult((begin-1)*row)  
                         .setMaxResults(row)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

	//添加了国家开放报名信息后 保存到数据库
	public void savestate(Stateapply s) {
		hibernateTemplate.save(s);
	}

	//编辑前查询国家开放大学报名表(根据学生id查)
	public List<Stateapply> selstate(int id) {
		try {
       	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
                public Object doInHibernate(Session session)  
                         throws HibernateException, SQLException {  
                    List list2 = session.createQuery("from Stateapply s inner join s.user inner join s.academy inner join s.specialty inner join s.city inner join s.county where s.sid="+id)   
                            .list();  

                    return list2;  
                }});
       	 
            return list;  
       	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//保存编辑后的国家开放报名表信息到数据库
	public void saveeditstate(Stateapply a) {
		Stateapply sta=hibernateTemplate.get(Stateapply.class, a.getSid());
		
		sta.setSid(a.getSid());
		sta.setSstudentno(a.getSstudentno());
		sta.setSname(a.getSname());
		sta.setUserid(a.getUserid());
		sta.setIdnumber(a.getIdnumber());
		sta.setSphone(a.getSphone());
		sta.setStype(a.getStype());
		sta.setAcaid(a.getAcaid());
		sta.setSpecid(a.getSpecid());
		sta.setSsystem(a.getSsystem());
		sta.setCityid(a.getCityid());
		sta.setSdata(a.getSdata());
		sta.setCountyid(a.getCountyid());
	
		hibernateTemplate.update(sta);
	}

	//根据学生id删除国家开放报名表信息
	public void delstate(int id) {
		Stateapply s=hibernateTemplate.get(Stateapply.class, id);
		hibernateTemplate.delete(s);
	}

	//查询远程报名表
	public List<Distanceapply> seldis(int begin, int row, String stuid, String stuname, String teachername) {
		try {
		  	hql="from Distanceapply d inner join d.user u inner join d.academy inner join d.specialty inner join d.city inner join d.county where 1=1 ";
		 
		 if(!stuid.equals("")) {//如果stuid不为空  模糊查询
			 hql+=" and d.dstudentno='"+stuid+"'";
			// System.out.println("进了stuid");
		 }
		 if(!stuname.equals("")) {
			 hql+=" and d.dname like '%"+stuname+"%'";
			// System.out.println("进了stuname");
		 }
		 if(!teachername.equals("")) {
			 hql+=" and u.name like '%"+teachername+"%'";
			// System.out.println("进了teac");
		 }
		 
	
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .setFirstResult((begin-1)*row)  
                         .setMaxResults(row)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

	//添加远程教育表信息到数据库
	public void savedistance(Distanceapply d) {
		hibernateTemplate.save(d);
	}

	//编辑前根据学生id 查询远程教育报名表
	public List<Distanceapply> seldis(int id) {
		try {
	       	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	                public Object doInHibernate(Session session)  
	                         throws HibernateException, SQLException {  
	                    List list2 = session.createQuery("from Distanceapply d inner join d.user inner join d.academy inner join d.specialty inner join d.city inner join d.county where d.did="+id)   
	                            .list();  

	                    return list2;  
	                }});
	       	 
	            return list;  
	       	 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}

	//保存编辑后的远程教育表到数据库
	public void saveeditdis(Distanceapply d) {
		Distanceapply dis=hibernateTemplate.get(Distanceapply.class, d.getDid());
		
		dis.setDid(d.getDid());
		dis.setDstudentno(d.getDstudentno());
		dis.setDname(d.getDname());
		dis.setUserid(d.getUserid());
		dis.setIdnumber(d.getIdnumber());
		dis.setDphone(d.getDphone());
		dis.setDtype(d.getDtype());
		dis.setAcaid(d.getAcaid());
		dis.setSpecid(d.getSpecid());
		dis.setDsystem(d.getDsystem());
		dis.setCityid(d.getCityid());
		dis.setDdata(d.getDdata());
		dis.setCountyid(d.getCountyid());
	
		hibernateTemplate.update(dis);
	}

	//删除远程表信息 根据id
	public void deldis(int id) {
		Distanceapply d=hibernateTemplate.get(Distanceapply.class, id);
		hibernateTemplate.delete(d);
	}

	//保存成人高考缴费表信息到数据库
	public void addadultfinance(Adultfinance a) {
		hibernateTemplate.save(a);
	}

	//添加国家开放缴费表信息到数据库
	public void addstatefinance(Statefinance s) {
		hibernateTemplate.save(s);
	}

	//添加远程教育缴费表到数据库
	public void adddisfinance(Distancefinance d) {
		hibernateTemplate.save(d);
	}

	//查询成考缴费表信息
	public List<Adultfinance> seladultfinance(int begin, int row, String stuid, String stuname, String teachername,
			String status, String types) {
		try {
		  	hql="from Adultfinance a inner join a.user u inner join a.academy inner join a.specialty  where 1=1 ";
		 
		 if(!stuid.equals("")) {//如果stuid不为空  模糊查询
			 hql+=" and a.sid='"+stuid+"'";
			// System.out.println("进了stuid");
		 }
		 if(!stuname.equals("")) {
			 hql+=" and a.sname like '%"+stuname+"%'";
			// System.out.println("进了stuname");
		 }
		 if(!teachername.equals("")) {
			 hql+=" and u.name like '%"+teachername+"%'";
			// System.out.println("进了teac");
		 }
		 if(!status.equals("")) {
			 hql+=" and a.fstatu like '%"+status+"%'";
		 }
		 if(!types.equals("")) {
			 hql+=" and a.fway like  '%"+types+"%'";
		 }
		 
	
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .setFirstResult((begin-1)*row)  
                         .setMaxResults(row)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

	//删除成人高考缴费表信息
	public void deladultfinance(int id) {
		Adultfinance a=hibernateTemplate.get(Adultfinance.class, id);
		hibernateTemplate.delete(a);
	}

	//查询国家开放缴费表信息
	public List<Statefinance> selstatefinance(int begin, int row, String stuid, String stuname, String teachername,
			String status, String types) {
		try {
		  	hql="from Statefinance s inner join s.user u inner join s.academy inner join s.specialty  where 1=1 ";
		 
		 if(!stuid.equals("")) {//如果stuid不为空  模糊查询
			 hql+=" and s.sid='"+stuid+"'";
			// System.out.println("进了stuid");
		 }
		 if(!stuname.equals("")) {
			 hql+=" and s.sname like '%"+stuname+"%'";
			// System.out.println("进了stuname");
		 }
		 if(!teachername.equals("")) {
			 hql+=" and u.name like '%"+teachername+"%'";
			// System.out.println("进了teac");
		 }
		 if(!status.equals("")) {
			 hql+=" and s.fstatu like '%"+status+"%'";
		 }
		 if(!types.equals("")) {
			 hql+=" and s.fway like  '%"+types+"%'";
		 }
		 
	
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .setFirstResult((begin-1)*row)  
                         .setMaxResults(row)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

	//删除国家开放缴费表信息
	public void delstatefinance(int id) {
		Statefinance s=hibernateTemplate.get(Statefinance.class, id);
		hibernateTemplate.delete(s);
	}

	//查询远程教育缴费表信息
	public List<Distancefinance> seldisfinance(int begin, int row, String stuid, String stuname, String teachername,
			String status, String types) {
		try {
		  	hql="from Distancefinance d inner join d.user u inner join d.academy inner join d.specialty  where 1=1 ";
		 
		 if(!stuid.equals("")) {//如果stuid不为空  模糊查询
			 hql+=" and d.sid='"+stuid+"'";
			// System.out.println("进了stuid");
		 }
		 if(!stuname.equals("")) {
			 hql+=" and d.sname like '%"+stuname+"%'";
			// System.out.println("进了stuname");
		 }
		 if(!teachername.equals("")) {
			 hql+=" and u.name like '%"+teachername+"%'";
			// System.out.println("进了teac");
		 }
		 if(!status.equals("")) {
			 hql+=" and d.fstatu like '%"+status+"%'";
		 }
		 if(!types.equals("")) {
			 hql+=" and d.fway like  '%"+types+"%'";
		 }
		 
	
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .setFirstResult((begin-1)*row)  
                         .setMaxResults(row)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

	//删除远程教育缴费表信息
	public void deldisfinance(int id) {
		Distancefinance d=hibernateTemplate.get(Distancefinance.class, id);
		hibernateTemplate.delete(d);
	}

	//查询会计缴费表信息
	public List<Accountantfinance> selaccfinance(int begin, int row, String stuid, String stuname, String teachername,
			String status, String types) {
		try {
		  	hql="from Accountantfinance a inner join a.user u  where 1=1 ";
		 
		 if(!stuid.equals("")) {//如果stuid不为空  模糊查询
			 hql+=" and a.sid='"+stuid+"'";
			// System.out.println("进了stuid");
		 }
		 if(!stuname.equals("")) {
			 hql+=" and a.sname like '%"+stuname+"%'";
			// System.out.println("进了stuname");
		 }
		 if(!teachername.equals("")) {
			 hql+=" and u.name like '%"+teachername+"%'";
			// System.out.println("进了teac");
		 }
		 if(!status.equals("")) {
			 hql+=" and a.fstatu like '%"+status+"%'";
		 }
		 if(!types.equals("")) {
			 hql+=" and a.fway like  '%"+types+"%'";
		 }
		 
	
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .setFirstResult((begin-1)*row)  
                         .setMaxResults(row)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//删除会计缴费表
	public void delaccfinance(int id) {
		Accountantfinance a=hibernateTemplate.get(Accountantfinance.class, id);
		hibernateTemplate.delete(a);
	}

	//查询职考缴费表信息
	public List<Professionfinance> selprofinance(int begin, int row, String stuid, String stuname, String teachername,
			String status, String types) {
		try {
		  	hql="from Professionfinance p inner join p.user u  where 1=1 ";
		 
		 if(!stuid.equals("")) {//如果stuid不为空  模糊查询
			 hql+=" and p.sid='"+stuid+"'";
			// System.out.println("进了stuid");
		 }
		 if(!stuname.equals("")) {
			 hql+=" and p.sname like '%"+stuname+"%'";
			// System.out.println("进了stuname");
		 }
		 if(!teachername.equals("")) {
			 hql+=" and u.name like '%"+teachername+"%'";
			// System.out.println("进了teac");
		 }
		 if(!status.equals("")) {
			 hql+=" and p.fstatu like '%"+status+"%'";
		 }
		 if(!types.equals("")) {
			 hql+=" and p.fway like  '%"+types+"%'";
		 }
		 
	
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .setFirstResult((begin-1)*row)  
                         .setMaxResults(row)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//删除职考缴费表信息
	public void delprofinance(int id) {
		Professionfinance p=hibernateTemplate.get(Professionfinance.class, id);
		hibernateTemplate.delete(p);
	}

	//查询艺考缴费表信息
	public List<Artfinance> selartfinance(int begin, int row, String stuid, String stuname, String teachername,
			String status, String types) {
		try {
		  	hql="from Artfinance a inner join a.user u  where 1=1 ";
		 
		 if(!stuid.equals("")) {//如果stuid不为空  模糊查询
			 hql+=" and a.sid='"+stuid+"'";
			// System.out.println("进了stuid");
		 }
		 if(!stuname.equals("")) {
			 hql+=" and a.sname like '%"+stuname+"%'";
			// System.out.println("进了stuname");
		 }
		 if(!teachername.equals("")) {
			 hql+=" and u.name like '%"+teachername+"%'";
			// System.out.println("进了teac");
		 }
		 if(!status.equals("")) {
			 hql+=" and a.fstatu like '%"+status+"%'";
		 }
		 if(!types.equals("")) {
			 hql+=" and a.fway like  '%"+types+"%'";
		 }
		 
	
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .setFirstResult((begin-1)*row)  
                         .setMaxResults(row)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//删除艺考缴费表信息
	public void delartfinance(int id) {
		Artfinance a=hibernateTemplate.get(Artfinance.class, id);
		hibernateTemplate.delete(a);
	}

	//超级管理员查询工作助手信息
	public List<Schedule> selschedule(int begin, int row, String userid, String stitle, String sdate,
			String finishdate, String status) {
		try {
		  	hql="from Schedule s inner join s.user u  where 1=1 ";
		 
		 if(!userid.equals("")) {
			 hql+=" and u.id='"+userid+"'";
			
		 }
		 if(!stitle.equals("")) {
			 hql+=" and s.stitle like '%"+stitle+"%'";
			
		 }
		 if(!sdate.equals("")) {
			 hql+=" and s.sdate like '%"+sdate+"%'";
			
		 }
		 if(!finishdate.equals("")) {
			 hql+=" and s.sfinishdate like '%"+finishdate+"%'";
			
		 }
		 if(!status.equals("")) {
			 hql+=" and s.sflag like  '%"+status+"%'";
			
		 }
		 
	
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .setFirstResult((begin-1)*row)  
                         .setMaxResults(row)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//保存工作助手信息到数据库
	public void addschedule(Schedule s) {
		hibernateTemplate.save(s);
	}

	//编辑工作助手前先查询
	public List<Schedule> selschedule(int id) {
		try {
	       	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	                public Object doInHibernate(Session session)  
	                         throws HibernateException, SQLException {  
	                    List list2 = session.createQuery("from Schedule s inner join s.user u where s.sid="+id)   
	                            .list();  

	                    return list2;  
	                }});
	       	 
	            return list;  
	       	 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}

	//保存编辑后的工作助手信息到数据库
	public void saveschedule(Schedule s) {
		Schedule sc=hibernateTemplate.get(Schedule.class, s.getSid());
		
		sc.setSid(s.getSid());
		sc.setUserid(s.getUserid());
		sc.setStitle(s.getStitle());
		sc.setScontent(s.getScontent());
		sc.setSdate(s.getSdate());
		
		if(s.getSflag()==1) {//已完成
			sc.setSfinishdate(new Date().toLocaleString());
		}
		sc.setSflag(s.getSflag());
		hibernateTemplate.update(sc);
	}

	//删除工作助手信息
	public void delschedule(int id) {
		Schedule s=hibernateTemplate.get(Schedule.class, id);

		hibernateTemplate.delete(s);
	}

	//根据用户id查询未完成的工作日志
	public List<Schedule> selschedulebyuid(int id) {
		try {
	       	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	                public Object doInHibernate(Session session)  
	                         throws HibernateException, SQLException {  
	                    List list2 = session.createQuery("from Schedule s where s.sflag=0 and s.userid="+id)   
	                            .list();  

	                    return list2;  
	                }});
	       	 
	            return list;  
	       	 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}

	//根据用户id和树id查询该用户是否有权限访问该树
	public List<Userjurisdiction> hasjur(int rid, int jid) {
		try {
	       	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	                public Object doInHibernate(Session session)  
	                         throws HibernateException, SQLException {  
	                    List list2 = session.createQuery("from Userjurisdiction u where u.rid="+rid+" and u.jid="+jid)   
	                            .list();  

	                    return list2;  
	                }});
	       	 
	            return list;  
	       	 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}

	//根据用户rid查询该用户有的所有权限
	public List<Userjurisdiction> findjurbyrid(int rid) {
		try {
	       	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	                public Object doInHibernate(Session session)  
	                         throws HibernateException, SQLException {  
	                    List list2 = session.createQuery("from Userjurisdiction u where u.rid="+rid )   
	                            .list();  

	                    return list2;  
	                }});
	       	 
	            return list;  
	       	 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}

	//根据userjurisdiction表的 id把权限全部清空
	public void deljurbyid(int id) {
		Userjurisdiction u=hibernateTemplate.get(Userjurisdiction.class, id);
		u.setFlag(1);
		hibernateTemplate.update(u);
	}

	//根据userjurisdiction表的id赋权限给角色
	public void addjurbyid(int id) {
		Userjurisdiction u=hibernateTemplate.get(Userjurisdiction.class, id);
		u.setFlag(0);
		hibernateTemplate.update(u);
	}

	//查询刚刚插入role表的id
	public int selroleid() {
		Integer count = (Integer) hibernateTemplate.find("select max(r.id) from Role r").listIterator().next();
		return count.intValue();
	}

	//根据rid查询角色的描述
	public String selrolejur(int id) {
		String jur =  (String) hibernateTemplate.find("select r.description from Role r where r.id="+id).listIterator().next();
		return jur;
	}

	//给新添加的角色插入数据
	public void addjur(Userjurisdiction u) {
		hibernateTemplate.save(u);
	}

	//查询所有部门
	public List<Organization> selorgs() {
		try {
	       	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	                public Object doInHibernate(Session session)  
	                         throws HibernateException, SQLException {  
	                    List list2 = session.createQuery("from Organization")   
	                            .list();  

	                    return list2;  
	                }});
	       	 
	            return list;  
	       	 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}

	//查询所有角色
	public List<Role> selroles() {
		try {
	       	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	                public Object doInHibernate(Session session)  
	                         throws HibernateException, SQLException {  
	                    List list2 = session.createQuery("from Role")   
	                            .list();  

	                    return list2;  
	                }});
	       	 
	            return list;  
	       	 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}

	//根据rid查询角色名
	public String selrolename(int id) {
		String name =  (String) hibernateTemplate.find("select r.name from Role r where r.id="+id).listIterator().next();
		return name;
	}

	//普通员工查询自己的工作助手
	public List<Schedule> selsche(int begin, int row, String userid, String stitle, String sdate, String finishdate,
			String status) {
		try {
		  	hql="from Schedule s inner join s.user u  where 1=1 ";
		 
		 if(!userid.equals("")) {
			 hql+=" and u.id='"+userid+"'";
			
		 }
		 if(!stitle.equals("")) {
			 hql+=" and s.stitle like '%"+stitle+"%'";
			
		 }
		 if(!sdate.equals("")) {
			 hql+=" and s.sdate like '%"+sdate+"%'";
			
		 }
		 if(!finishdate.equals("")) {
			 hql+=" and s.sfinishdate like '%"+finishdate+"%'";
			
		 }
		 if(!status.equals("")) {
			 hql+=" and s.sflag like  '%"+status+"%'";
			
		 }
		 
	
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .setFirstResult((begin-1)*row)  
                         .setMaxResults(row)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//查询学生文件上传表的信息
	public List<Stufile> selstufile(int begin, int row, String id, String name) {
		try {
		  	hql="from Stufile s where 1=1 ";
		 
		 if(!id.equals("")) {
			 hql+=" and s.stuid='"+id+"'";
			
		 }
		 if(!name.equals("")) {
			 hql+=" and s.stuname like '%"+name+"%'";
			
		 }
		
		 
	
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .setFirstResult((begin-1)*row)  
                         .setMaxResults(row)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//查询成人高考表信息 无模糊查询
	public List<Adultapply> seladultstu(int begin, int row) {
		 try {
		hql="from Adultapply a inner join a.user u inner join a.academy inner join a.specialty inner join a.city inner join a.county where 1=1 ";
     	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
              public Object doInHibernate(Session session)  
                       throws HibernateException, SQLException {  
                  List list2 = session.createQuery(hql)  
                          .setFirstResult((begin-1)*row)  
                          .setMaxResults(row)  
                          .list();  

                  return list2;  
              }});
     	 
	             return list;  
	        	 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}

	//根据成人高考报名表学生id查询学生名字
	public String seladultname(int id) {
		String name =  (String) hibernateTemplate.find("select a.aname from Adultapply a where a.astudentno="+id).listIterator().next();
		return name;
	}

	//保存学生文件上传信息到数据库
	public void savefile(Stufile s) {
		hibernateTemplate.save(s);
	}

	//根据学生id查询该同学是否上传过文件
	public List<Stufile> isupload(int id) {
		 try {
				hql="from Stufile s where s.stuid="+id;
		     	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
		              public Object doInHibernate(Session session)  
		                       throws HibernateException, SQLException {  
		                  List list2 = session.createQuery(hql)  
		                      
		                          .list();  

		                  return list2;  
		              }});
		     	 
			             return list;  
			        	 
					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
	}

	//根据主键id删除文件上传表信息
	public void delfile(int id) {
		Stufile s=hibernateTemplate.get(Stufile.class, id);
		hibernateTemplate.delete(s);
	}

	//根据stufile表主键id查询信息
	public List<Stufile> selfilebyid(int id) {
		 try {
			hql="from Stufile s where s.sfid="+id;
	     	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	              public Object doInHibernate(Session session)  
	                       throws HibernateException, SQLException {  
	                  List list2 = session.createQuery(hql)  
	                      
	                          .list();  

	                  return list2;  
	              }});
	     	 
		             return list;  
		        	 
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
	}

	//查询成考缴费表id 根据成考表学生id查
	public List<Adultfinance> seladuid(int id) {
		try {
			hql="from Adultfinance a where a.sid="+id;
	     	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	              public Object doInHibernate(Session session)  
	                       throws HibernateException, SQLException {  
	                  List list2 = session.createQuery(hql)  
	                      
	                          .list();  

	                  return list2;  
	              }});
	     	 
		             return list;  
		        	 
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
	}

	//修改成考缴费表姓名
	public void updateadultname(int id, String name) {
		Adultfinance a=hibernateTemplate.get(Adultfinance.class, id);
		a.setSname(name);
		hibernateTemplate.update(a);
	}

	//根据成考表学生id查询成考文件上传表的主键id
	public List<Stufile> selstuid(int id) {
		try {
			hql="from Stufile s where s.stuid="+id;
	     	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	              public Object doInHibernate(Session session)  
	                       throws HibernateException, SQLException {  
	                  List list2 = session.createQuery(hql)  
	                      
	                          .list();  

	                  return list2;  
	              }});
	     	 
		             return list;  
		        	 
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
		
	}

	//修改成考文件上传表的姓名
	public void updatestuname(int id, String name) {
		Stufile s=hibernateTemplate.get(Stufile.class, id);
		s.setStuname(name);
		hibernateTemplate.update(s);
	}

	//修改编辑后的文件上传到数据库
	public void updatestufile(Stufile s) {
		Stufile ss=hibernateTemplate.get(Stufile.class, s.getSfid());
		ss.setSfid(s.getSfid());
		ss.setStuid(s.getStuid());
		ss.setStuname(s.getStuname());
		ss.setSfphoto(s.getSfphoto());
		ss.setSfvoucher(s.getSfvoucher());
		ss.setSfpaper(s.getSfpaper());
		ss.setSfdate(s.getSfdate());
		hibernateTemplate.update(ss);
	}

	//根据学生学生和学生姓名查询是否有该学生
	public List<Adultapply> hasstu(int id, String name) {
		try {
			hql="from Adultapply a inner join a.user u inner join a.academy inner join a.specialty inner join a.city inner join a.county where a.astudentno="+id+"and a.aname='"+name+"'";
	     	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	              public Object doInHibernate(Session session)  
	                       throws HibernateException, SQLException {  
	                  List list2 = session.createQuery(hql)  
	                      
	                          .list();  

	                  return list2;  
	              }});
	     	 
		             return list;  
		        	 
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
	}

	//后台修改用户密码
	public void updatepwd(int id, String pwd) {
		User u=hibernateTemplate.get(User.class, id);
		u.setPassword(pwd);
		hibernateTemplate.update(u);
	}

	//根据用户id查用户密码
	public String seluserpwd(int id) {
		String pwd =  (String) hibernateTemplate.find("select u.password from User u where u.id="+id).listIterator().next();
		return pwd;
	}

	//根据成人高考报名表id查询成人高考报名表信息
	public List<Adultfinance> seladultfinancebyfid(int id) {
		try {
		  	hql="from Adultfinance a inner join a.user u inner join a.academy inner join a.specialty  where a.fid="+id;
		 
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//保存成人高考缴费表到数据库
	public void editadultfinance(AdultfinanceBean a) {
		Adultfinance af=hibernateTemplate.get(Adultfinance.class, a.getFid());
		//实交金额=上次的已交金额+本次实交金额
		af.setPracticalmoney(a.getFtest1()+a.getPracticalmoney());
		af.setFdata(new Date().toLocaleString());
		//int i=a.getFway().indexOf(",");
		
		af.setFway(a.getFway());
		
		if(af.getPracticalmoney()>=af.getNeedmoney()) {//已交清
			af.setFstatu(2);
		}
		if(af.getPracticalmoney()<af.getNeedmoney()&&af.getPracticalmoney()!=0) {
			af.setFstatu(1);
		}
		hibernateTemplate.update(af);
	}


	//根据会计缴费表的id查询会计缴费表的信息
	public List<Accountantfinance> selaccbyfid(int id){
		try {
		hql="from Accountantfinance a inner join a.user u  where a.fid="+id;
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)    
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//保存会计缴费表信息到数据库
	public void editaccfinance(AccountantfinanceBean a) {
		Accountantfinance ac=hibernateTemplate.get(Accountantfinance.class, a.getFid());
		//实交金额=上次的已交金额+本次实交金额
		ac.setPracticalmoney(a.getFtest1()+a.getPracticalmoney());
		ac.setFdata(new Date().toLocaleString());
		//int i=a.getFway().indexOf(",");
		ac.setFway(a.getFway());
		if(ac.getPracticalmoney()>=ac.getNeedmoney()) {//已交清
			ac.setFstatu(2);
		}
		if(ac.getPracticalmoney()<ac.getNeedmoney()&&ac.getPracticalmoney()!=0) {
			ac.setFstatu(1);
		}
		hibernateTemplate.update(ac);
	}

	//编辑前查询艺考缴费表信息 根据艺考缴费表id查
	public List<Artfinance> selartfinancebyfid(int id) {
		try {
		  	hql="from Artfinance a inner join a.user u  where a.fid="+id;
		 
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)   
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//保存艺考缴费表信息到数据库
	public void editartfinance(ArtfinanceBean a) {
		Artfinance ac=hibernateTemplate.get(Artfinance.class, a.getFid());
		//实交金额=上次的已交金额+本次实交金额
		ac.setPracticalmoney(a.getFtest1()+a.getPracticalmoney());
		ac.setFdata(new Date().toLocaleString());
		//int i=a.getFway().indexOf(",");
		ac.setFway(a.getFway());
		if(ac.getPracticalmoney()>=ac.getNeedmoney()) {//已交清
			ac.setFstatu(2);
		}
		if(ac.getPracticalmoney()<ac.getNeedmoney()&&ac.getPracticalmoney()!=0) {
			ac.setFstatu(1);
		}
		hibernateTemplate.update(ac);
	}

	//编辑前查询职考缴费表信息 根据职考缴费表主键查
	public List<Professionfinance> selprofinancebyfid(int id) {
		try {
		 hql="from Professionfinance p inner join p.user u  where p.fid="+id;
		 
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)   
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//保存编辑的职考缴费表信息到数据库
	public void editprofinance(ProfessionfinanceBean p) {
		Professionfinance pf=hibernateTemplate.get(Professionfinance.class, p.getFid());
		//实交金额=上次的已交金额+本次实交金额
		pf.setPracticalmoney(p.getFtest1()+p.getPracticalmoney());
		pf.setFdata(new Date().toLocaleString());
		//int i=p.getFway().indexOf(",");
		pf.setFway(p.getFway());
		if(pf.getPracticalmoney()>=pf.getNeedmoney()) {//已交清
			pf.setFstatu(2);
		}
		if(pf.getPracticalmoney()<pf.getNeedmoney()&&pf.getPracticalmoney()!=0) {
			pf.setFstatu(1);
		}
		hibernateTemplate.update(pf);
	}

	//编辑前查询国家开放缴费表信息
	public List<Statefinance> selstatefinancebyfid(int id) {
		try {
		 hql="from Statefinance s inner join s.user u inner join s.academy inner join s.specialty  where s.fid="+id;
		 
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

	//保存编辑国家开放缴费表信息到数据库
	public void editstatefinance(StatefinanceBean s) {
		Statefinance sf=hibernateTemplate.get(Statefinance.class, s.getFid());
		//实交金额=上次的已交金额+本次实交金额
		sf.setPracticalmoney(s.getFtest1()+s.getPracticalmoney());
		sf.setFdata(new Date().toLocaleString());
		//int i=s.getFway().indexOf(",");
		sf.setFway(s.getFway());
		if(sf.getPracticalmoney()>=sf.getNeedmoney()) {//已交清
			sf.setFstatu(2);
		}
		if(sf.getPracticalmoney()<sf.getNeedmoney()&&sf.getPracticalmoney()!=0) {
			sf.setFstatu(1);
		}
		hibernateTemplate.update(sf);
		
	}

	//编辑前查询远程缴费表信息
	public List<Distancefinance> seldisfinancebyfid(int id) {
		try {
		 hql="from Distancefinance d inner join d.user u inner join d.academy inner join d.specialty  where d.fid="+id;
		
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

	//保存远程缴费表到数据库
	public void editdisfinance(DistancefinanceBean d) {
		Distancefinance df=hibernateTemplate.get(Distancefinance.class, d.getFid());
		//实交金额=上次的已交金额+本次实交金额
		df.setPracticalmoney(d.getFtest1()+d.getPracticalmoney());
		df.setFdata(new Date().toLocaleString());
		//int i=d.getFway().indexOf(",");
		df.setFway(d.getFway());
		if(df.getPracticalmoney()>=df.getNeedmoney()) {//已交清
			df.setFstatu(2);
		}
		if(df.getPracticalmoney()<df.getNeedmoney()&&df.getPracticalmoney()!=0) {
			df.setFstatu(1);
		}
		hibernateTemplate.update(df);
	}

	//根据学生id查询国家开放缴费表id
	public List<Statefinance> selstaid(int id) {
		try {
			hql="from Statefinance a where a.sid="+id;
	     	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	              public Object doInHibernate(Session session)  
	                       throws HibernateException, SQLException {  
	                  List list2 = session.createQuery(hql)  
	                      
	                          .list();  

	                  return list2;  
	              }});
	     	 
		             return list;  
		        	 
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
	}

	//修改国家开放缴费表的学生姓名
	public void updatestatename(int id, String name) {
		Statefinance s=hibernateTemplate.get(Statefinance.class, id);
		s.setSname(name);
		hibernateTemplate.update(s);
	}

	//根据学生id查询远程缴费表id
	public List<Distancefinance> seldisid(int id) {
		try {
			hql="from Distancefinance d where d.sid="+id;
	     	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	              public Object doInHibernate(Session session)  
	                       throws HibernateException, SQLException {  
	                  List list2 = session.createQuery(hql)  
	                      
	                          .list();  

	                  return list2;  
	              }});
	     	 
		             return list;  
		        	 
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
	}

	//修改远程缴费表学生姓名
	public void updatedisname(int id, String name) {
		Distancefinance d=hibernateTemplate.get(Distancefinance.class, id);
		d.setSname(name);
		hibernateTemplate.update(d);
	}

	//查询所有县/区
	public List<County> selcountys() {
		try {
	       	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	                public Object doInHibernate(Session session)  
	                         throws HibernateException, SQLException {  
	                    List list2 = session.createQuery("from County c ")  
	                          .list();  
	                    return list2;  
	                }});
	       	 
	            return list;  
	       	 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}

	//成人高考报名表批量添加数据
	public void addmanyadultapply(AdultapplyBean a) {
		Adultapply ap=new Adultapply();
		ap.setAstudentno(a.getAstudentno());
		ap.setAname(a.getAname());
		ap.setUserid(a.getUserid());
		ap.setIdnumber(a.getIdnumber());
		ap.setAphone(a.getAphone());
		ap.setAtype(a.getAtype());
		ap.setAcaid(a.getAcaid());
		ap.setSpecid(a.getSpecid());
		ap.setAgradation(a.getAgradation());
		ap.setAsystem(a.getAsystem());
		ap.setCityid(a.getCityid());
		ap.setCountyid(a.getCountyid());
		ap.setAdata(new Date().toLocaleString());
		hibernateTemplate.save(ap);
	}

	//批量添加成人高考报名表数据时添加缴费表信息
	public void addmanyadultfinance(AdultapplyBean a) {
		Adultfinance af=new Adultfinance();
		af.setSid(Integer.parseInt(a.getAstudentno()));
		af.setSname(a.getAname());
		af.setSchoolid(a.getAcaid());
		af.setMajorid(a.getSpecid());
		af.setGradation(a.getAgradation());
		af.setTid(a.getUserid());
		if(af.getGradation().equals("高达专")) {
			af.setNeedmoney(6000);
		}
		if(af.getGradation().equals("高达本")) {
			af.setNeedmoney(10000);
		}
		if(af.getGradation().equals("专达本")) {
			af.setNeedmoney(8000);
		}
		af.setPracticalmoney(0);
		af.setFstatu(0);
		hibernateTemplate.save(af);
	}

	//查询角色管理表总数据
	public int adultapplycount(String astudentno,String aname,String teacher) {
		hql="select count(*) from Adultapply a inner join a.user u where 1=1";
		
		if(!astudentno.equals("")) {
			hql+=" and a.astudentno like'%"+astudentno+"%'";
		}
		if(!aname.equals("")) {
			hql+=" and a.aname like'%"+aname+"%'";
		}
		if(!teacher.equals("")) {
			hql+=" and u.name like'%"+teacher+"%'";
		}	
		Long count = (Long)hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
	}
	
	//查询成考报名表总数据
	public int adultapplycount() {
		hql="select count(*) from Adultapply a ";
		Long count = (Long)hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
	}
	
	

	//查询国家开放报名表总数据
	public int stateapplycount(String astudentno,String aname,String teacher) {
		hql="select count(*) from Stateapply s inner join s.user u where 1=1";
		if(!astudentno.equals("")) {
			hql+=" and s.sstudentno like'%"+astudentno+"%'";
		}
		if(!aname.equals("")) {
			hql+=" and s.sname like'%"+aname+"%'";
		}
		if(!teacher.equals("")) {
			hql+=" and u.name like'%"+teacher+"%'";
		}	
		
		
		Long count = (Long)hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
	}

	//查询远程报名表总数据
	public int disapplycount(String astudentno,String aname,String teacher) {
		hql="select count(*) from Distanceapply d inner join d.user u where 1=1";
		
		if(!astudentno.equals("")) {
			hql+=" and d.dstudentno like'%"+astudentno+"%'";
		}
		if(!aname.equals("")) {
			hql+=" and d.dname like'%"+aname+"%'";
		}
		if(!teacher.equals("")) {
			hql+="and u.name like'%"+teacher+"%'";
		}
		
		Long count = (Long)hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
	}

	//查询成人高考表所有数据
	public List<Adultapply> seladus() {
		try {
		hql="from Adultapply a inner join a.user u inner join a.academy inner join a.specialty inner join a.city inner join a.county ";
			 
     	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
              public Object doInHibernate(Session session)  
                       throws HibernateException, SQLException {  
                  List list2 = session.createQuery(hql)  
                          .list();  

                  return list2;  
              }});
     	 
	             return list;  
	        	 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}

	//查询文件上传下载表总数据
	public int stufilecount(String id,String name) {
		hql="select count(*) from Stufile s where 1=1";
		
		if(!id.equals("")) {
			hql+=" and s.stuid like'%"+id+"%'";
		}
		if(!name.equals("")) {
			hql+="and s.stuname like '%"+name+"%'";
		}
		
		Long count = (Long)hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
	}

	//查询工作助手表的总数据条数
	public int schedulecount(String userid,String stitle,String sdate,String finishdate,String statu) {
		hql="select count(*) from Schedule s where 1=1";
		
		if(!userid.equals("")) {
			hql+=" and s.userid="+userid;
		}
		if(!stitle.equals("")) {
			hql+="and s.stitle like '%"+stitle+"%'";
		}
		if(!sdate.equals("")) {
			hql+="and s.sdate like '%"+sdate+"%'";
		}
		if(!finishdate.equals("")) {
			hql+="and s.sfinishdate like '%"+finishdate+"%'";
		}
		if(!statu.equals("")) {
			hql+="and s.sflag="+statu;
		}
		
		Long count = (Long)hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
	}

	//根据用户id查询工作助手表的总数据条数
	public int schedulecounts(int id,String stitle,String sdate,String finishdate,String statu) {
		hql="select count(*) from Schedule s where s.userid="+id;
		
		if(!stitle.equals("")) {
			hql+=" and s.stitle like '%"+stitle+"%'";
		}
		if(!sdate.equals("")) {
			hql+=" and s.sdate like '%"+sdate+"%'";
		}
		if(!finishdate.equals("")) {
			hql+=" and s.sfinishdate like '%"+finishdate+"%'";
		}
		if(!statu.equals("")) {
			hql+=" and s.sflag="+statu;
		}
		
		Long count = (Long)hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
	}

	//查询成人缴费表总数据
	public int adultfinancecount(String sid,String name,String teacher,String status,String types) {
		hql="select count(*) from Adultfinance a inner join a.user u where 1=1";
		
		if(!sid.equals("")) {
			hql+="and a.sid like '%"+sid+"%'";
		}
		if(!name.equals("")) {
			hql+="and a.sname like '%"+name+"%'";
		}
		if(!teacher.equals("")) {
			hql+="and u.name like '%"+teacher+"%'";
		}
		if(!status.equals("")) {
			hql+="and a.fstatu ="+status;
		}
		if(!types.equals("")) {
			hql+="and a.fway like '%"+types+"%'";
		}
		
		
		
		Long count = (Long)hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
	}

	//查询会计缴费表总数据
	public int accfinancecount(String  sid,String sname,String teacher,String status,String types) {
		hql="select count(*) from Accountantfinance a inner join a.user u where 1=1";
		
		if(!sid.equals("")) {
			hql+="and a.sid like '%"+sid+"%'";
		}
		if(!sname.equals("")) {
			hql+="and a.sname like '%"+sname+"%'";
		}
		if(!teacher.equals("")) {
			hql+="and u.name like '%"+teacher+"%'";
		}
		if(!status.equals("")) {
			hql+="and a.fstatu ="+status;
		}
		if(!types.equals("")) {
			hql+="and a.fway like '%"+types+"%'";
		}
		
		Long count = (Long)hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
	}

	//查询国家开放缴费表总数据条数
	public int statefinancecount(String sid,String sname,String teacher,String status,String types) {
		hql="select count(*) from Statefinance s inner join s.user u where 1=1";
		if(!sid.equals("")) {
			hql+="and s.sid like '%"+sid+"%'";
		}
		if(!sname.equals("")) {
			hql+="and s.sname like '%"+sname+"%'";
		}
		if(!teacher.equals("")) {
			hql+="and u.name like '%"+teacher+"%'";
		}
		if(!status.equals("")) {
			hql+="and s.fstatu ="+status;
		}
		if(!types.equals("")) {
			hql+="and s.fway like '%"+types+"%'";
		}
		
		
		Long count = (Long)hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
	}

	//查询远程缴费表总数据条数
	public int disfinancecount(String sid,String sname,String teacher,String status,String types) {
		
		hql="select count(*) from Distancefinance d inner join d.user u where 1=1";
		
		if(!sid.equals("")) {
			hql+="and d.sid like '%"+sid+"%'";
		}
		if(!sname.equals("")) {
			hql+="and d.sname like '%"+sname+"%'";
		}
		if(!teacher.equals("")) {
			hql+="and u.name like '%"+teacher+"%'";
		}
		if(!status.equals("")) {
			hql+="and d.fstatu ="+status;
		}
		if(!types.equals("")) {
			hql+="and d.fway like '%"+types+"%'";
		}
		
		Long count = (Long)hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
	}

	//查询艺考缴费表总数据条数
	public int artfinancecount(String sid,String sname,String teacher,String status,String types) {
		hql="select count(*) from Artfinance a inner join a.user u where 1=1";
		if(!sid.equals("")) {
			hql+="and a.sid like '%"+sid+"%'";
		}
		if(!sname.equals("")) {
			hql+="and a.sname like '%"+sname+"%'";
		}
		if(!teacher.equals("")) {
			hql+="and u.name like '%"+teacher+"%'";
		}
		if(!status.equals("")) {
			hql+="and a.fstatu ="+status;
		}
		if(!types.equals("")) {
			hql+="and a.fway like '%"+types+"%'";
		}
		
		Long count = (Long)hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
	}

	//查询职考缴费表总数据条数
	public int profinancecount(String sid,String sname,String teacher,String status,String types) {
		hql="select count(*) from Professionfinance p inner join p.user u where 1=1";
		
		if(!sid.equals("")) {
			hql+="and p.sid like '%"+sid+"%'";
		}
		if(!sname.equals("")) {
			hql+="and p.sname like '%"+sname+"%'";
		}
		if(!teacher.equals("")) {
			hql+="and u.name like '%"+teacher+"%'";
		}
		if(!status.equals("")) {
			hql+="and p.fstatu ="+status;
		}
		if(!types.equals("")) {
			hql+="and p.fway like '%"+types+"%'";
		}
		
		Long count = (Long)hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
	}

	//根据角色id查询当前登入用户是什么角色
	public String selrolenamebyrid(int id) {
		String name =  (String) hibernateTemplate.find("select r.name from Role r where r.id="+id).listIterator().next();
		return name;
	}

	//根据用户id查询成考报名表的数据
	public List<Adultapply> seladultbyuid(int begin, int row, String astudentno, String aname, int uid) {
		try {
		  	hql="from Adultapply a inner join a.user u inner join a.academy inner join a.specialty inner join a.city inner join a.county where a.userid="+uid;
		 
		 if(!astudentno.equals("")) {//如果stuid不为空  模糊查询
			 hql+=" and a.astudentno='"+astudentno+"'";
			// System.out.println("进了stuid");
		 }
		 if(!aname.equals("")) {
			 hql+=" and a.aname like '%"+aname+"%'";
			// System.out.println("进了stuname");
		 }
		
		 
	
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .setFirstResult((begin-1)*row)  
                         .setMaxResults(row)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//根据用户id查询成考报名表的总数据条数
	public int seladultapplycountbyuid(int id) {
		Long count = (Long)hibernateTemplate.find("select count(*) from Adultapply a where a.userid="+id).listIterator().next();
        return count.intValue();
	}

	//根据用户id查询成考报名表的数据
	public List<Stateapply> selstatebyuid(int begin, int row, String astudentno, String aname, int uid) {
		try {
		  	hql="from Stateapply s inner join s.user u inner join s.academy inner join s.specialty inner join s.city inner join s.county where s.userid="+uid;
		 
		 if(!astudentno.equals("")) {//如果stuid不为空  模糊查询
			 hql+=" and s.sstudentno='"+astudentno+"'";
			// System.out.println("进了stuid");
		 }
		 if(!aname.equals("")) {
			 hql+=" and s.sname like '%"+aname+"%'";
			// System.out.println("进了stuname");
		 }
		
		 
	
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .setFirstResult((begin-1)*row)  
                         .setMaxResults(row)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//根据用户id查询国家开放报名表总数据条数
	public int selstateapplycountbyuid(int id,String sstudentno,String sname) {
		hql="select count(*) from Stateapply s where s.userid="+id;
		
		if(!sstudentno.equals("")) {
			 hql+=" and s.sstudentno like '%"+sstudentno+"%'";
		}
		if(!sname.equals("")) {
			hql+=" and s.sname like '%"+sname+"%'";
		}
		
		
		Long count = (Long)hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
	}

	//根据用户id查询远程报名表数据
	public List<Distanceapply> seldisbyuid(int begin, int row, String astudentno, String aname, int uid) {
		try {
		  	hql="from Distanceapply d inner join d.user u inner join d.academy inner join d.specialty inner join d.city inner join d.county where d.userid="+uid;
		 
		 if(!astudentno.equals("")) {//如果stuid不为空  模糊查询
			 hql+=" and d.dstudentno like'%"+astudentno+"%'";
			// System.out.println("进了stuid");
		 }
		 if(!aname.equals("")) {
			 hql+=" and d.dname like '%"+aname+"%'";
			// System.out.println("进了stuname");
		 }
		
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .setFirstResult((begin-1)*row)  
                         .setMaxResults(row)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//根据用户id查询远程报名表总数据条数
	public int seldisapplycountbyuid(int id,String dstudentno,String dname) {
		hql="select count(*) from Distanceapply d where d.userid="+id;
		
		if(!dstudentno.equals("")) {
			 hql+=" and d.dstudentno like'%"+dstudentno+"%'";
		}
		 if(!dname.equals("")) {
			 hql+=" and d.dname like '%"+dname+"%'";
			// System.out.println("进了stuname");
		 }
		
		Long count = (Long)hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
	}

	//根据用户id查询成人高考表信息 不带模糊查询 
	public List<Adultapply> seladubyuid(int begin, int row, int id) {
		 try {
				hql="from Adultapply a inner join a.user u inner join a.academy inner join a.specialty inner join a.city inner join a.county where a.userid="+id;
		     	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
		              public Object doInHibernate(Session session)  
		                       throws HibernateException, SQLException {  
		                  List list2 = session.createQuery(hql)  
		                          .setFirstResult((begin-1)*row)  
		                          .setMaxResults(row)  
		                          .list();  

		                  return list2;  
		              }});
		     	 
			             return list;  
			        	 
					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
	}

	//根据用户id查询成人高考缴费表信息
	public List<Adultfinance> seladultfinancebyuid(int begin, int row, String astudentno, String aname, String status,
			String types, int uid) {
		try {
		  	hql="from Adultfinance a inner join a.user u inner join a.academy inner join a.specialty  where a.tid="+uid;
		 
		  if(!aname.equals("")) {
			  hql+=" and a.sname like '%"+aname+"%'";
		  }	
		  	
		 if(!astudentno.equals("")) {
			 hql+=" and a.sid like '%"+astudentno+"%'";
			// System.out.println("进了stuname");
		 }
	
		 if(!status.equals("")) {
			 hql+=" and a.fstatu like '%"+status+"%'";
		 }
		 if(!types.equals("")) {
			 hql+=" and a.fway like  '%"+types+"%'";
		 }
		 
	
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .setFirstResult((begin-1)*row)  
                         .setMaxResults(row)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

	//根据用户id查询成人高考缴费表总数据
	public int seladultfinancecountbyuid(int id,String sid,String sname,String status,String types) {
		hql="select count(*) from Adultfinance a where a.tid="+id;
		  if(!sid.equals("")) {
			  hql+=" and a.sid like '%"+sid+"%'";
		  }
		  if(!sname.equals("")) {
			  hql+=" and a.sname like '%"+sname+"%'";
		  }
		  if(!status.equals("")) {
			  hql+=" and a.fstatu ="+status;
		  }
		  if(!types.equals("")) {
			  hql+=" and a.fway like '%"+types+"%'";
		  }
		  
		
		Long count = (Long)hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
	}

	//根据用户id查询会计缴费表信息
	public List<Accountantfinance> selaccfinancebyuid(int begin, int row, String astudentno, String aname,
			String status, String types, int uid) {
		try {
		  	hql="from Accountantfinance a inner join a.user u  where a.tid="+uid;
		 
		  if(!aname.equals("")) {
			  hql+=" and a.sname like '%"+aname+"%'";
		  }	
		  	
		 if(!astudentno.equals("")) {
			 hql+=" and a.sid like '%"+astudentno+"%'";
			// System.out.println("进了stuname");
		 }
	
		 if(!status.equals("")) {
			 hql+=" and a.fstatu like '%"+status+"%'";
		 }
		 if(!types.equals("")) {
			 hql+=" and a.fway like  '%"+types+"%'";
		 }
		 
	
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .setFirstResult((begin-1)*row)  
                         .setMaxResults(row)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

	//根据用户id查询会计缴费表总数据
	public int selaccfinancecountbyuid(int id,String sid,String sname,String status,String types) {
		hql="select count(*) from Accountantfinance a where a.tid="+id;
		 if(!sid.equals("")) {
			 hql+=" and a.sid like '%"+sid+"%'";
		 }
		 if(!sname.equals("")) {
			 hql+=" and a.sname like '%"+sname+"%'";
		 }
		 if(!status.equals("")) {
			 hql+=" and a.fstatu="+status;
		 }
		 if(!types.equals("")) {
			 hql+=" and a.fway like '%"+types+"%'";
		 }
		 
		
		
		Long count = (Long)hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
	}

	//根据用户id查询国家开放表总数据
	public List<Statefinance> selstatefinancebyuid(int begin, int row, String astudentno, String aname, String status,
			String types, int uid) {
		try {
		  	hql="from Statefinance s inner join s.user u inner join s.academy inner join s.specialty  where s.tid="+uid;
		 
		  if(!aname.equals("")) {
			  hql+=" and s.sname like '%"+aname+"%'";
		  }	
		  	
		 if(!astudentno.equals("")) {
			 hql+=" and s.sid like '%"+astudentno+"%'";
			// System.out.println("进了stuname");
		 }
	
		 if(!status.equals("")) {
			 hql+=" and s.fstatu like '%"+status+"%'";
		 }
		 if(!types.equals("")) {
			 hql+=" and s.fway like  '%"+types+"%'";
		 }
		 
	
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .setFirstResult((begin-1)*row)  
                         .setMaxResults(row)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

	//根据用户id查询国家开放缴费表总数据
	public int selstatefinancecountbyuid(int id,String sid,String sname,String status,String types) {
		hql="select count(*) from Statefinance s where s.tid="+id;
		
		 if(!sid.equals("")) {
			 hql+=" and s.sid like '%"+sid+"%'";
		 }
		 if(!sname.equals("")) {
			 hql+=" and s.sname like '%"+sname+"%'";
		 }
		 if(!status.equals("")) {
			 hql+=" and s.fstatu="+status;
		 }
		 if(!types.equals("")) {
			 hql+=" and s.fway like '%"+types+"%'";
		 }
		  
		
		Long count = (Long)hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
	}

	//根据用户id查询查询远程缴费表总数据
	public List<Distancefinance> seldisfinancebyuid(int begin, int row, String astudentno, String aname, String status,
			String types, int uid) {
		try {
		  	hql="from Distancefinance d inner join d.user u inner join d.academy inner join d.specialty  where d.tid="+uid;
		 
		  if(!aname.equals("")) {
			  hql+=" and d.sname like '%"+aname+"%'";
		  }	
		  	
		 if(!astudentno.equals("")) {
			 hql+=" and d.sid like '%"+astudentno+"%'";
			// System.out.println("进了stuname");
		 }
	
		 if(!status.equals("")) {
			 hql+=" and d.fstatu like '%"+status+"%'";
		 }
		 if(!types.equals("")) {
			 hql+=" and d.fway like  '%"+types+"%'";
		 }
		 
	
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .setFirstResult((begin-1)*row)  
                         .setMaxResults(row)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

	//根据用户id查询远程缴费表总数据
	public int seldisfinancecountbyuid(int uid,String sid,String sname,String status,String types) {
		hql="select count(*) from Distancefinance d where d.tid="+uid;
		
		 if(!sid.equals("")) {
			 hql+=" and d.sid like '%"+sid+"%'";
		 }
		 if(!sname.equals("")) {
			 hql+=" and d.sname like '%"+sname+"%'";
		 }
		 if(!status.equals("")) {
			 hql+=" and d.fstatu="+status;
		 }
		 if(!types.equals("")) {
			 hql+=" and d.fway like '%"+types+"%'";
		 }
		
		
		Long count = (Long)hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
	}

	//根据用户id查询艺考缴费表总数据
	public List<Artfinance> selartfinancebyuid(int begin, int row, String astudentno, String aname, String status,
			String types, int uid) {
		try {
		  	hql="from Artfinance a inner join a.user u  where a.tid="+uid;
		 
		  if(!aname.equals("")) {
			  hql+=" and a.sname like '%"+aname+"%'";
		  }	
		  	
		 if(!astudentno.equals("")) {
			 hql+=" and a.sid like '%"+astudentno+"%'";
			// System.out.println("进了stuname");
		 }
	
		 if(!status.equals("")) {
			 hql+=" and a.fstatu like '%"+status+"%'";
		 }
		 if(!types.equals("")) {
			 hql+=" and a.fway like  '%"+types+"%'";
		 }
		 
	
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .setFirstResult((begin-1)*row)  
                         .setMaxResults(row)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

	//根据用户id查询艺考缴费表总数据条数
	public int selartfinancecountbyuid(int id,String sid,String sname, String status,String types) {
		 hql="select count(*) from Artfinance a where a.tid="+id;
		 if(!sid.equals("")) {
			 hql+=" and a.sid like '%"+sid+"%'";
		 }
		 if(!sname.equals("")) {
			 hql+=" and a.sname like '%"+sname+"%'";
		 }
		 if(!status.equals("")) {
			 hql+=" and a.fstatu="+status;
		 }
		 if(!types.equals("")) {
			 hql+=" and a.fway like '%"+types+"%'";
		 }
		Long count = (Long)hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
	}

	//根据用户id查询职考缴费表总数据
	public List<Professionfinance> selprofinancebyuid(int begin, int row, String astudentno, String aname,
			String status, String types, int uid) {
		try {
		  	hql="from Professionfinance p inner join p.user u  where p.tid="+uid;
		 
		  if(!aname.equals("")) {
			  hql+=" and p.sname like '%"+aname+"%'";
		  }	
		  	
		 if(!astudentno.equals("")) {
			 hql+=" and p.sid like '%"+astudentno+"%'";
			// System.out.println("进了stuname");
		 }
	
		 if(!status.equals("")) {
			 hql+=" and p.fstatu like '%"+status+"%'";
		 }
		 if(!types.equals("")) {
			 hql+=" and p.fway like  '%"+types+"%'";
		 }
		 
	
    	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
             public Object doInHibernate(Session session)  
                      throws HibernateException, SQLException {  
                 List list2 = session.createQuery(hql)  
                         .setFirstResult((begin-1)*row)  
                         .setMaxResults(row)  
                         .list();  

                 return list2;  
             }});
    	 
             return list;  
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//根据用户id查询职考缴费表总数据条数
	public int selprofinancecountybyuid(int id,String sid,String sname,String status,String types) {
		  hql="select count(*) from Professionfinance p where p.tid="+id;
		 if(!sid.equals("")) {
			 hql+=" and p.sid like '%"+sid+"%'";
		 }
		 if(!sname.equals("")) {
			 hql+=" and p.sname like '%"+sname+"%'";
		 }
		 if(!status.equals("")) {
			 hql+=" and p.fstatu="+status;
		 }
		 if(!types.equals("")) {
			 hql+=" and p.fway like '%"+types+"%'";
		 }
		
		Long count = (Long)hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
	}

	//查询成考缴费表已交学费的总数
	public int seladultfinancemoney() {
		Long count = (Long) hibernateTemplate.find("select sum(a.practicalmoney) from Adultfinance a").listIterator().next();
        return count.intValue();
	}

	//查询会计缴费表已交学费的总数
	public int selaccfinancemoney() {
		Long count = (Long) hibernateTemplate.find("select sum(a.practicalmoney) from Accountantfinance a").listIterator().next();
        return count.intValue();
	}

	//查询国家开放缴费表已交学费的总数
	public int selstatefinancemoney() {
		Long count = (Long) hibernateTemplate.find("select sum(s.practicalmoney) from 	Statefinance s").listIterator().next();
        return count.intValue();
	}

	//查询远程缴费表已交学费总数
	public int seldisfinancemoney() {
		Long count = (Long) hibernateTemplate.find("select sum(d.practicalmoney) from 	Distancefinance d").listIterator().next();
        return count.intValue();
	}

	//查询艺考缴费表已交学费总数
	public int selartfinancemoney() {
		Long count = (Long) hibernateTemplate.find("select sum(a.practicalmoney) from 	Artfinance a").listIterator().next();
        return count.intValue();
	}

	//查询职考缴费表已交学费总数
	public int selprofinancemoney() {
		Long count = (Long) hibernateTemplate.find("select sum(p.practicalmoney) from 	Professionfinance p").listIterator().next();
        return count.intValue();
	}

	//根据角色id查询该角色在角色权限表的数据
	public List<Userjurisdiction> seluserjurbyrid(int id) {
		try {
	       	 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
	                public Object doInHibernate(Session session)  
	                         throws HibernateException, SQLException {  
	                    List list2 = session.createQuery("from Userjurisdiction u where u.rid="+id)   
	                            .list();  

	                    return list2;  
	                }});
	       	 
	            return list;  
	       	 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}

	//给角色赋权
	public void addjur(int id, int flag) {
		Userjurisdiction u=hibernateTemplate.get(Userjurisdiction.class, id);
		u.setFlag(flag);
		hibernateTemplate.update(u);
	}

	//根据用户id查询该用户名下的所有学生总数据条数 带模糊查询参数
	public int seladultapplycountbyuid(int uid, String astudentno, String aname) {
		hql="select count(*) from Adultapply a inner join a.user u where a.userid="+uid;
		if(!astudentno.equals("")) {
			hql+=" and a.astudentno like'%"+astudentno+"%'";
		}
		if(!aname.equals("")) {
			hql+=" and a.aname like'%"+aname+"%'";
		}
			
		Long count = (Long)hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
	}

	@Override
	public String selpwd(int id) {
		String jur =  (String) hibernateTemplate.find("select r.password from User r where r.id="+id).listIterator().next();
		return jur;
	}


	
	

	

	
	
	

}
