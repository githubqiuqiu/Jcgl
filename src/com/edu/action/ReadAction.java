package com.edu.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.edu.bean.ArtapplyBean;
import com.edu.service.impl.MinServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ReadAction extends ActionSupport {
	private MinServiceImpl minService;
	
	public MinServiceImpl getMinService() {
		return minService;
	}

	public void setMinService(MinServiceImpl minService) {
		this.minService = minService;
	}
	
	private ArtapplyBean ab;
	private List<ArtapplyBean> list = new ArrayList<>();
	
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
	public String add() {//批量添加
		//新文件名
		newfilename = new Date().getTime()+getRandom() + getPos(fileName);
		//新文件
		newfile = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename);
		String str = ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newfilename;
		System.out.println("文件地址"+str);
		//复制文件到新文件
		copy(myFile, newfile);
		
		String value = null;
		
		File file = new File(str);
		try {
			//创建工作簿，读取文件内容
			XSSFWorkbook workbook = new XSSFWorkbook(FileUtils.openInputStream(file));
			//读取Excel文件的第一个工作页
			//方式一
			//HSSFSheet sheet = workbook.getSheet("sheet0");
			//方式二
			XSSFSheet sheet = workbook.getSheetAt(0);
			int firstRowNum = 0;  //第一行
			//获取sheet中最后一行行号
			int lastRowNum = sheet.getLastRowNum();  //获取最后一行
			for(int i=0;i<=lastRowNum;i++){
				XSSFRow row = sheet.getRow(i);
				//获取当前行最后单元格列号
				int lastCellNum = row.getLastCellNum();
				//循环这一行来读取每一个单元格中的内容
				
				ab = new ArtapplyBean();
				
				for(int j=0;j<lastCellNum;j++){
					//读取
					XSSFCell cell = row.getCell(j);
					if(row.getCell(i)!=null){
						row.getCell(0).setCellType(cell.CELL_TYPE_STRING);
						row.getCell(1).setCellType(cell.CELL_TYPE_STRING);
						row.getCell(3).setCellType(cell.CELL_TYPE_STRING);
						row.getCell(4).setCellType(cell.CELL_TYPE_STRING);
						row.getCell(6).setCellType(cell.CELL_TYPE_STRING);
						row.getCell(7).setCellType(cell.CELL_TYPE_STRING);
				    }
					
					
					if(i>0&&j==8) {
						Date d = cell.getDateCellValue();
						SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
						value = s.format(d);
						System.out.println(value+" ");
					}else {
						value = cell.getStringCellValue();
						System.out.print(value+" ");
					}
					
					
					
					if(i>=1) {//去掉第一行头
						if(j==8) {
							ab.setAdata(value);
						}else if(j==1) {
							ab.setAstudentno(value);
						}else if(j==2) {
							ab.setAname(value);
						}else if(j==3) {
							ab.setId(Integer.parseInt(value));
						}else if(j==4) {
							ab.setAphone(value);
						}else if(j==5) {
							ab.setAcontent(value);
						}else if(j==6) {
							ab.setCid(Integer.parseInt(value));
						}else if(j==7) {
							ab.setCoid(Integer.parseInt(value));
						}
					}
					
				}
				//添加到list集合
				if(i==0) {
					System.out.println("第一次");
				}
				if(i!=0) {
					list.add(ab);
				}
				
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//循环list
		for(int i=0;i<list.size();i++) {
			ArtapplyBean a =(ArtapplyBean) list.get(i);
			//插入报名表
			minService.artadd(a);
			//插入缴费表
			minService.addartfiance(a);
		}
		
		
		
		return null;
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
