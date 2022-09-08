<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!-- 게시글 작성 요청 처리 -->
<c:catch var="e">
	<f:requestEncoding value="utf-8"/>
	<jsp:useBean id="testBoard" class="vo.TestBoardVO"/>
	<jsp:setProperty name="testBoard" property="*"/>
	
	<s:update var="result" dataSource="jdbc/MySQLDBCP">
		INSERT INTO test_board 
		VALUES(null, ?, ?, ?, ?, 0, now())
		<s:param>${testBoard.board_name}</s:param>
		<s:param>${testBoard.board_pass}</s:param>
		<s:param>${testBoard.board_title}</s:param>
		<s:param>${testBoard.board_content}</s:param>
	</s:update>
</c:catch>

<!-- 게시글 작성 결과 처리 -->
<c:redirect url="board_list.jsp"/>







