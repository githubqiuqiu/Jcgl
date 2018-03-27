package com.edu.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Min
 *	用户表            id 主键
 *			loginname登录名 
 *			name用户名
 *			password密码
 *		  	sex性别     0为男   1为女
 *			age年龄
 *			phone电话
 *			usertype用户类型  0用户 1管理员
 *			status用户状态  0启用 1停用
 *			organizationid所属机构
 *			createtime时间
 *			rid 角色id
 */
public class User implements Serializable{
	private Integer id;
	private String loginname;
	private String name;
	private String password;
	private Integer sex;
	private Integer age;
	private String phone;
	private Integer usertype;
	private Integer status;
	private Integer organizationid;
	private String createtime;
	private Integer rid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getUsertype() {
		return usertype;
	}
	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getOrganizationid() {
		return organizationid;
	}
	public void setOrganizationid(Integer organizationid) {
		this.organizationid = organizationid;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	
	
		//角色管理表
		private Role role;
		public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
		}
		
		//部门表
		private Organization organization;
		public void setOrganization(Organization organization) {
			this.organization = organization;
		}
		public Organization getOrganization() {
			return organization;
		}
		
		//与会计表一对多
		private Set<Accountantapply> accountantapplies = new HashSet();
		public Set<Accountantapply> getAccountantapplies() {
			return accountantapplies;
		}
		public void setAccountantapplies(Set<Accountantapply> accountantapplies) {
			this.accountantapplies = accountantapplies;
		}
		
		//与艺考表一对多
		private Set<Artapply> artapplies = new HashSet<>();
		public Set<Artapply> getArtapplies() {
			return artapplies;
		}
		public void setArtapplies(Set<Artapply> artapplies) {
			this.artapplies = artapplies;
		}
		
		//与职考表一对一
		private Set<Professionapply> professionapplies;
		public Set<Professionapply> getProfessionapplies() {
			return professionapplies;
		}
		public void setProfessionapplies(Set<Professionapply> professionapplies) {
			this.professionapplies = professionapplies;
		}
		
		//成人教育报名表(一个user 对应多个学生)
		private Set<Adultapply> adultapply=new HashSet<>();
		public Set<Adultapply> getAdultapply() {
			return adultapply;
		}
		public void setAdultapply(Set<Adultapply> adultapply) {
			this.adultapply = adultapply;
		}
		
		//成人教育缴费表
		private Set<Adultfinance> adultfinance=new HashSet<>();
		
		public Set<Adultfinance> getAdultfinance() {
			return adultfinance;
		}
		public void setAdultfinance(Set<Adultfinance> adultfinance) {
			this.adultfinance = adultfinance;
		}
		
		//国家开放大学报名表(一个院校对应多个学生)
		private Set<Stateapply> stateapply=new HashSet<>();
		public Set<Stateapply> getStateapply() {
			return stateapply;
		}
		public void setStateapply(Set<Stateapply> stateapply) {
			this.stateapply = stateapply;
		}
		
		//国家开放大学缴费表
		private Set<Statefinance> statefinance=new HashSet<>();
		public Set<Statefinance> getStatefinance() {
			return statefinance;
		}
		public void setStatefinance(Set<Statefinance> statefinance) {
			this.statefinance = statefinance;
		}
		
		
		//远程教育报名表(一个院校对应多个学生)
		private Set<Distanceapply> distanceapply=new HashSet<>();
		public Set<Distanceapply> getDistanceapply() {
			return distanceapply;
		}
		public void setDistanceapply(Set<Distanceapply> distanceapply) {
			this.distanceapply = distanceapply;
		}
		
		//远程教育缴费表
		private Set<Distancefinance> distancefinance=new HashSet<>();
		public Set<Distancefinance> getDistancefinance() {
			return distancefinance;
		}
		public void setDistancefinance(Set<Distancefinance> distancefinance) {
			this.distancefinance = distancefinance;
		}
		
		//会计缴费表
		private Set<Accountantfinance> accountantfinance=new HashSet<>();
		public Set<Accountantfinance> getAccountantfinance() {
			return accountantfinance;
		}
		public void setAccountantfinance(Set<Accountantfinance> accountantfinance) {
			this.accountantfinance = accountantfinance;
		}
		
		//职考缴费表
		private Set<Professionfinance> professionfinance=new HashSet<>();
		public Set<Professionfinance> getProfessionfinance() {
			return professionfinance;
		}
		public void setProfessionfinance(Set<Professionfinance> professionfinance) {
			this.professionfinance = professionfinance;
		}
		
		//艺考缴费表
		private Set<Artfinance> artfinance=new HashSet<>();
		public Set<Artfinance> getArtfinance() {
			return artfinance;
		}
		public void setArtfinance(Set<Artfinance> artfinance) {
			this.artfinance = artfinance;
		}
		
		//工作助手
		private Set<Schedule> schedule=new HashSet<>();
		public Set<Schedule> getSchedule() {
			return schedule;
		}
		public void setSchedule(Set<Schedule> schedule) {
			this.schedule = schedule;
		}

}
