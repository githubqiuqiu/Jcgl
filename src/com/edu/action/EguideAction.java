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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.struts2.ServletActionContext;
import org.springframework.http.HttpRequest;

import com.alibaba.fastjson.JSON;
import com.edu.model.Eguide;
import com.edu.service.impl.MinServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class EguideAction extends ActionSupport {
	private String log;
	private String p1;
	private String p2;
	private String p3;
	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
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
	private Eguide eguide;
	private List list;
	private int count;
	public Eguide getEguide() {
		return eguide;
	}

	public void setEguide(Eguide eguide) {
		this.eguide = eguide;
	}
	private MinServiceImpl minService;

	public MinServiceImpl getMinService() {
		return minService;
	}

	public void setMinService(MinServiceImpl minService) {
		this.minService = minService;
	}
//--------------------------------------------------	
	private static int BUFFER_SIZE = 16 * 1024;
	private File[] myFile = new File[4];
	private String[] contentType;
	private String[] fileName = new String[4];
	private File[] newfile = new File[4];
	private String[] newfilename = new String[4];
//-----------------------------------------------------------
	public void setMyFileContentType(String[] contentType) {
		this.contentType = contentType;
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

	//---------------------------------------------------------------
	public String sel() {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		res.setCharacterEncoding("utf-8");
		
		int page = Integer.parseInt(req.getParameter("page"));
		int rows = Integer.parseInt(req.getParameter("rows"));
		String type = req.getParameter("type");
		
		list = minService.seleguide(page, rows, type);
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
//		System.out.println(eguide.getSchool());
//		System.out.println(eguide.getTitle());
//		System.out.println(eguide.getType());
//		for(int i=0;i<fileName.length;i++) {
//			System.out.println(fileName[i]);
//		}
//		System.out.println(fileName[0]);
//		System.out.println(fileName[1]);
//		System.out.println(fileName[2]);
//		System.out.println(fileName[3]);
		
		for(int i = 0;i<fileName.length;i++) {
			newfilename[i] = new Date().getTime()+getRandom() + getPos(fileName[i]);
//			System.out.println(newfilename[i]);
			newfile[i] = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[i]);
//			System.out.println(newfile[i]);
			copy(myFile[i], newfile[i]);
		}
		
//		System.out.println(newfilename[0]);
//		System.out.println(newfilename[1]);
//		System.out.println(newfilename[2]);
//		System.out.println(newfilename[3]);
		
		Eguide eg = new Eguide();
		eg.setLog(newfilename[0]);
		eg.setPicture1(newfilename[1]);
		eg.setPicture2(newfilename[2]);
		eg.setPicture3(newfilename[3]);
		eg.setSchool(eguide.getSchool());
		eg.setTitle(eguide.getTitle());
		eg.setType(eguide.getType());
		
		minService.addeguide(eg);
		return SUCCESS;
	}
	public String del() {
		HttpServletRequest req = ServletActionContext.getRequest();
		int id = Integer.parseInt(req.getParameter("id"));
		minService.deleguide(id);
		return null;
	}
	public String editsel() {
		HttpServletRequest req = ServletActionContext.getRequest();
		int id = Integer.parseInt(req.getParameter("id"));
	 	eguide = minService.seloneeguide(id);
		return SUCCESS;
	}
	public String edit() {
		Eguide eg = new Eguide();
		//查询当前文件
		Eguide e = minService.seloneeguide(eguide.getId());
		String elog = e.getLog();
		String ep1 = e.getPicture1();
		String ep2 = e.getPicture2();
		String ep3 = e.getPicture3();
		
		System.out.println(elog);
		System.out.println(ep1);
		System.out.println(ep2);
		System.out.println(ep3);

		//首先判断文件长度
		if(fileName.length==1) {
			//判断那个修改了
			if(!log.equals("a")) {
				//上传新文件
				newfilename[0] = new Date().getTime()+getRandom() + getPos(fileName[0]);
				newfile[0] = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[0]);
				copy(myFile[0], newfile[0]);
				eg.setLog(newfilename[0]);
				eg.setPicture1(ep1);
				eg.setPicture2(ep2);
				eg.setPicture3(ep3);
			} else if(!p1.equals("b")) {
				newfilename[0] = new Date().getTime()+getRandom() + getPos(fileName[0]);
				newfile[0] = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[0]);
				copy(myFile[0], newfile[0]);
				eg.setPicture1(newfilename[0]);
				eg.setLog(elog);
				eg.setPicture2(ep2);
				eg.setPicture3(ep3);
			}else if(!p2.equals("c")) {
				newfilename[0] = new Date().getTime()+getRandom() + getPos(fileName[0]);
				newfile[0] = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[0]);
				copy(myFile[0], newfile[0]);
				eg.setPicture2(newfilename[0]);
				eg.setLog(elog);
				eg.setPicture1(ep1);
				eg.setPicture3(ep3);
			}else {
				newfilename[0] = new Date().getTime()+getRandom() + getPos(fileName[0]);
				newfile[0] = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[0]);
				copy(myFile[0], newfile[0]);
				eg.setPicture3(newfilename[0]);
				eg.setPicture1(ep1);
				eg.setPicture2(ep2);
				eg.setLog(elog);
			}
	
		}else if(fileName.length==2) {
			//判断那两个没改
			if(log.equals("a")) {
				if(p1.equals("b")) {
					for(int i=0;i<fileName.length;i++) {
						newfilename[i] = new Date().getTime()+getRandom() + getPos(fileName[i]);
						newfile[i] = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[i]);
						copy(myFile[i], newfile[i]);
					}
					eg.setLog(elog);
					eg.setPicture1(ep1);
					eg.setPicture2(newfilename[0]);
					eg.setPicture3(newfilename[1]);
				}else if(p2.equals("c")) {
					for(int i=0;i<fileName.length;i++) {
						newfilename[i] = new Date().getTime()+getRandom() + getPos(fileName[i]);
						newfile[i] = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[i]);
						copy(myFile[i], newfile[i]);
					}
					eg.setLog(elog);
					eg.setPicture1(newfilename[0]);
					eg.setPicture2(ep2);
					eg.setPicture3(newfilename[1]);
				}else if(p3.equals("d")) {
					for(int i=0;i<fileName.length;i++) {
						newfilename[i] = new Date().getTime()+getRandom() + getPos(fileName[i]);
						newfile[i] = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[i]);
						copy(myFile[i], newfile[i]);
					}
					eg.setLog(elog);
					eg.setPicture1(newfilename[0]);
					eg.setPicture2(newfilename[1]);
					eg.setPicture3(ep3);
				}
			} else if(p1.equals("b")) {
				if(p2.equals("c")) {
					for(int i=0;i<fileName.length;i++) {
						newfilename[i] = new Date().getTime()+getRandom() + getPos(fileName[i]);
						newfile[i] = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[i]);
						copy(myFile[i], newfile[i]);
					}
					eg.setLog(newfilename[0]);
					eg.setPicture1(ep1);
					eg.setPicture2(ep2);
					eg.setPicture3(newfilename[1]);
				}else if(p3.equals("d")) {
					for(int i=0;i<fileName.length;i++) {
						newfilename[i] = new Date().getTime()+getRandom() + getPos(fileName[i]);
						newfile[i] = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[i]);
						copy(myFile[i], newfile[i]);
					}
					eg.setLog(newfilename[0]);
					eg.setPicture1(ep1);
					eg.setPicture2(newfilename[1]);
					eg.setPicture3(ep3);
				}
			}else if(p2.equals("c")) {
				if(p3.equals("d")) {
					for(int i=0;i<fileName.length;i++) {
						newfilename[i] = new Date().getTime()+getRandom() + getPos(fileName[i]);
						newfile[i] = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[i]);
						copy(myFile[i], newfile[i]);
					}
					eg.setLog(newfilename[0]);
					eg.setPicture1(newfilename[1]);
					eg.setPicture2(ep2);
					eg.setPicture3(ep3);
				}
			}
		}else if(fileName.length==3) {
			//判断那个没改
			if(log.equals("a")) {
				//上传新文件
				for(int i=0;i<fileName.length;i++) {
					newfilename[i] = new Date().getTime()+getRandom() + getPos(fileName[i]);
					newfile[i] = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[i]);
					copy(myFile[i], newfile[i]);
				}
				eg.setLog(elog);
				eg.setPicture1(newfilename[0]);
				eg.setPicture2(newfilename[1]);
				eg.setPicture3(newfilename[2]);
			} else if(p1.equals("b")) {
				for(int i=0;i<fileName.length;i++) {
					newfilename[i] = new Date().getTime()+getRandom() + getPos(fileName[i]);
					newfile[i] = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[i]);
					copy(myFile[i], newfile[i]);
				}
				eg.setPicture1(ep1);
				eg.setLog(newfilename[0]);
				eg.setPicture2(newfilename[1]);
				eg.setPicture3(newfilename[2]);
			}else if(p2.equals("c")) {
				for(int i=0;i<fileName.length;i++) {
					newfilename[i] = new Date().getTime()+getRandom() + getPos(fileName[i]);
					newfile[i] = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[i]);
					copy(myFile[i], newfile[i]);
				}
				eg.setPicture2(ep2);
				eg.setLog(newfilename[0]);
				eg.setPicture1(newfilename[1]);
				eg.setPicture3(newfilename[2]);
			}else {
				for(int i=0;i<fileName.length;i++) {
					newfilename[i] = new Date().getTime()+getRandom() + getPos(fileName[i]);
					newfile[i] = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[i]);
					copy(myFile[i], newfile[i]);
				}
				eg.setPicture3(ep3);
				eg.setPicture1(newfilename[1]);
				eg.setPicture2(newfilename[2]);
				eg.setLog(newfilename[0]);
			}
		}else if(fileName.length==4) {
			if(log.equals("a")) {
				eg.setLog(elog);
				eg.setPicture1(ep1);
				eg.setPicture2(ep2);
				eg.setPicture3(ep3);
			}else {
				for(int i=0;i<fileName.length;i++) {
					newfilename[i] = new Date().getTime()+getRandom() + getPos(fileName[i]);
					newfile[i] = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[i]);
					copy(myFile[i], newfile[i]);
				}
				eg.setLog(newfilename[0]);
				eg.setPicture1(newfilename[1]);
				eg.setPicture2(newfilename[2]);
				eg.setPicture3(newfilename[3]);
			}
		}
		
		eg.setId(eguide.getId());
		eg.setSchool(eguide.getSchool());
		eg.setTitle(eguide.getTitle());
		eg.setType(eguide.getType());
		minService.edit(eg);
	
		return SUCCESS;
	}
	public String seleguidelog() {
		list = minService.seleguidelog();
		return SUCCESS;
	}
	
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String[] getFileName() {
		return fileName;
	}

	public void setFileName(String[] fileName) {
		this.fileName = fileName;
	}
	public String selmore() {
		HttpServletRequest req = ServletActionContext.getRequest();
		int id = Integer.parseInt(req.getParameter("id"));
		//根据id查询院校信息
		eguide = minService.seleguidebyid(id);
		return SUCCESS;
	}
	//--------------------------------------------------------------文件上传
	// 文件复制
	public  void copy(File src, File dec) {
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
	public  String getPos(String fileName) {
		int point = fileName.lastIndexOf(".");
		System.out.println(fileName.substring(point));
		return fileName.substring(point);
	}
	//获取文件名
	public String getrn(String name) {
		int point = name.lastIndexOf("\\");
		return name.substring(point+1);
	}
	//随机数
	public String getRandom() {
		Random r = new Random();
		return r.nextInt(1000000)+"";
	}
}
