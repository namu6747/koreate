<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s"%>
<!-- 게시글 삭제 요청 처리 -->

<f:requestEncoding value="utf-8"/>
<c:catch var="e">
<s:update var="result" dataSource="jdbc/MySQLDBCP">
	DELETE FROM test_board WHERE board_num = ? AND board_pass = ?
	<s:param>${param.board_num}</s:param>
	<s:param>${param.board_pass}</s:param>
</s:update>
	<c:choose>
		<c:when test="${result > 0}">
			<c:redirect url="board_list.jsp"/>
		</c:when>
		<c:otherwise>
			<script>
				alert("삭제실패! 정보가 일치하지 않습니다");
				history.back();
			</script>
		</c:otherwise>
	</c:choose>
</c:catch>
<c:if test="${!empty e}">
	<script>
		alert("삭제실패! 정보가 일치하지 않습니다");
		history.back();
	</script>
</c:if>
    
<!-- 게시글 삭제 요청 결과 처리 -->