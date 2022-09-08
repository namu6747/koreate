<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- delete.jsp -->
<%@ include file="conn.jsp" %>
<%
	String num = request.getParameter("board_num");
	int board_num = Integer.parseInt(num);
	
	PreparedStatement pstmt = null;
	String msg = "";
	String sql ="DELETE FROM board_test WHERE board_num = ?";
	
	try{
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,board_num);
		int result = pstmt.executeUpdate();
		msg = result > 0 ? "삭제완료" : "삭제내용이 없습니다.";
	}catch(Exception e){
		e.printStackTrace();
		msg = "삭제 시 문제가 발생했습니다.";
	}finally{
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
%>
<script>
	alert('<%=msg%>');
	location.href="index.jsp";
</script>









