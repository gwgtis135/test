<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../home/header.jsp" />
<div align="center">
	<div><h1>나 의 정 보</h1></div>
	<div>
		
			<form id="frm" action="memberMyInfo.do" method="post">
				<div>
					<table>
						<tr>
							<th width="100">아이디</th>
							<td width="200">${members.id }</td>
							<td><input type="text" id="id" name="id" >
							</td>
						</tr>
						<tr>
							<th width="100">패스워드</th>
							<td width="200">
								<textarea id="password" name="password" >${members.id }</textarea>
							</td>
						</tr>
						<tr>
							<th width="100">이  름</th>
							<td width="200">
								<textarea id="name" name="name" ></textarea>
							</td>
						</tr>
						<tr>
							<th width="100">주  소</th>
							<td width="200">
								<textarea id="address" name="address" ></textarea>
							</td>
						</tr>
						<tr>
							<th width="100">전화번호</th>
							<td width="200">
								<textarea id="tel" name="tel" ></textarea>
							</td>
						</tr>
					</table>
			 		<div>
          
          				<button type="button" onclick="">수정</button>&nbsp;&nbsp;&nbsp;
          				<button type="button" onclick="">홈가기</button>
     				 </div>
				</div>
			</form>
		
	</div>
</div>

</body>
</html>