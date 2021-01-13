package com.javacto.po;
/**
 * 
 * Title:BlogArticleCategory
 * describe:文章分类
 * @author 曾老师 javacto.ke.qq.com
 * @version 1.0
 */
public class BlogArticleCategory {
	private Integer bacId;//文章分类id
	private String bacName;//--文章分类名称
	private Integer bacParentId;//文章分类父id

	@Override
	public String toString() {
		return "BlogArticleCategory{" +
				"bacId=" + bacId +
				", bacName='" + bacName + '\'' +
				", bacParentId=" + bacParentId +
				'}';
	}

	public Integer getBacId() {
		return bacId;
	}
	public void setBacId(Integer bacId) {
		this.bacId = bacId;
	}
	public String getBacName() {
		return bacName;
	}
	public void setBacName(String bacName) {
		this.bacName = bacName;
	}
	public Integer getBacParentId() {
		return bacParentId;
	}
	public void setBacParentId(Integer bacParentId) {
		this.bacParentId = bacParentId;
	}
	
	

}
