package com.edu.model;

import java.io.Serializable;
/**
 * 
 * @author Min
 *	热门专业表    hmid 主键
 *			hmtitle 名称
 *			hmpicture 图片
 *			hmcontent 内容
 */
public class Hotmajor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer hmid;
	private String hmtitle;
	private String hmpicture;
	private String hmcontent;
	public Integer getHmid() {
		return hmid;
	}
	public void setHmid(Integer hmid) {
		this.hmid = hmid;
	}
	public String getHmtitle() {
		return hmtitle;
	}
	public void setHmtitle(String hmtitle) {
		this.hmtitle = hmtitle;
	}
	public String getHmpicture() {
		return hmpicture;
	}
	public void setHmpicture(String hmpicture) {
		this.hmpicture = hmpicture;
	}
	public String getHmcontent() {
		return hmcontent;
	}
	public void setHmcontent(String hmcontent) {
		this.hmcontent = hmcontent;
	}
}
