package net.member.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.board.db.BoardBean;

public class MemberDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MemberDAO() {
		try{
			Context init = new InitialContext();
	  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	  		conn = ds.getConnection();
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	public int login(String user_id, String user_pw) {
		String SQL = "SELECT user_pw FROM CAPSULES WHERE user_id = ?";

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(user_pw)) return 1;
				else return 0;
			}
			return -1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2;
	}
	
	// 회원 가입 정보 DB 등록
	public boolean memberInsert(MemberBean member) {
		
		int num = 0;
		String sql = "";

		int result = 0;

		try {
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER");
			rs = pstmt.executeQuery();

			sql = "INSERT INTO MEMBER(MEMBER_ID, MEMBER_PW, MEMBER_PW2, MEMBER_EMAIL, MEMBER_NAME, "
					+ "MEMBER_SSN, MEMBER_BIRTH, MEMBER_INTEREST, MEMBER_INTRO)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMEMBER_ID());
			pstmt.setString(2, member.getMEMBER_PW());
			pstmt.setString(3, member.getMEMBER_PW2());
			pstmt.setString(4, member.getMEMBER_EAMIL());
			pstmt.setString(5, member.getMEMBER_NAME());
			pstmt.setString(6, member.getMEMBER_SSN());
			pstmt.setString(7, member.getMEMBER_BIRTH());
			pstmt.setString(8, member.getMEMBER_INTEREST());
			pstmt.setString(9, member.getMEMBER_INTRO());
			
			result = pstmt.executeUpdate();
			
			if (result == 0) { return false; }
			return true;
			
		} catch (Exception ex) {
			System.out.println("memberInsert Error: " + ex);
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException ex) { }
			if (pstmt != null) try { pstmt.close(); } catch (SQLException ex) { }
		}
		return false;
	}
	
	// DB에서 맞는 회원이 있는 지 조회한다
	public boolean memberVerify(MemberBean member) {

		int num = 0;
		String sql = "";

		int result = 0;

		try {
			pstmt = conn.prepareStatement("SELECT MEMBER_PW FROM MEMBER WHERE MEMBER_ID = ?");
			pstmt.setString(1, member.getMEMBER_ID());

			rs = pstmt.executeQuery();
			rs.next();
			
			if (!rs.getString("MEMBER_PW").equals(member.getMEMBER_PW())) { return false; }
			return true;

		} catch (Exception ex) {
			System.out.println("memberVerify Error: " + ex);
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException ex) { }
			if (pstmt != null) try { pstmt.close(); } catch (SQLException ex) {	}
		}
		return false;
	}

}