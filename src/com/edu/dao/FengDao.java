package com.edu.dao;

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

public interface FengDao {
//------------------------------------------------------------------------------------------------------报名数据插入	
//插入数据到成人教育报名表
		public boolean insert(Adultapply bean);
		
//插入数据到会计报名表	
		public boolean inAcco(Accountantapply bean);
		
//插入数据到艺考报名表	
		public boolean inArta(Artapply bean);		
		
//插入数据到职业资格报名表	
		public boolean inProf(Professionapply bean);		
		
//插入数据到会计报名表	
		public boolean instat(Stateapply bean);

//插入数据到远程教育报名表	
		public boolean indist(Distanceapply bean);		
		
//------------------------------------------------------------------------------------------------------城市查询		
		
	//查询城市数据
		public List selectCS();
		
	//根据市查询县
		public List selectXC(Integer id);
		
	//院校查询
		public List selectAcad();
		
	//根据院校查询专业
		public List selectSpe(Integer id);
		
//------------------------------------------------------------------------------------------------------缴费表类型1操作

//查询成人教育学生学号	
		public List selesid();
//插入数据到成人教育缴费表
		public boolean insertfi(Adultfinance bean);
		
		
		
//查询国家开放学生学号	
		public List selestate();
//插入数据到国家开放缴费表
		public boolean insertfista(Statefinance bean);
		
		
		
//查询远程教育学生学号	
		public List selesdist();		
//插入数据到远程教育缴费表
		public boolean insertdist(Distancefinance bean);
		
		
//------------------------------------------------------------------------------------------------------------缴费类型2操作		
		//查询会计学生学号	
				public List selesAccdc();

		//插入数据到会计缴费表
				public boolean insertAccoun(Accountantfinance bean);
				
		//查询艺考学生学号	
				public List selesArtfi();

		//插入数据到艺考缴费表
				public boolean insertArtfi(Artfinance bean);	
				
		//查询职业资格学生学号	
				public List seleProfe();

		//插入数据到职业资格缴费表
				public boolean insertProfes(Professionfinance bean);
		
}
