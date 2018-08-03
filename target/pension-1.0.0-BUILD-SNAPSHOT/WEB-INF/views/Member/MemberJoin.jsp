<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">

<title>회원가입</title>
</head>
<body>
<%
String joinroot=(String)session.getAttribute("joinroot");
%>
	<center>
		<h2>회원가입</h2>
		<form action='JoinProc' method='post'>
			<table width='800' >
				<tr height='30'>
					<td width='150' align='center' bgcolor="#cccccc">아이디</td>
					<td width='550' align='left' bgcolor="#a6c6f5"><input type='input' name='id'
						size='40'></td>
				</tr>
				<tr height='30'>
					<td width='150' align='center' bgcolor="#cccccc">비밀번호</td>
					<td width='550' align='left' bgcolor="#a6c6f5"><input type='password'
						name='pass' size='40'></td>
				</tr>
				<tr height='30'>
					<td width='150' align='center' bgcolor="#cccccc">이메일</td>
					<td width='550' align='left' bgcolor="#a6c6f5"><input type='email'
						name='email' size='40'></td>
				</tr>
				<tr height='30'>
					<td width='150' align='center' bgcolor="#cccccc">나이</td>
					<td width='550' align='left' bgcolor="#a6c6f5"><input type='text' name='age'
						size='40'></td>
				</tr>
				<tr height='30'>
					<td width='150' align='center' bgcolor="#cccccc">전화번호</td>
					<td width='550' align='left' bgcolor="#a6c6f5"><input type='tel' name='tel'
						size='40'></td>
				</tr>
				<tr height='30'>
					<td width='150' align='center' bgcolor="#cccccc">거주 지역</td>
					<td width='550' align='left' bgcolor="#a6c6f5"><input type='text' name='region'
						size='40'></td>
				</tr>

				<tr height='30' bgcolor="#a6c6f5">
					<td align='center' colspan='2'><input type='submit' value='가입하기' class="btn btn-default">
					</td>
				</tr>
			</table>
		</form>
	</center>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>