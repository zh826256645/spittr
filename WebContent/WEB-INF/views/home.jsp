<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
  <head>
    <title>Spitter</title>
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1>Welcome to Spitter</h1>

    <a href="<c:url value="/spittles" />">Spittles</a> | 
    <a href="<c:url value="/spitter/register" />" >Register</a>|
    <c:if test="${sessionScope.SPRING_SECURITY_CONTEXT != null}">
    <security:authentication property="principal.username"/>
    </c:if>
    <br/>
    <sf:form servletRelativeAction="/logout" method="post">
    	<input type="submit" value="logout"/>
    </sf:form>
  </body>
</html>
