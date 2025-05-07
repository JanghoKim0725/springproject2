<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
 <head>
	<meta charset="UTF-8">
	<title>암호입력화면</title>
	<link rel="stylesheet" href="../css/style.css">
	<link rel="stylesheet" href="../css/jquery-ui.css">
  	<link rel="stylesheet" href="/resources/demos/style.css">
  	<script src="../js/jquery-3.7.1.js"></script>
  	<script src="../js/jquery-ui.js"></script>
 </head>
 <script>
 	$(function() {
		
		$("#btn_List"  ).click(function() {location = "/dataList";});
		
		$("#btn_submit").click(function() {
			
			if($("#pass").val() == "") {
				alert("암호를 입력하세요.");
				$("#pass").focus();
				return false;
			}
			
			//ajax : {비동기}전송
			let form = $("#frm").serialize(); // serialize() : 폼을 인식하는 함수
			$.ajax({
				type	 : "post",	//전송타입
				url		 : "/dataDelete", //전송장소
				data     : form,   //전송데이터
				dataType : "text", //받는 데이터 타입
				// success : 전송에 성공한 경우
				// let data = "ok";
				success  : function(data) { // data변수 : 실제 받은 데이터 값
					if(data == "1") { 		// data변수 값이 "ok" 라면 저장 성공으로 판단함
						alert("삭제완료!");
						location = "/dataList";
					}
					else if (data == "2") alert("암호가 잘못 입력되었습니다.");
					else 			     {alert("삭제실패!");}
				},
				error	 : function()    {alert("전송실패!");}
			});
		});
	});
 </script>
 <body>
 	<div class="div_title">암호입력</div>
 	<form id="frm">
	 	<input type="hidden" name="seqid" 	 value="${seqid}">
	 	<input type="hidden" name="filename" value="${filename}">
		<table class="table1">
			<colgroup>
				<col width="20%"/>
				<col width="*"/>
			</colgroup>
			<tr>
				<th><label for="pass">암호</label></th>
				<td>
					<input type="password" id="pass" name="pass" class="input1" 
						   placeholder="암호입력" autofocus>
				</td>
			</tr>
		</table>
		<div class="div_button_area">
			<button type="submit" id="btn_submit" onclick="return false;">삭제</button>
			<button type="reset" >취소</button>
			<button type="button"  id="btn_List">목록</button>
	 	</div>
	</form>
 </body>
</html>