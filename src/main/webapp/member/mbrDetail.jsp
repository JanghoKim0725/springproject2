<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
 <head>
	<meta charset="UTF-8">
	<title>회원 상세 화면</title>
	<link rel="stylesheet" href="../css/style.css"/>
 </head>
 <style>
 	
 	td {
 		text-align:left;
 		padding:5px;
 	}
 
 </style>
 <script> 
 	function fn_delete() {
 		if(confirm("정말 삭제하시겠습니까?")) {
 			alert("삭제처리가 되었습니다.");
 			location = "/mbrDelete/${dto.userid}";
 		}
 	} 
 </script>
 <body>
 	<div>
 		<form name="frm" method="post" action="/mbrInsert">
	 		<colgroup>
	 			<col width="25%"/>
	 			<col width="*"  />
	 		</colgroup>
	 		<table class="table1">
	 			<tr>
	 				<th>아이디</th>
	 				<td>${dto.userid}</td>
	 			</tr>
	 			<tr>
	 				<th>이름</th>
	 				<td>${dto.name}</td>
	 			</tr>
	 			<tr>
	 				<th>핸드폰</th>
	 				<td>${dto.phone}</td>
	 			</tr>
	 			<tr>
	 				<th>성별</th>
	 				<td>${dto.gender}</td>
	 			</tr>
	 			<tr>
	 				<th>주소</th>
	 				<td>${dto.addr}</td>
	 			</tr>
	 		</table>
 		</form>
 		<div class="div_button_area">
 			<button type="button" onclick="location='/mbrList'">목록</button>
 			<button type="button" onclick="location='/mbrModify/${dto.userid}'">수정</button>
 			<button type="button" onclick="fn_delete()">삭제</button>
 		</div>
 	</div>
 </body>
</html>