
<%@page import="com.lhs.pension.dto.RentPension"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<body>
	<%
		int carNo = Integer.parseInt(request.getParameter("no"));
		String fromPage = request.getParameter("fromPage");
		String temp = request.getParameter("category");
		int category = Integer.parseInt((temp != null) ? temp : "0");
		RentPension dto = null;
		String section = "";

		dto = (RentPension) request.getAttribute("dto");
				
		switch(category){
			case 1:
				section="경기도";
				break;					
			case 2:
				section="강원도";
				break;					
			case 3:
				section="충청남도";
				break;					
			case 4:
				section="충청북도";
				break;					
			case 5:
				section="경상남도";
				break;					
			case 6:
				section="경상북도";
				break;					
			case 7:
				section="전라남도";
				break;
			case 8:
				section="전라북도";
				break;
				
			default:
				switch(dto.getRegion()){
			case 1:
				section="경기도";
				break;					
			case 2:
				section="강원도";
				break;					
			case 3:
				section="충청남도";
				break;					
			case 4:
				section="충청북도";
				break;					
			case 5:
				section="경상남도";
				break;					
			case 6:
				section="경상북도";
				break;					
			case 7:
				section="전라남도";
				break;
			case 8:
				section="전라북도";
				break;
				}
				
				}

		String breakfast="";
		String spa="";
		String pool="";
		if(dto.getSpa()==1){
			spa="스파 펜션";
		}else{
			spa="스파 없음";
		}
		if(dto.getBreakfast()==1){
			breakfast="조식 제공";
		}else{
			breakfast="조식 없음";
		}
		if(dto.getPool()==1){
			pool="풀빌라";
		}else{
			pool="풀빌라 아님";
		}
		
		
		
		//out.println(vo+"<br>");
	%>
	<center>

		<form action="PensionOptionSelect" method="post">
			<table width="100%">
				<tr height="100">
					<td align="center" colspan="3"><font size="6" color="gray"><%=dto.getName()%></font></td>
				</tr>
				<tr>
					<td rowspan="6" width="50%" align="center"><image alt=""
							src="resources/img/<%=dto.getImg()%>" width="450"></image></td>
					<td width="25%" align="center">펜션이름</td>
					<td width="25%" align="center"><%=dto.getName()%></td>
				</tr>
				<tr>
					<td width="25%" align="center">숙박 인원</td> 
					<td width="25%" align="center">
					<select name="qty">
							<option value="1">1인</option>
							<option value="2">2인</option>
							<option value="3">3인</option>
							<option value="4">4인</option>
							<option value="5">5인</option>
							<option value="6">6인</option>
							<option value="7">7인</option>
							<option value="8">8인</option>
							<option value="9">9인 이상</option>
					</select>
					</td>
				</tr>
				<tr>
					<td width="25%" align="center">지역</td>
					<td width="25%" align="center"><%=section%></td>
				</tr>
				<tr>
					<td width="25%" align="center">숙박비용</td>
					<td width="25%" align="center"><%=dto.getPrice()%></td>
				</tr>
				<tr>
					<td width="25%" align="center">예약 가능인원</td>
					<td width="25%" align="center"><%=dto.getMinp()%>명~<%=dto.getMaxp()%>명</td>
				</tr>

				<tr>
					<td width="25%" align="center">조식</td>
					<td width="25%" align="center"><%=breakfast%></td>
				</tr>
				<tr>
					<input type="hidden" name="no" value="<%=dto.getNo()%>">
					<input type="hidden" name="img" value="<%=dto.getImg()%>">
					<td colspan="3" width="50%" align="center"><input
						type="submit" value="옵션선택후구매하기" class="btn btn-default"></td>
				</tr>

			</table>
		</form>
<div>
		<table>
		
				<tr >
					<td align="center" colspan="4"><font size="6" color="gray">펜션 정보</font></td>
				</tr>
				<tr>
					<td width="10%" align="center">화장실 갯수</td>
					<td width="10%" align="center"><%=dto.getToilet()%>개</td>
					<td width="10%" align="center">방 갯수</td>
					<td width="10%" align="center"><%=dto.getRoom()%>개</td>
				</tr>

				<tr>
					<td width="10%" align="center">스파</td>
					<td width="10%" align="center"><%=spa%></td>
					
					<td width="10%" align="center">풀빌라</td>
					<td width="10%" align="center"><%=pool%></td>
				</tr>

				<tr>
					<td align="center" colspan="4"><%=dto.getInfo()%></td>
				</tr>
		</table>
</div>
	</center>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>

</html>