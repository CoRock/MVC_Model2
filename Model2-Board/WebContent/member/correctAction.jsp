<%@page import="javax.naming.*"%>
<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>

<% request.setCharacterEncoding("UTF-8"); %>
<%-- <jsp:useBean id="member" class="capsules.Capsules" scope="page" /> --%>
<jsp:setProperty name="member" property="user_id" />
<jsp:setProperty name="member" property="user_pw" />

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
		
		String target = (String)session.getAttribute("id");
		out.println(target);	
		//String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_pw2 = request.getParameter("user_pw2");
		String user_email = request.getParameter("user_email");
		String user_name = request.getParameter("user_name");
		//String user_ssn = request.getParameter("user_ssn");
		//String user_birth = request.getParameter("user_birth");

		String[] interest_elements = request.getParameterValues("user_interest");
		StringBuffer user_interest = new StringBuffer();
		for(String s : interest_elements) {
			user_interest = user_interest.append(s).append(", ");		
		}
		
		String user_intro = request.getParameter("user_intro");

		// 쿼리문 preparedStatement 기법 적용
		String sql = ("UPDATE CAPSULES SET USER_PW=?, USER_PW2=?, USER_EMAIL=?, USER_NAME=?, USER_INTEREST=?, USER_INTRO=? WHERE USER_ID='"+target+"'");

	try {
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		// 1: id / 2: pw / 3: email / 4: name / 5: ssn(setInt) / 6: birth(setDate?) / 6: interest / 7: intro
		//pstmt.setString(1, user_id);
		pstmt.setString(1, user_pw);
		pstmt.setString(2, user_pw2);
		pstmt.setString(3, user_email);
		pstmt.setString(4, user_name);
		//pstmt.setString(6, user_ssn);
		//pstmt.setString(7, user_birth);
		pstmt.setString(5, user_interest.toString());
		pstmt.setString(6, user_intro);
		
		if(pstmt.executeUpdate() != 0) {
			out.println("<h2>레코드를 수정하였습니다.</h2>");
		}
	} catch (Exception e) {
		out.println("<h2>레코드 등록에 실패하였습니다.</h2>");
		e.printStackTrace();
	} finally {
		conn.close();
	}
	%>
	
 	<a href="./BoardList.bo">로그인 화면으로 돌아가기</a>

</body>
</html>