<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

</head>
<body>
	<form action="insertMember" method="post">
		<fieldset>
		<legend>SIGN UP</legend>
			ID: <input type="text" name="id" value="${member.id}" id="userId"><font color="red">${warning}</font><br>
			PW: <input type="password" name="pw" value="${member.pw}"><br>
			NAME: <input type="text" name="name" value="${member.name}"><br>
			PHONE: <input type="text" name="phone" value="${member.phone}"><br>
			EMAIL: <input type="text" name="email" value="${member.email}"><br>
			BIRTHDATE: <input type="text" name="birthdate" value="${member.birthdate}"><br>
			<input type="submit" value="Sign Up">
		</fieldset>
	</form>
</body>
</html>