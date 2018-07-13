<%@page import="com.lhs.pension.dto.RentPension"%>
<%@page import="com.lhs.pension.common.PageManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<body>
	<%
		List<RentPension> list = (List<RentPension>)request.getAttribute("list");

		//=============================================================
		// 화면에 보여질 게시글의 개수를 지정(임의로 설정)
		int perPage = 6; // (1) 화면에 보여질 글 갯수
		int perBlock = 5; // (2) 화면 하단에 보여질 패이지 블럭의 페이지 갯수 

		// (3)-----------------------------------
		int rowCount = list.size();//dao.getAllCount(); //전체 글의 갯수를 저장하는 변수 

		// 현재 보고자 하는 페이지 와 페이지 블럭
		// 현재 카운터를 클릭한 번호값을 읽어옴 
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

		List<RentPension> list2 = list.subList(pm.startRow-1, pm.endRow);
		// 수정,댓글, 삭제 후 현재위치로 돌아오게 하기 위해 현 위치값을 세션에 저장
		session.setAttribute("currentPage", currentPage);
		session.setAttribute("currentBlock", currentBlock);

		//=============================================================
	%>
	<center>
		<table>
			<tr>
				<td align="center" colspan="3"><font size="6" color="gray">전체렌트카보기(<%=currentPage%>/<%=pm.pageCount %>)</font>
				</td>
			</tr>
			<%
				int j = 0;
				for (int i = 0; i < list2.size(); i++) {
					RentPension dto = list2.get(i);
					if (i % 3 == 0) {
			%><tr height="220">
				<%
					}
				%>

				<td width="33%" align="center"><a
					href="CarReserveInfo?no=<%=dto.getNo()%>&fromPage=CarAllList">
						<img alt="" src="resources/img/<%=dto.getImg()%>" width="300" height="200">
				</a>
					<p>
						<font size="3" color="gray"><b>차량명 : <%=dto.getName()%></b></font></td>
				<%
					j += 1;

					}
				%>
			
		</table>
		<p>
		<%
			out.write(pm.getPagenation("CarAllList"));
		%>
	</center>

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>