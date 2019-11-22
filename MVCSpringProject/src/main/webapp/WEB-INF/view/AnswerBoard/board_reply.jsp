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
<form:form action = "answerBoardReplyPro" method="post" commandName="answerBoardReplyCommand" enctype="multipart/form-data">
<form:hidden path="boardNum"/>
<form:hidden path="boardReRef"/>
<form:hidden path="boardReLev"/>
<form:hidden path="boardReSeq"/>
<table border = "1" cellpadding = "0" cellspacing = "0">
   <tr align = "center" valign = "middle">
      <td colspan = 2>답글</td>
   </tr>
   <tr>
	   <td height="16" align="center">글쓴이</td>
	   <td>
	  	 <form:input path="boardCommand.boardName" />
	  	 <form:errors path="boardCommand.boardName"/>
	   </td>
   </tr>
   <tr>
   	<td height="16" align="center">제목</td>
   	<td>
   		<form:input path="boardCommand.boardSubject" size="50" />
   		<form:errors path="boardCommand.boardSubject"/>
   	</td>
   </tr>   
   <tr>
	   <td height="16" align="center">내용</td>
	   <td>
	   	<form:textarea path="boardCommand.boardContent" cols="67" rows="15" />
	   	<form:errors path="boardCommand.boardContent"/>
	   </td>
   </tr>
   <tr>
   	<td height="16" align="center">비밀번호</td>
   	<td>
   		<form:password path="boardCommand.boardPass" />
   		<form:errors path="boardCommand.boardPass"/>
   	</td>
   </tr>
   <tr>
   	<td height="16" align="center">파일</td>
   	<td>
   		<input type="file" name="reports" multiple="multiple"/>
   	</td>
   </tr>
   <tr align ="center" valign="middle">
   	<td colspan ="2">
	   <input type="submit" value="[등록]">&nbsp;&nbsp;
	   <input type="button" value="[뒤로]" onclick="javascript:history.back()">
   	</td>
   </tr>
</table>
</form:form>

</body>
</html>