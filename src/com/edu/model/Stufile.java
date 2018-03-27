package com.edu.model;

import java.io.Serializable;

public class Stufile implements Serializable{
	private Integer sfid;
	private Integer stuid;
	private String stuname;
	private String sfphoto;
	private String sfvoucher;
	private String sfpaper;
	private String sfdate;
	public Integer getSfid() {
		return sfid;
	}
	public void setSfid(Integer sfid) {
		this.sfid = sfid;
	}
	public Integer getStuid() {
		return stuid;
	}
	public void setStuid(Integer stuid) {
		this.stuid = stuid;
	}
	
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getSfphoto() {
		return sfphoto;
	}
	public void setSfphoto(String sfphoto) {
		this.sfphoto = sfphoto;
	}
	public String getSfvoucher() {
		return sfvoucher;
	}
	public void setSfvoucher(String sfvoucher) {
		this.sfvoucher = sfvoucher;
	}
	public String getSfpaper() {
		return sfpaper;
	}
	public void setSfpaper(String sfpaper) {
		this.sfpaper = sfpaper;
	}
	public String getSfdate() {
		return sfdate;
	}
	public void setSfdate(String sfdate) {
		this.sfdate = sfdate;
	}
	
	
}
