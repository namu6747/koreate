<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>방명록 메시지 목록</title>
</head>
<style>
</style>
<body>
	<!-- 방명록 작성 전달을 위한 form tag 완성 -->
	<form action="guestbook_write.jsp" method="post">
		<table>
			<tr>
				<td colspan=3><h1>방명록 작성</h1></td>
			</tr>
			<tr>
				<td colspan=2></td>
				<td rowspan="4"><input type="submit" value="메시지 남기기"
					style="width: 100%; height: 100px; margin-left: 20px;" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="guestName" style="width: 100%;" /></td>
			<tr>
				<td>암호</td>
				<td><input type="password" name="password" style="width: 100%;" /></td>
			</tr>
			<tr>
				<td>메시지</td>
				<td><textarea name="message" cols="35" rows="3"></textarea></td>
			</tr>
		</table>
	</form>
	<hr>

	<!-- 방명록 리스트 정보 출력 -->
	<h1>방명록 리스트</h1>
	<jsp:useBean id="pm" class="utils.PageMaker" />
	<c:if test="${!empty param.page}">
		<c:set target="${pm.cri}" property="page" value="${param.page}"/>
	</c:if>

	<s:query var="r" dataSource="jdbc/MySQLDBCP">
		SELECT count(*) AS c FROM test_guestbook
	</s:query>
	<c:set target="${pm}" property="totalCount" value="${r.rows[0].c}"/>

	<s:query var="rs" dataSource="jdbc/MySQLDBCP"
         startRow="${pm.cri.startRow}" 
		 maxRows="${pm.cri.perPageNum}">
		SELECT * FROM test_guestbook
		 ORDER BY id
	</s:query>

	<c:if test="${rs.rowCount > 0}">
		<jsp:useBean id="guestbookList" 
					 class="java.util.ArrayList" 
				 	 type="java.util.List<vo.TestGuestBookVO>"/>
		<c:forEach var="guestbook" items="${rs.rows}">
			<jsp:useBean id="vo" class="vo.TestGuestBookVO" />
			<c:set target="${vo}" property="id" value="${guestbook.id}"/>
			<c:set target="${vo}" property="guestName" value="${guestbook.guestName}"/>
			<c:set target="${vo}" property="password" value="${guestbook.password}"/>
			<c:set target="${vo}" property="message" value="${guestbook.message}"/>
			<c:set var="none" value="${guestbookList.add(vo)}"/> 
			<c:remove var="vo"/>
		</c:forEach>		 	  
		
	</c:if>
	
	<!-- 방명록 리스트 정보 출력 end -->
	<c:choose>
		<c:when test="${!empty guestbookList}">
			<c:forEach var="book" items="${guestbookList}">
				<div style="border: 1px solid black; width=500px;" >
					<table>
						<tr>
							<td>메시지 번호 : ${book.id}</td>
						</tr>
						<tr>
							<td>손님 이름 : ${book.guestName}</td>
						</tr>
						<tr>
							<td>메시지 : ${book.message}</td>
						</tr>
					</table>
					<a href="guestbook_confirm.jsp?id=${book.id}">[삭제하기]</a>
				</div>
			</c:forEach>
		</c:when>
	</c:choose>

	<!-- 방명록 정보에 따른 paging block 화면 출력 작성 -->
	<c:choose>
		<c:when test="${!empty guestbookList}">
			<c:if test="${pm.prev}">
				<a href="guestbook_list.jsp?page=1">[&lt;&lt;]</a>
				<a href="guestbook_list.jsp?page=${pm.startPage-1}">[&lt;]</a>
			</c:if>
			<c:forEach var="i" begin="${pm.startPage}" end="${pm.endPage}">
				<c:choose>
					<c:when test="${pm.cri.page eq i}">
						<span style="color: red;">[${i}]</span>
					</c:when>
					<c:otherwise>
						<a href="guestbook_list.jsp?page=${i}">[${i}]</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${pm.next}">
				<a href="guestbook_list.jsp?page=${pm.endPage+1}">[&gt;]</a>
			</c:if>
			<c:if test="${pm.cri.page != pm.maxPage}">
				<a href="guestbook_list.jsp?page=${pm.maxPage}">[&gt;&gt;]</a>
			</c:if>
		</c:when>
		<c:otherwise>
					<h3>등록된 게시물이 없습니다.</h3>
			</c:otherwise>
	</c:choose>
	<!-- 방명록 정보에 따른 paging block 화면 출력 end-->

</body>
</html>