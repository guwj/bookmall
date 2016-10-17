package com.bit2016.bookmall.vo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		// insert test
		insertTest();
	}

	public static void insertTest() {
		CategoryDao dao = new CategoryDao();
		
		CategoryVo vo1 = new CategoryVo();
		vo1.setName ("컴퓨터/IT");
		dao.insert(vo1);
		
		CategoryVo vo2 = new CategoryVo();
		vo2.setName ("생활/가전");
		dao.insert(vo2);
	}

}
