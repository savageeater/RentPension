
<%@page import="com.lhs.pension.dto.RentPension"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<%
	int no =Integer.parseInt(request.getParameter("no"));
	int qty = Integer.parseInt(request.getParameter("qty"));
	String img = request.getParameter("img");
	
	RentPension dto = (RentPension)request.getAttribute("dto");
	
%>
</head>
<body>
	<center>
		<form action="PensionReserveResult" method="post">
			<table width="100%">
				<tr height="100">
					<td align="center" colspan="3"><font size="6" color="gray">[<%=dto.getName()%>옵션선택]</font></td>
				</tr>
				<tr>
					<td rowspan="7" width="50%" align="center"><image alt="" src="resources/img/<%=img%>" width="450"></image></td>

					<td width="25%" align="center">예약 기간</td>
					<td width="25%" align="left" width="40"><select name="dday">
							<option value="1">1일</option>
							<option value="2">2일</option>
							<option value="3">3일</option>
							<option value="4">4일</option>
							<option value="5">5일</option>
							<option value="6">6일</option>
							<option value="7">7일</option>
					</select></td>
				</tr>
				<tr>
					<td width="25%" align="center">예약일자</td>
					<td align="left"><input type="date" name="rday" ></td>
				</tr>
				<tr>
					<td width="25%" align="center" colspan="2">
					<input type="hidden" name="qty" value="<%=qty%>">
					<input type="hidden" name="no" value="<%=no%>">
					<input type="submit" value="펜션예약하기" class="btn btn-default"></td>
				</tr>

			</table>
		</form>
		<p>
			<font size="5" color="gray">펜션정보보기</font>
		<p>
			<%=dto.getInfo()%>
	</center>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>