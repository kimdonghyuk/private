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
		<c:when test = "${paging.startPage-1 == 0}">
		</c:when>
		<c:when test = "${paging.startPage > 0 }">
			<a href="javascript:_goPage(${paging.startPage}-10)"> [Prev] </a>
		</c:when>
	</c:choose>
	
    <!-- Page List -->
	&nbsp; &nbsp;<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="index">
		<c:if test="${index < cnt}">
			<a href="javascript:_goPage(${index})">[${index}]</a>
		</c:if>
	</c:forEach>
	
	<!-- Next Page Button -->
	<c:choose>
		<c:when test = "${paging.endPage < cnt}">
			<a href="javascript:_goPage(${paging.endPage}+1)"> [Next] </a>
		</c:when>
	</c:choose>
	
	<!-- write context -->
	<button type="button"><a href="cboard"> write </a></button>

 	
<form method='get' name='pageForm'>
		<input type='hidden' name='bno'>
		<input type='hidden' name='page' value='${paging.page}'>
		<input type='text' name='keyword' value='${paging.keyword }'>
		<input type='checkbox' name='types' value="t" ${paging.checked("t") }>제목
		<input type='checkbox' name='types' value="w" ${paging.checked("w") }>글쓴이
		<input type='checkbox' name='types' value="c" ${paging.checked("c") }>내용
		<button onclick="javascript:_goPage(1);">Search</button>
</form>		


	<br>
	<br>
 	${paging}
 	<br>

<script>
      function _goPage(num){
         document.pageForm.page.value = num;
         document.pageForm.submit();
      }
            
</script>
</body>
</html>