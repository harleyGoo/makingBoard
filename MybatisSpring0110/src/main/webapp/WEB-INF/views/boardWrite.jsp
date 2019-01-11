<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록하기</title>
</head>
<body>
	<c:if test="${board == null}">
		<form action="insertBoard" method="post">
	</c:if>
	<c:if test="${board != null}">
		<form action="updateContent" method="post">
		<input type="hidden" name="boardseq" value="${board.boardseq}">
	</c:if>

	<form action="insertBoard" method="post">
		<fieldset>
		<legend>게시글 등록하기</legend>
			<table>
				<tr><td>제목: </td><td><input type="text" name="boardtitle" value="${board.boardtitle}"></td></tr>
				<tr><td>본문: </td><td><textarea name="boardcontent" cols="30" rows="10">${board.boardcontent}</textarea></td></tr>
			</table>
			<!-- 제목 : <input type="text" name="boardtitle"><br><br>
			본문 : <input type="text" name="boardcontent"><br>
			<textarea name="boardcontent" cols="30" rows="10"></textarea><br>
			input hidden을 하나 더 만들고 값을 넣은 후 script로 처리하면 가능 -->
			<input type="submit" value="Submit">
		</fieldset>
	</form>
</body>
</html>