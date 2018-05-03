<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="javax.naming.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
		Connection conn = null;
		
		String sql = "";
		
		String user_id = (String) session.getAttribute("successID");

		try {
			System.out.println("myView: try");
					
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE MEMBER_ID = ?");
			
			pstmt.setString(1, user_id);

			ResultSet rs = pstmt.executeQuery();
			
			// 1: id / 2: pw / 3: email / 4: name / 5: ssn(setInt) / 6: birth(setDate?) / 6: interest / 7: intro
			while(rs.next()) {
%>
				<h2>*** 나의 회원 정보입니다. ***</h2>
				<table border="1">
					<tr>
						<td>아이디</td>
						<td><%= rs.getString(1) %></td>
						<td>변경 불가</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><%= rs.getString(2) %></td>
					</tr>
					<tr>
						<td>비밀번호확인</td>
						<td><%= rs.getString(3) %></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><%= rs.getString(4) %></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><%= rs.getString(5) %></td>
					</tr>
					<tr>
						<td>주민등록번호</td>
						<td><%= rs.getString(6) %></td>
						<td>변경 불가</td>
					</tr>
					<tr>
						<td>생일</td>
						<td><%= rs.getString(7) %></td>
						<td>변경 불가</td>
					</tr>
					<tr>
						<td>관심사</td>
						<td><%= rs.getString(8) %></td>
					</tr>
					<tr>
						<td>자기소개</td>
						<td><%= rs.getString(9) %></td>
					</tr>
				</table>
	<%
		System.out.println("myView: while");
			}
		} catch (Exception e) {
			out.println("<h2>데이터 가져오기에 실패하였습니다.</h2>");
			e.printStackTrace();
		}
	%>
	
	<br /><a href="javascript:history.back();">돌아가기</a>

</body>
</html>