package com.edu.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.edu.model.Homecontent;
import com.edu.model.Hotmajor;
import com.edu.model.Notice;
import com.edu.service.impl.MinServiceImpl;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class HomeAction extends ActionSupport {
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	private String p1;
	private String p2;
	private String p3;
	private String p4;
	private String p5;

	public String getP4() {
		return p4;
	}

	public void setP4(String p4) {
		this.p4 = p4;
	}

	public String getP5() {
		return p5;
	}

	public void setP5(String p5) {
		this.p5 = p5;
	}

	public String getP1() {
		return p1;
	}

	public void setP1(String p1) {
		this.p1 = p1;
	}

	public String getP2() {
		return p2;
	}

	public void setP2(String p2) {
		this.p2 = p2;
	}

	public String getP3() {
		return p3;
	}

	public void setP3(String p3) {
		this.p3 = p3;
	}

	private List<Homecontent> list;
	private int count;
	private Homecontent home = new Homecontent();
	private MinServiceImpl minService;

	public Homecontent getHome() {
		return home;
	}

	public void setHome(Homecontent home) {
		this.home = home;
	}

	public MinServiceImpl getMinService() {
		return minService;
	}

	public void setMinService(MinServiceImpl minService) {
		this.minService = minService;
	}

	// --------------------------------------------------
	private static int BUFFER_SIZE = 16 * 1024;
	private File[] myFile = new File[5];
	private String[] contentType;
	private String[] fileName = new String[5];
	private File[] newfile = new File[5];
	private String[] newfilename = new String[5];
	// -----------------------------------------------------------

	public void setMyFileContentType(String[] contentType) {
		this.contentType = contentType;
	}

	public String[] getFileName() {
		return fileName;
	}

	public void setFileName(String[] fileName) {
		this.fileName = fileName;
	}

	public void setMyFileFileName(String[] fileName) {
		this.fileName = fileName;
	}

	public File[] getMyFile() {
		return myFile;
	}

	public void setMyFile(File[] myFile) {
		this.myFile = myFile;
	}

	public File[] getNewfile() {
		return newfile;
	}

	public void setNewfile(File[] newfile) {
		this.newfile = newfile;
	}

	public String[] getNewfilename() {
		return newfilename;
	}

	public void setNewfilename(String[] newfilename) {
		this.newfilename = newfilename;
	}

	// ---------------------------------------------------------------
	public String sel() {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		res.setCharacterEncoding("utf-8");

		int page = Integer.parseInt(req.getParameter("page"));
		int rows = Integer.parseInt(req.getParameter("rows"));

		list = minService.selhome(page, rows);
		count = list.size();
		Map map = new HashMap<>();
		map.put("total", count);
		map.put("rows", list);

		String str = JSON.toJSONString(map);
		PrintWriter pw = null;
		try {
			pw = res.getWriter();
			pw.print(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public String add() {
		Homecontent h = new Homecontent();
		for (int i = 0; i < fileName.length; i++) {
			newfilename[i] = new Date().getTime() + getRandom() + getPos(fileName[i]);
			newfile[i] = new File(
					ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[i]);
			copy(myFile[i], newfile[i]);
		}
		h.setHcaddress(home.getHcaddress());
		h.setHcphone(home.getHcphone());
		h.setInterlinkagefour(home.getInterlinkagefour());
		h.setInterlinkageone(home.getInterlinkageone());
		h.setInterlinkagethree(home.getInterlinkagethree());
		h.setInterlinkagetwo(home.getInterlinkagetwo());
		h.setPictureone(newfilename[0]);
		h.setPicturetwo(newfilename[1]);
		h.setPicturethree(newfilename[2]);
		h.setQrcodeone(newfilename[3]);
		h.setQrcodetwo(newfilename[4]);
		minService.addhome(h);
		return SUCCESS;
	}

	public String del() {
		HttpServletRequest req = ServletActionContext.getRequest();
		int hcid = Integer.parseInt(req.getParameter("hcid"));
		minService.delhome(hcid);
		return SUCCESS;
	}

	public String editsel() {
		HttpServletRequest req = ServletActionContext.getRequest();
		int hcid = Integer.parseInt(req.getParameter("hcid"));
		home = minService.selonehome(hcid);
		return SUCCESS;
	}

	public String edit() {
		Homecontent ho = minService.selonehome(home.getHcid());
		Homecontent h = new Homecontent();

		// 判断文件长度
		System.out.println(fileName);
		if (fileName.length == 1) {
			newfilename[0] = new Date().getTime() + getRandom() + getPos(fileName[0]);
			newfile[0] = new File(
					ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[0]);
			copy(myFile[0], newfile[0]);
			// 判断那个修改了
			if (!p1.equals("a")) {
				h.setPictureone(newfilename[0]);
				h.setPicturetwo(ho.getPicturetwo());
				h.setPicturethree(ho.getPicturethree());
				h.setQrcodeone(ho.getQrcodeone());
				h.setQrcodetwo(ho.getQrcodetwo());
			} else if (!p2.equals("b")) {
				h.setPictureone(ho.getPictureone());
				h.setPicturetwo(newfilename[0]);
				h.setPicturethree(ho.getPicturethree());
				h.setQrcodeone(ho.getQrcodeone());
				h.setQrcodetwo(ho.getQrcodetwo());
			} else if (!p3.equals("c")) {
				h.setPictureone(ho.getPictureone());
				h.setPicturetwo(ho.getPicturetwo());
				h.setPicturethree(newfilename[0]);
				h.setQrcodeone(ho.getQrcodeone());
				h.setQrcodetwo(ho.getQrcodetwo());
			} else if (!p4.equals("d")) {
				h.setPictureone(ho.getPictureone());
				h.setPicturetwo(ho.getPicturetwo());
				h.setPicturethree(ho.getPicturethree());
				h.setQrcodeone(newfilename[0]);
				h.setQrcodetwo(ho.getQrcodetwo());
			} else if (!p5.equals("e")) {
				h.setPictureone(ho.getPictureone());
				h.setPicturetwo(ho.getPicturetwo());
				h.setPicturethree(ho.getPicturethree());
				h.setQrcodeone(ho.getQrcodeone());
				h.setQrcodetwo(newfilename[0]);
			}
		} else if (fileName.length == 2) {
			// 判断那个没改
			for (int i = 0; i < fileName.length; i++) {
				newfilename[i] = new Date().getTime() + getRandom() + getPos(fileName[i]);
				newfile[i] = new File(
						ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[i]);
				copy(myFile[i], newfile[i]);
			}
			if (!p1.equals("a")) {
				if (!p2.equals("b")) {
					h.setPictureone(newfilename[0]);
					h.setPicturetwo(newfilename[1]);
					h.setPicturethree(ho.getPicturethree());
					h.setQrcodeone(ho.getQrcodeone());
					h.setQrcodetwo(ho.getQrcodetwo());
				} else if (!p3.equals("c")) {
					h.setPictureone(newfilename[0]);
					h.setPicturetwo(ho.getPicturetwo());
					h.setPicturethree(newfilename[1]);
					h.setQrcodeone(ho.getQrcodeone());
					h.setQrcodetwo(ho.getQrcodetwo());
				} else if (!p4.equals("d")) {
					h.setPictureone(newfilename[0]);
					h.setPicturetwo(ho.getPicturetwo());
					h.setPicturethree(ho.getPicturethree());
					h.setQrcodeone(newfilename[1]);
					h.setQrcodetwo(ho.getQrcodetwo());
				} else if (!p5.equals("e")) {
					h.setPictureone(newfilename[0]);
					h.setPicturetwo(ho.getPicturetwo());
					h.setPicturethree(ho.getPicturethree());
					h.setQrcodeone(ho.getQrcodeone());
					h.setQrcodetwo(newfilename[1]);
				}
			} else if (!p2.equals("b")) {
				if (!p3.equals("c")) {
					h.setPictureone(ho.getPictureone());
					h.setPicturetwo(newfilename[0]);
					h.setPicturethree(newfilename[1]);
					h.setQrcodeone(ho.getQrcodeone());
					h.setQrcodetwo(ho.getQrcodetwo());
				} else if (!p4.equals("d")) {
					h.setPictureone(ho.getPictureone());
					h.setPicturetwo(newfilename[0]);
					h.setPicturethree(ho.getPicturethree());
					h.setQrcodeone(newfilename[1]);
					h.setQrcodetwo(ho.getQrcodetwo());
				} else if (!p5.equals("e")) {
					h.setPictureone(ho.getPictureone());
					h.setPicturetwo(newfilename[0]);
					h.setPicturethree(ho.getPicturethree());
					h.setQrcodeone(ho.getQrcodeone());
					h.setQrcodetwo(newfilename[1]);
				}
			} else if (!p3.equals("c")) {
				if (!p4.equals("d")) {
					h.setPictureone(ho.getPictureone());
					h.setPicturetwo(ho.getPicturetwo());
					h.setPicturethree(newfilename[0]);
					h.setQrcodeone(newfilename[1]);
					h.setQrcodetwo(ho.getQrcodetwo());
				} else if (!p5.equals("e")) {
					h.setPictureone(ho.getPictureone());
					h.setPicturetwo(ho.getPicturetwo());
					h.setPicturethree(newfilename[0]);
					h.setQrcodeone(ho.getQrcodeone());
					h.setQrcodetwo(newfilename[1]);
				}
			} else if (!p4.equals("d")) {
				if (!p5.equals("e")) {
					h.setPictureone(ho.getPictureone());
					h.setPicturetwo(ho.getPicturetwo());
					h.setPicturethree(ho.getPicturethree());
					h.setQrcodeone(newfilename[0]);
					h.setQrcodetwo(newfilename[1]);
				}
			}
		} else if (fileName.length == 3) {
			for (int i = 0; i < fileName.length; i++) {
				newfilename[i] = new Date().getTime() + getRandom() + getPos(fileName[i]);
				newfile[i] = new File(
						ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[i]);
				copy(myFile[i], newfile[i]);
			}
			if (p1.equals("a")) {
				if (p2.equals("b")) {
					h.setPictureone(ho.getPictureone());
					h.setPicturetwo(ho.getPicturetwo());
					h.setPicturethree(newfilename[0]);
					h.setQrcodeone(newfilename[1]);
					h.setQrcodetwo(newfilename[2]);
				} else if (p3.equals("c")) {
					h.setPictureone(ho.getPictureone());
					h.setPicturetwo(newfilename[0]);
					h.setPicturethree(ho.getPicturethree());
					h.setQrcodeone(newfilename[1]);
					h.setQrcodetwo(newfilename[2]);
				} else if (p4.equals("d")) {
					h.setPictureone(ho.getPictureone());
					h.setPicturetwo(newfilename[0]);
					h.setPicturethree(newfilename[1]);
					h.setQrcodeone(ho.getQrcodeone());
					h.setQrcodetwo(newfilename[2]);
				} else if (p5.equals("e")) {
					h.setPictureone(ho.getPictureone());
					h.setPicturetwo(newfilename[0]);
					h.setPicturethree(newfilename[1]);
					h.setQrcodeone(newfilename[2]);
					h.setQrcodetwo(ho.getQrcodetwo());
				}
			} else if (p2.equals("b")) {
				if (p3.equals("c")) {
					h.setPictureone(newfilename[0]);
					h.setPicturetwo(ho.getPicturetwo());
					h.setPicturethree(ho.getPicturethree());
					h.setQrcodeone(newfilename[1]);
					h.setQrcodetwo(newfilename[2]);
				} else if (p4.equals("d")) {
					h.setPictureone(newfilename[0]);
					h.setPicturetwo(ho.getPicturetwo());
					h.setPicturethree(newfilename[1]);
					h.setQrcodeone(ho.getQrcodeone());
					h.setQrcodetwo(newfilename[2]);
				} else if (p5.equals("e")) {
					h.setPictureone(newfilename[0]);
					h.setPicturetwo(ho.getPicturetwo());
					h.setPicturethree(newfilename[1]);
					h.setQrcodeone(newfilename[2]);
					h.setQrcodetwo(ho.getQrcodetwo());
				}
			} else if (p3.equals("c")) {
				if (p4.equals("d")) {
					h.setPictureone(newfilename[0]);
					h.setPicturetwo(newfilename[1]);
					h.setPicturethree(ho.getPicturethree());
					h.setQrcodeone(ho.getQrcodeone());
					h.setQrcodetwo(newfilename[2]);
				} else if (p5.equals("e")) {
					h.setPictureone(newfilename[0]);
					h.setPicturetwo(newfilename[1]);
					h.setPicturethree(ho.getPicturethree());
					h.setQrcodeone(newfilename[2]);
					h.setQrcodetwo(ho.getQrcodetwo());
				}
			} else if (p4.equals("d")) {
				h.setPictureone(newfilename[0]);
				h.setPicturetwo(newfilename[1]);
				h.setPicturethree(newfilename[2]);
				h.setQrcodeone(ho.getQrcodeone());
				h.setQrcodetwo(ho.getQrcodetwo());
			}

		} else if (fileName.length == 4) {
			for (int i = 0; i < fileName.length; i++) {
				newfilename[i] = new Date().getTime() + getRandom() + getPos(fileName[i]);
				newfile[i] = new File(
						ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[i]);
				copy(myFile[i], newfile[i]);
			}
			if (p1.equals("a")) {
				h.setPictureone(ho.getPictureone());
				h.setPicturetwo(newfilename[0]);
				h.setPicturethree(newfilename[1]);
				h.setQrcodeone(newfilename[2]);
				h.setQrcodetwo(newfilename[3]);
			} else if (p2.equals("b")) {
				h.setPictureone(newfilename[0]);
				h.setPicturetwo(ho.getPicturetwo());
				h.setPicturethree(newfilename[1]);
				h.setQrcodeone(newfilename[2]);
				h.setQrcodetwo(newfilename[3]);
			} else if (p3.equals("c")) {
				h.setPictureone(newfilename[0]);
				h.setPicturetwo(newfilename[1]);
				h.setPicturethree(ho.getPicturethree());
				h.setQrcodeone(newfilename[2]);
				h.setQrcodetwo(newfilename[3]);
			} else if (p4.equals("d")) {
				h.setPictureone(newfilename[0]);
				h.setPicturetwo(newfilename[1]);
				h.setPicturethree(newfilename[2]);
				h.setQrcodeone(ho.getQrcodeone());
				h.setQrcodetwo(newfilename[3]);
			} else if (p5.equals("e")) {
				h.setPictureone(newfilename[0]);
				h.setPicturetwo(newfilename[1]);
				h.setPicturethree(newfilename[2]);
				h.setQrcodeone(newfilename[3]);
				h.setQrcodetwo(ho.getQrcodetwo());
			}
		} else if (fileName.length == 5) {
			if (!p1.equals("a")) {
				for (int i = 0; i < fileName.length; i++) {
					newfilename[i] = new Date().getTime() + getRandom() + getPos(fileName[i]);
					newfile[i] = new File(
							ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[i]);
					copy(myFile[i], newfile[i]);
				}
				h.setPictureone(newfilename[0]);
				h.setPicturetwo(newfilename[1]);
				h.setPicturethree(newfilename[2]);
				h.setQrcodeone(newfilename[3]);
				h.setQrcodetwo(newfilename[4]);
			} else {
				h.setPictureone(ho.getPictureone());
				h.setPicturethree(ho.getPicturethree());
				h.setPicturetwo(ho.getPicturetwo());
				h.setQrcodeone(ho.getQrcodeone());
				h.setQrcodetwo(ho.getQrcodetwo());
			}
		}

		h.setHcaddress(home.getHcaddress());
		h.setHcid(home.getHcid());
		h.setHcphone(home.getHcphone());
		h.setInterlinkagefour(home.getInterlinkagefour());
		h.setInterlinkageone(home.getInterlinkageone());
		h.setInterlinkagethree(home.getInterlinkagethree());
		h.setInterlinkagetwo(home.getInterlinkagetwo());
		minService.edit(h);
		return SUCCESS;
	}

	// 最新动态
	private Notice notice;
	private List nlist;
	// 热门专业
	private Hotmajor hotmajor;
	private List hlist;

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public List getNlist() {
		return nlist;
	}

	public void setNlist(List nlist) {
		this.nlist = nlist;
	}

	public Hotmajor getHotmajor() {
		return hotmajor;
	}

	public void setHotmajor(Hotmajor hotmajor) {
		this.hotmajor = hotmajor;
	}

	public List getHlist() {
		return hlist;
	}

	public void setHlist(List hlist) {
		this.hlist = hlist;
	}

	public String selindex() {

		System.out.println("进入后台查询首页");

		HttpServletResponse res = ServletActionContext.getResponse();
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session = req.getSession();

		res.setCharacterEncoding("utf-8");
		list = minService.selhomeindex();

		// Map m = new HashMap<>();
		// m.put("home", list);
		//
		// result = JSON.toJSONString(m);
		// System.out.println(result);
		// PrintWriter pw = null;
		// try {
		// pw = res.getWriter();
		// pw.print(result);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// home
		for (int i = 0; i < list.size(); i++) {
			Homecontent h = list.get(i);
			home.setHcaddress(h.getHcaddress());
			home.setHcid(h.getHcid());
			home.setHcphone(h.getHcphone());
			home.setInterlinkagefour(h.getInterlinkagefour());
			home.setInterlinkageone(h.getInterlinkageone());
			home.setInterlinkagethree(h.getInterlinkagethree());
			home.setInterlinkagetwo(h.getInterlinkagetwo());
			home.setPictureone(h.getPictureone());
			home.setPicturethree(h.getPicturethree());
			home.setPicturetwo(h.getPicturetwo());
			home.setQrcodeone(h.getQrcodeone());
			home.setQrcodetwo(h.getQrcodetwo());
		}

		// nlist
		nlist = minService.selnotice();
		hlist = minService.selHotmajor();

		return SUCCESS;
	}

	public String selfooter() {
		HttpServletResponse res = ServletActionContext.getResponse();
		res.setCharacterEncoding("utf-8");
		list = minService.selhomeindex();

		Map m = new HashMap<>();
		m.put("home", list);

		result = JSON.toJSONString(m);
		System.out.println(result);
		PrintWriter pw = null;
		try {
			pw = res.getWriter();
			pw.print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// --------------------------------------------------------------文件上传
	// 文件复制
	public void copy(File src, File dec) {
		try {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dec), BUFFER_SIZE);
				byte[] b = new byte[BUFFER_SIZE];
				while (in.read(b) > 0) {
					out.write(b);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (in != null) {
					in.close();
				} else if (out != null) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获取文件后缀名
	public String getPos(String fileName) {
		int point = fileName.lastIndexOf(".");
		System.out.println(fileName.substring(point));
		return fileName.substring(point);
	}

	// 随机数
	public String getRandom() {
		Random r = new Random();
		return r.nextInt(1000000) + "";
	}

	public String saveid() {
		HttpServletResponse res = ServletActionContext.getResponse();
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session = req.getSession();

		String userid = req.getParameter("userid");
		if (userid == null) {
			userid = "xxx";
		}

		// System.out.println("userid="+userid);
		if (!userid.equals("xxx")) {
			session.setAttribute("userid", userid);
		}
		res.setCharacterEncoding("utf-8");
		return SUCCESS;
	}
}
