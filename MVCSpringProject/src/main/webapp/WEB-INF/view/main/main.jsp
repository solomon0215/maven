<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login.title"/></title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<!-- 로그인 전 -->
<c:if test="${empty authInfo }">
<form:form name="frm" id="frm" action="login" method="post">
<table border="1">
   <tr>
   	<td colspan="3"><form:checkbox path="autoLogin" value="auto" /><spring:message code="login.auto"/></td>
   </tr>
   <tr>
   	<td>아이디</td>
    <td>
    	<form:input path="id1" id="id1" /><br>
    	<form:errors path="id1"></form:errors>
    </td>
    <td>
    	<form:checkbox path="idStore" value="store" />아이디체크
    </td>
   </tr>
   <tr>
   	<td>비밀번호</td>
   	<td>
   		<form:password path="pw" id="pw" /><br>
   		<form:errors path="pw"></form:errors>
   	</td>
    <td><input type="submit" id="btn" value="로그인" /></td>
   </tr>
   <tr>
   		<td colspan="3">
	   		<a href="#">아이디</a> 
	        <a href="#">비밀번호 찾기</a> 
	        &nbsp;&nbsp;
	        <a href="register/agree">회원가입</a>
		</td>
   </tr>
</table>
</form:form>
</c:if>
<!-- 로그인 후 -->
<c:if test="${! empty authInfo }">
${authInfo.name }님 환영합니다.
<a href="memberDetail.nhn">내 정보</a>
<a href="logout.nhn">로그아웃</a>
<a href="memberList.nhn">회원리스트</a>
<a href="board.bo">공지사항</a>
<a href="answerBoard.ab">답변형 게시판</a>
<a href="goodsList.gd">상품 목록</a>
</c:if>
</body>
</html>