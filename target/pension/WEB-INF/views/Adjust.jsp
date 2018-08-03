
<%@page import="com.lhs.pension.dto.RentReserve"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<%
	int regno = Integer.parseInt(request.getParameter("regno"));
	//int qty = Integer.parseInt(request.getParameter("qty"));
	String img = request.getParameter("img");

	//RentCarDAOImpl dao  = null;//new RentCarDAOImpl("RentCar");
	RentReserve dto = (RentReserve)request.getAttribute("dto");
%>
</head>
<body>
	<center>
		<form action="AdjustProc" method="post">
			<table width="500">
				<tr height="100">
					<td align="center" colspan="3"><font size="6" color="gray">[<%=dto.getMemid()%>님의 예약 번호<%=dto.getRegno()%>번 예약수정]</font></td>
				</tr>
				<tr>
					<td colspan="3">
						<img src="resources/img/<%=img%>" width="500" height="250"/>
					</td>
				</tr>
				<tr bgcolor="lightgray">
					<td width="133" align="center">항목</td>
					<td width="133" align="center">예약 사항</td>
					<td width="134" align="center">수정 사항</td>
				</tr>
				<tr>
					<td align="center">예약일</td>
					<td><%=dto.getRday()%></td>
					<td align="left"><input type="date" name="rday"></td>
				</tr>
								
				<tr>
					<td align="center">예약 기간</td>
					<td><%=dto.getDday()%></td>
					<td align="left" width="40"><select name="dday">
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
					<td align="center">예약인원</td>
					<td><%=dto.getQty()%></td>
					<td align="left" width="40"><select name="qty">
							<option value="1">1명</option>
							<option value="2">2명</option>
							<option value="3">3명</option>
							<option value="4">4명</option>
							<option value="5">5명</option>
							<option value="6">6명</option>
							<option value="7">7명</option>
							<option value="8">8명</option>
							<option value="9">9명 이상</option>
					</select></td>
				</tr>

				<tr>

					<td  align="center" colspan="3"><input
						type="submit" value="수정하기" class="btn btn-default">
					<input type="hidden" name="memid" value="<%=dto.getMemid()%>"/>
					<input type="hidden" name="regno" value="<%=dto.getRegno()%>"/>
					<input type="hidden" name="no" value="<%=dto.getNo()%>"/>
						
					</td>
				</tr>

			</table>
		</form>
		
	</center>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>