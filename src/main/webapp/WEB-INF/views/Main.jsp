<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>우리펜션 메인 화면</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String center = request.getParameter("center");
	session.setMaxInactiveInterval(60*60*24);
	if(center==null){
		center = "Center.jsp";
	}
%>
<table width="100%">
	<tr height="140" align="center">
		<td align="center"><jsp:include page="Top.jsp"/>
		</td>
	</tr>
	<tr height="140" align="center">
		<td align="center"><jsp:include page="<%=center %>"/>
		</td>
	</tr>
	<tr height="2">
	<td bgcolor="#a6c6f5"></td>
	</tr>
	<tr height="110" align="center">
		<td align="center"><jsp:include page="Bottom.jsp"/>
		</td>
	</tr>
</table>
</body>
</html>