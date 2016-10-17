package com.bit2016.bookmall.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "bitdb", "bitdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		}

		return conn;
	}

	public boolean update(BookVo vo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try{
			conn = getConnection();
			
			String sql = "update  set name = ? where no = ?";
			pstmt = conn.prepareStatement(sql);
			
			//pstmt.setString(1,  vo.getName());
			pstmt.setLong(2,  vo.getNo());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("error : " + e);
		}finally{
			try{
				if(pstmt != null){
					pstmt.close();
				}
				if(conn != null){
					conn.close();
				}
				}catch(SQLException e){
					System.out.println("error : " + e);
			}
		}
		return result == 1;
	}
	
	public boolean delete(Long no){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try{
			conn = getConnection();
			
			String sql = "delete from Book where no = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, no);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("error : " + e);
		}finally{
			try{
				if(pstmt != null){
					pstmt.close();
				}
				if(conn != null){
					conn.close();
				}
				}catch(SQLException e){
					System.out.println("error : " + e);
			}
		}
		return result == 1;
	}

	public List<BookVo> getList() {
		List<BookVo> list = new ArrayList<BookVo>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			stmt = conn.createStatement();

			String sql = "select no, name from Book order by no asc";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				//Long no = rs.getLong(1);

				BookVo vo = new BookVo();
				vo.setNo(no);
				//vo.setPrice(price);

				list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					rs.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println("error : " + ex);
			}
		}

		return list;
	}

	public void insert(BookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// // 1. JDBC 드라이버 로딩
			// Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버
			// connection
			// // path
			//
			// // 2. Connection 얻어오기
			// String url = "jdbc:oracle:thin:@localhost:1521:xe";
			// conn = DriverManager.getConnection(url, "bitdb", "bitdb"); -->
			// getConnection() 메소드 생성으로 이제 필요없어짐

			conn = getConnection();

			// 3. Statement 준비
			String sql = "insert into Book values(Book_seq.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩

			pstmt.setString(1, vo.getTitle());
			pstmt.setLong(2, vo.getPrice());
			pstmt.setLong(3, vo.getCategory_no());

			// 5. SQL 실행
			int count = pstmt.executeUpdate(); // 미완성된 query를 날리기 때문에 파라미터에 sql
												// 안들어가도 된다
			System.out.println(count);

		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				// 3. 자원정리

				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
