<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 

<!DOCTYPE html>
<html>
 <head>
	<meta charset="UTF-8">
	<title>일반게시판 목록화면</title>
	<link rel="stylesheet" href="../css/style.css">
	<link rel="stylesheet" href="../css/jquery-ui.css">
  	<link rel="stylesheet" href="/resources/demos/style.css">
  	<script src="../js/jquery-3.7.1.js"></script>
  	<script src="../js/jquery-ui.js"></script>
 </head>
 <script>$(function() {$("#btn_Write").click(function() {location = "/nboardWrite";});});</script>
 <body>
 	<div class="div_title">게시판 목록화면</div>
	<div>Total : ${total}</div>
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
		<c:forEach var="result" items="${emsisList}">
			<tr>
				<td><img src="/images/icons/icon_notice.png" width="20" height="15"></td>
				<td><a href="/nboardDetail/${result.SEQID}">${result.TITLE}</a></td>
				<td>${result.WRITER}</td>
				<td>${result.HITS}</td>
				<td>${fn:substring(result.RDATE,0,10)}</td>
			</tr>
		</c:forEach>	
		<c:forEach var="result" items="${resultList}">
			<tr>
				<td>${pageRownum}</td>
				<td><a href="/nboardDetail/${result.SEQID}">${result.TITLE}</a></td>
				<td>${result.WRITER}</td>
				<td>${result.HITS}</td>
				<td>${fn:substring(result.RDATE,0,10)}</td>
			</tr>
			<c:set var="pageRownum" value="${pageRownum - 1}"/>
		</c:forEach>	
	</table>
	<div class="div_button_area1">
		<c:forEach var="p" begin="1" end="${totalPage}">
			<a href="/nboardList?pageIndex=${p}">${p}</a>
		</c:forEach>
	</div>
	<div class="div_button_area2"><button type="button" id="btn_Write">등록</button></div>
 </body>
</html>