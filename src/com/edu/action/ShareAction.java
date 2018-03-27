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
import com.edu.model.Share;
import com.edu.service.impl.MinServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ShareAction extends ActionSupport {
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	private String pho;
	private String pic;
	public String getPho() {
		return pho;
	}

	public void setPho(String pho) {
		this.pho = pho;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	private Share share;
	public Share getShare() {
		return share;
	}

	public void setShare(Share share) {
		this.share = share;
	}
	private List list;
	private int count;
	private MinServiceImpl minService;

	public MinServiceImpl getMinService() {
		return minService;
	}

	public void setMinService(MinServiceImpl minService) {
		this.minService = minService;
	}
//--------------------------------------------------	
		private static int BUFFER_SIZE = 16 * 1024;
		private File[] myFile = new File[2];
		private String[] contentType;
		private String[] fileName = new String[2];
		private File[] newfile = new File[2];
		private String[] newfilename = new String[2];
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

		public String[] getFileName() {
			return fileName;
		}

		public void setFileName(String[] fileName) {
			this.fileName = fileName;
		}

	//---------------------------------------------------------------
	public String sel() {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		res.setCharacterEncoding("utf-8");
		
		int page = Integer.parseInt(req.getParameter("page"));
		int rows = Integer.parseInt(req.getParameter("rows"));
		String sharetitle = req.getParameter("sharetitle");
		
		list = minService.selshare(page, rows, sharetitle);
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
		for(int i = 0;i<fileName.length;i++) {
			newfilename[i] = new Date().getTime()+getRandom() + getPos(fileName[i]);
			newfile[i] = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[i]);
			copy(myFile[i], newfile[i]);
		}
		Share s = new Share();
		s.setSharecontent(share.getSharecontent());
		s.setSharephoto(newfilename[0]);
		s.setSharepicture(newfilename[1]);
		s.setSharetitle(share.getSharetitle());
		
		minService.addshare(s);
		return SUCCESS;
	}
	public String del() {
		HttpServletRequest req = ServletActionContext.getRequest();
		int id = Integer.parseInt(req.getParameter("shareid"));
		minService.delshare(id);
		return SUCCESS;
	}
	public String editsel() {
		HttpServletRequest req = ServletActionContext.getRequest();
		int id = Integer.parseInt(req.getParameter("shareid"));
		share = minService.seloneshare(id);
		return SUCCESS;
	}
	public String edit() {
		Share s = new Share();
		//查询当前id
		Share se = minService.seloneshare(share.getShareid());
		
		//获取参数
		String spho = se.getSharephoto();
		String spic = se.getSharepicture();
		
		//判断是否修改过
		if(fileName.length==1) {
			if(pho.equals("a")) {
				newfilename[0] = new Date().getTime()+getRandom() + getPos(fileName[0]);
				newfile[0] = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[0]);
				copy(myFile[0], newfile[0]);
				s.setSharephoto(newfilename[0]);
				s.setSharepicture(spic);
			}else {
				newfilename[0] = new Date().getTime()+getRandom() + getPos(fileName[0]);
				newfile[0] = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[0]);
				copy(myFile[0], newfile[0]);
				s.setSharephoto(spho);
				s.setSharepicture(newfilename[0]);
			}
		}else if(fileName.length==2){
			if(pho.equals("a")) {
				s.setSharephoto(spho);
				s.setSharepicture(spic);
			}else {
				for(int i =0;i<fileName.length;i++) {
					newfilename[i] = new Date().getTime()+getRandom() + getPos(fileName[i]);
					newfile[i] = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename[i]);
					copy(myFile[i], newfile[i]);
				}
				s.setSharephoto(newfilename[0]);
				s.setSharepicture(newfilename[1]);
			}
		}
		
		s.setSharecontent(share.getSharecontent());
		s.setShareid(share.getShareid());
		s.setSharetitle(share.getSharetitle());
		minService.edit(s);
		return SUCCESS;
	}
	public String selsharepho() {
		list = minService.selsharepho();
		return SUCCESS;
	}
	public String allshare() {
		list = minService.selshare();
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
		//随机数
		public String getRandom() {
			Random r = new Random();
			return r.nextInt(1000000)+"";
		}
}
