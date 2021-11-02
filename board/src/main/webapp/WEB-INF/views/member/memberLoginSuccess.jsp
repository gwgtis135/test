<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../home/header.jsp" />
<body>
<div align="center">
	<div><h1>${name}님 환영합니다.</h1></div>		<!-- 세션명만 읽어서 name만 하면 됨  -->
	<a href="home.do">홈가기</a>
	
</div>
</body>
</html>