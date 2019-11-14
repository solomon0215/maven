<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="memberJoinAction" name="frm" id="frm" method="post">
      <table width=600 align="center" border=1>
         <tr>
            <td width="200">사용자 ID</td>
            <td width="400"><input type="text" name="userId" size="12"
               maxlength="10" id="userId"> <input type="button"
               name="userConfirm" id="userConfirm" value="중복확인"></td>
         </tr>
         <tr>
            <td width="200">비밀번호</td>
            <td width="400"><input type="password" name="userPw"
               id="userPw" size="12" maxlength="10"></td>
         </tr>
         <tr>
            <td width="200">비밀번호 확인</td>
            <td width="400"><input type="password" name="userPwCon"
               id="userPwCon" size="12" maxlength="10"></td>
         </tr>
         <tr>
            <td width="200">사용자 이름</td>
            <td width="400"><input type="text" name="userName"
               id="userName" size="12" maxlength="10"></td>
         </tr>
         <tr>
            <td width="200">생년월일</td>
            <td width="400"><input type="date" name="userBirth"
               id="userBirth" size="12" maxlength="10"></td>
         </tr>
         <tr>
            <td width="200">성별</td>
            <td width="400">
           	남자 : <input type="radio" value="M" name="userGender"  id="userGender" size="12" maxlength="10" checked>
           	여자 : <input type="radio" value="F" name="userGender"  id="userGender" size="12" maxlength="10">
            </td>
         </tr>
         <tr>
            <td width="200">이메일</td>
            <td width="400"><input type="text" name="userEmail"
               id="userEmail" size="12" maxlength="10"></td>
         </tr>
         <tr>
            <td width="200">주소</td>
            <td width="400"><input type="text" name="userAddr"
               id="userAddr" size="12" maxlength="10"></td>
         </tr>
         <tr>
            <td width="200">연락처1</td>
            <td width="400"><input type="text" name="userPh1"
               id="userPh1" size="12" maxlength="10"></td>
         </tr>
         <tr>
            <td width="200">연락처2</td>
            <td width="400"><input type="text" name="userPh2"
               id="userPh2" size="12" maxlength="10"></td>
         </tr>
         <tr>
         	<td colspan="2">
         	<input type="submit" value="가입">
         	<input type="reset" value="다시 입력">
         	<input type="button" value="가입 안함">
         	</td>
         </tr>
      </table>
   </form>
</body>
</html>