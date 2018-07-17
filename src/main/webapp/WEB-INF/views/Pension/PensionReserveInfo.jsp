
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
		out.print(section);

		//out.println(vo+"<br>");
	%>
	<center>

		<form action="PensionOptionSelect" method="post">
			<table width="100%">
				<tr height="100">
					<td align="center" colspan="3"><font size="6" color="gray"><%=dto.getName()%>펜션
							선택</font></td>
				</tr>
				<tr>
					<td rowspan="6" width="50%" align="center"><image alt=""
							src="resources/img/<%=dto.getImg()%>" width="450"></image></td>
					<td width="25%" align="center">펜션이름</td>
					<td width="25%" align="center"><%=dto.getName()%></td>
				</tr>
				<tr>
					<td width="25%" align="center">숙박 인원</td> <!-- 삭제항목 -->
					<td width="25%" align="center"><select name="qty">
							<option value="1">1인</option>
							<option value="2">2인</option>
							<option value="3">3인</option>
							<option value="4">4인</option>
							<option value="5">5인</option>
							<option value="6">6인</option>
							<option value="7">7인</option>
							<option value="8">8인</option>
							<option value="9">9인 이상</option>
					</select></td>
				</tr>
				<tr>
					<td width="25%" align="center">지역</td>
					<td width="25%" align="center"><%=section%></td>
				</tr>
				<tr>
					<td width="25%" align="center">렌트가격</td>
					<td width="25%" align="center"><%=dto.getPrice()%></td>
				</tr>

				<tr>
					<input type="hidden" name="no" value="<%=dto.getNo()%>">
					<input type="hidden" name="img" value="<%=dto.getImg()%>">
					<td colspan="2" width="50%" align="center"><input
						type="submit" value="옵션선택후구매하기" class="btn btn-default"></td>
				</tr>

			</table>
		</form>

		<p>
			<font size="5" color="gray">펜션 정보보기</font>
		<p>
			<%=dto.getInfo()%>
	</center>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>

</html>