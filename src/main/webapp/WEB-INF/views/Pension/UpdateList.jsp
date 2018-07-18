
<%@page import="com.lhs.pension.dto.RentPension"%>
<%@page import="java.util.List"%>
<%@page import="com.lhs.pension.common.PageManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	int rowCount = Integer.parseInt(request.getAttribute("num").toString());
	
	int perPage = 7; // (1) 화면에 보여질 글 갯수
	int perBlock = 5; // (2) 화면 하단에 보여질 패이지 블럭의 페이지 갯수 
	
	String pageNum = request.getParameter("pageNum");
	// 만약 처음 boardList.jsp 를 클릭하거나 수정 삭제 등 다른 게시글에서 이 페이지로 넘어오면 
	// pageNum값이 없어서 null처리를 해줌
	if (pageNum == null) {
		pageNum = "1";
	}
	// (4)------------------------------------
	int currentPage = Integer.parseInt(pageNum);
	String blockNum = request.getParameter("blockNum");
	if (blockNum == null) {
		blockNum = "1";
	}
	// (5)-------------------------------------
	int currentBlock = Integer.parseInt(blockNum);

	// 페이지 관리 객체를 생성 - new PageManager((1), (2))
	PageManager pm = new PageManager(perPage, perBlock);
	// 페이지 관리 객체 환경설정 - pm.setRowCount((3),(4),(5))
	pm.setRowCount(rowCount, currentPage, currentBlock);
	//테이블에 표시할 번호를 지정 - 거꾸로 줄력해 나갈것임.
	int number = pm.number;
	
	List<RentPension> list2 = (List<RentPension>)request.getAttribute("carlist");
	List<RentPension> list = list2.subList(pm.startRow-1, pm.endRow);
	
	// 수정,댓글, 삭제 후 현재위치로 돌아오게 하기 위해 현 위치값을 세션에 저장
	session.setAttribute("currentPage", currentPage);
	session.setAttribute("currentBlock", currentBlock);
	
%>
<center>
<font size="6" color="gray">등록된 차량(<%=rowCount%>대)</font>
<table border="1">
	<tr>
		<td align="center">번호</td>
		<td align="center">펜션 이미지</td>
		<td align="center">이름</td>
		<td align="center">지역</td>
		<td align="center">풀빌라</td>
		<td align="center">최소인원</td>
		<td align="center">최대인원</td>
		<td align="center">조식</td>
		<td align="center">화장실 갯수</td>
		<td align="center">방 갯수</td>
		<td align="center">스파</td>
		<td align="center">가격</td>
		<td align="center">설명</td>
		<td align="center">수정</td>
	</tr>
	<tr>
		<%
			for(RentPension dto : list){
				%>
				<tr height="50">
					<td width="100" align="center"><%=dto.getNo()%></td>
					<td width="150" align="center"><img alt="" src="resources/img/<%=dto.getImg()%>" width="200" height="80"></td>
					<td width="100" align="center"><%=dto.getName()%></td>	
					<td width="100" align="center"><%=dto.getRegion() %></td>
					<td width="100" align="center"><%=dto.getPool() %></td>
					<td width="100" align="center"><%=dto.getMinp() %></td>
					<td width="100" align="center"><%=dto.getMaxp() %></td>
					<td width="100" align="center"><%=dto.getBreakfast() %></td>
					<td width="100" align="center"><%=dto.getToilet() %></td>
					<td width="100" align="center"><%=dto.getRoom() %></td>
					<td width="100" align="center"><%=dto.getSpa() %></td>
					<td width="250" align="center"><%=dto.getPrice()%>원</td>
					<td width="250" align="center"><%=dto.getInfo()%></td>
					<td width="70" align="center"><button onclick="location.href='UpdateCarInfo?No=<%=dto.getNo()%>'" class="btn btn-default">수정</button></td>
				</tr>
				<%}%>
</table>
<p>
		<%
			out.write(pm.getPagenation("UpdateList"));
		%>
</center>
</body>
</html>