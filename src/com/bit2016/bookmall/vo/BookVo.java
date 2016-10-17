package com.bit2016.bookmall.vo;

public class BookVo {

	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", price=" + price + ", category_no=" + category_no + "]";
	}

	private long no;
	private String title;
	private long price;
	private long category_no;

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getCategory_no() {
		return category_no;
	}

	public void setCategory_no(long category_no) {
		this.category_no = category_no;
	}

}
