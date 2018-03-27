package com.edu.action;

import java.util.List;

import com.edu.model.Userjurisdiction;
import com.edu.service.QiuService;
import com.opensymphony.xwork2.ActionSupport;

public class GrantAction extends ActionSupport{
	private Integer[] id=new Integer[27];
	private QiuService qiuService;
	private Integer rid;
	private Integer jid[];
	private Integer []xid=new Integer[27];
	private Integer[] flag=new Integer[27];
	private List<Userjurisdiction> listuserjur;
	
	
	
	public Integer[] getXid() {
		return xid;
	}

	public void setXid(Integer[] xid) {
		this.xid = xid;
	}

	public Integer[] getId() {
		return id;
	}

	public void setId(Integer[] id) {
		this.id = id;
	}

	public Integer[] getFlag() {
		return flag;
	}

	public void setFlag(Integer[] flag) {
		this.flag = flag;
	}

	public List<Userjurisdiction> getListuserjur() {
		return listuserjur;
	}

	public void setListuserjur(List<Userjurisdiction> listuserjur) {
		this.listuserjur = listuserjur;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}
	
	public QiuService getQiuService() {
		return qiuService;
	}

	public void setQiuService(QiuService qiuService) {
		this.qiuService = qiuService;
	}

	public Integer[] getJid() {
		return jid;
	}

	public void setJid(Integer[] jid) {
		this.jid = jid;
	}

	//修改权限前 先查询用户有的权限
	public String findgrant() {
		System.out.println("rid="+rid);
		//根据用户rid查该用户有哪些权限
		listuserjur=qiuService.findjurbyrid(rid);
		for (int i = 0; i < listuserjur.size(); i++) {
			Userjurisdiction u=listuserjur.get(i);
			//把id赋给id数组
			id[i]=u.getId();
			//把flag赋给flag数组
			flag[i]=u.getFlag();
			//System.out.println("flag="+flag[i]);
		}
		//System.out.println("返回成功");
		return SUCCESS;
	}
	
	//修改权限
	public String grant() {
		//System.out.println("进了修改权限");
		//System.out.println("rid="+rid);
		//不管有没有权限选中先根据id把用户的所有权限清空(赋1)
		for (int i = 0; i < xid.length; i++) {
			//先删除用户的所有权限
			qiuService.deljurbyid(xid[i]);
		}
		
		if(jid!=null) {//如果权限选中
			for (int i = 0; i < jid.length; i++) {
				//System.out.println("id="+jid[i]);
				qiuService.addjurbyid(jid[i]);
			}
		}
		
		return SUCCESS;
	}
}
