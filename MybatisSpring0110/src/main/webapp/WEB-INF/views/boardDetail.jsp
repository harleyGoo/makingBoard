<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- jstl 태그 라이브러리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
</head>
<body>
	<c:if test="${sessionScope.loginId == board.id}">
		<div style="display: inline-flex;">
		<form action="updateBoard" method="post">
			<input type="hidden" name="boardseq" value="${board.boardseq}">
			<input type="submit" value="수정">
		</form>
		<form action="deleteBoard" method="post">
			<input type="hidden" name="boardseq" value="${board.boardseq}">
			<input type="submit" value="삭제">
		</form>
		</div>
	</c:if>
	
	<table>
		<tr><td>제목:</td><td>${board.boardtitle}</td></tr>
		<tr><td>게시자:</td><td>${board.id}</td></tr>
		<tr><td>조회수:</td><td>${board.hitcount}</td></tr>
		<tr><td>등록일:</td><td>${board.indate}</td></tr>
	</table>
	<hr>
	<div>${board.boardcontent}</div>
	
	<form action="boardList">
		<input type="submit" value="돌아가기">
	</form>
	<form action="goHome">
		<input type="submit" value="홈페이지로 가기">
	</form>
</body>
</html>