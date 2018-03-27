package com.edu.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.edu.bean.AcaspeBean;
import com.edu.model.Academy;
import com.edu.model.Acaspe;
import com.edu.model.Specialty;
import com.edu.service.impl.MinServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class MajorAction extends ActionSupport {
	private int count = 0;
	private AcaspeBean acaspeBean;

	public AcaspeBean getAcaspeBean() {
		return acaspeBean;
	}

	public void setAcaspeBean(AcaspeBean acaspeBean) {
		this.acaspeBean = acaspeBean;
	}

	private Academy academy;

	public Academy getAcademy() {
		return academy;
	}

	public void setAcademy(Academy academy) {
		this.academy = academy;
	}

	private int aid;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	private MinServiceImpl minService;
	private List list = new ArrayList<>();
	private List list2 = new ArrayList<>();



	public MinServiceImpl getMinService() {
		return minService;
	}

	public void setMinService(MinServiceImpl minService) {
		this.minService = minService;
	}

	public String sel() {

		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		res.setCharacterEncoding("utf-8");

		// System.out.println("获取到值---"+req.getParameter("aschool"));
		// System.out.println("获取到值---"+req.getParameter("aflag"));

		int page = Integer.parseInt(req.getParameter("page"));
		int rows = Integer.parseInt(req.getParameter("rows"));

		String aschool = req.getParameter("aschool");
		String af = req.getParameter("aflag");

		int aflag = -1;
		if (!af.equals("x")) {
			aflag = Integer.parseInt(af);
		}
		// int aflag = Integer.parseInt(req.getParameter("aflag"));

		if (!aschool.equals("")) {
			if (aflag != -1) {
				System.out.println("---1");
				list = minService.slist(page, rows, aschool, aflag);
				// 根据学校名和标志查询aid
				List t = minService.selaidbyaschoolaflag(aschool, aflag);
				for (int i = 0; i < t.size(); i++) {
					int id = (int) t.get(i);
					count += minService.selacaspecount(id);
				}
			} else {
				System.out.println("---2");
				list = minService.slist(page, rows, aschool);
				// 根据学校名查aid再查acaspe条数
				List st = minService.selaidbyaschool(aschool);
				for (int i = 0; i < st.size(); i++) {
					int aid = (int) st.get(i);
					count += minService.selacaspecount(aid);
				}
			}
		} else {
			if (aflag != -1) {
				System.out.println("---3");
				list = minService.slist(page, rows, aflag);
				// 查询标志为aflag的学院id再查询acaspe表符合的数据条数
				List l = minService.selaidbyaflag(aflag);
				for (int i = 0; i < l.size(); i++) {
					int se = (int) l.get(i);
					count += minService.selacaspecount(se);
				}
				System.out.println("count=" + count);
			} else {
				System.out.println("---4");
				list = minService.list(page, rows);
				// 查询acaspe表数据条数
				count = minService.selacaspecount();
				System.out.println("count=" + count);
				System.out.println(list.size());
			}
		}

		for (int i = 0; i < list.size(); i++) {
			Object[] o = (Object[]) list.get(i);
			Academy a = (Academy) o[0];
			Acaspe c = (Acaspe) o[1];
			Specialty s = (Specialty) o[2];

			AcaspeBean bean = new AcaspeBean();
			bean.setAflag(a.getAflag());
			bean.setAmajor(a.getAmajor());
			bean.setAschool(a.getAschool());
			bean.setSname(s.getSname());
			bean.setSort(s.getSort());
			bean.setAid(a.getAid());
			bean.setSid(s.getSid());
			bean.setAsid(c.getAsid());

			list2.add(bean);
		}

		Map map = new HashMap<>();
		map.put("total", count);
		map.put("rows", list2);

		String str = JSON.toJSONString(map);
		PrintWriter pw = null;
		try {
			pw = res.getWriter();
			pw.print(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println(str);
		return null;
	}

	public String add() {
		System.out.println(acaspeBean.getAschool());
		System.out.println(acaspeBean.getAflag());
		System.out.println(acaspeBean.getSname());

		// 判断学校是否已存在
		int flag = 0;
		int c = 0;
		List l = minService.selaname();
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).equals(acaspeBean.getAschool())) {
				flag = 1;
				//根据学校的名字查询学校id
				c = minService.selschoolid(acaspeBean.getAschool());
			}
		}
		
		// 不存在
		if (flag == 0) {
			// 学校表新增数据
			Academy b = new Academy();
			b.setAschool(acaspeBean.getAschool());
			b.setAflag(acaspeBean.getAflag());
			b.setAmajor("");
			minService.add(b);
			// 查询新添加学校的aid
			int aid = minService.selaid();
			// 判断将要添加的专业是否存在
			// 判断专业表是否已存在将要修改的专业
			int nflag = 0;
			List s = minService.selname();
			for (int i = 0; i < s.size(); i++) {
				Specialty spe = (Specialty) s.get(i);
				if (spe.getSname().equals(acaspeBean.getSname())) {
					nflag = 1;
				}
			}
			// 将要修改的专业不存在
			if (nflag == 0) {
				// 专业表新增一条数据，院校专业表的专业字段修改为新添加的专业
				Specialty spe = new Specialty();
				spe.setSname(acaspeBean.getSname());
				spe.setSort(0);
				minService.addsname(spe);
				int sid = minService.selsid();
				Acaspe aca = new Acaspe();
				aca.setAcid(aid);
				aca.setSid(sid);
				minService.addacaspe(aca);
			} else {
				// 查询将要修改的专业的id修改院校专业表的专业字段
				int sid = minService.selsid(acaspeBean.getSname());
				minService.editsid(aid, sid);
			}
		} else {// 学校存在
				// 修改校名,修改标志
			Academy a = new Academy();
			a.setAid(c);
			a.setAflag(acaspeBean.getAflag());
			a.setAschool(acaspeBean.getAschool());

			minService.edit(a);

			// 查询该院校已有专业
			List list = minService.selsname(a.getAid());
			int f = 0;
			// 判断院校专业是否修改过
			for (int i = 0; i < list.size(); i++) {
				Object[] o = (Object[]) list.get(i);
				Specialty s = (Specialty) o[2];
				if (acaspeBean.getSname().equals(s.getSname())) {
					f = 1;
				}
			}
			// 修改了该专业
			if (f == 0) {
				// 判断专业表是否已存在将要修改的专业
				int nflag = 0;
				List s = minService.selname();
				for (int i = 0; i < s.size(); i++) {
					Specialty spe = (Specialty) s.get(i);
					if (spe.getSname().equals(acaspeBean.getSname())) {
						nflag = 1;
					}
				}
				// 将要修改的专业不存在
				if (nflag == 0) {
					// 专业表新增一条数据，院校专业表的专业字段修改为新添加的专业
					Specialty spe = new Specialty();
					spe.setSname(acaspeBean.getSname());
					spe.setSort(0);
					minService.addsname(spe);
					int sid = minService.selsid();
					Acaspe ac = new Acaspe();
					ac.setAcid(c);
					ac.setSid(sid);
					minService.addacaspe(ac);
				} else {
					// 查询将要修改的专业的id修改院校专业表的专业字段
					int sid = minService.selsid(acaspeBean.getSname());
					Acaspe ac = new Acaspe();
					ac.setAcid(c + 1);
					ac.setSid(sid);
					minService.addacaspe(ac);
				}
			}

		}
		return SUCCESS;
	}

	public String editsel() {
		HttpServletRequest req = ServletActionContext.getRequest();
		String id = req.getParameter("aid");
		// System.out.println(req.getParameter("aid")+" --- "+req.getParameter("sid"));
		int aid = Integer.parseInt(id);
		int sid = Integer.parseInt(req.getParameter("sid"));
		acaspeBean = minService.selbean(aid, sid);
		// System.out.println(acaspeBean.getAschool());
		// System.out.println(acaspeBean.getAid());
		return SUCCESS;
	}

	public String edit() {
		System.out.println(acaspeBean.getAid());
		System.out.println(acaspeBean.getAschool());
		System.out.println(acaspeBean.getAflag());
		System.out.println(acaspeBean.getSname());
		System.out.println(acaspeBean.getAsid());
		// 修改校名,修改标志
		Academy a = new Academy();
		a.setAid(acaspeBean.getAid());
		a.setAflag(acaspeBean.getAflag());
		a.setAschool(acaspeBean.getAschool());

		// 判断院校专业是否修改过
		// 查询该院校已有专业
		List l = minService.selsname(a.getAid());
		int flag = 0;
		for (int i = 0; i < l.size(); i++) {
			Object[] o = (Object[]) l.get(i);
			Specialty s = (Specialty) o[2];
			if (acaspeBean.getSname().equals(s.getSname())) {
				flag = 1;
			}
		}
		// 修改了该专业
		if (flag == 0) {
			// 判断专业表是否已存在将要修改的专业
			int nflag = 0;
			List s = minService.selname();
			for (int i = 0; i < s.size(); i++) {
				Specialty spe = (Specialty) s.get(i);
				if (spe.getSname().equals(acaspeBean.getSname())) {
					nflag = 1;
				}
			}
			// 将要修改的专业不存在
			if (nflag == 0) {
				// 专业表新增一条数据，院校专业表的专业字段修改为新添加的专业
				Specialty spe = new Specialty();
				spe.setSname(acaspeBean.getSname());
				spe.setSort(0);
				minService.addsname(spe);
				int sid = minService.selsid();
				minService.editsid(acaspeBean.getAsid(), sid);
			} else {
				// 查询将要修改的专业的id修改院校专业表的专业字段
				int sid = minService.selsid(acaspeBean.getSname());
				minService.editsid(acaspeBean.getAsid(), sid);
			}
		}
		minService.edit(a);
		return SUCCESS;
	}

	public String del() {
		HttpServletRequest req = ServletActionContext.getRequest();
		String id = req.getParameter("asid");
		int asid = 0;
		if (id != null && id != "") {
			asid = Integer.parseInt(id);
		}
		minService.del(asid);
		return SUCCESS;
	}
}
