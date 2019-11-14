<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>${memberCommand.userName }회원 가입을 완료했습니다.</p>
<p><a href="<c:url value='/main' />">[첫화면으로 이동]</a></p>
</body>
</html>