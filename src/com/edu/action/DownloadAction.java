package com.edu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.edu.model.Stufile;
import com.edu.model.User;
import com.edu.service.QiuService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport{
	private String sfid;
	private QiuService qiuService;
    private InputStream fileInput;  
	private String fileName;  
	  
    public String getFileName() {  
        return fileName;  
    }  
  
    public void setFileName(String fileName) {  
        this.fileName = fileName;  
    }  
  
    public InputStream getFileInput() {  
        return ServletActionContext.getServletContext().getResourceAsStream("upload\\"+fileName);  
    }  
  
    public void setFileInput(InputStream fileInput) {  
        this.fileInput = fileInput;  
    }

	public QiuService getQiuService() {
		return qiuService;
	}

	public void setQiuService(QiuService qiuService) {
		this.qiuService = qiuService;
	}

	public String getSfid() {
		return sfid;
	}

	public void setSfid(String sfid) {
		this.sfid = sfid;
	}


	//下载相片
	public String downloadphoto() {
		//System.out.println("sfid="+sfid);
		
		//根据sfid查询文件上传表
		List<Stufile> list=qiuService.selfilebyid(Integer.parseInt(sfid));
		Stufile s=list.get(0);
		fileName=s.getSfphoto();
		
		System.out.println("filename="+fileName);
		
		//先获得request和response
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		
		//获得文件夹的路径
		//String url=ServletActionContext.getServletContext().getRealPath("/upload");
		fileInput=ServletActionContext.getServletContext().getResourceAsStream("upload\\"+fileName);  
	        
		return SUCCESS;
	}
	
	//下载缴费凭证
	public String downloadvoucher() {
		//根据sfid查询文件上传表
		List<Stufile> list=qiuService.selfilebyid(Integer.parseInt(sfid));
		Stufile s=list.get(0);
		fileName=s.getSfvoucher();
		
		System.out.println("filename="+fileName);
		
		//先获得request和response
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		
		//获得文件夹的路径
		//String url=ServletActionContext.getServletContext().getRealPath("/upload");
		fileInput=ServletActionContext.getServletContext().getResourceAsStream("upload\\"+fileName);  
	        
		return SUCCESS;
	}
	
	//下载论文
	public String downloadpaper() {
		//根据sfid查询文件上传表
		List<Stufile> list=qiuService.selfilebyid(Integer.parseInt(sfid));
		Stufile s=list.get(0);
		fileName=s.getSfpaper();
		
		System.out.println("filename="+fileName);
		
		//先获得request和response
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		
		//获得文件夹的路径
		//String url=ServletActionContext.getServletContext().getRealPath("/upload");
		fileInput=ServletActionContext.getServletContext().getResourceAsStream("upload\\"+fileName);  
	        
		return SUCCESS;
	}
	
	//下载成人高考表导出的excel表格
	public String uploadexport() {
		//System.out.println("进了下载表格");
		fileName="export.xlsx";
		//先获得request和response
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		fileInput=ServletActionContext.getServletContext().getResourceAsStream("upload\\"+"export.xlsx");  
		return SUCCESS;
	}
	
	//下载模版
	public String downloadmoban() {
		//System.out.println("进了下载模版");
		fileName="moban.xlsx";
		//先获得request和response
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		fileInput=ServletActionContext.getServletContext().getResourceAsStream("upload\\"+"moban.xlsx");  
		return SUCCESS;
	}
	
	//老师生成二维码后下载
	public String terweima() {
		System.out.println("进了生成二维码");
		//进了生成二维码
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=request.getSession();
		User u=(User) session.getAttribute("teacher");
		
		//获得老师的id
		int id=u.getId();
		
		
		int width = 300;//长
		int height = 300;//宽
		String format = "png";//文件格式
		String content = "http://localhost:8080/project/cour.action?userid="+id;//设置内容
		//"http://localhost:8080/project/index.action?userid="+id
		//"https://www.baidu.com"
		HashMap hints = new HashMap();
		
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");//字符集和编码
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		hints.put(EncodeHintType.MARGIN, 2);
		
		try {
			
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height);
			
			String url=ServletActionContext.getServletContext().getRealPath("/upload");
			
			Path file = new File(url+"/terweima.png").toPath();//存放路径
			
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.print(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return null;
	}
	
	//下载老师生成的二维码
	public String downloaderweima() {
		System.out.println("进了下载二维码");
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=request.getSession();
		User u=(User) session.getAttribute("teacher");
		//获得老师的id
		int id=u.getId();
		String content = "http://localhost:8080/project/cour.action?userid="+id;//设置内容
		
		//下载二维码
		fileName="terweima.png";
		//先获得request和response
		
		fileInput=ServletActionContext.getServletContext().getResourceAsStream("upload\\"+"terweima.png"); 
		return SUCCESS;
	}
	
	
}
