package com.edu.service.impl;

import java.util.List;

import com.edu.service.QiuService;
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

public class QiuServiceImpl implements QiuService{
	private QiuDao qiuDao;

	public QiuDao getQiuDao() {
		return qiuDao;
	}

	public void setQiuDao(QiuDao qiuDao) {
		this.qiuDao = qiuDao;
	}

	@Override
	public List<User> showlist(int begin, int row) {
		List<User> list=qiuDao.showlist(begin, row);
		return list;
	}
	
	@Override
	public List<User> showlistbyname(int begin, int row, String name) {
		List<User> list=qiuDao.showlistbyname(begin, row,name);
		return list;
	}
	

	@Override
	public int listcount() {
		int i=qiuDao.listcount();
		return i;
	}

	

	@Override
	public List<User> findUser(String uname) {
		List<User> list=qiuDao.findUser(uname);
		return list;
	}

	@Override
	public List<User> selectUser(String uname, String pwd) {
		List<User> list=qiuDao.selectUser(uname, pwd);
		return list;
	}

	@Override
	public int listcount1() {
		int i=qiuDao.listcount1();
		return i;
	}

	@Override
	public List<Role> showlist1(int begin, int row) {
		List<Role> list=qiuDao.showlist1(begin, row);
		return list;
	}

	@Override
	public void addrole(Role role) {
		qiuDao.addrole(role);
	}

	@Override
	public void adduser(User user) {
		qiuDao.adduser(user);
	}

	@Override
	public void adddep(Organization o) {
		qiuDao.adddep(o);
	}

	@Override
	public void delrole(int id) {
		qiuDao.delrole(id);
	}

	@Override
	public void delorg(int id) {
		qiuDao.delorg(id);
	}

	@Override
	public void resertpwd(int id) {
		qiuDao.resertpwd(id);
	}

	@Override
	public Role selrole(int id) {
		Role role=qiuDao.selrole(id);
		return role;
	}

	@Override
	public User seluser(int id) {
		User u=qiuDao.seluser(id);
		return u;
	}

	@Override
	public Organization selorg(int id) {
		Organization o=qiuDao.selorg(id);
		return o;
	}
	
	@Override
	public void saverole(Role r) {
		qiuDao.saverole(r);
	}

	@Override
	public void savauser(User u) {
		qiuDao.savauser(u);
	}

	@Override
	public void savedep(Organization o) {
		qiuDao.savedep(o);
	}

	@Override
	public List<OrganizationBean> selorg() {
		List<OrganizationBean> list=qiuDao.selorg();
		return list;
	}

	@Override
	public List<RoleBean> selrole() {
		List<RoleBean> list=qiuDao.selrole();
		return list;
	}

	@Override
	public List<Adultapply> seladu(int begin, int row,String sid,String sname,String teachername) {
		List<Adultapply> list=qiuDao.seladu(begin, row,sid,sname,teachername);
		return list;
	}

	@Override
	public List<User> seluser() {
		List<User> list=qiuDao.seluser();
		return list;
	}

	@Override
	public List<Academy> selacademy() {
		List<Academy> list=qiuDao.selacademy();
		return list;
	}

	@Override
	public List<Acaspe> selacaspe(int id) {
		List<Acaspe> list=qiuDao.selacaspe(id);
		return list;
	}

	@Override
	public List<City> selcity() {
		List<City> list=qiuDao.selcity();
		return list;
	}

	@Override
	public List<County> selcounty(int id) {
		List<County> list=qiuDao.selcounty(id);
		return list;
	}

	@Override
	public void saveadult(Adultapply a) {
		qiuDao.saveadult(a);
	}

	@Override
	public List<Adultapply> seladult(int id) {
		List<Adultapply> list=qiuDao.seladult(id);
		return list;
	}

	@Override
	public void deladult(int id) {
		qiuDao.deladult(id);
	}

	@Override
	public void saveeditadult(Adultapply a) {
		qiuDao.saveeditadult(a);
	}

	@Override
	public List<Stateapply> selstate(int begin, int row, String stuid, String stuname, String teachername) {
		List<Stateapply> list=qiuDao.selstate(begin, row, stuid, stuname, teachername);
		return list;
	}

	@Override
	public void savestate(Stateapply s) {
		qiuDao.savestate(s);
	}

	@Override
	public List<Stateapply> selstate(int id) {
		List<Stateapply> list=qiuDao.selstate(id);
		return list;
	}

	@Override
	public void saveeditstate(Stateapply a) {
		qiuDao.saveeditstate(a);
	}

	@Override
	public void delstate(int id) {
		qiuDao.delstate(id);
	}

	@Override
	public List<Distanceapply> seldis(int begin, int row, String stuid, String stuname, String teachername) {
		List<Distanceapply> list=qiuDao.seldis(begin, row, stuid, stuname, teachername);
		return list;
	}

	@Override
	public void savedistance(Distanceapply d) {
		qiuDao.savedistance(d);
	}

	@Override
	public List<Distanceapply> seldis(int id) {
		List<Distanceapply> list=qiuDao.seldis(id);
		return list;
	}

	@Override
	public void saveeditdis(Distanceapply d) {
		qiuDao.saveeditdis(d);
	}

	@Override
	public void deldis(int id) {
		qiuDao.deldis(id);
	}

	@Override
	public void addadultfinance(Adultfinance a) {
		qiuDao.addadultfinance(a);
	}

	@Override
	public void addstatefinance(Statefinance s) {
		qiuDao.addstatefinance(s);
	}

	@Override
	public void adddisfinance(Distancefinance d) {
		qiuDao.adddisfinance(d);
	}

	@Override
	public List<Adultfinance> seladultfinance(int begin, int row, String stuid, String stuname, String teachername,
			String status, String types) {
		List<Adultfinance> list=qiuDao.seladultfinance(begin, row, stuid, stuname, teachername, status, types);
		return list;
	}

	@Override
	public void deladultfinance(int id) {
		qiuDao.deladultfinance(id);
	}

	@Override
	public List<Statefinance> selstatefinance(int begin, int row, String stuid, String stuname, String teachername,
			String status, String types) {
		List<Statefinance> list=qiuDao.selstatefinance(begin, row, stuid, stuname, teachername, status, types);
		return list;
	}

	@Override
	public void delstatefinance(int id) {
		qiuDao.delstatefinance(id);
	}

	@Override
	public List<Distancefinance> seldisfinance(int begin, int row, String stuid, String stuname, String teachername,
			String status, String types) {
		List<Distancefinance> list=qiuDao.seldisfinance(begin, row, stuid, stuname, teachername, status, types);
		return list;
	}

	@Override
	public void deldisfinance(int id) {
		qiuDao.deldisfinance(id);
	}

	@Override
	public List<Accountantfinance> selaccfinance(int begin, int row, String stuid, String stuname, String teachername,
			String status, String types) {
		List<Accountantfinance> list=qiuDao.selaccfinance(begin, row, stuid, stuname, teachername, status, types);
		return list;
	}

	@Override
	public void delaccfinance(int id) {
		qiuDao.delaccfinance(id);
	}

	@Override
	public List<Professionfinance> selprofinance(int begin, int row, String stuid, String stuname, String teachername,
			String status, String types) {
		List<Professionfinance> list=qiuDao.selprofinance(begin, row, stuid, stuname, teachername, status, types);
		return list;
	}

	@Override
	public void delprofinance(int id) {
		qiuDao.delprofinance(id);
	}

	@Override
	public List<Artfinance> selartfinance(int begin, int row, String stuid, String stuname, String teachername,
			String status, String types) {
		List<Artfinance> list=qiuDao.selartfinance(begin, row, stuid, stuname, teachername, status, types);
		return list;
	}

	@Override
	public void delartfinance(int id) {
		qiuDao.delartfinance(id);
	}

	@Override
	public List<Schedule> selschedule(int begin, int row, String userid, String stitle, String sdate,
			String finishdate, String status) {
		List<Schedule> list=qiuDao.selschedule(begin, row, userid, stitle, sdate, finishdate, status);
		return list;
	}

	@Override
	public void addschedule(Schedule s) {
		qiuDao.addschedule(s);
	}

	@Override
	public List<Schedule> selschedule(int id) {
		List<Schedule> list=qiuDao.selschedule(id);
		return list;
	}

	@Override
	public void saveschedule(Schedule s) {
		qiuDao.saveschedule(s);
	}

	@Override
	public void delschedule(int id) {
		qiuDao.delschedule(id);
	}

	@Override
	public List<Schedule> selschedulebyuid(int id) {
		List<Schedule> list=qiuDao.selschedulebyuid(id);
		return list;
	}

	@Override
	public List<Userjurisdiction> hasjur(int rid, int jid) {
		List<Userjurisdiction> list=qiuDao.hasjur(rid, jid);
		return list;
	}

	@Override
	public List<Userjurisdiction> findjurbyrid(int rid) {
		List<Userjurisdiction> list=qiuDao.findjurbyrid(rid);
		return list;
	}

	@Override
	public void deljurbyid(int rid) {
		qiuDao.deljurbyid(rid);
	}

	@Override
	public void addjurbyid(int id) {
		qiuDao.addjurbyid(id);
	}

	@Override
	public int selroleid() {
		int i=qiuDao.selroleid();
		return i;
	}

	@Override
	public String selrolejur(int id) {
		String str=qiuDao.selrolejur(id);
		return str;
	}

	@Override
	public void addjur(Userjurisdiction u) {
		qiuDao.addjur(u);
	}

	@Override
	public List<Organization> selorgs() {
		List<Organization> list=qiuDao.selorgs();
		return list;
	}

	@Override
	public List<Role> selroles() {
		List<Role> list=qiuDao.selroles();
		return list;
	}

	@Override
	public String selrolename(int id) {
		String name=qiuDao.selrolename(id);
		return name;
	}

	@Override
	public List<Schedule> selsche(int begin, int row, String userid, String stitle, String sdate, String finishdate,
			String status) {
		List<Schedule> list=qiuDao.selsche(begin, row, userid, stitle, sdate, finishdate, status);
		return list;
	}

	@Override
	public List<Stufile> selstufile(int begin, int row, String id, String name) {
		List<Stufile> list=qiuDao.selstufile(begin, row, id, name);
		return list;
	}

	@Override
	public List<Adultapply> seladultstu(int begin, int row) {
		List<Adultapply> list=qiuDao.seladultstu(begin, row);
		return list;
	}

	@Override
	public String seladultname(int id) {
		String name=qiuDao.seladultname(id);
		return name;
	}

	@Override
	public void savefile(Stufile s) {
		qiuDao.savefile(s);
	}

	@Override
	public List<Stufile> isupload(int id) {
		List<Stufile> list=qiuDao.isupload(id);
		return list;
	}

	@Override
	public void delfile(int id) {
		qiuDao.delfile(id);
	}

	@Override
	public List<Stufile> selfilebyid(int id) {
		List<Stufile> list=qiuDao.selfilebyid(id);
		return list;
	}

	@Override
	public List<Adultfinance> seladuid(int id) {
		List<Adultfinance> list=qiuDao.seladuid(id);
		return list;
	}

	@Override
	public void updateadultname(int id, String name) {
		qiuDao.updateadultname(id, name);
	}

	@Override
	public List<Stufile> selstuid(int id) {
		List<Stufile> list=qiuDao.selstuid(id);
		return list;
	}

	@Override
	public void updatestuname(int id, String name) {
		qiuDao.updatestuname(id, name);
	}

	@Override
	public void updatestufile(Stufile s) {
		qiuDao.updatestufile(s);
	}

	@Override
	public List<Adultapply> hasstu(int id, String name) {
		List<Adultapply> list=qiuDao.hasstu(id, name);
		return list;
	}

	@Override
	public void updatepwd(int id, String pwd) {
		qiuDao.updatepwd(id, pwd);
	}

	@Override
	public String seluserpwd(int id) {
		String pwd=qiuDao.seluserpwd(id);
		return pwd;
	}

	@Override
	public List<Adultfinance> seladultfinancebyfid(int id) {
		List<Adultfinance> list=qiuDao.seladultfinancebyfid(id);
		return list;
	}

	@Override
	public void editadultfinance(AdultfinanceBean a) {
		qiuDao.editadultfinance(a);
	}

	@Override
	public List<Accountantfinance> selaccbyfid(int id) {
		List<Accountantfinance> list=qiuDao.selaccbyfid(id);
		return list;
	}

	@Override
	public void editaccfinance(AccountantfinanceBean a) {
		qiuDao.editaccfinance(a);
	}

	@Override
	public List<Artfinance> selartfinancebyfid(int id) {
		List<Artfinance> list=qiuDao.selartfinancebyfid(id);
		return list;
	}

	@Override
	public void editartfinance(ArtfinanceBean a) {
		qiuDao.editartfinance(a);
	}

	@Override
	public List<Professionfinance> selprofinancebyfid(int id) {
		List<Professionfinance> list=qiuDao.selprofinancebyfid(id);
		return list;
	}

	@Override
	public void editprofinance(ProfessionfinanceBean p) {
		qiuDao.editprofinance(p);
	}

	@Override
	public List<Statefinance> selstatefinancebyfid(int id) {
		List<Statefinance> list=qiuDao.selstatefinancebyfid(id);
		return list;
	}

	@Override
	public void editstatefinance(StatefinanceBean s) {
		qiuDao.editstatefinance(s);
	}

	@Override
	public List<Distancefinance> seldisfinancebyfid(int id) {
		List<Distancefinance> list=qiuDao.seldisfinancebyfid(id);
		return list;
	}

	@Override
	public void editdisfinance(DistancefinanceBean d) {
		qiuDao.editdisfinance(d);
	}

	@Override
	public List<Statefinance> selstaid(int id) {
		List<Statefinance> list=qiuDao.selstaid(id);
		return list;
	}

	@Override
	public void updatestatename(int id, String name) {
		qiuDao.updatestatename(id, name);
	}

	@Override
	public List<Distancefinance> seldisid(int id) {
		List<Distancefinance> list=qiuDao.seldisid(id);
		return list;
	}

	@Override
	public void updatedisname(int id, String name) {
		qiuDao.updatedisname(id, name);
	}

	@Override
	public List<County> selcountys() {
		List<County> list=qiuDao.selcountys();
		return list;
	}

	@Override
	public void addmanyadultapply(AdultapplyBean a) {
		qiuDao.addmanyadultapply(a);
	}

	@Override
	public void addmanyadultfinance(AdultapplyBean a) {
		qiuDao.addmanyadultfinance(a);
	}

	@Override
	public int adultapplycount(String astudentno,String aname,String teacher) {
		int i=qiuDao.adultapplycount(astudentno,aname,teacher);
		return i;
	}
	
	public int adultapplycount() {
		int i=qiuDao.adultapplycount();
		return i;
	}

	public int stateapplycount(String astudentno,String aname,String teacher) {
		int i=qiuDao.stateapplycount( astudentno, aname, teacher);
		return i;
	}

	@Override
	public int disapplycount(String astudentno,String aname,String teacher) {
		int i=qiuDao.disapplycount(astudentno,aname,teacher);
		return i;
	}

	@Override
	public List<Adultapply> seladus() {
		List<Adultapply> list=qiuDao.seladus();
		return list;
	}

	@Override
	public int stufilecount(String id,String name) {
		int i=qiuDao.stufilecount(id,name);
		return i;
	}

	@Override
	public int schedulecount(String userid,String stitle,String sdate,String finishdate,String statu) {
		int i=qiuDao.schedulecount( userid, stitle, sdate, finishdate, statu);
		return i;
	}

	@Override
	public int schedulecounts(int id,String stitle,String sdate,String finishdate,String statu) {
		int i=qiuDao.schedulecounts( id, stitle, sdate, finishdate, statu);
		return i;
	}

	@Override
	public int adultfinancecount(String astudentno,String aname,String teacher,String status,String types) {
		int i=qiuDao.adultfinancecount(astudentno,aname,teacher,status,types);
		return i;
	}

	@Override
	public int accfinancecount(String astudentno,String aname,String teacher,String status,String types) {
		int i=qiuDao.accfinancecount(astudentno,aname,teacher,status,types);
		return i;
	}

	@Override
	public int statefinancecount(String astudentno,String aname,String teacher,String status,String types) {
		int i=qiuDao.statefinancecount(astudentno,aname,teacher,status,types);
		return i;
	}

	@Override
	public int disfinancecount(String astudentno,String aname,String teacher,String status,String types) {
		int i=qiuDao.disfinancecount( astudentno, aname, teacher, status, types);
		return i;
	}

	@Override
	public int artfinancecount(String astudentno,String aname,String teacher,String status,String types) {
		int i=qiuDao.artfinancecount( astudentno, aname, teacher, status, types);
		return i;
	}

	@Override
	public int profinancecount(String astudentno,String aname,String teacher,String status,String types) {
		int i=qiuDao.profinancecount( astudentno, aname, teacher, status, types);
		return i;
	}

	@Override
	public String selrolenamebyrid(int id) {
		String name=qiuDao.selrolename(id);
		return name;
	}

	@Override
	public List<Adultapply> seladultbyuid(int i1, int i2, String astudentno, String aname, int uid) {
		List<Adultapply> list=qiuDao.seladultbyuid(i1, i2, astudentno, aname, uid);
		return list;
	}

	@Override
	public int seladultapplycountbyuid(int id) {
		int i=qiuDao.seladultapplycountbyuid(id);
		return i;
	}

	@Override
	public List<Stateapply> selstatebyuid(int i1, int i2, String astudentno, String aname, int uid) {
		List<Stateapply> list=qiuDao.selstatebyuid(i1, i2, astudentno, aname, uid);
		return list;
	}

	@Override
	public int selstateapplycountbyuid(int id,String sstudentno,String sname) {
		int i=qiuDao.selstateapplycountbyuid(id,sstudentno,sname);
		return i;
	}

	@Override
	public List<Distanceapply> seldisbyuid(int begin, int row, String astudentno, String aname, int uid) {
		List<Distanceapply> list=qiuDao.seldisbyuid(begin, row, astudentno, aname, uid);
		return list;
	}

	@Override
	public int seldisapplycountbyuid(int id ,String dstudentno,String dname) {
		int i=qiuDao.seldisapplycountbyuid(id,dstudentno,dname);
		return i;
	}

	@Override
	public List<Adultapply> seladubyuid(int begin, int row, int id) {
		List<Adultapply> list=qiuDao.seladubyuid(begin, row, id);
		return list;
	}

	@Override
	public List<Adultfinance> seladultfinancebyuid(int begin, int row, String astudentno, String aname, String status,
			String types, int uid) {
		List<Adultfinance>list=qiuDao.seladultfinancebyuid(begin, row, astudentno, aname, status, types, uid);
		return list;
	}

	@Override
	public int seladultfinancecountbyuid(int id,String astudentno,String aname,String status,String types) {
		int i=qiuDao.seladultfinancecountbyuid(id,astudentno,aname,status,types);
		return i;
	}

	@Override
	public List<Accountantfinance> selaccfinancebyuid(int begin, int row, String astudentno, String aname,
			String status, String types, int uid) {
		List<Accountantfinance> list=qiuDao.selaccfinancebyuid(begin, row, astudentno, aname, status, types, uid);
		return list;
	}

	@Override
	public int selaccfinancecountbyuid(int id,String astudentno,String aname,String status,String types) {
		int i=qiuDao.selaccfinancecountbyuid(id,astudentno,aname,status,types);
		return i;
	}

	@Override
	public List<Statefinance> selstatefinancebyuid(int begin, int row, String astudentno, String aname, String status,
			String types, int uid) {
		List<Statefinance> list=qiuDao.selstatefinancebyuid(begin, row, astudentno, aname, status, types, uid);
		return list;
	}

	@Override
	public int selstatefinancecountbyuid(int id,String astudentno,String aname,String status,String types) {
		int i=qiuDao.selstatefinancecountbyuid(id, astudentno, aname, status, types);
		return i;
	}

	@Override
	public List<Distancefinance> seldisfinancebyuid(int begin, int row, String astudentno, String aname, String status,
			String types, int uid) {
		List<Distancefinance> list=qiuDao.seldisfinancebyuid(begin, row, astudentno, aname, status, types, uid);
		return list;
	}

	@Override
	public int seldisfinancecountbyuid(int uid,String astudentno,String aname,String status,String types) {
		int i=qiuDao.seldisfinancecountbyuid( uid, astudentno, aname, status, types);
		return i;
	}

	@Override
	public List<Artfinance> selartfinancebyuid(int begin, int row, String astudentno, String aname, String status,
			String types, int uid) {
		List<Artfinance> list=qiuDao.selartfinancebyuid(begin, row, astudentno, aname, status, types, uid);
		return list;
	}

	@Override
	public int selartfinancecountbyuid(int id,String astudentno,String aname, String status,String types) {
		int i=qiuDao.selartfinancecountbyuid( id, astudentno, aname,  status, types);
		return i;
	}

	@Override
	public List<Professionfinance> selprofinancebyuid(int begin, int row, String astudentno, String aname,
			String status, String types, int uid) {
		List<Professionfinance> list=qiuDao.selprofinancebyuid(begin, row, astudentno, aname, status, types, uid);
		return list;
	}

	@Override
	public int selprofinancecountybyuid(int id,String astudentno,String aname,String status,String types) {
		int i=qiuDao.selprofinancecountybyuid( id, astudentno, aname, status, types);
		return i;
	}

	@Override
	public int seladultfinancemoney() {
		int i= qiuDao.seladultfinancemoney();
		return i;
	}

	@Override
	public int selaccfinancemoney() {
		int i= qiuDao.selaccfinancemoney();
		return i;
	}

	@Override
	public int selstatefinancemoney() {
		int i= qiuDao.selstatefinancemoney();
		return i;
	}

	@Override
	public int seldisfinancemoney() {
		int i= qiuDao.seldisfinancemoney();
		return i;
	}

	@Override
	public int selartfinancemoney() {
		int i= qiuDao.selartfinancemoney();
		return i;
	}

	@Override
	public int selprofinancemoney() {
		int i= qiuDao.selprofinancemoney();
		return i;
	}

	@Override
	public List<Userjurisdiction> seluserjurbyrid(int id) {
		List<Userjurisdiction> list=qiuDao.seluserjurbyrid(id);
		return list;
	}

	@Override
	public void addjur(int id, int flag) {
		qiuDao.addjur(id, flag);
	}

	@Override
	public int seladultapplycountbyuid(int uid, String astudentno, String aname) {
		int i=qiuDao.seladultapplycountbyuid(uid, astudentno, aname);
		return i;
	}

	@Override
	public int listcount(String name) {
		int i=qiuDao.listcount(name);
		return i;
	}

	@Override
	public String selpwd(int id) {
		String str=qiuDao.selpwd(id);
		return str;
	}

	

	

	
}
