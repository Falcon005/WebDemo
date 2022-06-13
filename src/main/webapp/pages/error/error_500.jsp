<%--
  Created by IntelliJ IDEA.
  User: ashurmatovlochinbek
  Date: 08/06/22
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error 500</title>
</head>
<body>
Request form: ${pageContext.errorData.requestURI} is failed <br/>
Servlet name: ${pageContext.errorData.servletname} <br/>
Status code: ${pageContext.errorData.statusCode} <br/>
Exception: ${pageContext.errorData.exception} <br/>
<br/><br/><br/>
Message from Exception: ${error_msg}
</body>
</html>
