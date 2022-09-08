<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		body{
		margin:0 auto;
		text-align:center;
		border:1px solid black;
		width:900px;
		}
		
		#inner{
			margin: 0 auto;
			text-align: right;
			width : 300px;
		}
		
	</style>
</head>
<body>
	<h1>로그인</h1>
	<form action="loginCheck.jsp" method="POST">
	<div id="inner">
		아이디 <input type="text" name="id" required/><br/>
		비밀번호 <input type="password" name="pass" required/><br/>
		</div>
		<input type="checkbox" name="chk" value="cook"/> 로그인 상태 유지<br/>
		<button>로그인</button>
	</form>
		
</body>
</html>