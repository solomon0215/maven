<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="board_title"/></title>
</head>
<body>
	<form:form action="answerBoardWritePro" method="POST" enctype="multipart/form-data" commandName="boardCommand">
		<table cellpaddion="0" cellspacing="0">
			<tr align="center" valign="middle">
				<td colspan="2">답변형 자료실</td>
			</tr>
			<tr>
				<td style="font-size:12" height="16">
					<div align="center">글쓴이</div>
				</td>
				<td>
					<form:input path="boardName" size="10" maxlength="10"/>
				</td>
			</tr>
			<tr>
				<td style="font-size:12" height="16">
					<div align="center">비밀번호</div>
				</td>
				<td>
					<form:password path="boardPass" size="10" maxlength="10"/>
				</td>
			</tr>
			<tr>
				<td style="font-size:12" height="16">
					<div align="center">제목</div>
				</td>
				<td>
					<form:input path="boardSubject" size="10" maxlength="10"/>
				</td>
			</tr>
			<tr>
				<td style="font-size:12" height="16">
					<div align="center">내용</div>
				</td>
				<td>
					<form:textarea path="boardContent" cols="67" rows="15"></form:textarea>
				</td>
			</tr>
			<tr>
				<td style="font-size:12" height="16">
					<div align="center">자료실</div>
				</td>
				<td>
					<input type="file" name="report" multiple="multiple"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록">
					<input type="button" value="뒤로" onclick="javascript:history.back();">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>