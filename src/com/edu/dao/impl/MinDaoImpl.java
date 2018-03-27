package com.edu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.edu.bean.AcaspeBean;
import com.edu.bean.AccountantapplyBean;
import com.edu.bean.ArtapplyBean;
import com.edu.bean.ProapplyBean;
import com.edu.dao.MinDao;
import com.edu.model.Academy;
import com.edu.model.Acaspe;
import com.edu.model.Accountantapply;
import com.edu.model.Accountantfinance;
import com.edu.model.Artapply;
import com.edu.model.Artfinance;
import com.edu.model.City;
import com.edu.model.County;
import com.edu.model.Eguide;
import com.edu.model.Homecontent;
import com.edu.model.Hotmajor;
import com.edu.model.Notice;
import com.edu.model.Organization;
import com.edu.model.Professionapply;
import com.edu.model.Professionfinance;
import com.edu.model.Relation;
import com.edu.model.Schedule;
import com.edu.model.Share;
import com.edu.model.Specialty;
import com.edu.model.Syslog;
import com.edu.model.User;
import com.edu.service.impl.MinServiceImpl;

public class MinDaoImpl implements MinDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<Organization> seldata(int pag, int row) {
		try {
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List list2 = session.createQuery("from Organization").setFirstResult((pag - 1) * row)
							.setMaxResults(row).list();
					return list2;
				}
			});
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int selline() {
		// System.out.println("456!");
		// TODO Auto-generated method stub
		Long count = (Long) hibernateTemplate.find("select count(*) from Organization").listIterator().next();
		// System.out.println(count.intValue());
		return count.intValue();
	}

	// ----------------------------------------------------------专业管理
	@Override
	public List<Academy> list(int page, int rows) {
		try {
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List list2 = session
							.createQuery(
									"from Academy a inner join a.acaspes c inner join c.specialty order by a.aid asc")
							.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
					return list2;
				}
			});
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public int count() {
		Long count = (Long) hibernateTemplate.find("select count(*) from Academy").listIterator().next();
		return count.intValue();
	}

	@Override
	public void add(Academy academy) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(academy);
	}

	@Override
	public void del(int id) {
		// TODO Auto-generated method stub
		Acaspe a = hibernateTemplate.get(Acaspe.class, id);
		hibernateTemplate.delete(a);
	}

	@Override
	public void edit(Academy academy) {
		Academy a = hibernateTemplate.get(Academy.class, academy.getAid());
		a.setAflag(academy.getAflag());
		a.setAschool(academy.getAschool());
		hibernateTemplate.update(a);
	}

	@Override
	public List<Academy> slist(int page, int rows, String aschool, int aflag) {

		try {
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query q = session.createQuery(
							"from Academy a inner join a.acaspes c inner join c.specialty s where a.aschool like ? and aflag = ?")
							.setFirstResult((page - 1) * rows).setMaxResults(rows);
					q.setString(0, aschool + "%");
					q.setInteger(1, aflag);
					List list2 = q.list();
					return list2;
				}
			});
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Academy> slist(int page, int rows, String aschool) {
		try {
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query q = session.createQuery(
							"from Academy a inner join a.acaspes c inner join c.specialty s where a.aschool like ?")
							.setFirstResult((page - 1) * rows).setMaxResults(rows);
					q.setString(0, aschool + "%");
					List list2 = q.list();
					return list2;
				}
			});
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Academy> slist(int page, int rows, int aflag) {
		try {
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query q = session
							.createQuery(
									"from Academy a inner join a.acaspes c inner join c.specialty s where a.aflag = ?")
							.setFirstResult((page - 1) * rows).setMaxResults(rows);
					q.setInteger(0, aflag);
					List list2 = q.list();
					return list2;
				}
			});
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AcaspeBean selbean(int aid, int sid) {
		// Academy a = hibernateTemplate.get(Academy.class, aid);
		// List list = hibernateTemplate.find("from Academy a inner join a.acaspes c
		// inner join c.specialty where a.aid=?",aid);
		// AcaspeBean b = (AcaspeBean)list.get(0);
		// return b;
		try {
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query q = session.createQuery(
							"from Academy a inner join a.acaspes c inner join c.specialty s where a.aid=? and s.sid=?");

					q.setInteger(0, aid);
					q.setInteger(1, sid);
					List list2 = q.list();
					return list2;
				}
			});
			Object[] o = (Object[]) list.get(0);
			Academy a = (Academy) o[0];
			Acaspe c = (Acaspe) o[1];
			Specialty s = (Specialty) o[2];

			AcaspeBean b = new AcaspeBean();
			b.setAid(a.getAid());
			b.setAflag(a.getAflag());
			b.setAschool(a.getAschool());
			b.setSid(s.getSid());
			b.setSname(s.getSname());
			b.setAsid(c.getAsid());

			return b;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List selsname(int aid) {
		// TODO Auto-generated method stub
		try {
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query q = session.createQuery(
							"from Academy a inner join a.acaspes c inner join c.specialty s where a.aid=?");

					q.setInteger(0, aid);
					List list2 = q.list();
					return list2;
				}
			});

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List selname() {
		// TODO Auto-generated method stub
		List l = hibernateTemplate.find("from Specialty");
		return l;
	}

	@Override
	public void addsname(Specialty specialty) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(specialty);
	}

	@Override
	public int selsid() {
		// TODO Auto-generated method stub
		Integer count = (Integer) hibernateTemplate.find("select max(sid) from Specialty").listIterator().next();
		return count.intValue();
	}

	@Override
	public void editsid(int asid, int sid) {
		// TODO Auto-generated method stub
		Acaspe a = hibernateTemplate.get(Acaspe.class, asid);
		a.setSid(sid);
		hibernateTemplate.update(a);
	}

	@Override
	public int selsid(String sname) {
		try {
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query q = session.createQuery("from Specialty where sname =?");
					q.setString(0, sname);
					List list2 = q.list();
					return list2;
				}
			});
			Specialty s = (Specialty) list.get(0);

			return s.getSid();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List selaname() {
		// TODO Auto-generated method stub
		List list = hibernateTemplate.find("from Academy");
		List list2 = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Academy a = (Academy) list.get(i);
			list2.add(a.getAschool());
		}
		return list2;
	}

	@Override
	public void addacaspe(Acaspe a) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(a);
	}

	@Override
	public int selaid() {
		Integer count = (Integer) hibernateTemplate.find("select max(aid) from Academy").listIterator().next();
		return count;
	}

	@Override
	public int selacaspecount() {
		Long count = (Long) hibernateTemplate.find("select count(*) from Acaspe").listIterator().next();
		// Long count = (Long)hibernateTemplate.find("select count(*) from
		// Acaspe").listIterator().next();
		return count.intValue();
	}

	@Override
	public List selaidbyaflag(int aflag) {
		List list = hibernateTemplate.find("from Academy where aflag =?", aflag);
		List l = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Academy a = (Academy) list.get(i);
			l.add(a.getAid());
		}
		return l;
	}

	@Override
	public int selacaspecount(int aid) {
		Long count = (Long) hibernateTemplate.find("select count(*) from Acaspe where acid=?", aid).listIterator()
				.next();
		return count.intValue();
	}

	@Override
	public List selaidbyaschool(String aschool) {
		try {
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query q = session.createQuery("from Academy where aschool like ?");
					q.setString(0, aschool + "%");
					List list2 = q.list();
					return list2;
				}
			});

			List l = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				Academy a = (Academy) list.get(i);
				l.add(a.getAid());
			}

			return l;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List selaidbyaschoolaflag(String aschool, int aflag) {
		try {
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query q = session.createQuery("from Academy where aschool like ? and aflag=?");
					q.setString(0, aschool + "%");
					q.setInteger(1, aflag);
					List list2 = q.list();
					return list2;
				}
			});

			List l = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				Academy a = (Academy) list.get(i);
				l.add(a.getAid());
			}

			return l;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// -------------------------------------------------------------------------会计报名
	@Override
	public List selaccountantapplydata(int page, int rows, String aname, String name, String cname) {
		String a = aname;
		String b = name;
		String c = cname;
		String sql = "from Accountantapply a inner join a.user u inner join a.city c inner join a.county co where 1=1 ";
		if (!a.equals("")) {
			sql += " and a.aname like '%" + aname + "%'";
		}
		if (!b.equals("")) {
			sql += " and u.name like '%" + name + "%'";
		}
		if (!c.equals("")) {
			sql += " and c.cname=" + "'" + cname + "'" + "";
		}
		try {
			String s = sql+" order by a.aid asc";
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List list2 = session.createQuery(s).setFirstResult((page - 1) * rows).setMaxResults(rows).list();
					return list2;
				}
			});
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AccountantapplyBean selone(int aid) {
		System.out.println("进来了");
		AccountantapplyBean bean = null;
		List l = hibernateTemplate.find(
				"from Accountantapply a inner join a.user inner join a.city inner join a.county where a.aid=?", aid);
		for (int i = 0; i < l.size(); i++) {
			Object[] o = (Object[]) l.get(i);
			Accountantapply a = (Accountantapply) o[0];
			User u = (User) o[1];
			City c = (City) o[2];
			County co = (County) o[3];

			bean = new AccountantapplyBean();
			bean.setAcontent(a.getAcontent());
			bean.setAdata(a.getAdata());
			bean.setAid(a.getAid());
			bean.setAname(a.getAname());
			bean.setAphone(a.getAphone());
			bean.setAstudentno(a.getAstudentno());
			bean.setCid(c.getCid());
			bean.setCname(c.getCname());
			bean.setCoid(co.getCoid());
			bean.setId(u.getId());
			bean.setConame(co.getConame());
			bean.setName(u.getName());
		}
		return bean;
	}

	@Override
	public List selallcity() {
		List l = hibernateTemplate.find("from City");
		return l;
	}

	@Override
	public List selcountybycity(int cid) {
		List l = hibernateTemplate.find("from County  where cid=?", cid);
		return l;
	}

	@Override
	public void edit(AccountantapplyBean bean) {
		Accountantapply a = hibernateTemplate.get(Accountantapply.class, bean.getAid());
		a.setAcontent(bean.getAcontent());
		a.setAdata(bean.getAdata());
		a.setAid(bean.getAid());
		a.setAname(bean.getAname());
		a.setAphone(bean.getAphone());
		a.setAstudentno(bean.getAstudentno());
		a.setCityid(bean.getCid());
		a.setCountyid(bean.getCoid());
		a.setUserid(bean.getId());
		hibernateTemplate.update(a);
	}

	@Override
	public List seluser() {
		List list = hibernateTemplate.find("from User");
		return list;
	}

	@Override
	public void acountadd(AccountantapplyBean abean) {
		// TODO Auto-generated method stub
		Accountantapply a = new Accountantapply();
		a.setAcontent(abean.getAcontent());
		a.setAdata(abean.getAdata());
		a.setUserid(abean.getId());
		a.setAname(abean.getAname());
		a.setAphone(abean.getAphone());
		a.setAstudentno(abean.getAstudentno());
		a.setCityid(abean.getCid());
		a.setCountyid(abean.getCoid());
		hibernateTemplate.save(a);
	}

	// ------------------------------------------------------热门专业
	@Override
	public List selhotmajor(int page, int rows, String title) {
		String a = title;

		String sql = "from Hotmajor a where 1=1 ";
		if (!a.equals("")) {
			sql += " and a.hmtitle like '%" + title + "%'";
		}
		try {
			String s = sql;
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List list2 = session.createQuery(s).setFirstResult((page - 1) * rows).setMaxResults(rows).list();
					return list2;
				}
			});
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Hotmajor selonehot(int hmid) {
		List l = hibernateTemplate.find("from Hotmajor where hmid=?", hmid);
		Hotmajor h = new Hotmajor();
		for (int i = 0; i < l.size(); i++) {
			Hotmajor m = (Hotmajor) l.get(i);
			h.setHmcontent(m.getHmcontent());
			h.setHmtitle(m.getHmtitle());
			h.setHmpicture(m.getHmpicture());
			h.setHmid(m.getHmid());
		}
		return h;
	}

	@Override
	public void delhotmajor(int hmid) {
		// TODO Auto-generated method stub
		Hotmajor h = hibernateTemplate.get(Hotmajor.class, hmid);
		hibernateTemplate.delete(h);
	}

	@Override
	public void hotmajoradd(Hotmajor h) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(h);
	}

	@Override
	public void edithotmajor(Hotmajor h) {
		Hotmajor c = hibernateTemplate.get(Hotmajor.class, h.getHmid());
		c.setHmid(h.getHmid());
		c.setHmcontent(h.getHmcontent());
		c.setHmpicture(h.getHmpicture());
		c.setHmtitle(h.getHmtitle());
		hibernateTemplate.update(c);
	}

	// -------------------------------------------------------招生简章
	@Override
	public List seleguide(int page, int rows, String type) {
		String a = type;

		String sql = "from Eguide e where 1=1 ";
		if (!a.equals("")) {
			sql += " and e.type like '%" + type + "%'";
		}
		try {
			String s = sql;
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List list2 = session.createQuery(s).setFirstResult((page - 1) * rows).setMaxResults(rows).list();
					return list2;
				}
			});
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addeguide(Eguide eg) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(eg);
	}

	@Override
	public void deleguide(int id) {
		// TODO Auto-generated method stub
		Eguide e = hibernateTemplate.get(Eguide.class, id);
		hibernateTemplate.delete(e);
	}

	@Override
	public Eguide seloneeguide(int id) {
		List l = hibernateTemplate.find("from Eguide e where e.id=?", id);
		Eguide e = new Eguide();
		for (int i = 0; i < l.size(); i++) {
			Eguide g = (Eguide) l.get(i);
			e.setId(g.getId());
			e.setLog(g.getLog());
			e.setPicture1(g.getPicture1());
			e.setPicture2(g.getPicture2());
			e.setPicture3(g.getPicture3());
			e.setSchool(g.getSchool());
			e.setTitle(g.getTitle());
			e.setType(g.getType());
		}
		return e;
	}

	@Override
	public void edit(Eguide eg) {
		Eguide e = hibernateTemplate.get(Eguide.class, eg.getId());
		Eguide g = new Eguide();
		g.setId(eg.getId());
		g.setLog(eg.getLog());
		g.setPicture1(eg.getPicture1());
		g.setPicture2(eg.getPicture2());
		g.setPicture3(eg.getPicture3());
		g.setSchool(eg.getSchool());
		g.setTitle(eg.getTitle());
		g.setType(eg.getType());
		hibernateTemplate.update(g);
	}

	// -----------------------------------------------------------共享管理
	@Override
	public List selshare(int page, int rows, String type) {
		String a = type;

		String sql = "from Share e where 1=1 ";
		if (!a.equals("")) {
			sql += " and e.sharetitle like '%" + type + "%'";
		}
		try {
			String s = sql;
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List list2 = session.createQuery(s).setFirstResult((page - 1) * rows).setMaxResults(rows).list();
					return list2;
				}
			});
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addshare(Share share) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(share);
	}

	@Override
	public void delshare(int id) {
		// TODO Auto-generated method stub
		Share s = hibernateTemplate.get(Share.class, id);
		hibernateTemplate.delete(s);
	}

	@Override
	public Share seloneshare(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Share.class, id);
	}

	@Override
	public void edit(Share share) {
		// TODO Auto-generated method stub
		Share s = hibernateTemplate.get(Share.class, share.getShareid());
		s.setSharecontent(share.getSharecontent());
		s.setSharephoto(share.getSharephoto());
		s.setSharepicture(share.getSharepicture());
		s.setSharetitle(share.getSharetitle());
		hibernateTemplate.update(s);
	}

	@Override
	public List selrelation(int page, int rows, String rcontent) {
		String a = rcontent;

		String sql = "from Relation r where 1=1 ";
		if (!a.equals("")) {
			sql += " and r.rcontent like '%" + rcontent + "%'";
		}
		try {
			String s = sql;
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List list2 = session.createQuery(s).setFirstResult((page - 1) * rows).setMaxResults(rows).list();
					return list2;
				}
			});
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addrelation(Relation r) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(r);
	}

	@Override
	public void delrelation(int rid) {
		// TODO Auto-generated method stub
		Relation r = hibernateTemplate.get(Relation.class, rid);
		hibernateTemplate.delete(r);
	}

	@Override
	public Relation selonerelation(int rid) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Relation.class, rid);
	}

	@Override
	public void edit(Relation r) {
		// TODO Auto-generated method stub
		Relation re = hibernateTemplate.get(Relation.class, r.getRid());
		re.setRcontent(r.getRcontent());
		re.setReffect(r.getReffect());
		re.setRid(r.getRid());
		re.setRphone(r.getRphone());
		re.setRqq(r.getRqq());
		hibernateTemplate.update(re);
	}

	@Override
	public List selnotice(int page, int rows, String ntitle) {
		String a = ntitle;

		String sql = "from Notice e where 1=1 ";
		if (!a.equals("")) {
			sql += " and e.ntitle like '%" + ntitle + "%'";
		}
		try {
			String s = sql;
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List list2 = session.createQuery(s).setFirstResult((page - 1) * rows).setMaxResults(rows).list();
					return list2;
				}
			});
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addnotice(Notice n) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(n);
	}

	@Override
	public void delnotice(int nid) {
		// TODO Auto-generated method stub
		Notice n = hibernateTemplate.get(Notice.class, nid);
		hibernateTemplate.delete(n);
	}

	@Override
	public Notice selonernotice(int nid) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Notice.class, nid);
	}

	@Override
	public void edit(Notice r) {
		// TODO Auto-generated method stub
		Notice n = hibernateTemplate.get(Notice.class, r.getNid());
		n.setNcontent(r.getNcontent());
		n.setNdate(r.getNdate());
		n.setNflag(r.getNflag());
		n.setNid(r.getNid());
		n.setNtitle(r.getNtitle());
		hibernateTemplate.update(n);
	}

	@Override
	public List selhome(int page, int rows) {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Homecontent");
	}

	@Override
	public void addhome(Homecontent h) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(h);
	}

	@Override
	public void delhome(int hcid) {
		// TODO Auto-generated method stub
		Homecontent h = hibernateTemplate.get(Homecontent.class, hcid);
		hibernateTemplate.delete(h);
	}

	@Override
	public Homecontent selonehome(int hcid) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Homecontent.class, hcid);
	}

	@Override
	public void edit(Homecontent r) {
		// TODO Auto-generated method stub
		Homecontent h = hibernateTemplate.get(Homecontent.class, r.getHcid());
		h.setHcaddress(r.getHcaddress());
		h.setHcid(r.getHcid());
		h.setHcphone(r.getHcphone());
		h.setInterlinkagefour(r.getInterlinkagefour());
		h.setInterlinkageone(r.getInterlinkageone());
		h.setInterlinkagethree(r.getInterlinkagethree());
		h.setInterlinkagetwo(r.getInterlinkagetwo());
		h.setPictureone(r.getPictureone());
		h.setPicturethree(r.getPicturethree());
		h.setPicturetwo(r.getPicturetwo());
		h.setQrcodeone(r.getQrcodeone());
		h.setQrcodetwo(r.getQrcodetwo());
		hibernateTemplate.update(h);
	}

	@Override
	public void addaccountfiance(AccountantapplyBean abean) {
		// TODO Auto-generated method stub
		Accountantfinance a = new Accountantfinance();
		a.setSid(Integer.parseInt(abean.getAstudentno()));
		a.setSname(abean.getAname());
		a.setTid(abean.getId());
		a.setFstatu(0);
		a.setNeedmoney(6000);
		a.setPracticalmoney(0);
		hibernateTemplate.save(a);
	}

	@Override
	public void delaccount(int aid) {
		// TODO Auto-generated method stub
		Accountantapply a = hibernateTemplate.get(Accountantapply.class, aid);
		hibernateTemplate.delete(a);
	}

	@Override
	public List selartapplydata(int page, int rows, String aname, String name, String cname) {
		String a = aname;
		String b = name;
		String c = cname;
		String sql = "from Artapply a inner join a.user u inner join a.city c inner join a.county co where 1=1 ";
		if (!a.equals("")) {
			sql += " and a.aname like '%" + aname + "%'";
		}
		if (!b.equals("")) {
			sql += " and u.name like '%" + name + "%'";
		}
		if (!c.equals("")) {
			sql += " and c.cname=" + "'" + cname + "'" + "";
		}
		try {
			String s = sql+" order by a.aid asc";
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List list2 = session.createQuery(s).setFirstResult((page - 1) * rows).setMaxResults(rows).list();
					return list2;
				}
			});
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArtapplyBean seloneart(int aid) {
		System.out.println("进来了");
		ArtapplyBean bean = null;
		List l = hibernateTemplate
				.find("from Artapply a inner join a.user inner join a.city inner join a.county where a.aid=?", aid);
		for (int i = 0; i < l.size(); i++) {
			Object[] o = (Object[]) l.get(i);
			Artapply a = (Artapply) o[0];
			User u = (User) o[1];
			City c = (City) o[2];
			County co = (County) o[3];

			bean = new ArtapplyBean();
			bean.setAcontent(a.getAcontent());
			bean.setAdata(a.getAdata());
			bean.setAid(a.getAid());
			bean.setAname(a.getAname());
			bean.setAphone(a.getAphone());
			bean.setAstudentno(a.getAstudentno());
			bean.setCid(c.getCid());
			bean.setCname(c.getCname());
			bean.setCoid(co.getCoid());
			bean.setId(u.getId());
			bean.setConame(co.getConame());
			bean.setName(u.getName());
		}
		return bean;
	}

	@Override
	public List selallcityart() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from City");
	}

	@Override
	public List selcountybycityart(int cid) {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from County  where cid=?", cid);
	}

	@Override
	public void editart(ArtapplyBean bean) {
		Artapply a = hibernateTemplate.get(Artapply.class, bean.getAid());
		a.setAcontent(bean.getAcontent());
		a.setAdata(bean.getAdata());
		a.setAid(bean.getAid());
		a.setAname(bean.getAname());
		a.setAphone(bean.getAphone());
		a.setAstudentno(bean.getAstudentno());
		a.setCityid(bean.getCid());
		a.setCountyid(bean.getCoid());
		a.setUserid(bean.getId());
		hibernateTemplate.update(a);
	}

	@Override
	public void delart(int aid) {
		// TODO Auto-generated method stub
		Artapply a = hibernateTemplate.get(Artapply.class, aid);
		hibernateTemplate.delete(a);
	}

	@Override
	public List seluserart() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from User");
	}

	@Override
	public void artadd(ArtapplyBean abean) {
		Artapply a = new Artapply();
		a.setAcontent(abean.getAcontent());
		a.setAdata(abean.getAdata());
		a.setUserid(abean.getId());
		a.setAname(abean.getAname());
		a.setAphone(abean.getAphone());
		a.setAstudentno(abean.getAstudentno());
		a.setCityid(abean.getCid());
		a.setCountyid(abean.getCoid());
		hibernateTemplate.save(a);
	}

	@Override
	public void addartfiance(ArtapplyBean abean) {
		// TODO Auto-generated method stub
		Artfinance a = new Artfinance();
		a.setSid(Integer.parseInt(abean.getAstudentno()));
		a.setSname(abean.getAname());
		a.setTid(abean.getId());
		a.setFstatu(0);
		a.setNeedmoney(8000);
		a.setPracticalmoney(0);
		hibernateTemplate.save(a);
	}

	@Override
	public List selproapplydata(int page, int rows, String aname, String name, String cname) {
		String a = aname;
		String b = name;
		String c = cname;
		String sql = "from Professionapply a inner join a.user u inner join a.city c inner join a.county co where 1=1 ";
		if (!a.equals("")) {
			sql += " and a.pname like '%" + aname + "%'";
		}
		if (!b.equals("")) {
			sql += " and u.name like '%" + name + "%'";
		}
		if (!c.equals("")) {
			sql += " and c.cname=" + "'" + cname + "'" + "";
		}
		try {
			String s = sql+" order by a.pid asc";
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List list2 = session.createQuery(s).setFirstResult((page - 1) * rows).setMaxResults(rows).list();
					return list2;
				}
			});
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProapplyBean selonepro(int aid) {
		System.out.println("进来了");
		ProapplyBean bean = null;
		List l = hibernateTemplate.find(
				"from Professionapply a inner join a.user inner join a.city inner join a.county where a.pid=?", aid);
		for (int i = 0; i < l.size(); i++) {
			Object[] o = (Object[]) l.get(i);
			Professionapply a = (Professionapply) o[0];
			User u = (User) o[1];
			City c = (City) o[2];
			County co = (County) o[3];

			bean = new ProapplyBean();
			bean.setAcontent(a.getPcontent());
			bean.setAdata(a.getPdata());
			bean.setAid(a.getPid());
			bean.setAname(a.getPname());
			bean.setAphone(a.getPphone());
			bean.setAstudentno(a.getPstudentno());
			bean.setCid(c.getCid());
			bean.setCname(c.getCname());
			bean.setCoid(co.getCoid());
			bean.setId(u.getId());
			bean.setConame(co.getConame());
			bean.setName(u.getName());
		}
		return bean;
	}

	@Override
	public List selallcitypro() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from City");
	}

	@Override
	public List selcountybycitypro(int cid) {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from County  where cid=?", cid);
	}

	@Override
	public void editpro(ProapplyBean bean) {
		Professionapply a = hibernateTemplate.get(Professionapply.class, bean.getAid());
		a.setPcontent(bean.getAcontent());
		a.setPdata(bean.getAdata());
		a.setPid(bean.getAid());
		a.setPname(bean.getAname());
		a.setPphone(bean.getAphone());
		a.setPstudentno(bean.getAstudentno());
		a.setCityid(bean.getCid());
		a.setCountyid(bean.getCoid());
		a.setUserid(bean.getId());
		hibernateTemplate.update(a);
	}

	@Override
	public void delpro(int aid) {
		Professionapply a = hibernateTemplate.get(Professionapply.class, aid);
		hibernateTemplate.delete(a);
	}

	@Override
	public List seluserpro() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from User");
	}

	@Override
	public void proadd(ProapplyBean abean) {
		Professionapply a = new Professionapply();
		a.setPcontent(abean.getAcontent());
		a.setPdata(abean.getAdata());
		a.setUserid(abean.getId());
		a.setPname(abean.getAname());
		a.setPphone(abean.getAphone());
		a.setPstudentno(abean.getAstudentno());
		a.setCityid(abean.getCid());
		a.setCountyid(abean.getCoid());
		hibernateTemplate.save(a);
	}

	@Override
	public void addprofiance(ProapplyBean abean) {
		Professionfinance a = new Professionfinance();
		a.setSid(Integer.parseInt(abean.getAstudentno()));
		a.setSname(abean.getAname());
		a.setTid(abean.getId());
		a.setFstatu(0);
		a.setNeedmoney(10000);
		a.setPracticalmoney(0);
		hibernateTemplate.save(a);
	}

	@Override
	public List selsyslog(int page, int rows) {
		try {
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List list2 = session.createQuery("from Syslog").setFirstResult((page - 1) * rows)
							.setMaxResults(rows).list();
					return list2;
				}
			});
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public void addsyslog(Syslog syslog) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(syslog);
	}

	@Override
	public List selaccbytid(int userid) {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Accountantfinance where tid=?", userid);
	}

	@Override
	public List selartbytid(int userid) {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Artfinance where tid=?", userid);
	}

	@Override
	public List selprobytid(int userid) {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Professionfinance where tid=?", userid);
	}

	@Override
	public List seladubytid(int userid) {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Adultfinance where tid=?", userid);
	}

	@Override
	public List selstabytid(int userid) {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from  Statefinance where tid=?", userid);
	}

	@Override
	public List seldisbytid(int userid) {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from  Distancefinance where tid=?", userid);
	}

	@Override
	public int selcountacc() {
		Long count = (Long) hibernateTemplate.find("select count(*) from Accountantapply").listIterator().next();
		return count.intValue();
	}

	@Override
	public int selcountart() {
		Long count = (Long) hibernateTemplate.find("select count(*) from Artapply").listIterator().next();
		return count.intValue();
	}

	@Override
	public int selcountpro() {
		Long count = (Long) hibernateTemplate.find("select count(*) from Professionapply").listIterator().next();
		return count.intValue();
	}

	@Override
	public int selcountadu() {
		Long count = (Long) hibernateTemplate.find("select count(*) from Adultapply").listIterator().next();
		return count.intValue();
	}

	@Override
	public int selcountsta() {
		Long count = (Long) hibernateTemplate.find("select count(*) from Stateapply").listIterator().next();
		return count.intValue();
	}

	@Override
	public int selcountdis() {
		Long count = (Long) hibernateTemplate.find("select count(*) from Distanceapply").listIterator().next();
		return count.intValue();
	}

	@Override
	public List selteancher(String name, String pwd) {
		try {
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query q = session.createQuery("from User where loginname=? and password=?");
					q.setString(0, name);
					q.setString(1, pwd);
					List list2 = q.list();
					return list2;
				}
			});
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List selsche(int userid) {
		return hibernateTemplate.find("from Schedule where userid=?", userid);
	}

	@Override
	public List selhomeindex() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Homecontent");
	}

	@Override
	public List selnotice() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Notice");
	}

	@Override
	public List selHotmajor() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Hotmajor");
	}

	@Override
	public int selsyscount() {
		Long count = (Long) hibernateTemplate.find("select count(*) from Syslog").listIterator().next();
		return count.intValue();
	}

	@Override
	public void updateuser(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(user);
	}

	@Override
	public List selsharepho() {
		List l = hibernateTemplate.find("from Share");
		return l;
	}

	@Override
	public List seleguidelog() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Eguide");
	}

	@Override
	public Eguide seleguidebyid(int id) {
		List l = hibernateTemplate.find("from Eguide where id=?",id);
		Eguide e = new Eguide();
		for(int i=0;i<l.size();i++) {
			 Eguide g =(Eguide) l.get(i);
			 e.setId(g.getId());
			 e.setLog(g.getLog());
			 e.setPicture1(g.getPicture1());
			 e.setPicture2(g.getPicture2());
			 e.setPicture3(g.getPicture3());
			 e.setSchool(g.getSchool());
			 e.setTitle(g.getTitle());
			 e.setType(g.getType());
		}
		return e;
	}

	@Override
	public void delsche(int sid) {
		// TODO Auto-generated method stub
		List l = hibernateTemplate.find("from Schedule where sid=?",sid);
		Schedule s = new Schedule();
		for(int i=0;i<l.size();i++) {
			Schedule c = (Schedule)l.get(i);
			s.setScontent(c.getScontent());
			s.setSdate(c.getSdate());
			s.setSfinishdate(c.getSfinishdate());
			s.setSflag(c.getSflag());
			s.setSid(c.getSid());
			s.setStitle(c.getStitle());
			s.setUser(c.getUser());
			s.setUserid(c.getUserid());
		}
		hibernateTemplate.delete(s);
	}

	@Override
	public void editsche(int sid) {
		// TODO Auto-generated method stub
		List l = hibernateTemplate.find("from Schedule where sid=?",sid);
		Schedule s = new Schedule();
		for(int i=0;i<l.size();i++) {
			Schedule c = (Schedule)l.get(i);
			s.setScontent(c.getScontent());
			s.setSdate(c.getSdate());
			s.setSfinishdate(new Date().toLocaleString());//修改完成时间
			s.setSflag(1);//修改为已完成
			s.setSid(c.getSid());
			s.setStitle(c.getStitle());
			s.setUser(c.getUser());
			s.setUserid(c.getUserid());
		}
		hibernateTemplate.update(s);
	}

	@Override
	public void addsche(Schedule schedule) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(schedule);
	}

	@Override
	public int selaccount(String aname,String name,String cname) {
		String sql = "select count(*) from Accountantapply a inner join a.user u inner join a.city c inner join a.county co where 1=1 ";
		if(!aname.equals("")) {
			sql += " and a.aname like '%" + aname + "%'";
		}
		if(!name.equals("")) {
			sql += " and u.name like '%" + name + "%'";
		}
		if(!cname.equals("")) {
			sql += " and c.cname=" + "'" + cname + "'" + "";
		}
		Long count = (Long) hibernateTemplate.find(sql).listIterator().next();
		return count.intValue();
	}

	@Override
	public List selaccountantapplydata(int page, int rows, String aname, String name, String cname, int userid) {
		String a = aname;
		String b = name;
		String c = cname;
		String sql = "from Accountantapply a inner join a.user u inner join a.city c inner join a.county co where 1=1 ";
		if (!a.equals("")) {
			sql += " and a.aname like '%" + aname + "%'";
		}
		if (!b.equals("")) {
			sql += " and u.name like '%" + name + "%'";
		}
		if (!c.equals("")) {
			sql += " and c.cname=" + "'" + cname + "'" + "";
		}
		try {
			String s = sql+" and a.userid="+userid+" order by a.aid asc";
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List list2 = session.createQuery(s).setFirstResult((page - 1) * rows).setMaxResults(rows).list();
					return list2;
				}
			});
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String selaccname(int aid) {
		List l = hibernateTemplate.find("from Accountantapply a where a.aid=?",aid);
		Accountantapply a =(Accountantapply) l.get(0);
		return a.getAname();
	}

	@Override
	public void editaccf(int sid, String aname) {
		// TODO Auto-generated method stub
		List l = hibernateTemplate.find("from Accountantfinance where sid=?",sid);
		Accountantfinance a =(Accountantfinance) l.get(0);
		a.setSname(aname);
		hibernateTemplate.update(a);
	}

	@Override
	public int selartcount(String aname, String name, String cname) {
		String sql = "select count(*) from Artapply a inner join a.user u inner join a.city c inner join a.county co where 1=1 ";
		if (!aname.equals("")) {
			sql += " and a.aname like '%" + aname + "%'";
		}
		if (!name.equals("")) {
			sql += " and u.name like '%" + name + "%'";
		}
		if (!cname.equals("")) {
			sql += " and c.cname=" + "'" + cname + "'" + "";
		}
		Long count = (Long) hibernateTemplate.find(sql).listIterator().next();
		return count.intValue();
	}

	@Override
	public List selartapplydata(int page, int rows, String aname, String name, String cname, int userid) {
		String a = aname;
		String b = name;
		String c = cname;
		String sql = "from Artapply a inner join a.user u inner join a.city c inner join a.county co where 1=1 ";
		if (!a.equals("")) {
			sql += " and a.aname like '%" + aname + "%'";
		}
		if (!b.equals("")) {
			sql += " and u.name like '%" + name + "%'";
		}
		if (!c.equals("")) {
			sql += " and c.cname=" + "'" + cname + "'" + "";
		}
		try {
			String s = sql+" and a.userid="+userid+" order by a.aid asc";
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List list2 = session.createQuery(s).setFirstResult((page - 1) * rows).setMaxResults(rows).list();
					return list2;
				}
			});
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String selartname(int aid) {
		List l = hibernateTemplate.find("from Artapply a where a.aid=?",aid);
		Artapply a =(Artapply) l.get(0);
		return a.getAname();
	}

	@Override
	public void editartf(int sid, String aname) {
		List l = hibernateTemplate.find("from Artfinance where sid=?",sid);
		Artfinance a =(Artfinance) l.get(0);
		a.setSname(aname);
		hibernateTemplate.update(a);
	}

	@Override
	public int selprocount(String aname,String name,String cname) {
		String sql="select count(*) from Professionapply a inner join a.user u inner join a.city c inner join a.county co where 1=1 ";
		if (!aname.equals("")) {
			sql += " and a.pname like '%" + aname + "%'";
		}
		if (!name.equals("")) {
			sql += " and u.name like '%" + name + "%'";
		}
		if (!cname.equals("")) {
			sql += " and c.cname=" + "'" + cname + "'" + "";
		}
		Long count = (Long) hibernateTemplate.find(sql).listIterator().next();
		return count.intValue();
	}

	@Override
	public List selproapplydata(int page, int rows, String aname, String name, String cname, int userid) {
		String a = aname;
		String b = name;
		String c = cname;
		String sql = "from Professionapply a inner join a.user u inner join a.city c inner join a.county co where 1=1 ";
		if (!a.equals("")) {
			sql += " and a.pname like '%" + aname + "%'";
		}
		if (!b.equals("")) {
			sql += " and u.name like '%" + name + "%'";
		}
		if (!c.equals("")) {
			sql += " and c.cname=" + "'" + cname + "'" + "";
		}
		try {
			String s = sql+" and a.userid="+userid+" order by a.pid asc";
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List list2 = session.createQuery(s).setFirstResult((page - 1) * rows).setMaxResults(rows).list();
					return list2;
				}
			});
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String selproname(int aid) {
		List l = hibernateTemplate.find("from Professionapply a where a.pid=?",aid);
		Professionapply a =(Professionapply) l.get(0);
		return a.getPname();
	}

	@Override
	public void editprof(int sid, String aname) {
		List l = hibernateTemplate.find("from Professionfinance where sid=?",sid);
		Professionfinance a =(Professionfinance) l.get(0);
		a.setSname(aname);
		hibernateTemplate.update(a);
	}

	@Override
	public List selshare() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Share");
	}

	@Override
	public List selrelation() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Relation");
	}

	@Override
	public List selacclist(String aname, String name, String cname) {
		String sql = "from Accountantapply a inner join a.user u inner join a.city c inner join a.county co where 1=1 ";
		if (!aname.equals("")) {
			sql += " and a.aname like '%" + aname + "%'";
		}
		if (!name.equals("")) {
			sql += " and u.name like '%" + name + "%'";
		}
		if (!cname.equals("")) {
			sql += " and c.cname=" + "'" + cname + "'" + "";
		}
		try {
			String s = sql;
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List list2 = session.createQuery(s).list();
					return list2;
				}
			});
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List selartlist(String aname, String name, String cname) {
		String sql = "from Artapply a inner join a.user u inner join a.city c inner join a.county co where 1=1 ";
		if (!aname.equals("")) {
			sql += " and a.aname like '%" + aname + "%'";
		}
		if (!name.equals("")) {
			sql += " and u.name like '%" + name + "%'";
		}
		if (!cname.equals("")) {
			sql += " and c.cname=" + "'" + cname + "'" + "";
		}
		try {
			String s = sql;
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List list2 = session.createQuery(s).list();
					return list2;
				}
			});
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List selprolist(String aname, String name, String cname) {
		String sql = "from Professionapply a inner join a.user u inner join a.city c inner join a.county co where 1=1 ";
		if (!aname.equals("")) {
			sql += " and a.pname like '%" + aname + "%'";
		}
		if (!name.equals("")) {
			sql += " and u.name like '%" + name + "%'";
		}
		if (!cname.equals("")) {
			sql += " and c.cname=" + "'" + cname + "'" + "";
		}
		try {
			String s = sql;
			List list = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List list2 = session.createQuery(s).list();
					return list2;
				}
			});
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//----------------------------------修改
	@Override
	public int selschoolid(String name) {
		List l = hibernateTemplate.find("from Academy a where a.aschool=?",name);
		Academy a =(Academy) l.get(0);
		return a.getAid();
	}


}
