package com.edu.model;

import java.io.Serializable;
/**
 * 
 * @author Min
 * 共享管理表  	shareid主键
 * 			sharetitle标题
 * 			sharephoto图片
 * 			sharecontent内容
 * 			sharepicture图片
 */
public class Share implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer shareid;
	private String sharetitle;
	private String sharephoto;
	private String sharecontent;
	private String sharepicture;
	public Integer getShareid() {
		return shareid;
	}
	public void setShareid(Integer shareid) {
		this.shareid = shareid;
	}
	public String getSharetitle() {
		return sharetitle;
	}
	public void setSharetitle(String sharetitle) {
		this.sharetitle = sharetitle;
	}
	public String getSharephoto() {
		return sharephoto;
	}
	public void setSharephoto(String sharephoto) {
		this.sharephoto = sharephoto;
	}
	public String getSharecontent() {
		return sharecontent;
	}
	public void setSharecontent(String sharecontent) {
		this.sharecontent = sharecontent;
	}
	public String getSharepicture() {
		return sharepicture;
	}
	public void setSharepicture(String sharepicture) {
		this.sharepicture = sharepicture;
	}
	
}
