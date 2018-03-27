package com.edu.action;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.edu.service.QiuService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LineAction extends ActionSupport{
	private JFreeChart chart;
	private QiuService qiuService;
	
	
	public QiuService getQiuService() {
		return qiuService;
	}

	public void setQiuService(QiuService qiuService) {
		this.qiuService = qiuService;
	}

	// 必须提供 getChart() 方法，且由该方法返回 JFreeChart 对象
	public JFreeChart getChart() throws Exception {
		  //JFreeChart类是一个制图对象类，先用它来创建一个制图对象chart
	      //ChartFactory类是制图工厂类，用它来为制图对象chart完成实例化
		  //createLineChart()是制图工厂的一个方法，用来创建一个常规的折线图对象
		  chart = ChartFactory.createLineChart(
	    		  
	    		"教育收益统计图",                 //图表标题
	            "类别",                        //X轴标题     
	            "销售金额(元)",                        //Y轴标题
	            createDataset(),              //数据集
	            PlotOrientation.VERTICAL,     //绘制方向
	      		true,                         //是否显示图例
	      		false,                        //是否采用标准生成器
	      		false                         //是否支持超链接
	      		);
	      
	      //通过JFreeChart对象的 setTitle方法，修改统计图表的标题部分（包括修改图表标题内容、字体大小等）
	      chart.setTitle(new TextTitle("教育收益统计图", new Font("黑体", Font.ITALIC , 22))); 
	      //调用 JFreeChart对象的 getLegend(int index)方法，取得该图表的指定索引的图例对象，通过 LegendTitle对象来修改统计图表的图例  
	      LegendTitle legend = chart.getLegend(0); 
	      //设置图例的字体和字体大小，即位于下方的字的字体和大小
	      legend.setItemFont(new Font("宋体", Font.BOLD, 14));
	      // 设置画布背景色
	      chart.setBackgroundPaint(new Color(192, 228, 106)); 
	      //取得折线图的绘图(plot)对象
	      CategoryPlot plot = chart.getCategoryPlot();
	      //设置数据区的背景透明度，范围在0.0～1.0间
	      plot.setBackgroundAlpha(0.5f);
	      // 设置数据区的前景透明度，范围在0.0～1.0间     
	      plot.setForegroundAlpha(0.5f);     
	      // 设置横轴字体
	      plot.getDomainAxis().setLabelFont(new Font("黑体", Font.BOLD, 14));
	      // 设置坐标轴标尺值字体
		  plot.getDomainAxis().setTickLabelFont(new Font("宋体", Font.BOLD, 12));
		  // 设置纵轴字体
		  plot.getRangeAxis().setLabelFont(new Font("黑体", Font.BOLD, 14));
		  // 设置绘图区背景色
		  plot.setBackgroundPaint(Color.WHITE);
		  // 设置水平方向背景线颜色
		  plot.setRangeGridlinePaint(Color.BLACK);
		  // 设置是否显示水平方向背景线,默认值为true
		  plot.setRangeGridlinesVisible(true);
		  // 设置垂直方向背景线颜色
		  plot.setDomainGridlinePaint(Color.BLACK);
		  // 设置是否显示垂直方向背景线,默认值为false
		  plot.setDomainGridlinesVisible(true);
		  // 没有数据时显示的消息
	      plot.setNoDataMessage("没有相关统计数据");
	      plot.setNoDataMessageFont(new Font("黑体", Font.CENTER_BASELINE, 16));
	      plot.setNoDataMessagePaint(Color.RED);
		  
			
			// 获取折线对象
			LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot
					.getRenderer();

			//设置折点处以某种形状凸出
			renderer.setShapesVisible(true);
			renderer.setDrawOutlines(true);
			renderer.setUseFillPaint(true);
			renderer.setFillPaint(java.awt.Color.WHITE);
			
			//设置显示折点处的数据值
			//renderer.setBaseItemLabelGenerator (new StandardCategoryItemLabelGenerator ());
			//renderer.setItemLabelFont (new Font ("黑体", Font.PLAIN, 12));
			//renderer.setItemLabelsVisible (true);
			
	        BasicStroke realLine = new BasicStroke(2.0f); // 设置实线
			float dashes[] = { 8.0f }; // 定义虚线数组
			BasicStroke brokenLine = new BasicStroke(2.0f, // 线条粗细
					BasicStroke.CAP_SQUARE, // 端点风格
					BasicStroke.JOIN_MITER, // 折点风格
					8.f, // 折点处理办法
					dashes, // 虚线数组
					0.0f); // 虚线偏移量
			// 利用虚线绘制
			renderer.setSeriesStroke(0, brokenLine);
			// 利用虚线绘制
			renderer.setSeriesStroke(1, brokenLine);
			// 利用实线绘制
			renderer.setSeriesStroke(2, realLine);
			// 利用实线绘制
			renderer.setSeriesStroke(3, realLine);
			
			//设置折线的颜色
			renderer.setSeriesPaint(0, Color.BLACK);
			renderer.setSeriesPaint(1, Color.RED);
			renderer.setSeriesPaint(2, Color.BLUE);
			renderer.setSeriesPaint(3, Color.MAGENTA);
			
        //设置生成的图表的文件名
        String fileName = "tb1.jpg";
        //设置图表输出的指定路径
       // String filePath = FileUtil.getWebRootPath()+"images\\chart\\"+fileName;
        //设置图像输出的指定路径
        String filePath =ServletActionContext.getServletContext().getRealPath("/upload")+"/"+fileName;
        //输出图表到文件
        saveAsFile(filePath, chart, 800, 600);
		
        //取得request对象
        Map request = (Map)ActionContext.getContext().get("request");
		//把生成的图表文件的路径filePath放进request对象中
        request.put("filePath", filePath);
		
		return chart;
	}
	
	/**
	 * 保存图表为文件 
	 */
    public  void saveAsFile(String filePath, JFreeChart jfreeChart,      
            int weight, int height) throws IOException { 
        
    	//输出图表到文件，saveCharAsJPEG()方法的参数(File file,JFreeChart chart,int width,int height)
        ChartUtilities.saveChartAsJPEG(new File(filePath), jfreeChart, weight, height);
    }
    
    /**
     * 创建一个dataset，该dataset包含图表要显示的数据
     * @return CategoryDataset
     */
	public  CategoryDataset createDataset() {
		// 图例名称
		//String[] line = { "成考教育", "会计培训", "国家开放大学教育", "远程教育","艺考教育","职考教育"};
		String line="类别";
		// 类别
		String[] category = { "成考教育", "会计培训", "国家开放大学教育", "远程教育","艺考教育","职考教育"};
	
		// 实例化DefaultCategoryDataset对象
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		//查询成考缴费表的学生已交学费的总数
		double i1=qiuService.seladultfinancemoney();
		double i2=qiuService.selaccfinancemoney();
		double i3=qiuService.selstatefinancemoney();
		double i4=qiuService.seldisfinancemoney();
		double i5=qiuService.selartfinancemoney();
		double i6=qiuService.selprofinancemoney();
		
		dataset.addValue(i1,line,category[0]);
		dataset.addValue(i2,line,category[1]);
		dataset.addValue(i3,line,category[2]);
		dataset.addValue(i4,line,category[3]);
		dataset.addValue(i5,line,category[4]);
		dataset.addValue(i6,line,category[5]);
	
		return dataset;
	}

	//在struts.xml中的对应<action>里，应该写的是  method="pieChart" 和  <result type="chart">
	public String line() {
		return SUCCESS;
	}
}
