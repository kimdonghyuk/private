<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h3>list page입니다.</h3>

	<c:forEach items="${list}" var="list">
		<li>${list.bno}${list.title}${list.userid}${list.vcount}</li>
	</c:forEach>

	<%-- 	<c:forEach begin="${paging.first }" end="${paging.last }" var="idx">
		<a href="javascript:_goPage(${idx})">[${idx}]</a>
	</c:forEach> --%>
	
	
	<!-- Before Page Button  -->
 	<c:choose>
		<c:when test = "${pagePrev == 0}">
		...</c:when>
		<c:when test = "${pagePrev > 0 }">
			<a href="javascript:_goPage(${pagePrev})"> [Prev] </a>
		</c:when>
	</c:choose>
	
	<!-- Page List -->
	&nbsp; &nbsp;<c:forEach items="${pageList}" var="index">
		<c:if test="${index < cnt}">
			<a href="javascript:_goPage(${index})">[${index}]</a>
		</c:if>
	</c:forEach>
	
	<!-- Next Page Button -->
	<a href="javascript:_goNextLine(${pageNext}+1)"> [Next] </a>
	
	<!-- write context -->
	<button type="button"><a href="cboard"> write </a></button>
	
	<br>
	<br>
	<br>
	${paging}
	
	<form method='get' name='pageForm'>
		<input type='hidden' name='page'>
		<script>
      function _goPage(num){
         document.pageForm.page.value = num;
         document.pageForm.submit();
      }
      
      function _goNextLine(num,first,last){
         document.pageForm.page.value = num;
         document.pageForm.submit();
      }
            
   </script>
</body>
</html>