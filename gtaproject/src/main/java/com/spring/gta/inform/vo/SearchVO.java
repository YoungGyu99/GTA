package com.spring.gta.inform.vo;

public class SearchVO {

	private String keyword;
	private String category;
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "SearchVO [keyword=" + keyword + ", category=" + category + "]";
	}

	
}