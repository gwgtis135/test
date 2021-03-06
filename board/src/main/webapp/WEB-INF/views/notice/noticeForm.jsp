<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../home/header.jsp" />
<div align="center">
	<div><h1>게시글 작성</h1></div>
	<div>
		<form id="frm" action="noticeInsert.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="100">아이디</th>
						<td width="150">
							<input type="text" id="id" name="id">	<!-- 이름은 보와 같게 만들어야함  -->
						</td>
						<th width="100">작성자</th>
						<td width="150">
							<input type="text" id="name" name="name">
						</td>
						<th width="100">작성일자</th>
						<td width="150">
							<input type="date" id="writeDate" name="writeDate">
						</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3"><input type="text" id="title" name="title"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							<textarea rows="10" cols="55" id="contents" name="contents"></textarea>
						</td>
					</tr>
				</table>
			</div><br>
			<div>
				<input type="submit" value="저 장">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취 소">&nbsp;&nbsp;&nbsp;
				<input type="button" value="목 록" onclick="location.href='noticeList.do'">&nbsp;&nbsp;&nbsp;
			</div>
		</form>
		
	</div>
</div>
</body>
</html>