<%@page import="java.io.PrintWriter"%>

<%@page import="javax.naming.*"%>
<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@page import="java.util.*"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
		Connection conn = null;
		//session.setAttribute("id", request.getParameter("user_id"));
		String sql = "SELECT * FROM MEMBER";
		
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			// 1: id / 2: pw / 3: email / 4: name / 5: ssn(setInt) / 6: birth(setDate?) / 6: interest / 7: intro
%>			<h2>*** 전체 회원 정보입니다. ***</h2>
<%
			while(rs.next()) {
%>
				<table border="1">
					<tr>
						<td>아이디</td>
						<td><%= rs.getString(1) %></td>
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
					</tr>
					<tr>
						<td>생일</td>
						<td><%= rs.getString(7) %></td>
					</tr>
					<tr>
						<td>관심사</td>
						<td><%= rs.getString(8) %></td>
					</tr>
					<tr>
						<td>자기소개</td>
						<td><%= rs.getString(9) %></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center;">
						<a href="delete.jsp?del=<%=rs.getString(1)%>">삭제</td><br />
					</tr>
				</table>

	<%
			}
		} catch (Exception e) {
			out.println("<h2>데이터 가져오기에 실패하였습니다.</h2>");
			e.printStackTrace();
		}
	%>
	
	<br /><a href="javascript:history.back();">뒤로가기</a>

</body>
</html>