package com.bit2016.bookmall.vo;

public class CategoryVo {

	@Override
	public String toString() {
		return "CategoryVo [name=" + name + ", no=" + no + "]";
	}

	private String name;
	private long no;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

}
