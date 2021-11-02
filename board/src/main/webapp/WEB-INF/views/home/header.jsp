<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/menu.css">
</head>
<body>
	<div align="center">
		<div>
			<br />
		</div>
		<div>
			<!-- 메뉴부분 -->
			<ul>
				<li><a class="active" href="home.do">Home</a></li>
				<c:if test="${empty id }">
						<li><a href="memberLoginForm.do">로그인</a></li>
						<li><a href="memberJoinForm.do">회원가입</a></li>
				</c:if>
				<c:if test="${not empty id }">			<!-- id값이 비어있으면 안보이게 -->
					<li><a href="noticeList.do">공지사항</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Product</a></li>
					<li><a href="memberMyInfoForm.do">나의정보</a></li>	<!-- 로그인된 사람들의 정보를 가져올수 있게 해야한다. -->
					
					<c:if test="${author == 'ADMIN'}">
						<li><a href="memberSelectList.do">Members</a></li>
					</c:if>
					<li><a href="memberLogout.do">로그아웃</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>