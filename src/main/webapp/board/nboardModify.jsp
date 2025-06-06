<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 

<!DOCTYPE html>
<html>
 <head>
	<meta charset="UTF-8">
	<title>게시판 수정 화면</title>
	<link rel="stylesheet" href="../css/style.css">
	<link rel="stylesheet" href="../css/jquery-ui.css">
  	<script src="../js/jquery-3.7.1.js"></script>
  	<script src="../js/jquery-ui.js"></script>
 </head>
 <script>
 	$(function() {
 		
 		$("#btn_List"  ).click(function() {location = "/nboardList";});
 		
 		$("#btn_submit").click(function() {
 			
 			if($("#title").val() == "") {
 				alert("제목을 입력하세요.");
 				$("#title").focus();
 				return false;
 			}
 			
 			if($("#pass").val() == "") {
 				alert("암호를 입력하세요.");
 				$("#pass").focus();
 				return false;
 			}
 			
 			//ajax : {비동기}전송
 			let form = $("#frm").serialize(); // serialize() : 폼을 인식하는 함수
 			$.ajax({
 				type	 : "post",	//전송타입
 				url		 : "/nboardUpdate", //전송장소
 				data     : form,   //전송데이터
 				dataType : "text", //받는 데이터 타입
 				// success : 전송에 성공한 경우
 				// let data = "ok";
 				success  : function(data) { // data변수 : 실제 받은 데이터 값
 					if(data == "1") { 		// data변수 값이 "ok" 라면 저장 성공으로 판단함
 						alert("수정완료!");
 						location = "/nboardList";
 					}
 					else if (data == "2") alert("암호가 잘못 입력되었습니다.");
 					else 			   	 {alert("수정실패!");}
 				},
 				error	 : function()  	 {alert("전송실패!");}
 			});
 		});
 	});
 </script>
 <body>
 	<form id="frm">
 		<input type="hidden" id="seqid" name="seqid" value="${dto.seqid}">
	 	<div class="div_title">수정화면</div>
		<table class="table1">
			<colgroup>
				<col width="20%"/>
				<col width="*"  />
			</colgroup>
			<tr>
				<th><label for="title">제목</label></th>
				<td>
					<input type="text" id="title" name="title" class="input1" 
						   placeholder="제목입력" autofocus value="${dto.title}">
				</td>
			</tr>
			<tr>
				<th><label for="pass">암호</label></th>
				<td>
					<input type="password" id="pass" name="pass" class="input1" 
						   placeholder="암호입력">
				</td>
			</tr>
			<tr>
				<th><label for="writer">글쓴이</label></th>
				<td><input type="text" id="writer" name="writer" class="input1" value="${dto.writer}"></td>
			</tr>
			<tr>
				<th><label for="emsis">강조</label></th>
				<td style="text-align:left;">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="checkbox" id="emsis" name="emsis" value="Y" 
						   <c:if test="${dto.emsis == 'Y'}">checked</c:if>>
				</td>
			</tr>
			<tr>
				<th><label for="content">내용</label></th>
				<td><textarea id="content" name="content" class="textarea1">${dto.content}</textarea></td>
			</tr>
		</table>
		<div class="div_button_area1">
			<button type="submit" id="btn_submit" onclick="return false;">수정</button>
			<button type="reset">취소</button>
			<button type="button" id="btn_List">목록</button>
	 	</div>
	</form>
 </body>
</html>