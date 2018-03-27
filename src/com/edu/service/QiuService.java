package com.edu.service;

import java.util.List;

import com.edu.bean.AccountantfinanceBean;
import com.edu.bean.AdultapplyBean;
import com.edu.bean.AdultfinanceBean;
import com.edu.bean.ArtfinanceBean;
import com.edu.bean.DistancefinanceBean;
import com.edu.bean.OrganizationBean;
import com.edu.bean.ProfessionfinanceBean;
import com.edu.bean.RoleBean;
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
import com.edu.model.Stateapply;
import com.edu.model.Statefinance;
import com.edu.model.Stufile;
import com.edu.model.User;
import com.edu.model.Userjurisdiction;

public interface QiuService {
	//循环遍历用户管理信息
	public List<User> showlist(int begin,int row);
	
	//模糊查询查询用户管理模块的数据
	public List<User> showlistbyname(int begin,int row,String name);
	
	//查总数据条数
	public int listcount();
	
	//查用户管理模块的总数据条数   有模糊查询
	public int listcount(String name);
	
	
	//根据uname查用户信息
	public List<User> findUser(String uname);
	
	//判断账号密码是否匹配(根据账号密码查用户信息)
	public List<User> selectUser(String uname,String pwd);
	
	//查询角色管理模块的总数据
	public List<Role> showlist1(int begin, int row);
	
	//查询角色管理模块的总数据条数
	public int listcount1();
	
	//添加角色管理信息到数据库
	public void addrole(Role role);
	
	//添加用户管理信息到数据库
	public void adduser(User user);
	
	//添加部门管理信息到数据库
	public void adddep(Organization o);
	
	//删除角色管理信息
	public void delrole(int id);
	
	//删除部门管理信息
	public void delorg(int id);
	
	//重置用户的登录密码
	public void resertpwd(int id);
	
	//根据id查询角色管理表的信息
	public Role selrole(int id);
	
	//根据id查用户管理表的信息
	public User seluser(int id);
	
	//根据id查部门管理表的信息
	public Organization selorg(int id);
	
	//保存role表编辑到数据库
	public void saverole(Role r);
	
	//保存user表编辑信息到数据库
	public void savauser(User u);
	
	//保存organization表编辑的信息到数据库
	public void savedep(Organization o);
	
	//查询部门表 取出所有部门
	public List<OrganizationBean> selorg();
	
	//查询角色表 取出所有角色
	public List<RoleBean> selrole();
	
	//查询成人高考报名表信息
	public List<Adultapply> seladu(int begin,int row,String sid,String sname,String teachername);
	
	//查询所有user表的数据
	public List<User> seluser();
	
	//查询出所有学校academy表
	public List<Academy> selacademy();
	
	//根据院校表的id查询该院校的所有专业
	public List<Acaspe> selacaspe(int id);
	
	//查询城市表的所有城市
	public List<City> selcity();
	
	//根据城市id查询所有县/区
	public List<County> selcounty(int id);
	
	//保存成人高考信息到数据库
	public void saveadult(Adultapply a);
	
	//编辑前查询成人高考报名表
	public List<Adultapply> seladult(int id);
	
	//删除成人报名表信息
	public void deladult(int id);
	
	//保存编辑后的成人高考表到数据库
	public void saveeditadult(Adultapply a);
	
	//查询国家开放大学报名表信息
	public List<Stateapply> selstate(int begin,int row,String stuid,String stuname,String teachername);
	
	//保存国家开放大学报名信息到数据库
	public void savestate(Stateapply s);
	
	//编辑前查询国家开放大学报名表
	public List<Stateapply> selstate(int id);
	
	//保存编辑后的国家开放大学表到数据库
	public void saveeditstate(Stateapply a);
	
	//删除成人报名表信息
	public void delstate(int id);
	
	//查询国家开放大学报名信息
	public List<Distanceapply> seldis(int begin,int row,String stuid,String stuname,String teachername);
	
	//保存国家开放大学报名信息到数据库
	public void savedistance(Distanceapply d);
	
	//编辑前查询远程教育报名表
	public List<Distanceapply> seldis(int id);
	
	//保存编辑后的远程教育表到数据库
	public void saveeditdis(Distanceapply d);
	
	//删除远程教育报名表信息
	public void deldis(int id);
	
	//保存成人高考缴费信息到数据库
	public void addadultfinance(Adultfinance a);
	
	//保存国家开放大学缴费信息到数据库
	public void addstatefinance(Statefinance s);
	
	//保存远程教育缴费信息到数据库
	public void adddisfinance(Distancefinance d);
	
	//查询成人高考缴费表的信息
	public List<Adultfinance> seladultfinance(int begin,int row,String stuid,String stuname,String teachername,String status,String types);
	
	//删除成人缴费表的信息
	public void deladultfinance(int id);
	
	//查询国家开放大学缴费表信息
	public List<Statefinance> selstatefinance(int begin,int row,String stuid,String stuname,String teachername,String status,String types);
	
	//删除成人缴费表的信息
	public void delstatefinance(int id);
	
	//查询国家开放大学缴费表信息
	public List<Distancefinance> seldisfinance(int begin,int row,String stuid,String stuname,String teachername,String status,String types);
	
	//删除远程教育缴费表信息
	public void deldisfinance(int id);
	
	//查询会计缴费表信息
	public List<Accountantfinance> selaccfinance(int begin,int row,String stuid,String stuname,String teachername,String status,String types);
	
	//删除会计缴费表
	public void delaccfinance(int id);
	
	//查询职考缴费表信息
	public List<Professionfinance> selprofinance(int begin,int row,String stuid,String stuname,String teachername,String status,String types);
	
	//删除会计缴费表
	public void delprofinance(int id);
		
	//查询艺考缴费表信息
	public List<Artfinance> selartfinance(int begin,int row,String stuid,String stuname,String teachername,String status,String types);
	
	//删除会计缴费表
	public void delartfinance(int id);
	
	//超级管理员查询工作助手信息
	public List<Schedule> selschedule(int begin,int row,String userid,String stitle,String sdate,String finishdate,String status);
	
	//保存工作助手信息到数据库
	public void addschedule(Schedule s);
	
	//编辑工作助手前先查询
	public List<Schedule> selschedule(int id);
	
	//保存编辑后的工作助手到数据库
	public void saveschedule(Schedule s);
	
	//删除工作助手信息
	public void delschedule(int id);
	
	//根据用户id查询用户未完成的工作日志
	public List<Schedule>  selschedulebyuid(int id);
	
	//根据用户id和树id查询该用户是否有权限访问该功能的权限
	public List<Userjurisdiction> hasjur(int rid,int jid);
	
	//根据用户rid查询该用户有的所有权限
	public List<Userjurisdiction> findjurbyrid(int rid);
	
	//根据userjurisdiction表的 id把权限全部清空
	public void deljurbyid(int id);
	
	//根据userjurisdiction表的id赋权限给角色
	public void addjurbyid(int id);
	
	//查询刚刚插入role表的id
	public int selroleid();
	
	//根据role表的id 查询权限
	public String selrolejur(int id);
	
	//插入权限到权限表
	public void addjur(Userjurisdiction u);
	
	//查询所有部门
	public List<Organization> selorgs();
	
	//查所有角色
	public List<Role> selroles();
	
	//根据用户表的rid查询role表的角色名
	public String selrolename(int id);
	
	//普通员工查询工作助手信息
	public List<Schedule> selsche(int begin,int row,String userid,String stitle,String sdate,String finishdate,String status);
	
	//查询学生文件上传表的信息
	public List<Stufile> selstufile(int begin,int row,String id,String name);
	
	//查询成人高考表信息
	public List<Adultapply> seladultstu(int begin,int row);
	
	//根据成人高考学生的学号 查询学生名称
	public String seladultname(int id);
	
	//保存学生文件上传信息到数据库
	public void savefile(Stufile s);
	
	//根据学生id查询该学生是否上传过文件
	public List<Stufile> isupload(int id);
	
	//根据主键id删除文件上传表的信息
	public void delfile(int id);
	
	//根据stufile表主键id查询信息
	public List<Stufile> selfilebyid(int id);
	
	//查询成考缴费表id 根据成考表学生id查
	public List<Adultfinance> seladuid(int id);
	
	//修改成考缴费表姓名 
	public void updateadultname(int id,String name);
	
	//根据成考表学生id查询成考文件上传表的主键id
	public List<Stufile> selstuid(int id);
	
	//修改文件上传表姓名
	public void updatestuname(int id,String name);
	
	//修改编辑后的文件上传到数据库
	public void updatestufile(Stufile s);
	
	//根据学生学生和学生姓名查询是否有该学生
	public List<Adultapply> hasstu(int id,String name);
	
	//后台修改用户密码
	public void updatepwd(int id,String pwd);
	
	//判断用户的密码正不正确(根据用户id去查密码 返回密码和传到后台的密码做判断)
	public String seluserpwd(int id);
	
	//根据成人高考缴费表主键查询成人高考缴费表信息
	public List<Adultfinance> seladultfinancebyfid(int id);
	
	//保存成人高考缴费表到数据库
	public void editadultfinance(AdultfinanceBean a);
	
	//根据会计缴费表的id查询会计缴费表的信息
	public List<Accountantfinance> selaccbyfid(int id);
	
	//保存会计缴费表信息到数据库
	public void editaccfinance(AccountantfinanceBean a);
	
	//编辑前根据艺考缴费表id查询艺考缴费表信息
	public List<Artfinance> selartfinancebyfid(int id);
	
	//保存艺考缴费表信息到数据库
	public void editartfinance(ArtfinanceBean a);
	
	//编辑前查询职考缴费表信息到数据库
	public List<Professionfinance> selprofinancebyfid(int id);
	
	//保存职考缴费表信息到数据库
	public void editprofinance(ProfessionfinanceBean p);
	
	//编辑前查询国家开放大学缴费信息
	public List<Statefinance> selstatefinancebyfid(int id);
	
	//保存国家开放大学缴费表到数据库
	public void editstatefinance(StatefinanceBean s);
	
	//编辑前查询远程缴费表信息到数据库
	public List<Distancefinance> seldisfinancebyfid(int id);
	
	//保存远程缴费表到数据库
	public void editdisfinance(DistancefinanceBean d);
	
	//根据学生id查询国家开放缴费表id
	public List<Statefinance> selstaid(int id);
	
	//修改成考缴费表姓名 
	public void updatestatename(int id,String name);
	
	//根据学生id查询远程缴费表id
	public List<Distancefinance> seldisid(int id);
	
	//修改远程缴费表学生姓名
	public void updatedisname(int id,String name);
	
	//查询出所有县/区
	public List<County>selcountys();
	
	//成人高考报名表批量添加数据
	public void addmanyadultapply(AdultapplyBean a);
	
	//批量添加成人高考报名表数据时添加缴费表信息
	public void addmanyadultfinance(AdultapplyBean a);
	
	//查询成考报名表总数据
	public int adultapplycount(String astudentno,String aname,String teacher);
	
	//查询成考报名表总数据
	public int adultapplycount();
	
	//查询国家开放报名表总数据
	public int stateapplycount(String astudentno,String aname,String teacher);
	
	//查询远程报名表总数据
	public int disapplycount(String astudentno,String aname,String teacher);
	
	//查成人高考缴费表总数据
	public List<Adultapply> seladus();
	
	//查询文件上传下载表总数据
	public int stufilecount(String id,String name);
	
	//查询工作助手表的总数据条数
	public int schedulecount(String userid,String stitle,String sdate,String finishdate,String statu);
	
	//根据用户id查询工作助手表的总数据条数
	public int schedulecounts(int id,String stitle,String sdate,String finishdate,String statu);
	
	//查询成考缴费表的总数据条数
	public int adultfinancecount(String astudentno,String aname,String teacher,String status,String types);
	
	//查询会计缴费表的总数据条数
	public int accfinancecount(String astudentno,String aname,String teacher,String status,String types);
	
	//查询国家开放大学缴费表总数据条数
	public int statefinancecount(String astudentno,String aname,String teacher,String status,String types);
	
	//查询远程缴费表总数据条数
	public int disfinancecount(String astudentno,String aname,String teacher,String status,String types);
	
	//艺考缴费表总数据
	public int artfinancecount(String astudentno,String aname,String teacher,String status,String types);
	
	//职考缴费表总数据
	public int profinancecount(String astudentno,String aname,String teacher,String status,String types);
	
	//根据角色id查询当前登入用户是什么角色
	public String selrolenamebyrid(int id);
	
	//根据用户id查询成考报名表的数据
	public List<Adultapply> seladultbyuid(int i1,int i2,String astudentno,String aname,int uid);
	
	//根据用户id查询成考报名表的总数据条数
	public int seladultapplycountbyuid(int id);
	
	//根据用户id查询成考报名表的数据
	public List<Stateapply> selstatebyuid(int i1,int i2,String astudentno,String aname,int uid);
	
	//根据用户id查询国家开放报名表总数据条数
	public int selstateapplycountbyuid(int id,String sstudentno,String sname);
	
	//根据用户id查询远程报名表数据
	public List<Distanceapply> seldisbyuid(int begin,int row,String astudentno,String aname,int uid);
	
	//根据用户id查询远程表总数据条数
	public int seldisapplycountbyuid(int id ,String dstudentno,String dname);
	
	//根据用户id查询成人高考表信息 不带模糊查询 
	public List<Adultapply> seladubyuid(int begin,int row,int id);
	
	//根据用户id查询成人高考缴费表信息
	public List<Adultfinance> seladultfinancebyuid(int begin,int row,String astudentno,String aname,String status,String types,int uid);
	
	//根据用户id查询成人高考缴费表总数据
	public int seladultfinancecountbyuid(int id,String astudentno,String aname,String status,String types);
	
	//根据用户id查询会计缴费表信息
	public List<Accountantfinance> selaccfinancebyuid(int begin,int row,String astudentno,String aname,String status,String types,int uid);
	
	//根据用户id查询会计缴费表总数据
	public int selaccfinancecountbyuid(int id,String astudentno,String aname,String status,String types);
	
	//根据用户id查询国家开放表总数据
	public List<Statefinance> selstatefinancebyuid(int begin,int row,String astudentno,String aname,String status,String types,int uid);
	
	//根据用户id查询国家开放缴费表总数据
	public int selstatefinancecountbyuid(int id,String astudentno,String aname,String status,String types);
	
	//根据用户id查询查询远程缴费表总数据
	public List<Distancefinance> seldisfinancebyuid(int begin,int row,String astudentno,String aname,String status,String types,int uid);
	
	//根据用户id查询远程缴费表总数据
	public int seldisfinancecountbyuid(int uid,String astudentno,String aname,String status,String types);
	
	//根据用户id查询艺考缴费表总数据
	public List<Artfinance> selartfinancebyuid(int begin,int row,String astudentno,String aname,String status,String types,int uid);
	
	//根据用户id查询艺考缴费表总数据
	public int selartfinancecountbyuid(int id,String astudentno,String aname, String status,String types);

	//根据用户id查询职考缴费表总数据
	public List<Professionfinance> selprofinancebyuid(int begin,int row,String astudentno,String aname,String status,String types,int uid);
	
	//根据用户id查询职考缴费表总数据条数
	public int selprofinancecountybyuid(int id,String astudentno,String aname,String status,String types);
	
	//查询成考缴费表已交学费的总数
	public int seladultfinancemoney();
	
	//查询会计缴费表已交学费的总数
	public int selaccfinancemoney();
	
	//查询国家开放缴费表已交学费的总数
	public int selstatefinancemoney();
	
	//查询远程缴费表已交学费总数
	public int seldisfinancemoney();
	
	//查询艺考缴费表已交学费总数
	public int selartfinancemoney();
	
	//查询职考缴费表已交学费总数
	public int selprofinancemoney();
	
	//根据角色id查询该角色在角色权限表的数据
	public List<Userjurisdiction> seluserjurbyrid(int id);
	
	//给角色赋权
	public void addjur(int id,int flag);
	
	//根据用户id查询该用户名下的所有学生总数据条数 带模糊查询参数
	public int seladultapplycountbyuid(int uid,String astudentno,String aname);
	
	//根据用户id查询当前角色密码
	public String selpwd(int id);
	
	
	
	
}
