package com.bit2016.bookmall.vo;

public class BookDaoTest {
	public static void main(String[] args) {
		// insert test
		insertTest();
	}

	public static void insertTest() {
		BookDao dao = new BookDao();
		
		BookVo vo1 = new BookVo();
		vo1.setTitle ("해리포터");
		vo1.setPrice(10000);
		vo1.setCategory_no(1L);
		dao.insert(vo1);
		
		BookVo vo2 = new BookVo();
		vo2.setTitle ("반지의제왕");
		vo2.setPrice(20000);
		vo2.setCategory_no(2L);
		dao.insert(vo2);
	}
}
