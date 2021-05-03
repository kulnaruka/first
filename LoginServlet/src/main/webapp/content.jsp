<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Content</title>
</head>
<body>
	
	<%	//In order to preventthe back button after logout
	//will work on HTTP 1.1
	response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");//HTTP 1.1
	//for older version
	response.setHeader("Pragma","no-cache");//HTTP 1.0
	//for proxies servers
	response.setHeader("Expires", "0");//Proxies	
		
		if(session.getAttribute("uname") == null){
			response.sendRedirect("login.jsp");
		}
	%>
	Welcome ${uname}! here is your content!
	<br>
	<br>
	<iframe width="560" height="315" src="https://www.youtube.com/embed/VNs_cCtdbPc" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
	<br>
	<br>
	<form action="Logout">
	<input type = "submit" value = "LOGOUT">
	</form>
	
</body>
</html>