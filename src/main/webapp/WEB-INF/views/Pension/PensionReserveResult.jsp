
<%@page import="com.lhs.pension.dto.RentPension"%>
<%@page import="com.lhs.pension.dto.RentReserve"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<head>
<%
request.setCharacterEncoding("UTF-8");
RentReserve rbean = (RentReserve)request.getAttribute("dto2");
RentPension rentpension = (RentPension)request.getAttribute("dto");
	String id = (String) session.getAttribute("id");

/*	if (id == null) {
<script>
	alert("로그인후 예약 가능합니다.");
	location.href = "Main.jsp?center=Login.jsp";
</script>
	}
*/
	
	if(rbean.getQty()>rentpension.getMaxp()){
		
	}


	String option = "";
	int optionFee = 0;
	int rentalFee = 0;

		rentalFee = rbean.getDday() * rentpension.getPrice();
		
		// 10000은 인원 추가시 개인별
		
		
		if(rbean.getQty()>rentpension.getMinp()){
		option += "숙박인원 추가요금:"+(10000*(rbean.getQty()-rentpension.getMinp()));
		optionFee += 10000*(rbean.getQty()-rentpension.getMinp());
		}else{
			option+="숙박인원 추가요금:"+(0);
		}


	Date d1 = new Date();
	Date d2 = new Date();

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	d1 = sdf.parse(rbean.getRday());
	d2 = sdf.parse(sdf.format(d2));

	int res = d1.compareTo(d2);// -1,0,1
	if (res == -1) {
%>
<script>
	alert("현재 이전 날짜는 예약일로 사용할 수 없습니다.");
	history.go(-1);
</script>
<%
	}
	// 중요함. 빼먹지 말것 
//	rbean.setMemid(id);
//	dao.insert(rbean);
//	rbean.setRegno(dao.getCurrval());

%>

</head>
<body>
	<center>
		<table width=70%>
			<tr bgcolor="lightgreen">
				<td colspan="3" align="center"><font size="5" color="gray">예약결과</font></td>
			</tr>
			<tr>
				<td rowspan="6"><img alt="" src="resource/img/<%=rentpension.getImg()%>" /></td>
				<td width="30%">펜션 이름</td>
				<td width="40%"><%=rentpension.getName()%></td>
			</tr>
			<tr>
				<td width="30%">예약 일자</td>
				<td width="40%"><%=rbean.getRday()%>부터</td>
			</tr>
			<tr>
				<td width="30%">예약 일수</td>
				<td width="40%"><%=rbean.getDday()%>일</td>
			</tr>
			<tr>
				<td width="30%">예약 인원</td>
				<td width="40%"><%=rbean.getQty()%>명</td>
			</tr>
			<tr>
				<td width="30%">예약 금액</td>
				<td width="40%"><%=rentalFee%>원</td>
			</tr>
			<tr>
				<td width="30%">추가 금액</td>
				<td width="40%"><%=option%>원</td>
			</tr>
			
			<tr bgcolor="lightgray">
				<td colspan="3" align="center"><font size="4" color="gray">합계액:<%=optionFee + rentalFee%>원
				</font></td>
			</tr>
			<tr bgcolor="lightgray">
				<td colspan="3" align="left"><font size="2" color="gray"><%=rbean.toString()%></font></td>
			</tr>
			<tr bgcolor="lightgray">
				<td colspan="3" align="left"><font size="2" color="gray"><%=rentpension.toString()%></font></td>
			</tr>
		</table>
	</center>
</html>