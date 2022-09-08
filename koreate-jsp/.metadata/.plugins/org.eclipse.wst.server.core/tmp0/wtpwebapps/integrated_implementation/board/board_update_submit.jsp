<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<!-- 게시글 수정 처리 -->
<f:requestEncoding value="utf-8"/>
<c:catch var="e">
	<jsp:useBean id="board" class="vo.TestBoardVO"/>
	<jsp:setProperty property="*" name="board"/>
	<s:update var="result" dataSource="jdbc/MySQLDBCP">
		UPDATE test_board SET 
		board_name = ?,
		board_title = ?,
		board_content = ? 
		WHERE board_num = ? AND board_pass = ?
		<s:param>${board.board_name}</s:param>
		<s:param>${board.board_title}</s:param>
		<s:param>${board.board_content}</s:param>
		<s:param>${board.board_num}</s:param>
		<s:param>${board.board_pass}</s:param>
	</s:update>
	<c:choose>
		<c:when test="${result > 0}">
			<c:redirect url="board_detail.jsp?board_num=${board.board_num}"/>
		</c:when>
		<c:otherwise>
			<script>
				alert("수정실패! 정보가 일치하지 않습니다");
				history.back();
			</script>
		</c:otherwise>
	</c:choose>
</c:catch>
<c:if test="${!empty e}">
	<script>
		alert("수정실패! 정보가 일치하지 않습니다");
		history.back();
	</script>
</c:if>

<!-- 게시글 수정 결과 처리 -->






