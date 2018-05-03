<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="javax.naming.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="java.util.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Connection conn = null;
		ResultSet rs = null;
		
		// allView.jsp에서 get 방식으로 보낸 값을 request로 받는다.
		String user_id = request.getParameter("del");
		
		// 쿼리문 preparedStatement 기법 적용
		String sql = "DELETE FROM MEMBER WHERE MEMBER_ID = ?";	
		
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// ? 해결
			pstmt.setString(1, user_id);
			int result = pstmt.executeUpdate();
			
	        if(result != 0) { out.println("삭제 완료"); }
		} catch (Exception e) {
			out.println("<h2>삭제 실패하였습니다.</h2>");
			e.printStackTrace();
		} finally {		
			conn.close();
		}
	%>
	
 	<a href="./allView.jsp">뒤로가기</a>

</body>
</html>