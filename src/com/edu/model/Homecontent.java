package com.edu.model;

import java.io.Serializable;
/**
 * 
 * @author Min
 *	首页内容        hcid 主键
 *		    pictureone 轮播图1
 *		    picturetwo 轮播图2
 *			picturethree 轮播图3
 *			qrcodeone 二维码1
 *			qrcodetwo 二维码2
 *			hcphone 电话
 *			hcaddress 地址
 *			interlinkageone 链接1	
 *			interlinkagetwo 链接2	
 *			interlinkagethree 链接3
 *			interlinkagefour 链接4			
 */
public class Homecontent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer hcid;
	private String pictureone;
	private String picturetwo;
	private String picturethree;
	private String qrcodeone;
	private String qrcodetwo;
	private String hcphone;
	private String hcaddress;
	private String interlinkageone;
	private String interlinkagetwo;
	private String interlinkagethree;
	private String interlinkagefour;
	public Integer getHcid() {
		return hcid;
	}
	public void setHcid(Integer hcid) {
		this.hcid = hcid;
	}
	public String getPictureone() {
		return pictureone;
	}
	public void setPictureone(String pictureone) {
		this.pictureone = pictureone;
	}
	public String getPicturetwo() {
		return picturetwo;
	}
	public void setPicturetwo(String picturetwo) {
		this.picturetwo = picturetwo;
	}
	public String getPicturethree() {
		return picturethree;
	}
	public void setPicturethree(String picturethree) {
		this.picturethree = picturethree;
	}
	public String getQrcodeone() {
		return qrcodeone;
	}
	public void setQrcodeone(String qrcodeone) {
		this.qrcodeone = qrcodeone;
	}
	public String getQrcodetwo() {
		return qrcodetwo;
	}
	public void setQrcodetwo(String qrcodetwo) {
		this.qrcodetwo = qrcodetwo;
	}
	public String getHcphone() {
		return hcphone;
	}
	public void setHcphone(String hcphone) {
		this.hcphone = hcphone;
	}
	public String getHcaddress() {
		return hcaddress;
	}
	public void setHcaddress(String hcaddress) {
		this.hcaddress = hcaddress;
	}
	public String getInterlinkageone() {
		return interlinkageone;
	}
	public void setInterlinkageone(String interlinkageone) {
		this.interlinkageone = interlinkageone;
	}
	public String getInterlinkagetwo() {
		return interlinkagetwo;
	}
	public void setInterlinkagetwo(String interlinkagetwo) {
		this.interlinkagetwo = interlinkagetwo;
	}
	public String getInterlinkagethree() {
		return interlinkagethree;
	}
	public void setInterlinkagethree(String interlinkagethree) {
		this.interlinkagethree = interlinkagethree;
	}
	public String getInterlinkagefour() {
		return interlinkagefour;
	}
	public void setInterlinkagefour(String interlinkagefour) {
		this.interlinkagefour = interlinkagefour;
	}
	
}
