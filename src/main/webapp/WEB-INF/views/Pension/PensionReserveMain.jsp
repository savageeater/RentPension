<%@page import="com.lhs.pension.dto.RentPension"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
</head>
<body>
<center>
	<!-- 데이타베이스에서 최신순 3대만 가져오기 -->
	<%
		List<RentPension> list = null;
		
		//int nums = (int)request.getAttribute("allcount");
		list = (List<RentPension>)request.getAttribute("list");
		//list = list.subList(nums-3, nums);
	%>
	<table width="1000">
		<tr>
			<td align="center" colspan="3">
				<font size="6" color="gray">최신등록차량</font>
			</td>
		</tr>
		<tr height="240">
			<%
				for (RentPension x : list) {
			%>
			<td width="333" align="center">
				<a href="PensionReserveInfo?no=<%=x.getNo()%>">
					<img alt=""	src="resources/img/<%=x.getImg()%>" width="300" height="200">
				</a>
				<p>차량명 : <%=x.getName() %></td>
			<%
				}
			%>

		</tr>
</table>
<hr color="red" size="3">
<p>	
	<form action="PensionCategoryList" method="post">

		<font size="3" color="gray"><b>지역검색</b></font>&nbsp;&nbsp;
		<select name = "category" class="form-control" style="width:300px;">
			<option value="1">경기도</option>
			<option value="2">강원도</option> 
			<option value="3">충청남도</option>
			<option value="4">충청북도</option>
			<option value="5">경상남도</option>
			<option value="6">경상북도</option>
			<option value="7">전라남도</option>
			<option value="8">전라북도</option>  
		</select><br>
		<input type="submit" value="검색" class="btn btn-default">&nbsp;&nbsp;&nbsp;
		<button type="button" onclick="location.href='PensionAllList'" class="btn btn-default">전체검색</button>
	</form>
	
	
</center>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>