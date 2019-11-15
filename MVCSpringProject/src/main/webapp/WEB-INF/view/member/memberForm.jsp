<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.info"/></title>
</head>
<body>
   <form:form action="memberJoinAction" name="frm" id="frm" method="post" commandName="memberCommand">
      <table width=600 align="center" border=1>
         <tr>
            <td width="200"><spring:message code="userId"/></td>
            <td width="400">
            	<form:input path="userId" size="12" maxlength="10" id="userId"/> 
            	<input type="button" id="userConfirm" value="중복확인"/><br>
            	<form:errors path="userId"></form:errors>
            </td>
         </tr>
         <tr>
            <td width="200"><spring:message code="password"/></td>
            <td width="400">
            <form:password path="userPw" id="userPw" size="12" maxlength="10"/><br>
            <form:errors path="userPw"></form:errors>
            </td>
         </tr>
         <tr>
            <td width="200"><spring:message code="password.confirm"/></td>
            <td width="400">
            	<form:password path="userPwCon" id="userPwCon" size="12" maxlength="10"/><br>
            	<form:errors path="userPwCon"></form:errors>
            </td>
         </tr>
         <tr>
            <td width="200"><spring:message code="name"/></td>
            <td width="400">
            	<form:input path="userName" id="userName" size="12" maxlength="10"/><br>
            	<form:errors path="userName"></form:errors>
            </td>
         </tr>
         <tr>
            <td width="200"><spring:message code="birth"/></td>
            <td width="400">
            	<form:input path="userBir" id="userBir" size="12" maxlength="10"/><br>
            	<form:errors path="userBir"></form:errors>
            </td>
         </tr>
         <tr>
            <td width="200"><spring:message code="gender"/></td>
            <td width="400">
           	<spring:message code="male"/><form:radiobutton  value="M" path="userGender"  id="userGender" size="12" maxlength="10" checked="checked"/>
           	<spring:message code="female"/><form:radiobutton  value="w" path="userGender"  id="userGender" size="12" maxlength="10"/>
            </td>
         </tr>
         <tr>
            <td width="200"><spring:message code="email"/></td>
            <td width="400">
            	<form:input path="userEmail" id="userEmail" size="12" maxlength="10"/><br>
            	<form:errors path="userEmail"></form:errors>
            </td>
         </tr>
         <tr>
            <td width="200"><spring:message code="addr"/></td>
            <td width="400">
            <form:input path="userAddr" id="userAddr" size="12" maxlength="10"/><br>
            <form:errors path="userAddr"></form:errors>
            </td>
         </tr>
         <tr>
            <td width="200"><spring:message code="ph1"/></td>
            <td width="400">
            	<form:input path="userPh1" id="userPh1" size="12" maxlength="10"/><br>
            	<form:errors path="userPh1"></form:errors>
            </td>
         </tr>
         <tr>
            <td width="200"><spring:message code="ph2"/></td>
            <td width="400">
            	<form:input path="userPh2" id="userPh2" size="12" maxlength="10"/>
            </td>
         </tr>
         <tr>
         	<td colspan="2">
         	<input type="submit" value="가입">
         	<input type="reset" value="다시 입력">
         	<input type="button" value="<spring:message code="register.btn"/>">
         	</td>
         </tr>
      </table>
   </form:form>
</body>
</html>