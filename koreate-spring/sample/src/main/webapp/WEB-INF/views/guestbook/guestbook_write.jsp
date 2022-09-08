<%@ page contentType="text/html; utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>board</h1>
	${board}
	
	<c:choose>
	
		<c:when test="${empty board}">
			<h2>방명록 등록 실패</h2>
		<a href="/le/list">[목록으로 이동]</a>
		</c:when>
		<c:when test="${board != null}">
		<h2>방명록 등록 성공</h2>
		<a href="/le/list">[목록으로 이동]</a>
		</c:when>
		<c:otherwise>
			이상함
		</c:otherwise>
	
	</c:choose>


