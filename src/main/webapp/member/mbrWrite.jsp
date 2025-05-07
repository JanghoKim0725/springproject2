<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
 <head>
	<meta charset="UTF-8">
	<title>회원 등록 화면</title>
	<link rel="stylesheet" href="../css/style.css"/>
 </head>
 <script>
 	function fn_submit() {
 		
 		let f = document.frm;
 		
 		if( f.userid.value == "") { 
 			alert("아이디를 입력해주세요.");
 			f.userid.focus();
 			return false;
 		}
 		
 		if( f.pass.value == "") { 
 			alert("암호를 입력해주세요.");
 			f.pass.focus();
 			return false;
 		}
 		
 		f.submit();
 	}
 </script>
 <body>
 	<div>
 		<form name="frm" method="post" action="/mbrInsert">
	 		<table class="table1">
	 			<tr>
	 				<th>아이디</th>
	 				<td><input type="text" name="userid" id="userid" class="input1"></td>
	 			</tr>
	 			<tr>
	 				<th>암호</th>
	 				<td><input type="password" name="pass" id="pass" class="input1"></td>
	 			</tr>
	 			<tr>
	 				<th>이름</th>
	 				<td><input type="text" name="name" id="name" class="input1"></td>
	 			</tr>
	 			<tr>
	 				<th>핸드폰</th>
	 				<td><input type="text" name="phone" id="phone" class="input1"></td>
	 			</tr>
	 			<tr>
	 				<th>성별</th>
	 				<td>
	 					<input type="radio" name="gender" value="M" class="radio1">남
	 					<input type="radio" name="gender" value="F" class="radio1">여
	 				</td>
	 			</tr>
	 			<tr>
	 				<th>주소</th>
	 				<td><input type="text" name="addr" id="addr" class="input1"></td>
	 			</tr>
	 		</table>
 		</form>
 		<div class="div_button_area">
 			<button type="submit" onclick="fn_submit();return false;">저장</button>
 			<button type="reset">취소</button>
 			<button type="button" onclick="location='/mbrList'">목록</button>
 		</div>
 	</div>
 </body>
</html>