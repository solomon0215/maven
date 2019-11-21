<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width=100% border="1" cellpaddion="0" cellspacing="0">
	<c:if test="${! empty boards }">
		<tr align="center" valign="middle">
			<td align="center" colspan="4">답변 게시판</td>
			<td align="right">
				<font size=2>글 개수 : ${boardCount}</font>
			</td>
		</tr>
		<tr align="center" valign="middle">
			<td width="8%" height="26">번호</td>
			<td width="28%" height="26">제목</td>
			<td width="8%" height="26">작성자</td>
			<td width="8%" height="26">날짜</td>
			<td width="8%" height="26">조회수</td>
		</tr>
		<c:forEach var="board" items="${boards }" varStatus="status">
		<tr align="center" valign="middle">
			<td width="8%" height="26">${status.count}</td>
			<td width="28%" height="26">${board.boardSubject }
				<c:if test="${board.originalFilename != null }">
					<img src=""/>
				</c:if>
			</td>
			<td width="8%" height="26">${board.boardName }</td>
			<td width="8%" height="26"><fmt:formatDate value="${board.boardDate }" pattern="yyyy-MM-dd"/></td>
			<td width="8%" height="26">${board.boardReadcount }</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${ empty boards }">
		<tr align="center" valign="middle">
			<td align="center" colspan="4">답변 게시판</td>
			<td align="right">
				<font size=2>게시글이 없습니다.</font>
			</td>
		</tr>
	</c:if>
		<tr align="center" valign="middle">
			<td align="center" colspan="5"><a href="answerBoard">등록하기</a></td>
		</tr>	
</table>
<table>
	<tr>
		<td>
		<c:if test="${page<= 1 }">
			[이전]&nbsp;
		</c:if>
		<c:if test="${page > 1 }">
			<a href="answerBoardList?page=${page-1}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
			<a href="answerBoardList?page=${i}">[${i}]&nbsp;&nbsp;</a>
		</c:forEach>
		<c:if test="${maxPage <= page }">
			[이후]&nbsp;
		</c:if>
		<c:if test="${maxPage>page }">
			<a href="answerBoardList?page=${page+1}">[이후]</a>
		</c:if>
		</td>
	</tr>
</table>
</body>
</html>