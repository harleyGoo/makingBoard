<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<form action="writeBoard">
		<input type="submit" value="Write"><font>${warning}</font>
	</form>
	
	<form action="goHome">
		<input type="submit" value="Home">
	</form>
	
	<table style="border: 1px solid black; margin: 0 auto; padding: 10px;">
		<tr>
			<td style="width:45%">글제목</td>
			<td style="width:15%">게시자</td>
			<td style="width:15%">조회수</td>
			<td>등록일</td>
		</tr>
		<c:forEach var="board" items="${bList}">
			<tr>
			<td style="width:45%">
			<a href="boardDetail?boardseq=${board.boardseq}">${board.boardtitle}</a>
			</td>
			<td style="width:15%">${board.id}</td>
			<td style="width:15%">${board.hitcount}</td>
			<td>${board.indate}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>