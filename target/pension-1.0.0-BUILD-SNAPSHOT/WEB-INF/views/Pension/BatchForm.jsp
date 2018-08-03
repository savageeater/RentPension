<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<title>BatchForm.jsp</title>
<style type="text/css">
td
{
padding-top:10px;
padding-bottom:10px;
}

</style>

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
		<td width="150"  bgcolor="#a6c6f5" rowspan="2">지역 입력 정보</td>
		<td bgcolor="#a6c6f5">
		경기도 : 1 /  강원도 : 2 /  충청남도 : 3 / 충청북도 : 4
		</td>
		</tr>
		<tr>
		<td bgcolor="#a6c6f5">
		 경상남도 : 5 / 경상북도 : 6 / 전라남도 : 7  / 전라북도 : 8
		</td>
		</tr>
		<!-- 
		<tr>
			<td width="100" bgcolor="#a6c6f5">배치자료입력</td>
			<td width="600">
			<textarea rows="15" cols="100" name="text"></textarea>
			</td>
		</tr>	
 	-->

<tr>
	<td align="left">펜션이름</td>
	<td align="left" width="150"><input type="text" name="name"></td>
</tr>
<tr>
	<td align="left">가격</td>
	<td align="left" width="150"><input type="text" name="price"></td>
</tr>		
<tr>
	<td align="left">이미지 파일명</td>
	<td align="left" width="150"><input type="text" name="img"></td>
</tr>
<tr>
	<td align="left">특이사항</td>
	<td align="left" width="150"><input type="text" name="info"></td>
</tr>
<tr>
	<td align="left">숙박 최소인원</td>
	<td align="left" width="150"><input type="text" name="minp"></td>
</tr>
<tr>
	<td align="left">숙박 최대인원</td>
	<td align="left" width="150"><input type="text" name="maxp"></td>
</tr>
<tr>
	<td align="left">지역</td>
	<td align="left" width="150"><input type="text" name="region"></td>
</tr>	
<tr>
	<td align="left">스파 여부(Y:1,N:0)</td>
	<td align="left" width="150"><input type="text" name="spa"></td>
</tr>	
<tr>
	<td align="left">풀빌라 여부(Y:1,N:0)</td>
	<td align="left" width="150"><input type="text" name="pool"></td>
</tr>	
<tr>
	<td align="left">화장실 갯수</td>
	<td align="left" width="150"><input type="text" name="toilet"></td>
</tr>	
<tr>
	<td align="left">방 갯수</td>
	<td align="left" width="150"><input type="text" name="room"></td>
</tr>
<tr>
	<td align="left">조식 여부(Y:1,N:0)</td>
	<td align="left" width="150"><input type="text" name="breakfast"></td>
</tr>	
<tr>
	<td align="left">와이파이 여부(Y:1,N:0)</td>
	<td align="left" width="150"><input type="text" name="wifi"></td>
</tr>	
		<tr>
		<td colspan="2" align="center">
			<input type="submit" value="입력"/>
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