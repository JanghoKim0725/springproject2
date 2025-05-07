<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="eng" value="80"/>
<c:set var="kor" value="70"/>
<c:set var="msg" value="javascript"/>
영어 : ${eng}		 	 <br>
국어 : ${kor}		 	 <br>
합계1 : ${eng+kor} 	 <br>
합계2 : ${eng}+${kor} <br>
과목 : ${msg} 		 <br>
길이 : ${fn:length(msg)} <br>

<c:if test="${eng == 100}">영어만점입니다.</c:if>
<c:if test="${eng != 100}">영어만점이 아닙니다.</c:if> <br>

<c:forEach var="i" begin="1" end="10">${i }</c:forEach>