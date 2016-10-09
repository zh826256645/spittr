<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
	<sf:form name="f" method="POST" servletRelativeAction="/login">
	<table>
	    <tr><td>User:</td><td>
		<input name="username"/></td></tr>
	    <tr><td>Password:</td><td>
	   	<input name="password" type="password" /></td></tr>
	   	<tr><td colspan='2'>
	   	<input name="submit" type="submit" value="Login"/></td></tr>
	</table>
	</sf:form>
</body>
</html>