<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>


<h2> This is Reading Page. 	<button type="button"><a href="list"> Back List </a></button> </h2>
&nbsp; &nbsp;<h1> 제목 </h1>
${read.title}
<br>
<h1> 글 내용 </h1>
${read.cont}
<br>

<button type="button"><a href="upboard?bno=${read.bno}">Update </a></button>

<button type="button"><a href="delete?bno=${read.bno}">Delete </a></button>


<br>

</body>
</html>