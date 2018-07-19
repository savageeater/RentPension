<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<title>BatchForm.jsp</title>
</head>
<body>
<script>
	var pass = prompt('관리자 비밀번호를 입력하세요.');
	if(pass!='1234'){
		history.go(-1);
	}
</script>

<center>
<form action="BatchProc" method="post">
	<table width="800">
		<tr align="center">
		<td colspan="2">
		<font size="5" color="gray">
			펜션 등록 화면
		</font>
		</td>
		</tr>
		<tr>
		<td width="100"  bgcolor="#a6c6f5">입력 정보</td>
		<td>
		이름/가격/이미지/정보/숙박최소인원/최대인원/지역/스파여부/풀빌라여부/화장실갯수/방갯수/조식여부/와이파이여부#
		</td>
		</tr>
		<tr>
		<td width="100"  bgcolor="#a6c6f5">입력 샘플</td>
		<td>
		홍천라임오렌지펜션/55000/hongla.jpg/할인중/2/4/2/0/0/3/3/1/1#
		</td>
		</tr>
		<tr>
			<td width="100" bgcolor="#a6c6f5">배치자료입력</td>
			<td width="600">
			<textarea rows="15" cols="100" name="content"></textarea>
			</td>
		</tr>
		<tr>
		<td colspan="2" align="center">
			<input type="submit" value="배치처리"/>
		</td>
		</tr>
	</table>
</form>
</center>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/jquery-3.3.1.js" />"></script>
</body>
</html>