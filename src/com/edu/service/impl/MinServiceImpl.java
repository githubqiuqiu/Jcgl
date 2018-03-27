package com.edu.service.impl;

import java.util.List;

import com.edu.bean.AcaspeBean;
import com.edu.bean.AccountantapplyBean;
import com.edu.bean.ArtapplyBean;
import com.edu.bean.ProapplyBean;
import com.edu.dao.impl.MinDaoImpl;
import com.edu.model.Academy;
import com.edu.model.Acaspe;
import com.edu.model.Eguide;
import com.edu.model.Homecontent;
import com.edu.model.Hotmajor;
import com.edu.model.Notice;
import com.edu.model.Relation;
import com.edu.model.Schedule;
import com.edu.model.Share;
import com.edu.model.Specialty;
import com.edu.model.Syslog;
import com.edu.model.User;
import com.edu.service.MinService;

public class MinServiceImpl implements MinService {
	private MinDaoImpl minDao;

	public MinDaoImpl getMinDao() {
		return minDao;
	}
	public void setMinDao(MinDaoImpl minDao) {
		this.minDao = minDao;
	}
	@Override
	public List seldep(int pag,int row) {
		// TODO Auto-generated method stub
		List list = minDao.seldata(pag,row);
		return list;
	}
	@Override
	public int line() {
		// TODO Auto-generated method stub
		int i = minDao.selline();
		return i;
	}
	//---------------------------------------------专业管理

	@Override
	public List<Academy> list(int page,int rows) {
		// TODO Auto-generated method stub
		List list = minDao.list(page, rows);
		return list;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		int count = minDao.count();
		return count;
	}

	@Override
	public void add(Academy academy) {
		// TODO Auto-generated method stub
		minDao.add(academy);
	}

	@Override
	public void del(int aid) {
		// TODO Auto-generated method stub
		minDao.del(aid);
	}

	@Override
	public void edit(Academy academy) {
		minDao.edit(academy);
	}

	@Override
	public List<Academy> slist(int page,int rows,String aschool, int aflag) {
		// TODO Auto-generated method stub
		
		return minDao.slist(page,rows,aschool, aflag);
	}

	@Override
	public List<Academy> slist(int page, int rows, String aschool) {
		// TODO Auto-generated method stub
		return minDao.slist(page,rows,aschool);
	}

	@Override
	public List<Academy> slist(int page, int rows, int aflag) {
		// TODO Auto-generated method stub
		return minDao.slist(page,rows, aflag);
	}

	@Override
	public AcaspeBean selbean(int aid,int sid) {
		AcaspeBean a =minDao.selbean(aid,sid);
		return a;
	}

	@Override
	public List selsname(int aid) {
		// TODO Auto-generated method stub
		return minDao.selsname(aid);
	}

	@Override
	public List selname() {
		// TODO Auto-generated method stub
		return minDao.selname();
	}

	@Override
	public void addsname(Specialty specialty) {
		// TODO Auto-generated method stub
		minDao.addsname(specialty);
	}

	@Override
	public int selsid() {
		// TODO Auto-generated method stub
		return minDao.selsid();
	}

	@Override
	public void editsid(int asid, int sid) {
		// TODO Auto-generated method stub
		minDao.editsid(asid, sid);
	}

	@Override
	public int selsid(String sname) {
		// TODO Auto-generated method stub
		return minDao.selsid(sname);
	}

	@Override
	public List selaname() {
		// TODO Auto-generated method stub
		return minDao.selaname();
	}

	@Override
	public void addacaspe(Acaspe a) {
		// TODO Auto-generated method stub
		minDao.addacaspe(a);
	}

	@Override
	public int selaid() {
		// TODO Auto-generated method stub
		return minDao.selaid();
	}

	@Override
	public int selacaspecount() {
		// TODO Auto-generated method stub
		return minDao.selacaspecount();
	}

	@Override
	public List selaidbyaflag(int aflag) {
		// TODO Auto-generated method stub
		return minDao.selaidbyaflag(aflag);
	}

	@Override
	public int selacaspecount(int aid) {
		// TODO Auto-generated method stub
		return minDao.selacaspecount(aid);
	}

	@Override
	public List selaidbyaschool(String aschool) {
		// TODO Auto-generated method stub
		return minDao.selaidbyaschool(aschool);
	}

	@Override
	public List selaidbyaschoolaflag(String aschool, int aflag) {
		// TODO Auto-generated method stub
		return minDao.selaidbyaschoolaflag(aschool, aflag);
	}
//------------------------------------------------------------会计报名
	@Override
	public List selaccountantapplydata(int page, int rows,String aname,String name,String cname) {
		// TODO Auto-generated method stub
		return minDao.selaccountantapplydata(page, rows,aname,name,cname);
	}
	@Override
	public AccountantapplyBean selone(int aid) {
		// TODO Auto-generated method stub
		return minDao.selone(aid);
	}
	@Override
	public List selallcity() {
		// TODO Auto-generated method stub
		return minDao.selallcity();
	}
	@Override
	public List selcountybycity(int cid) {
		// TODO Auto-generated method stub
		return minDao.selcountybycity(cid);
	}
	@Override
	public void edit(AccountantapplyBean bean) {
		// TODO Auto-generated method stub
		minDao.edit(bean);
	}
	@Override
	public List seluser() {
		// TODO Auto-generated method stub
		return minDao.seluser();
	}
	@Override
	public void acountadd(AccountantapplyBean abean) {
		// TODO Auto-generated method stub
		minDao.acountadd(abean);
	}
	@Override
	public List selhotmajor(int page,int rows,String title) {
		// TODO Auto-generated method stub
		return minDao.selhotmajor(page,rows,title);
	}
	@Override
	public Hotmajor selonehot(int hmid) {
		// TODO Auto-generated method stub
		return minDao.selonehot(hmid);
	}
	@Override
	public void delhotmajor(int hmid) {
		// TODO Auto-generated method stub
		minDao.delhotmajor(hmid);
	}
	@Override
	public void hotmajoradd(Hotmajor h) {
		// TODO Auto-generated method stub
		minDao.hotmajoradd(h);
	}
	@Override
	public void edithotmajor(Hotmajor h) {
		// TODO Auto-generated method stub
		minDao.edithotmajor(h);
	}
	@Override
	public List seleguide(int page, int rows, String type) {
		// TODO Auto-generated method stub
		return minDao.seleguide(page, rows, type);
	}
	@Override
	public void addeguide(Eguide e) {
		// TODO Auto-generated method stub
		minDao.addeguide(e);
	}
	@Override
	public void deleguide(int id) {
		// TODO Auto-generated method stub
		minDao.deleguide(id);
	}
	@Override
	public Eguide seloneeguide(int id) {
		// TODO Auto-generated method stub
		return minDao.seloneeguide(id);
	}
	@Override
	public void edit(Eguide eg) {
		// TODO Auto-generated method stub
		minDao.edit(eg);
	}
	@Override
	public List selshare(int page, int rows, String type) {
		// TODO Auto-generated method stub
		return minDao.selshare(page, rows, type);
	}
	@Override
	public void addshare(Share share) {
		// TODO Auto-generated method stub
		minDao.addshare(share);
	}
	@Override
	public void delshare(int id) {
		// TODO Auto-generated method stub
		minDao.delshare(id);
	}
	@Override
	public Share seloneshare(int id) {
		// TODO Auto-generated method stub
		return minDao.seloneshare(id);
	}
	@Override
	public void edit(Share share) {
		// TODO Auto-generated method stub
		minDao.edit(share);
	}
	@Override
	public List selrelation(int page, int rows, String rcontent) {
		// TODO Auto-generated method stub
		return  minDao.selrelation(page, rows, rcontent);
	}
	@Override
	public void addrelation(Relation r) {
		// TODO Auto-generated method stub
		minDao.addrelation(r);
	}
	@Override
	public void delrelation(int rid) {
		// TODO Auto-generated method stub
		minDao.delrelation(rid);
	}
	@Override
	public Relation selonerelation(int rid) {
		// TODO Auto-generated method stub
		return minDao.selonerelation(rid);
	}
	@Override
	public void edit(Relation r) {
		// TODO Auto-generated method stub
		minDao.edit(r);
	}
	@Override
	public List selnotice(int page, int rows, String ntitle) {
		// TODO Auto-generated method stub
		return minDao.selnotice(page, rows, ntitle);
	}
	@Override
	public void addnotice(Notice n) {
		// TODO Auto-generated method stub
		minDao.addnotice(n);
	}
	@Override
	public void delnotice(int nid) {
		// TODO Auto-generated method stub
		minDao.delnotice(nid);
	}
	@Override
	public Notice selonernotice(int nid) {
		// TODO Auto-generated method stub
		return minDao.selonernotice(nid);
	}
	@Override
	public void edit(Notice r) {
		// TODO Auto-generated method stub
		minDao.edit(r);
	}
	@Override
	public List selhome(int page, int rows) {
		// TODO Auto-generated method stub
		return minDao.selhome(page, rows);
	}
	@Override
	public void addhome(Homecontent h) {
		// TODO Auto-generated method stub
		minDao.addhome(h);
	}
	@Override
	public void delhome(int hcid) {
		// TODO Auto-generated method stub
		minDao.delhome(hcid);
	}
	@Override
	public Homecontent selonehome(int hcid) {
		// TODO Auto-generated method stub
		return minDao.selonehome(hcid);
	}
	@Override
	public void edit(Homecontent r) {
		// TODO Auto-generated method stub
		minDao.edit(r);
	}
	@Override
	public void addaccountfiance(AccountantapplyBean abean) {
		// TODO Auto-generated method stub
		minDao.addaccountfiance(abean);
	}
	@Override
	public void delaccount(int aid) {
		// TODO Auto-generated method stub
		minDao.delaccount(aid);
	}
	@Override
	public List selartapplydata(int page, int rows, String aname, String name, String cname) {
		// TODO Auto-generated method stub
		return minDao.selartapplydata(page, rows, aname, name, cname);
	}
	@Override
	public ArtapplyBean seloneart(int aid) {
		// TODO Auto-generated method stub
		return minDao.seloneart(aid);
	}
	@Override
	public List selallcityart() {
		// TODO Auto-generated method stub
		return minDao.selallcityart();
	}
	@Override
	public List selcountybycityart(int cid) {
		// TODO Auto-generated method stub
		return minDao.selcountybycityart(cid);
	}
	@Override
	public void editart(ArtapplyBean bean) {
		// TODO Auto-generated method stub
		minDao.editart(bean);
	}
	@Override
	public void delart(int aid) {
		// TODO Auto-generated method stub
		minDao.delart(aid);
	}
	@Override
	public List seluserart() {
		// TODO Auto-generated method stub
		return minDao.seluserart();
	}
	@Override
	public void artadd(ArtapplyBean abean) {
		// TODO Auto-generated method stub
		minDao.artadd(abean);
	}
	@Override
	public void addartfiance(ArtapplyBean abean) {
		// TODO Auto-generated method stub
		minDao.addartfiance(abean);
	}
	@Override
	public List selproapplydata(int page, int rows, String aname, String name, String cname) {
		// TODO Auto-generated method stub
		return minDao.selproapplydata(page, rows, aname, name, cname);
	}
	@Override
	public ProapplyBean selonepro(int aid) {
		// TODO Auto-generated method stub
		return minDao.selonepro(aid);
	}
	@Override
	public List selallcitypro() {
		// TODO Auto-generated method stub
		return minDao.selallcitypro();
	}
	@Override
	public List selcountybycitypro(int cid) {
		// TODO Auto-generated method stub
		return minDao.selcountybycitypro(cid);
	}
	@Override
	public void editpro(ProapplyBean bean) {
		// TODO Auto-generated method stub
		minDao.editpro(bean);
	}
	@Override
	public void delpro(int aid) {
		// TODO Auto-generated method stub
		minDao.delpro(aid);
	}
	@Override
	public List seluserpro() {
		// TODO Auto-generated method stub
		return minDao.seluserpro();
	}
	@Override
	public void proadd(ProapplyBean abean) {
		// TODO Auto-generated method stub
		minDao.proadd(abean);
	}
	@Override
	public void addprofiance(ProapplyBean abean) {
		// TODO Auto-generated method stub
		minDao.addprofiance(abean);
	}
	@Override
	public List selsyslog(int page,int rows) {
		// TODO Auto-generated method stub
		return minDao.selsyslog(page,rows);
	}
	@Override
	public void addsyslog(Syslog syslog) {
		// TODO Auto-generated method stub
		minDao.addsyslog(syslog);
	}
	@Override
	public List selaccbytid(int userid) {
		// TODO Auto-generated method stub
		return minDao.selaccbytid(userid);
	}
	@Override
	public List selartbytid(int userid) {
		// TODO Auto-generated method stub
		return minDao.selartbytid(userid);
	}
	@Override
	public List selprobytid(int userid) {
		// TODO Auto-generated method stub
		return minDao.selprobytid(userid);
	}
	@Override
	public List seladubytid(int userid) {
		// TODO Auto-generated method stub
		return minDao.seladubytid(userid);
	}
	@Override
	public List selstabytid(int userid) {
		// TODO Auto-generated method stub
		return minDao.selstabytid(userid);
	}
	@Override
	public List seldisbytid(int userid) {
		// TODO Auto-generated method stub
		return minDao.seldisbytid(userid);
	}
	@Override
	public int selcountacc() {
		// TODO Auto-generated method stub
		return minDao.selcountacc();
	}
	@Override
	public int selcountart() {
		// TODO Auto-generated method stub
		return minDao.selcountart();
	}
	@Override
	public int selcountpro() {
		// TODO Auto-generated method stub
		return minDao.selcountpro();
	}
	@Override
	public int selcountadu() {
		// TODO Auto-generated method stub
		return minDao.selcountadu();
	}
	@Override
	public int selcountsta() {
		// TODO Auto-generated method stub
		return minDao.selcountsta();
	}
	@Override
	public int selcountdis() {
		// TODO Auto-generated method stub
		return minDao.selcountdis();
	}
	@Override
	public List selteancher(String name, String pwd) {
		// TODO Auto-generated method stub
		return minDao.selteancher(name, pwd);
	}
	@Override
	public List selsche(int userid) {
		// TODO Auto-generated method stub
		return minDao.selsche(userid);
	}
	@Override
	public List selhomeindex() {
		// TODO Auto-generated method stub
		return minDao.selhomeindex();
	}
	@Override
	public List selnotice() {
		// TODO Auto-generated method stub
		return minDao.selnotice();
	}
	@Override
	public List selHotmajor() {
		// TODO Auto-generated method stub
		return minDao.selHotmajor();
	}
	@Override
	public int selsyscount() {
		// TODO Auto-generated method stub
		return minDao.selsyscount();
	}
	@Override
	public void updateuser(User user) {
		// TODO Auto-generated method stub
		minDao.updateuser(user);
	}
	@Override
	public List selsharepho() {
		// TODO Auto-generated method stub
		return minDao.selsharepho();
	}
	@Override
	public List seleguidelog() {
		// TODO Auto-generated method stub
		return minDao.seleguidelog();
	}
	@Override
	public Eguide seleguidebyid(int id) {
		// TODO Auto-generated method stub
		return minDao.seleguidebyid(id);
	}
	@Override
	public void delsche(int sid) {
		// TODO Auto-generated method stub
		minDao.delsche(sid);
	}
	@Override
	public void editsche(int sid) {
		// TODO Auto-generated method stub
		minDao.editsche(sid);
	}
	@Override
	public void addsche(Schedule schedule) {
		// TODO Auto-generated method stub
		minDao.addsche(schedule);
	}
	@Override
	public int selaccount(String aname,String name,String cname) {
		// TODO Auto-generated method stub
		return minDao.selaccount(aname,name,cname);
	}
	@Override
	public List selaccountantapplydata(int page, int rows, String aname, String name, String cname, int userid) {
		// TODO Auto-generated method stub
		return minDao.selaccountantapplydata(page, rows, aname, name, cname, userid);
	}
	@Override
	public String selaccname(int aid) {
		// TODO Auto-generated method stub
		return minDao.selaccname(aid);
	}
	@Override
	public void editaccf(int sid, String aname) {
		// TODO Auto-generated method stub
		minDao.editaccf(sid, aname);
	}
	@Override
	public int selartcount(String aname,String name,String cname) {
		// TODO Auto-generated method stub
		return minDao.selartcount(aname,name,cname);
	}
	@Override
	public List selartapplydata(int page, int rows, String aname, String name, String cname, int userid) {
		// TODO Auto-generated method stub
		return minDao.selartapplydata(page, rows, aname, name, cname, userid);
	}
	@Override
	public String selartname(int aid) {
		// TODO Auto-generated method stub
		return minDao.selartname(aid);
	}
	@Override
	public void editartf(int sid, String aname) {
		// TODO Auto-generated method stub
		minDao.editartf(sid, aname);
	}
	@Override
	public int selprocount(String aname,String name,String cname) {
		// TODO Auto-generated method stub
		return minDao.selprocount(aname,name,cname);
	}
	@Override
	public List selproapplydata(int page, int rows, String aname, String name, String cname, int userid) {
		// TODO Auto-generated method stub
		return minDao.selproapplydata(page, rows, aname, name, cname, userid);
	}
	@Override
	public String selproname(int aid) {
		// TODO Auto-generated method stub
		return minDao.selproname(aid);
	}
	@Override
	public void editprof(int sid, String aname) {
		// TODO Auto-generated method stub
		minDao.editprof(sid, aname);
	}
	@Override
	public List selshare() {
		// TODO Auto-generated method stub
		return minDao.selshare();
	}
	@Override
	public List selrelation() {
		// TODO Auto-generated method stub
		return minDao.selrelation();
	}
	@Override
	public List selacclist(String aname, String name, String cname) {
		// TODO Auto-generated method stub
		return minDao.selacclist(aname, name, cname);
	}
	@Override
	public List selartlist(String aname, String name, String cname) {
		// TODO Auto-generated method stub
		return minDao.selartlist(aname, name, cname);
	}
	@Override
	public List selprolist(String aname, String name, String cname) {
		// TODO Auto-generated method stub
		return minDao.selprolist(aname, name, cname);
	}
	@Override
	public int selschoolid(String name) {
		// TODO Auto-generated method stub
		return minDao.selschoolid(name);
	}
}
