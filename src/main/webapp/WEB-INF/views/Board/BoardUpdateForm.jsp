<%@page import="com.lhs.pension.dto.PBoard"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<title>보드 업데이트 폼</title>
</head>
<body>
	<%
		int num = Integer.parseInt(request.getParameter("num"));
		String root = (String) session.getAttribute("root");
		//BoardDAO dao = new BoardDAO();
		PBoard dto = null;
		String subject = "";
		String content = "";
		dto = (PBoard)request.getAttribute("dto");
		String id = (String) session.getAttribute("id");
//		try {
			//bean = dao.select(num);
			//subject = bean.getSubject();
			//content = bean.getContent();

//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	%>
	<center>
		<h2>게시글수정</h2>
		<form action="BoardUpdateProc" method="post">
			<table width="600">
				<tr height="40">
					<td width="120" align="center" bgcolor="#a6c6f5">작성자</td>
					<td width="180" align="center"><%=id%></td>
					<td width="120" align="center" bgcolor="#a6c6f5">작성일</td>
					<td width="180" align="center"><%=dto.getReg_date()%></td>
				</tr>

				<tr height="40">
					<td width="120" align="center" bgcolor="#a6c6f5">제목</td>
					<td width="480" colspan="3">&nbsp; <input type="text"
						name="subject" value="<%=dto.getSubject()%>" size="60"></td>
				</tr>
				<tr height="40">
					<td width="120" align="center" bgcolor="#a6c6f5">패스워드</td>
					<td width="480" colspan="3">&nbsp; <input type="password"
						name="password" size="60"></td>
				</tr>
				<tr height="40" align="center">
					<td width="120" align="center" bgcolor="#a6c6f5">글내용</td>
					<td width="480" colspan="3"><textarea rows="10" cols="70"
							name="content" align="left"><%=dto.getContent()%></textarea></td>
				</tr>
				<tr height="40" align="center">
					<td width="120" align="center" bgcolor="#a6c6f5">점수</td>
					<td width="50" colspan="3">	
					<select name="score">
							<option value="1">★</option>
							<option value="2">★★</option>
							<option value="3">★★★</option>
							<option value="4">★★★★</option>
							<option value="5">★★★★★</option>
					</select></td>
				</tr>
				<tr>

					<td colspan="4" align="center"><input type="hidden" name="num"
						value="<%=dto.getNum()%>"> <input type="submit"
						value="글수정" class="btn btn-default"> &nbsp;&nbsp; <input type="button"
						onclick="location.href='BoardList'" value="전체글보기" class="btn btn-default"></td>
				</tr>
			</table>
	</center>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/jquery-3.3.1.js" />"></script>
</body>
</html>