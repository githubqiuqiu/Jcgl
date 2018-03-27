package com.edu.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class City implements Serializable {
	private Integer cid;
	private String cname;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	//与县区表一对多
	private Set<County> counties= new HashSet<>();
	public Set<County> getCounties() {
		return counties;
	}
	public void setCounties(Set<County> counties) {
		this.counties = counties;
	}
	//与会计表一对多
	private Set<Accountantapply> accountantapplies = new HashSet<>();
	public Set<Accountantapply> getAccountantapplies() {
		return accountantapplies;
	}
	public void setAccountantapplies(Set<Accountantapply> accountantapplies) {
		this.accountantapplies = accountantapplies;
	}
}
