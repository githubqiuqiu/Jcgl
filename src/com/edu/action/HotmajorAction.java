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

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.edu.model.Hotmajor;
import com.edu.service.impl.MinServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class HotmajorAction extends ActionSupport {
	private Hotmajor hotmajor;
	public Hotmajor getHotmajor() {
		return hotmajor;
	}
	public void setHotmajor(Hotmajor hotmajor) {
		this.hotmajor = hotmajor;
	}
	private MinServiceImpl minService;
	private List list;
	private int count;
	public MinServiceImpl getMinService() {
		return minService;
	}
	public void setMinService(MinServiceImpl minService) {
		this.minService = minService;
	}
	
	private static int BUFFER_SIZE = 16 * 1024;
	private File myFile;
	private String contentType;
	private String fileName;
	private File newfile;
	private String newfilename;
	
	// ------------------------------------------------------------
	public void setMyFileContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setMyFileFileName(String fileName) {
		this.fileName = fileName;
	}
	//----------------------------------------------------------------------------	
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public File getNewfile() {
		return newfile;
	}
	public void setNewfile(File newfile) {
		this.newfile = newfile;
	}
	public String getNewfilename() {
		return newfilename;
	}
	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
	}
	// -------------------------------------------------------------
	
	public String sel() {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		res.setCharacterEncoding("utf-8");
		
		int page = Integer.parseInt(req.getParameter("page"));
		int rows = Integer.parseInt(req.getParameter("rows"));
		String title = req.getParameter("title");

		list = minService.selhotmajor(page,rows,title);
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
		
//		System.out.println(hotmajor.getHmcontent());
//		System.out.println(hotmajor.getHmtitle());
//		System.out.println(fileName);
		
		newfilename = new Date().getTime()+getRandom() + getPos(fileName);
		newfile = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename);
		copy(myFile, newfile);
		
		Hotmajor h = new Hotmajor();
		h.setHmcontent(hotmajor.getHmcontent());
		h.setHmtitle(hotmajor.getHmtitle());
		h.setHmpicture(newfilename);
		minService.hotmajoradd(h);
		
		return SUCCESS;
	}
	public String editsel() {
		HttpServletRequest req = ServletActionContext.getRequest();
		int hmid = Integer.parseInt(req.getParameter("hmid"));
		hotmajor = minService.selonehot(hmid);
		return SUCCESS;
	}
	public String edit() {
		System.out.println(hotmajor.getHmcontent());
		System.out.println(hotmajor.getHmtitle());
		System.out.println(fileName);
		//判断文件是否修改
		//查询当前文件名
		boolean p = true;
		Hotmajor hot = minService.selonehot(hotmajor.getHmid());
		if(hot.getHmpicture()!=null) {
			if(hot.getHmpicture().equals(fileName)) {
				p = false;
			}else if(fileName==null) {
				p = false;
			}
		}else {
			p = true;
		}
		Hotmajor h = new Hotmajor();
		h.setHmcontent(hotmajor.getHmcontent());
		h.setHmid(hotmajor.getHmid());
		h.setHmtitle(hotmajor.getHmtitle());
		System.out.println(p);
		if(p) {
			newfilename = new Date().getTime()+getRandom() + getPos(fileName);
			newfile = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename);
			copy(myFile, newfile);
			h.setHmpicture(newfilename);
		}else {
			h.setHmpicture(hot.getHmpicture());
		}
		
		minService.edithotmajor(h);
		return SUCCESS;
	}
	public String del() {
		HttpServletRequest req = ServletActionContext.getRequest();
		int hmid = Integer.parseInt(req.getParameter("hmid"));
		minService.delhotmajor(hmid);
		return SUCCESS;
	}
//-------------------------------------------------------------文件上传
	// 文件复制
		public static void copy(File src, File dec) {
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
		public static String getPos(String fileName) {
			int point = fileName.lastIndexOf(".");
			return fileName.substring(point);
		}
		//随机数
		public String getRandom() {
			Random r = new Random();
			return r.nextInt(1000000)+"";
		}
}
