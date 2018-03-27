package com.edu.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Min
 *	角色管理       id主键
 *			name角色名
 *			seq排序
 *			description描述
 *			status状态 0启用 1停用
 */
public class Role implements Serializable{
	private Integer id;
	private String name;
	private Integer seq;
	private String description;
	private Integer status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	//用户管理表(role角色1  user用户多)
	private Set<User> user=new HashSet<>();
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	
	
}
