<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*" import="vo.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>

	<jsp:useBean id="memberVO" class="vo.MemberVO" scope="page" />
	<jsp:setProperty name="memberVO" property="*" />

	<%
	List<MemberVO> list = (List)application.getAttribute("list");
	for(MemberVO vo : list){
		if(memberVO.equals(vo)){
			System.out.println("아이디 중복");
			response.sendRedirect("index.jsp?page=default");
			return;
		}
	}
	list.add(memberVO);%>
	
	 <script>
		alert('회원가입 성공');
	</script>
	<%
	 response.sendRedirect("index.jsp?page=default");
	 %> 
	
</body>
</html>