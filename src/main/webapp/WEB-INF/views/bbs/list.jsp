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

	<c:forEach begin="${paging.first }" end="${paging.last }" var="idx">
		<a href="javascript:_goPage(${idx})">[${idx}]</a>
	</c:forEach>
	&nbsp;
	<a href="javascript:_goNextLine(${paging.last}+1)">|| Next</a>


	<form method='get' name='pageForm'>
		<input type='hidden' name='page'>
		<script>
   
      var next = ${paging.perPage}*${paging.last}+1;
      var fire = ${paging.getRowNum()};
      

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