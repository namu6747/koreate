<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import = "java.util.*" %>
	<% 
		String nextPage = request.getParameter("page");
		if(nextPage == null){
			nextPage = "default";
		}
		nextPage = nextPage+".jsp";
		%>
		
		
			<% 
		String headerPage = request.getParameter("headerPage");
		if(headerPage == null){
			headerPage = "header";
		}
		headerPage = headerPage+".jsp";
		%>
		
		<%  
			if(application.getAttribute("list") == null)
			application.setAttribute("list", new ArrayList());
		%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		margin:0 auto;
		text-align:center;
		border:1px solid black;
		width:900px;
	}
	
	td{
		border-right:1px solid gray;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<th height="100">
			<jsp:include page="<%=headerPage %>" />
			</th>
		</tr>
		<tr>
			<td height="500">
			<jsp:include page="<%=nextPage%>" />
			</td>
		</tr>
		<tr>
			<th height="100">
			<jsp:include page="footer.jsp" />
			</th>
		</tr>
	</table>

</body>
</html>