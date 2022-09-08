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
<%@ page import="vo.*" %>
	<% MemberVO member = (MemberVO)session.getAttribute("member"); %>
	<div id="inner">
		<%= "아이디 " + member.getName() %></div><br/>
		<%= "비밀번호 " + member.getPass() %><br/>
		<%= "이름 " + member.getName() %><br/>
		<%= "주소 " + member.getAddr() %><br/>
		<%= "전화번호 " + member.getPhone() %><br/>
		<% if(member.getGender().equals("남성")){ %>
		<div id="gen"> 성별<input type='radio' name='gender' value='male' checked/>남성
  		<input type='radio' name='gender' value='female' />여성</div><br/>
		<%} else { %>
			<div id="gen"> 성별<input type='radio' name='gender' value='male' />남성
			  		<input type='radio' name='gender' value='female' checked/>여성</div><br/>
		<% } %><br/>
		
		
		<%= "나이 " + member.getAge() %><br/>
	
	
	
</body>
</html>