<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<title>방명록 메시지 삭제함</title>
</head>
	<br />
	<!-- 삭제 확인 처리  알림 code 작성-->
	<f:requestEncoding value="utf-8"/>
	<s:update var="result" dataSource="jdbc/MySQLDBCP">
	DELETE FROM test_guestbook WHERE id = ? and password = ?
	<s:param>${param.id}</s:param>
	<s:param>${param.password}</s:param>
	</s:update>
	<c:if test="${result > 0}">
		<h1>방명록 삭제하였습니다.</h1>
	</c:if>
	<c:if test="${result != 1}">
		<h1>방명록 삭제 실패 하였습니다.</h1>
	</c:if>
	<a href="guestbook_list.jsp">[목록 보기]</a>
</html>