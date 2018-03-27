package com.edu.action;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import com.edu.service.impl.MinServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class JFPieChartAction extends ActionSupport {
	private MinServiceImpl minService;
	public MinServiceImpl getMinService() {
		return minService;
	}

	public void setMinService(MinServiceImpl minService) {
		this.minService = minService;
	}

	private static final long serialVersionUID = 5752180822913527064L;
	 private JFreeChart chart;
	  
	 public String execute(){
	  
	       //生成JFreeChart对象   
	       chart = ChartFactory.createPieChart3D(
	             "饼状图",  // 图表标题
	              getDataSet(), //数据
	              true, // 是否显示图例
	              false, //是否显示工具提示
	              false //是否生成URL
	           );

	        //通过JFreeChart对象的 setTitle方法，修改统计图表的标题部分（包括修改图表标题内容、字体大小等）
	        chart.setTitle(new TextTitle("学生报名统计图", new Font("黑体", Font.ITALIC , 22))); 
	        //调用 JFreeChart对象的 getLegend(int index)方法，取得该图表的指定索引的图例对象，通过 LegendTitle对象来修改统计图表的图例  
	        LegendTitle legend = chart.getLegend(0); 
	        //设置图例的字体和字体大小，即位于下方的字的字体和大小
	        legend.setItemFont(new Font("宋体", Font.BOLD, 14));
	        // 设置画布背景色
	        //chart.setBackgroundPaint(new Color(192, 228, 106));
	        
	        //取得饼图的绘图(plot)对象
	        PiePlot plot = (PiePlot)chart.getPlot();
	        
	        //设置Pie图的分类标签的字体，即位于Pie图的中间部分的每个扇形旁边对应的字的字体
	        plot.setLabelFont(new Font("隶书", Font.BOLD, 16));
	        //设置数据区的背景透明度，范围在0.0～1.0间
	        plot.setBackgroundAlpha(0.9f);
	        //设置PieChart是否显示为圆形    
	        plot.setCircular(true);
	        //完全关闭片区外廓，若将值设为 true 即可让外廓显示出来
	        plot.setSectionOutlinesVisible(false);
	        //设置忽略零值，不设值时默认会将一个标签放置在饼图片区显示的位置，并且在图表的图例中添加一个分类。
	        //plot.setIgnoreZeroValues(true);
	        //设置忽略null值，不设值时默认情况跟零值一样
	        //plot.setIgnoreNullValues(true);
	        
	        //设置旋转角度    
	        plot.setStartAngle(90.0);    
	        //设置旋转方向，Rotation.CLOCKWISE)为顺时针。    
	        plot.setDirection(Rotation.CLOCKWISE); 
	        
	        //设置将某一片区取出，即偏离图表中心，以起到强调作用
	        plot.setExplodePercent("文学类", 0.2);
	        
	        //设置每个数据区的填充颜色，不设置即默认，默认时是自动分配的
	        //plot.setSectionPaint("文学类", new Color(200, 255, 255));        
	        
	        // 图片中显示百分比:自定义方式，{0} 表示选项， {1} 表示数值， {2} 表示所占比例 ,小数点后两位
	        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})", NumberFormat.getNumberInstance(),new DecimalFormat("0.00%")));
	        // 图例显示百分比:自定义方式， {0} 表示选项， {1} 表示数值， {2} 表示所占比例
	        //plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})"));
	      
	       return SUCCESS;
	 
	 }
	 
	 public DefaultPieDataset getDataSet(){
	   DefaultPieDataset data = new DefaultPieDataset();
//	      data.setValue("Java", new Double(43.2));
//	      data.setValue("Visual Basic", new Double(1.0));
//	      data.setValue("C/C++", new Double(17.5));
//	      data.setValue("tangjun书", new Double(60.0));
	   //查询每个报名的人数
	   int acc = minService.selcountacc();
	   int adu = minService.selcountadu();
	   int art = minService.selcountart();
	   int dis = minService.selcountdis();
	   int pro = minService.selcountpro();
	   int sta = minService.selcountsta();
	   data.setValue("成人教育", adu);
	   data.setValue("国家开放", sta);
	   data.setValue("远程教育", dis);
	   data.setValue("会计", acc);
	   data.setValue("艺考", art);
	   data.setValue("职考", pro);
	      return data;
	 }
	 
	 public JFreeChart getChart() {
		 return chart;
	 }
}
