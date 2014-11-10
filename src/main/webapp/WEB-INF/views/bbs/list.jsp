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

	
	<!-- Before Page Button  -->
 	<c:choose>
		<c:when test = "${paging.getStartPage()-1 == 0}">
		</c:when>
		<c:when test = "${paging.getStartPage() > 0 }">
			<a href="javascript:_goPage(${paging.getStartPage()}-10)"> [Prev] </a>
		</c:when>
	</c:choose>
	
    <!-- Page List -->
	&nbsp; &nbsp;<c:forEach begin="${paging.getStartPage()}" end="${paging.getEndPage()}" var="index">
		<c:if test="${index < cnt}">
			<a href="javascript:_goPage(${index})">[${index}]</a>
		</c:if>
	</c:forEach>
	
	<!-- Next Page Button -->
	<c:choose>
		<c:when test = "${paging.getLast() < cnt}">
			<a href="javascript:_goPage(${paging.getEndPage()}+1)"> [Next] </a>
		</c:when>
	</c:choose>
	
	<!-- write context -->
	<button type="button"><a href="cboard"> write </a></button>
	
	<br>
	<br>
 	${paging}
 	<br>
 	${paging.getStartPage()}
	<br>

 	
<form method='get' name='pageForm'>
		<input type='hidden' name='page'>
		<script>
      function _goPage(num){
         document.pageForm.page.value = num;
         document.pageForm.submit();
      }
            
   </script>
</body>
</html>