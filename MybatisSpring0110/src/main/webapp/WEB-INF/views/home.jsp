<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<!-- 회원로그인을 한 경우 -->
	<c:if test="${sessionScope.loginId != null}">
		<h1>${sessionScope.loginId}님 환영합니다!</h1>
		<form action="logout">
			<input type="submit" value="Logout">
		</form>
	</c:if>
	
	
	<!-- 새로 들어온 경우(회원 로그인을 하지 않은 경우) -->
	<c:if test="${sessionScope.loginId == null}">
	
	<!-- 회원가입폼 이동액션 -->
	<form action="signUp">
		<input type="submit" value="SIGN UP">
	</form> 
	<!-- 로그인폼 이동액션 -->
	<form action="login">
		<input type="submit" value="LOGIN">
	</form>
	
	<!-- form이 아닌 링크를 태워서 이동액션 만들기 
	<a href="login?param=값">로그인</a>
	 : a tag이기 때문에 버튼이 아니라 밑줄이 그어져 있는 텍스트로 나타난다.
	   http://localhost:8888/어플리케이션명/액션?파라미터이름=값 의 형태로 파라미터를 전달할 수 있다.-->
	
	</c:if>
	
	
	<!-- 게시판 이동액션 -->
	<form action="goBoard">
		<input type="submit" value="Go Board">
	</form>
</body>
</html>
