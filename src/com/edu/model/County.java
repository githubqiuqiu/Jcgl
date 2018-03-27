package com.edu.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class County implements Serializable {
	private Integer coid;
	private String coname;
	private Integer cid;
	public Integer getCoid() {
		return coid;
	}
	public void setCoid(Integer coid) {
		this.coid = coid;
	}
	public String getConame() {
		return coname;
	}
	public void setConame(String coname) {
		this.coname = coname;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	//与城市表多对一
	private City city;
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
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
