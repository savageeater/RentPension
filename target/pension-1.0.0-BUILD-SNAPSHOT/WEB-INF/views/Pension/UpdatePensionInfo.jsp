<%@page import="com.lhs.pension.dto.RentPension"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String id = (String) session.getAttribute("id");
		RentPension dto = (RentPension) request.getAttribute("dto");
	%>

	<font size="6" color="gray"><%=dto.getName()%> 수정</font>
	<form action="UpdatePensionInfoProc" method="post">
		<center>
			<table border="1">
				<tr>
					<td>번호</td>
					<td><input type="hidden" name="no" value="<%=dto.getNo() %>"><%=dto.getNo() %></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="<%=dto.getName()%>"></td>
				</tr>
				<tr>
					<td>지역</td>
					<td>
						<input type="radio" name="region" value="1" <c:if test="${dto.category eq '1'}">checked="checked"</c:if>/>경기도
						<input type="radio" name="region" value="2" <c:if test="${dto.category eq '2'}">checked="checked"</c:if>/>강원도
						<input type="radio" name="region" value="3" <c:if test="${dto.category eq '3'}">checked="checked"</c:if>/>충청남도
						<input type="radio" name="region" value="4" <c:if test="${dto.category eq '4'}">checked="checked"</c:if>/>충청북도
						<input type="radio" name="region" value="5" <c:if test="${dto.category eq '5'}">checked="checked"</c:if>/>경상남도
						<input type="radio" name="region" value="6" <c:if test="${dto.category eq '6'}">checked="checked"</c:if>/>경상북도
						<input type="radio" name="region" value="7" <c:if test="${dto.category eq '7'}">checked="checked"</c:if>/>전라남도
						<input type="radio" name="region" value="8" <c:if test="${dto.category eq '8'}">checked="checked"</c:if>/>전라북도
					</td>
				</tr>
				<tr>
					<td>풀빌라</td>
					<td><input type="text" name="price" value="<%=dto.getPool()%>"></td>
				</tr>
				
				<tr>
					<td>조식</td>
					<td><input type="text" name="price" value="<%=dto.getBreakfast()%>"></td>
				</tr>
				<tr>
					<td>화장실 갯수</td>
					<td><input type="text" name="price" value="<%=dto.getToilet()%>"></td>
				</tr>
				<tr>
					<td>방 갯수</td>
					<td><input type="text" name="price" value="<%=dto.getRoom()%>"></td>
				</tr>
				<tr>
					<td>스파</td>
					<td><input type="text" name="price" value="<%=dto.getSpa()%>"></td>
				</tr>
	
				<tr>
					<td>최소인원</td>
					<td><select name="minp">
					 		<option value="8" <c:if test="${dto.minp eq '1'}">selected="selected"</c:if>>1명</option>	
							<option value="8" <c:if test="${dto.minp eq '2'}">selected="selected"</c:if>>2명</option>	
							<option value="8" <c:if test="${dto.minp eq '3'}">selected="selected"</c:if>>3명</option>	

					</select>
					</td>
				</tr>				<tr>
					<td>최대인원</td>
					<td><select name="maxp">
							<option value="8" <c:if test="${dto.maxp eq '2'}">selected="selected"</c:if>>2명</option>	
							<option value="8" <c:if test="${dto.maxp eq '3'}">selected="selected"</c:if>>3명</option>	
							<option value="8" <c:if test="${dto.maxp eq '4'}">selected="selected"</c:if>>4명</option>	
							<option value="8" <c:if test="${dto.maxp eq '5'}">selected="selected"</c:if>>5명</option>	
							<option value="8" <c:if test="${dto.maxp eq '6'}">selected="selected"</c:if>>6명</option>	
							<option value="8" <c:if test="${dto.maxp eq '7'}">selected="selected"</c:if>>7명</option>	
							<option value="8" <c:if test="${dto.maxp eq '8'}">selected="selected"</c:if>>8명</option>	
							<option value="8" <c:if test="${dto.maxp eq '9'}">selected="selected"</c:if>>9명이상</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>이미지</td>
					<td><input type="text" name="img" value="<%=dto.getImg() %>"></td>
				</tr>
				<tr>
					<td height="70">정보</td>
					<td><textarea cols="32" rows="6" name="info" value="<%=dto.getInfo()%>"><%=dto.getInfo()%></textarea></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">1
					<input type="submit" value="수정">
					<input type="button" value="취소" onclick="location.href='UpdateCancel'">
					</td>
				</tr>



			</table>
		</center>
	</form>
</body>
</html>