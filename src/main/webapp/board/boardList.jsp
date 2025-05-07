<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%//jstl : jsp의 확장버전, jsp를 프레임워크(전자정부,스프링부트)에 연동하기위한 프로그램 %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
 <head>
	<meta charset="UTF-8">
	<title>일반게시판 목록화면</title>
	<link rel="stylesheet" href="../css/style.css">
 </head>
 <body>
 	<button type="button" onclick="location='Write'">등록</button> <br><br>
 	<div class="div_title">
 		<table border="1">
 			<colgroup>
 				<col width="10%"/>
 				<col width="*"  />
 				<col width="15%"/>
 				<col width="15%"/>
 				<col width="15%"/>
 			</colgroup>
 			<tr>
 				<th>번호 </th>
 				<th>제목 </th>
 				<th>이름 </th>
 				<th>조회수</th>
 				<th>등록일</th>
 			</tr>
 			<c:forEach var="ls" items="${datalist}">
				<tr align="center">
					<td>${ls.SEQID }</td>
					<td>${ls.TITLE }</td>
					<td><a href="Detail/${ls.SEQID}">${ls.WRITER}</a></td>
					<td>${ls.HITS  }</td>
					<td>${ls.RDATE }</td>
				</tr>
 			</c:forEach>
 		</table>
 	</div>
 </body>
</html>