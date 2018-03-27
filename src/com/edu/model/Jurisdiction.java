package com.edu.model;

import java.io.Serializable;

//权限表
public class Jurisdiction implements Serializable{
	private Integer id;
	private Integer jid;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getJid() {
		return jid;
	}
	public void setJid(Integer jid) {
		this.jid = jid;
	}
	
}
