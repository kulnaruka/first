<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display</title>
</head>
<body>
	<c:out value="Hello "></c:out>
	<%
		String str = request.getAttribute("label").toString();
		out.println(str);
	%>
	${label}
	
	
</body>
</html>