package com.edu.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.sound.midi.Synthesizer;

import org.apache.struts2.ServletActionContext;

import com.edu.model.Stufile;
import com.edu.service.QiuService;
import com.opensymphony.xwork2.ActionSupport;

public class FileuploadAction extends ActionSupport{
	private QiuService qiuService;
	private Stufile stufile;
	//定义文件上传的大小
	private static final int buffersize=1024*16;
	
	//给新文件定义一个新名字
	private String newfilename;
	
	//文件数组
	private File []myfile;
		
	//文件内容
	private String[] myfileContentType;
	
	//文件名
	private String [] myfileFileName;

	
	
	public QiuService getQiuService() {
		return qiuService;
	}

	public void setQiuService(QiuService qiuService) {
		this.qiuService = qiuService;
	}

	public Stufile getStufile() {
		return stufile;
	}

	public void setStufile(Stufile stufile) {
		this.stufile = stufile;
	}

	public String getNewfilename() {
		return newfilename;
	}

	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
	}

	public File[] getMyfile() {
		return myfile;
	}

	public void setMyfile(File[] myfile) {
		this.myfile = myfile;
	}

	public String[] getMyfileContentType() {
		return myfileContentType;
	}

	public void setMyfileContentType(String[] myfileContentType) {
		this.myfileContentType = myfileContentType;
	}

	public String[] getMyfileFileName() {
		return myfileFileName;
	}

	public void setMyfileFileName(String[] myfileFileName) {
		this.myfileFileName = myfileFileName;
	}

	//获取文件内容类型的方法
	public String getcontentType(String name){
		//获得文件名的最后一个.的下标
		int index=name.lastIndexOf(".");
		return name.substring(index);
	}
	
	//读取文件的方法
	public void copy(File src,File tosrc){
		try {
			//初始化输入输出流
			InputStream in=null;
			OutputStream out=null;
			
			try {
				//得到输入输出流
				in=new BufferedInputStream(new FileInputStream(src),buffersize);
				out=new BufferedOutputStream(new FileOutputStream(tosrc),buffersize);
				
				//定义一个字节数组
				byte [] b=new byte[buffersize];
				
				//循环读写文件
				while(in.read(b)>0){//只要文件没读完
					out.write(b);//写文件
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				if(in!=null){
					in.close();
				}
				if(out!=null){
					out.close();
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//学生文件上传
	public String addfile() {
		//先根据学生id查询文件上传表 看是该同学是否上传过文件
		List<Stufile> li=qiuService.isupload(stufile.getStuid());
		
		if(li != null && li.size() > 0) {//该同学上传过
			Stufile ss=li.get(0);
			int ii=ss.getSfid();
			qiuService.delfile(ii);
		}
		
		List<String> list=new ArrayList<>();
		
		//执行上传
		for (int i = 0; i < myfile.length; i++) {
			Random r=new Random();
			String strs=r.nextInt(1000000)+"";
			//得到一个新名称
			newfilename=new Date().getTime()+strs+getcontentType(myfileFileName[i]);
			//获取项目路径
			String url=ServletActionContext.getServletContext().getRealPath("/upload");
			//保存文件
			File newfile=new File(url+"/"+newfilename);
			//执行上传
			copy(myfile[i], newfile);
			list.add(newfilename);
		}
		
		//保存信息到数据库
		Stufile s=new Stufile();
		s.setStuid(stufile.getStuid());
		s.setStuname(stufile.getStuname());	
		s.setSfphoto(list.get(0));
		s.setSfvoucher(list.get(1));
		s.setSfpaper(list.get(2));
		s.setSfdate(new Date().toLocaleString());
		qiuService.savefile(s);
		
		return SUCCESS;
	}
}
