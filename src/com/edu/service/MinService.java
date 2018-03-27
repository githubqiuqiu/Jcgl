package com.edu.service;

import java.util.List;

import com.edu.bean.AcaspeBean;
import com.edu.bean.AccountantapplyBean;
import com.edu.bean.ArtapplyBean;
import com.edu.bean.ProapplyBean;
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

public interface MinService {
	public List seldep(int pag,int row);
	public int line();
	//-------------------------------------------专业管理
	public List<Academy> list(int page, int rows);

	public int count();

	public void add(Academy academy);

	public void del(int aid);

	public void edit(Academy academy);

	// 2个参数
	public List<Academy> slist(int page, int rows, String aschool, int aflag);

	// 1个参数
	public List<Academy> slist(int page, int rows, String aschool);

	// 1个参数
	public List<Academy> slist(int page, int rows, int aflag);

	public AcaspeBean selbean(int aid, int sid);

	public List selsname(int aid);

	public List selname();

	public void addsname(Specialty specialty);

	public int selsid();

	public void editsid(int asid, int sid);

	public int selsid(String sname);

	public List selaname();

	// 院校专业表添加值
	public void addacaspe(Acaspe a);

	public int selaid();

	public int selacaspecount();

	public List selaidbyaflag(int aflag);

	public int selacaspecount(int aid);

	public List selaidbyaschool(String aschool);

	public List selaidbyaschoolaflag(String aschool, int aflag);
	//----------------------------------------------------------会计报名
	public List selaccountantapplydata(int page,int rows,String aname,String name,String cname);
	public AccountantapplyBean selone(int aid);
	public List selallcity();
	public List selcountybycity(int cid);
	public void edit(AccountantapplyBean bean);
	public List seluser();
	public void delaccount(int aid);
	public void acountadd(AccountantapplyBean abean);
	//添加学生后自动添加一条新的缴费数据
	public void addaccountfiance(AccountantapplyBean abean);
	//----------------------------------------------------------------热门专业	
	public List selhotmajor(int page,int rows,String title);
	public Hotmajor selonehot(int hmid);
	public void delhotmajor(int hmid);
	public void hotmajoradd(Hotmajor h);
	public void edithotmajor(Hotmajor h);
	//--------------------------------------------------------------招生简章
	public List seleguide(int page,int rows,String type);
	public void addeguide(Eguide e);
	public void deleguide(int id);
	public Eguide seloneeguide(int id);
	public void edit(Eguide eg);
	//-----------------------------------------------------------共享管理
	public List selshare(int page,int rows,String type);
	public void addshare(Share share);
	public void delshare(int id);
	public Share seloneshare(int id);
	public void edit(Share share);
	//-------------------------------------------------------------联系方式
	public List selrelation(int page,int rows,String rcontent);
	public void addrelation(Relation r);
	public void delrelation(int rid);
	public Relation selonerelation(int rid);
	public void edit(Relation r);
	//-------------------------------------------------------------公告管理
	public List selnotice(int page,int rows,String ntitle);
	public void addnotice(Notice n);
	public void delnotice(int nid);
	public Notice selonernotice(int nid);
	public void edit(Notice r);
	//--------------------------------------------------------首页管理
	public List selhome(int page,int rows);
	public void addhome(Homecontent h);
	public void delhome(int hcid);
	public Homecontent selonehome(int hcid);
	public void edit(Homecontent r);
	//----------------------------------------------------------艺考报名
	public List selartapplydata(int page,int rows,String aname,String name,String cname);
	public ArtapplyBean seloneart(int aid);
	public List selallcityart();
	public List selcountybycityart(int cid);
	public void editart(ArtapplyBean bean);
	public void delart(int aid);
	public List seluserart();
	public void artadd(ArtapplyBean abean);
	//添加学生后自动添加一条新的缴费数据
	public void addartfiance(ArtapplyBean abean);
	//----------------------------------------------------------艺考报名
	public List selproapplydata(int page,int rows,String aname,String name,String cname);
	public ProapplyBean selonepro(int aid);
	public List selallcitypro();
	public List selcountybycitypro(int cid);
	public void editpro(ProapplyBean bean);
	public void delpro(int aid);
	public List seluserpro();
	public void proadd(ProapplyBean abean);
	//添加学生后自动添加一条新的缴费数据
	public void addprofiance(ProapplyBean abean);
	//----------------------------------------------------------------日志监控
		public List selsyslog(int page,int rows);
		public void addsyslog(Syslog syslog);
		public int selsyscount();
	//----------------------------------------------------------------合作老师登陆查询名下的学生信息
	public List selaccbytid(int userid);
	public List selartbytid(int userid);
	public List selprobytid(int userid);
	public List seladubytid(int userid);
	public List selstabytid(int userid);
	public List seldisbytid(int userid);
	//---------------------------------------------------------------查询每个报名的人数
	public int selcountacc();
	public int selcountart();
	public int selcountpro();
	public int selcountadu();
	public int selcountsta();
	public int selcountdis();
	public List selteancher(String name,String pwd);
	public List selsche(int userid);
	public List selhomeindex();
	public List selnotice();
	public List selHotmajor();
	public void updateuser(User user);
	public List selsharepho();
	public List seleguidelog();
	public Eguide seleguidebyid(int id);
	public void delsche(int sid);
	public void editsche(int sid);
	public void addsche(Schedule schedule);
	public int selaccount(String aname,String name,String cname);
	public List selaccountantapplydata(int page,int rows,String aname,String name,String cname,int userid);
	public String selaccname(int aid);
	public void editaccf(int sid, String aname);
	public int selartcount(String aname,String name,String cname);
	public List selartapplydata(int page,int rows,String aname,String name,String cname,int userid);
	public String selartname(int aid);
	public void editartf(int sid,String aname);
	public int selprocount(String aname,String name,String cname);
	public List selproapplydata(int page,int rows,String aname,String name,String cname,int userid);
	public String selproname(int aid);
	public void editprof(int sid,String aname);
	public List selshare();
	public List selrelation();
	public List selacclist(String aname,String name,String cname);
	public List selartlist(String aname,String name,String cname);
	public List selprolist(String aname,String name,String cname);
	//-----------修改添加
		public int selschoolid(String name);
}
