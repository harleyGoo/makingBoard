<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<!-- <script>
	function check(){
		var id = document.getElementById('userId').value;
		var pw = document.getElementById('userPw').value;
	
		if (condition) {
			
		}
	}
</script> -->
</head>
<body>
	<h1>로그인</h1>
	<!-- 로그인폼 -->
	<form action="loginMember" method="post">
		<fieldset>
		<legend>LOGIN</legend>
		ID: <input type="text" name="id" id="userId" value="${member.id}"><font>${warning}</font><br>
		PW: <input type="password" name="pw" id="userPw"><br>
		<input type="submit" value="Login">
		</fieldset>
	</form>
</body>
</html>