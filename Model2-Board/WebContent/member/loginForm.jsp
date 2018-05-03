<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	session.invalidate(); System.out.println("invalidate!");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지</title>

	<title>MVC 게시판</title>
	<script language="javascript">

	function wantToJoin() {
		memberForm.submit();
	}
	
	</script>

</head>

<body>
	
	<form method="post" action="./MemberLoginAction.me" name="memberForm">
		<table border="1">
			<tr><td colspan="2" align="center"><h2>로그인 페이지</h2></td></tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="REQUEST_ID"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="REQUEST_PW"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<a href="javascript:wantToJoin()">로그인&nbsp;
					<a href="./MemberJoin.me">회원가입</a>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>