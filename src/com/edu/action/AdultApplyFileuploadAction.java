package com.edu.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.edu.bean.AdultapplyBean;
import com.edu.model.Academy;
import com.edu.model.Adultapply;
import com.edu.model.City;
import com.edu.model.County;
import com.edu.model.Specialty;
import com.edu.model.User;
import com.edu.service.QiuService;
import com.opensymphony.xwork2.ActionSupport;

public class AdultApplyFileuploadAction extends ActionSupport{
	private QiuService qiuService;
	//定义文件上传的大小
	private static final int buffersize=1024*16;
	
	//文件
	private File myfile;
	
	//文件内容
	private String myfileContentType;
	
	//文件名
	private String  myfileFileName;
	
	//给新文件定义一个新名字
	private String newfilename;
	
	//bean
	private AdultapplyBean ab;
	
	//定义一个list
	private List<AdultapplyBean> list=new ArrayList<>();
	
	private List listadult;
	
	public List<AdultapplyBean> getList() {
		return list;
	}

	public void setList(List<AdultapplyBean> list) {
		this.list = list;
	}

	public AdultapplyBean getAb() {
		return ab;
	}

	public void setAb(AdultapplyBean ab) {
		this.ab = ab;
	}

	public QiuService getQiuService() {
		return qiuService;
	}

	public void setQiuService(QiuService qiuService) {
		this.qiuService = qiuService;
	}

	public File getMyfile() {
		return myfile;
	}

	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}

	public String getMyfileContentType() {
		return myfileContentType;
	}

	public void setMyfileContentType(String myfileContentType) {
		this.myfileContentType = myfileContentType;
	}

	public String getMyfileFileName() {
		return myfileFileName;
	}

	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}

	public String getNewfilename() {
		return newfilename;
	}

	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
	}

	//读取文件的方法
	public void  copy(File src,File tosrc){
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
	
	//获取文件内容类型的方法
	public String getcontentType(String name){
		//获得文件名的最后一个.的下标
		int index=name.lastIndexOf(".");
		return name.substring(index);
	}
	
	//文件上传  批量导入数据到数据库
	public String adultapplyaddmanyfileupload() {
		Random r=new Random();
		String strs=r.nextInt(1000000)+"";
		
		//得到一个新名称
		newfilename=new Date().getTime()+strs+getcontentType(myfileFileName);
		//获取项目路径
		String url=ServletActionContext.getServletContext().getRealPath("/upload");
		//保存文件
		File newfile=new File(url+"/"+newfilename);
		//执行上传
		copy(myfile, newfile);
		//获取新上传的.xlsx格式的表格路径
		String urls=url+"/"+newfilename;
		
		String value=null;
		File file=new File(urls);
		
		try {
			//创建工作簿 读取内容
			XSSFWorkbook workbook=new XSSFWorkbook(FileUtils.openInputStream(file));
			//读取Excel文件的第一个工作页
			//方式一
			//HSSFSheet sheet = workbook.getSheet("sheet0");
			//方式二
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			int firstRowNum = 0;  //第一行
			//获取sheet中最后一行行号
			int lastRowNum = sheet.getLastRowNum();  //获取最后一行
			
			//循环每一行  获取每一行里面每一列的值
			for(int i=0;i<=lastRowNum;i++){//从第一行循环到最后一行
				XSSFRow row = sheet.getRow(i);
				//获取当前行最后单元格列号
				int lastCellNum = row.getLastCellNum();
				//循环这一行来读取每一个单元格中的内容
				
				ab=new AdultapplyBean();
				
				//循环每一列
				for (int j = 0; j < lastCellNum; j++) {
					//读取
					XSSFCell cell = row.getCell(j);
					if(row.getCell(i)!=null){
						row.getCell(0).setCellType(cell.CELL_TYPE_STRING);
						row.getCell(1).setCellType(cell.CELL_TYPE_STRING);
						row.getCell(2).setCellType(cell.CELL_TYPE_STRING);
						row.getCell(3).setCellType(cell.CELL_TYPE_STRING);
						row.getCell(4).setCellType(cell.CELL_TYPE_STRING);
						row.getCell(5).setCellType(cell.CELL_TYPE_STRING);
						row.getCell(6).setCellType(cell.CELL_TYPE_STRING);
						row.getCell(7).setCellType(cell.CELL_TYPE_STRING);
						row.getCell(8).setCellType(cell.CELL_TYPE_STRING);
						row.getCell(9).setCellType(cell.CELL_TYPE_STRING);
						row.getCell(10).setCellType(cell.CELL_TYPE_STRING);
						row.getCell(11).setCellType(cell.CELL_TYPE_STRING);
				    }
					value = cell.getStringCellValue();
					System.out.print(value+" ");
					if(i>=1) {//去掉第一行表头
						//循环读取每一个的每一列数据  第一列下标为0
						if(j==0) {
							ab.setAstudentno(value);
						}
						if(j==1) {
							ab.setAname(value);
						}
						if(j==2) {
							ab.setUserid(Integer.parseInt(value));
						}
						if(j==3) {
							ab.setIdnumber(value);
						}
						if(j==4) {
							ab.setAphone(value);
						}
						if(j==5) {
							ab.setAtype(Integer.parseInt(value));
						}
						if(j==6) {
							ab.setAcaid(Integer.parseInt(value));
						}
						if(j==7) {
							ab.setSpecid(Integer.parseInt(value));
						}
						if(j==8) {
							ab.setAgradation(value);
						}
						if(j==9) {
							ab.setAsystem(value);
						}
						if(j==10) {
							ab.setCityid(Integer.parseInt(value));
						}
						if(j==11) {
							ab.setCountyid(Integer.parseInt(value));
						}
						
					}
					
					
				}
				
				
				if(i!=0) {
					
					list.add(ab);
					//System.out.println("=======");
				}
			}
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//循环list   将学生信息插入报名表 插入缴费表
		for (int k = 0; k < list.size(); k++) {
			AdultapplyBean a=list.get(k);
			//保存批量添加到成人高考报名表
			qiuService.addmanyadultapply(a);
			//保存批量添加到成人高考缴费表
			qiuService.addmanyadultfinance(a);
		}
		
		
		return SUCCESS;
	}
	
	//批量导出数据到数据库
	public String exportmanyadultapply() {
		System.out.println("进了导出");
		
		//excel表格的第一行 字段
		String[] title = {"学生编号","学生姓名","老师姓名","身份证号码","手机号码","报考院校","专业","报考层次","学制","报名类型","城市","县/区","报名时间"};	
		
		//创建Excel工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		//创建一个工作表sheet
		XSSFSheet sheet = workbook.createSheet();
		
		//创建第一行
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell = null;
		//插入第一行数据  String[] title
		for (int i = 0; i < title.length; i++) {
		cell = row.createCell(i);
		cell.setCellValue(title[i]);
		}
		
		//查询数据
		listadult=qiuService.seladus();
		List<AdultapplyBean> list1=new ArrayList<>();
		//追加数据
		for (int i = 0; i < listadult.size(); i++) {
			Object[] o = (Object[])listadult.get(i);
			
			Adultapply adu=new Adultapply();
			User u=new User();
			Academy aca=new Academy();
			Specialty spe=new Specialty();
			City c=new City();
			County co=new County();
			
			AdultapplyBean ab=new AdultapplyBean();
			
			adu=(Adultapply) o[0];
			u=(User) o[1];
			aca=(Academy) o[2];
			spe=(Specialty) o[3];
			c=(City) o[4];
			co=(County) o[5];
			
			ab.setAid(adu.getAid());
			ab.setAstudentno(adu.getAstudentno());
			ab.setAname(adu.getAname());
			ab.setUserid(adu.getUserid());
			ab.setIdnumber(adu.getIdnumber());
			ab.setAphone(adu.getAphone());
			ab.setAtype(adu.getAtype());
			ab.setAcaid(adu.getAcaid());
			ab.setSpecid(adu.getSpecid());
			ab.setAgradation(adu.getAgradation());
			ab.setAsystem(adu.getAsystem());
			ab.setCityid(adu.getCityid());
			ab.setCountyid(adu.getCountyid());
			ab.setAdata(adu.getAdata());
			
			ab.setUsername(u.getName());
			ab.setAcaname(aca.getAschool());
			ab.setSpecname(spe.getSname());
			ab.setCityname(c.getCname());
			ab.setCountyname(co.getConame());
			
			//插入数据到表格
			XSSFRow nextrow = sheet.createRow(i+1);
			
			//得到第一个单元格
			XSSFCell cell2 = nextrow.createCell(0);
			cell2.setCellValue(adu.getAstudentno());
			
			//得到第二个单元格
			cell2 = nextrow.createCell(1);
			cell2.setCellValue(adu.getAname());
			
			//得到第三个单元格
			cell2 = nextrow.createCell(2);
			cell2.setCellValue(u.getName());
			
			//得到第四个单元格
			cell2 = nextrow.createCell(3);
			cell2.setCellValue(adu.getIdnumber());
			
			//得到第五个单元格
			cell2 = nextrow.createCell(4);
			cell2.setCellValue(adu.getAphone());
			
			//得到第六个单元格
			cell2 = nextrow.createCell(5);
			cell2.setCellValue(aca.getAschool());
			
			//得到第七个单元格
			cell2 = nextrow.createCell(6);
			cell2.setCellValue(spe.getSname());
			
			//得到第八个单元格
			cell2 = nextrow.createCell(7);
			cell2.setCellValue(adu.getAgradation());
			
			//得到第九个单元格
			cell2 = nextrow.createCell(8);
			cell2.setCellValue(adu.getAsystem());
			
			//得到第十个单元格
			cell2 = nextrow.createCell(9);
			cell2.setCellValue("成人教育");
			
			//得到第十一个单元格
			cell2 = nextrow.createCell(10);
			cell2.setCellValue(c.getCname());
			
			//得到第十二个单元格
			cell2 = nextrow.createCell(11);
			cell2.setCellValue(co.getConame());
			
			//得到第十三个单元格
			cell2 = nextrow.createCell(12);
			cell2.setCellValue(adu.getAdata());
			String filepath = ServletActionContext.getServletContext().getRealPath("/upload") + "/";
			//创建一个文件
			File file = new File(filepath+"export.xlsx");
			try {
				file.createNewFile();
				
				//将Excel内容存盘
				FileOutputStream stream = FileUtils.openOutputStream(file);
				workbook.write(stream);
				stream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}	
		return null;
	}
	
	
	
}
