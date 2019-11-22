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
<title><spring:message code="board_title"/></title>
</head>
<body>
<table width=50% border="1" cellpaddion="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td style="font-size:12" height="16">
			<spring:message code="board_title"/>
		</td>
		<td style="font-size:12" align="right">
			조회수 : ${board.boardReadcount}
			| 등록일 : <fmt:formatDate value="${board.boardDate}" type="date"/>
		</td>
	</tr>
	<tr align="center" valign="middle">
		<td style="font-size:12" height="16">
			글쓴이
		</td>
		<td style="font-size:12">
			${board.boardName }
		</td>
	</tr>
	<tr align="center" valign="middle">
		<td style="font-size:12" height="16">
			제목
		</td>
		<td style="font-size:12">
			${board.boardSubject }
		</td>
	</tr>
	<tr align="center" valign="middle">
		<td style="font-size:12" height="16">
			내용
		</td>
		<td style="font-size:12">
			${board.boardContent }
		</td>
	</tr>
	<tr align="center" valign="middle">
		<td colspan=2>
			<a href="answerBoardReply?num=${board.boardNum }">[답변]</a>
			<a href="answerBoardUpdate/${board.boardNum}">[수정]</a>
			<a href="answerBoardDelete/${board.boardNum}">[삭제]</a>
			<a href="answerBoardList">[목록]</a>
		</td>
	</tr>
</table>
</body>
</html>