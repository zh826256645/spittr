<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
  <head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1>Register</h1>

    <sf:form method="POST" commandName="spitter">
      First Name: <sf:input path="firstName" />
      <sf:errors path="firstName"/><br/>
      Last Name: <sf:input  path="lastName" />
      <sf:errors path="lastName"/><br/>
      Email: <sf:input type="email" path="email" /><br/>
      Username: <sf:input path="username" />
      <sf:errors path="username"/><br/>
      Password: <sf:input type="password" path="password" />
      <sf:errors path="password"/><br/>
      <input type="submit" value="Register" />
    </sf:form >
  </body>
</html>
