<%@ page contentType="text/html; utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 방명록 메인화면 -->
<h1>방명록 작성</h1>

<form action="/le/write" method="get">
이름<input type="text" name="name" id="name"><br/>
비밀번호<input type="text" name="pw" id="pw"><br/>
메시지<input type="text" name="message" id="message"><br/>
<input type="submit" value="메시지 남기기">
</form>


<h1>방명록 리스트</h1>

		
		<c:if test="${not empty list}">
			<c:forEach var="item" items="${list}">
			<table style="border-size: 1px; border-color: black">
				<tr>
				</tr>
				<br/>
				<tr>
					손님 이름 : ${item.name}
				</tr>
				<br/>
				<tr>
					메시지 : ${item.message}
				</tr>
				<br/>
				<tr>
				</tr>
			</table>			
			</c:forEach>
		</c:if>
		


