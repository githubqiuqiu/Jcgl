package com.edu.service;

import java.util.List;

import com.edu.model.Accountantapply;
import com.edu.model.Accountantfinance;
import com.edu.model.Adultapply;
import com.edu.model.Adultfinance;
import com.edu.model.Artapply;
import com.edu.model.Artfinance;
import com.edu.model.Distanceapply;
import com.edu.model.Distancefinance;
import com.edu.model.Professionapply;
import com.edu.model.Professionfinance;
import com.edu.model.Stateapply;
import com.edu.model.Statefinance;

public interface FengService {
	//成人教育插入数据
		public boolean insertinto(Adultapply bean);
	//会计报名插入数据
		public boolean insertacc(Accountantapply bean);
	//艺考报名插入数据
		public boolean insertaart(Artapply bean);
	//职业资格报名插入数据
		public boolean inserprofe(Professionapply bean);			
	//会计报名插入数据
		public boolean inserstate(Stateapply bean);	
	//会计报名插入数据
		public boolean inserdista(Distanceapply bean);		
		
		
		//城市查询数据
	    public List selectcity();
	    
	    //根据城市查询县
	    public List selectcounty(Integer id);
	    
	    //院校查询返回值
	    public List selectAcademy();
	    
	    //查询专业返回值
	    public List selectASP(Integer id);
	    
//--------------------------------------------------------------------缴费操作1	    
//查询成人教育表数据
	    public List selectssid();
 	    
//成人教育缴费插入数据
	    public boolean insertltfinace(Adultfinance bean);
	    
//查询国家开放表数据
	    public List selectstid();
 	    
//国家开放缴费插入数据
	    public boolean insertstfinace(Statefinance bean);
	    
//查询远程教育表数据
	    public List selectstDist();
 	    
//远程教育缴费插入数据
	    public boolean insertDistan(Distancefinance bean);    
	    
//-----------------------------------------------------------------------缴费操作2	
	    
//查询会计报名表数据
	    public List selectacdc();
 	    
//会计缴费插入数据
	    public boolean insertaccoun(Accountantfinance bean);  
	    
//查询艺考报名表数据
	    public List selectartapp();
 	    
//艺考缴费插入数据
	    public boolean insertartapply(Artfinance bean); 
	    
//查询职业资格报名表数据
	    public List selectPro();
 	    
//职业资格缴费插入数据
	    public boolean insertPro(Professionfinance bean); 	    
}
