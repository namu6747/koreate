<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
	
	}
	
	div{
		width : 300;
		
		align : center;
	}
	a{
		text-decoration:none;
		color:black;
	}
	a:hover{
		cursor:pointer;
	}
</style>
</head>
<body>
	<div>
		<a href="index.jsp?page=default">home</a> 
		<%@page import="vo.*" %>
		<% MemberVO member = (MemberVO)session.getAttribute("member"); %>
		<a href="index.jsp?page=info&headerPage=loginCompl"><%= member.getName() + "님 반갑습니다" %></a>
		<a href="index.jsp?page=logout">로그아웃</a>
	</div>
</body>
</html>