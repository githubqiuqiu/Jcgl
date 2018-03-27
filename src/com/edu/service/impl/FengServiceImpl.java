package com.edu.service.impl;

import java.util.List;

import com.edu.dao.impl.FengDaoImpl;
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
import com.edu.service.FengService;

public class FengServiceImpl implements FengService{
	private	FengDaoImpl fengDao;

	public FengDaoImpl getFengDao() {
		return fengDao;
	}

	public void setFengDao(FengDaoImpl fengDao) {
		this.fengDao = fengDao;
	}
	
//插入成人教育数据
		@Override
		public boolean insertinto(Adultapply bean) {
			boolean fh=fengDao.insert(bean);//插入方法
			return fh;
		}
//插入会计报名数据
		@Override
		public boolean insertacc(Accountantapply bean) {
			boolean fh=fengDao.inAcco(bean);
			return fh;
		}
//插入艺考报名数据		
		@Override
		public boolean insertaart(Artapply bean) {
			boolean fh=fengDao.inArta(bean);
			return fh;
		}
//插入职业资格报名数据		
		@Override
		public boolean inserprofe(Professionapply bean) {
			boolean fh=fengDao.inProf(bean);
			return fh;
		}
//插入国家开放报名数据		
		@Override
		public boolean inserstate(Stateapply bean) {
			boolean fh=fengDao.instat(bean);
			return fh;
		}
//插入远程教育报名数据		
		@Override
		public boolean inserdista(Distanceapply bean) {
			boolean fh=fengDao.indist(bean);
			return fh;
		}
		
		
	//查询城市数据
		@Override
		public List selectcity() {
			List fh=fengDao.selectCS();//调用Dao层的查询方法
			return fh;
		}
		
	//根据市查询县
		@Override
		public List selectcounty(Integer id) {
			List list=fengDao.selectXC(id);
			return list;
		}
		
	//查询院校数据
		@Override
		public List selectAcademy() {
			List list=fengDao.selectAcad();
			return list;
		}

	//查询专业数据	
		@Override
		public List selectASP(Integer id) {
		List lsit=fengDao.selectSpe(id);
			return lsit;
		}

		
//------------------------------------------------------------------------------------缴费操作1		
//查询成人教育学生学号数据		
		@Override
		public List selectssid() {
		 List list=fengDao.selesid();
			return list;
		}

//成人教育缴费表插入数据		
		@Override
		public boolean insertltfinace(Adultfinance bean) {
			boolean ss=fengDao.insertfi(bean);
			return ss;
		}

		
//国家开放数据查询		
		@Override
		public List selectstid() {
			 List list=fengDao.selestate();
				return list;
		}
		
//国家开放插入数据
		@Override
		public boolean insertstfinace(Statefinance bean) {
			boolean ss=fengDao.insertfista(bean);
			return ss;
		}

//远程教育报名数据查询		
		@Override
		public List selectstDist() { 
			List list=fengDao.selesdist();
			return list;
		}
//远程教育缴费数据插入
		@Override
		public boolean insertDistan(Distancefinance bean) {
			boolean ss=fengDao.insertdist(bean);
			return ss;
		}
//--------------------------------------------------------------------------------------缴费操作2
	
//查询会计报名数据
		@Override
		public List selectacdc() {
			List list=fengDao.selesAccdc();
			return list;
		}
//插入会计缴费表
		@Override
		public boolean insertaccoun(Accountantfinance bean) {
			boolean ss=fengDao.insertAccoun(bean);
			return ss;
		}

//查询出艺考报名数据		
		@Override
		public List selectartapp() {
			List list=fengDao.selesArtfi();
			return list;
		}
//插入艺考缴费数据
		@Override
		public boolean insertartapply(Artfinance bean) {
			boolean ss=fengDao.insertArtfi(bean);
			return ss;
		}
//查询职业资格报名数据
		@Override
		public List selectPro() {
			List list=fengDao.seleProfe();
			return list;
		}
//插入职业资格缴费数据
		@Override
		public boolean insertPro(Professionfinance bean) {
			boolean ss=fengDao.insertProfes(bean);
			return ss;
		}
	 	
}
