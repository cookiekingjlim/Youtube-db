package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.model.vo.Book;
import com.kh.model.vo.Member;
import com.kh.model.vo.Rent;

import config.ServerInfo;

public class BookDAO implements BookDAOTemplate {

	private Properties p = new Properties();
	
	public BookDAO() {
		try {
			p.load(new FileInputStream("src/config/jdbc.properties"));
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Connection getConnect() throws SQLException {
		return null;
	}

	@Override
	public void closeAll(PreparedStatement st, Connection conn) throws SQLException {
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement st, Connection conn) throws SQLException {
	}

	@Override
	public ArrayList<Book> printBookAll() throws SQLException {
		// SQL문 : SELECT, 테이블 : TB_BOOK
		// ArrayList에 추가할 때 add 메서드!
		// rs.getString("bk_title"); // bkTitle (X)
		return null;
	}

	@Override
	public int registerBook(Book book) throws SQLException {
		// 반환값 타입이 int인 경우 다 st.executeUpdate()!
		return 0;
	}

	@Override
	public int sellBook(int no) throws SQLException {
		// 책 삭제! DELETE문!
		return 0;
	}

	@Override
	public int registerMember(Member member) throws SQLException {
		// id, name, password
		return 0;
	}

	@Override
	public Member login(String id, String password) throws SQLException {
		
		// char   rs.getString("status").charAt(0)
		
		return null;
	}

	@Override
	public int deleteMember(String id, String password) throws SQLException {
		// UPDATE - STATUS를 Y로!
		// status가 n이면 회원 유지, y면 회원 탈퇴
		// n이 기본값! <--- 회원 유지!
		return 0;
	}

	@Override
	public int rentBook(Rent rent) throws SQLException {
		// 책 대여 기능! INSERT ~~ TB_RENT
		return 0;
	}

	@Override
	public int deleteRent(int no) throws SQLException {
		return 0;
	}

	@Override
	public ArrayList<Rent> printRentBook(String id) throws SQLException {
		// SQL문 - JOIN 필요! 테이블 다 엮어야 됨!
		// 이유 --> rent_no, rent_date, bk_title, bk_author
		//  조건은 member_id가지고 가져오니까!
		
		// while문 안에서! Rent rent = new Rent();
		// setter 사용!!
		// rent.setBook(new Book(rs.getString("bk_title"), 
		//                        rs.getString("bk_author")));
		return null;
	}

}
