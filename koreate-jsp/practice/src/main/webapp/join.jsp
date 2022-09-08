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
		vertical-align:center;
		}
		
		#inner {
		margin:0 auto;
			text-align: right;
			width : 300px;
		}
		#gen {
		
			text-align: center;
			width : 300px;
		}
		
	</style>
</head>




<body>
	<h1>회원가입</h1>
	<form action="joinCheck.jsp" method="POST">
	<div id="inner">
		아이디 <input type="text" name="id" required/><br/><br/>
		비밀번호 <input type="password" name="pass" required/><br/><br/>
		이름 <input type="text" name="name" required/><br/><br/>
		주소 <input type="text" name="addr" required/><br/><br/>
		전화번호 <input type="text" name="phone" required/><br/><br/>
		<div id="gen"> 성별<input type='radio' name='gender' value='male' />남성
  		<input type='radio' name='gender' value='female' />여성</div><br/>
 		나이 <input type="text" name="age" required/><br/><br/>
		</div>
		<button>회원가입</button>
	</form>
		
</body>
</html>