<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.*" import="vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="memberVO" class="vo.MemberVO" scope="page" />
	<jsp:setProperty name="memberVO" property="*" />
<%
	List<MemberVO> list = (List)application.getAttribute("list");

	if(memberVO != null){
	for(MemberVO vo : list){
		if(memberVO.equals(vo) && memberVO.getPass().equals(vo.getPass())){
			session.setAttribute("member", vo);
			
			String chkbox = request.getParameter("chk");
			
			if(chkbox != null){
				Cookie cookie = new Cookie("id", vo.getId());
				cookie.setMaxAge(60*60);
				response.addCookie(cookie);
			}
			response.sendRedirect("index.jsp?page=default&headerPage=loginCompl");		
			return;
		}
	}
	
	response.sendRedirect("index.jsp?page=login");
	}
	%>
	
</body>
</html>