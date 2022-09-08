<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
	<title>방명록 메시지 작성 확인</title>
</head>
<body>
<!-- 방명록 작성 후 처리 결과 출력 code 작성 -->
<c:catch var="e">
	<f:requestEncoding value="utf-8"/>
	<jsp:useBean id="testGuestBook" class="vo.TestGuestBookVO"/>
	<jsp:setProperty name="testGuestBook" property="*"/>
	
	<s:update var="result" dataSource="jdbc/MySQLDBCP">
		INSERT INTO test_guestbook 
		VALUES(null,?,?,?)
		<s:param>${testGuestBook.guestName}</s:param>
		<s:param>${testGuestBook.password}</s:param>
		<s:param>${testGuestBook.message}</s:param>
	</s:update>
	<c:choose>
		<c:when test="${result > 0}">
			<h1>방명록 등록 성공</h1>
			<span>방명록에 메시지를 남겼습니다.</span>
		</c:when>
		<c:otherwise>
			<h1>방명록 등록 실패</h1>
			<span>방명록에 메시지를 남기지 못했습니다.</span>
		</c:otherwise> 
	</c:choose>
</c:catch>
<c:if test="${!empty e}">
	<h1>방명록 등록 실패</h1>
	<span>방명록에 메시지를 남기지 못했습니다.</span>
</c:if>
<!-- 방명록 작성 후 처리 결과 출력 code 작성 end-->

<br/>
<a href="<c:url value="/guestbook/guestbook_list.jsp"/>">[목록 보기]</a>
</body>
</html>
