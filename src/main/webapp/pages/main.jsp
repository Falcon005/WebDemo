<%--
  Created by IntelliJ IDEA.
  User: ashurmatovlochinbek
  Date: 06/06/22
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
Hello (forward)= ${user}
<hr/>
Hi (redirect/forward) = ${userName}
<hr/>
${filter_attr}
<hr/>
<form action="controller">
    <input type="hidden" name="command" value="logout">
    <input type="submit" value="logout">
</form>
</body>
</html>
