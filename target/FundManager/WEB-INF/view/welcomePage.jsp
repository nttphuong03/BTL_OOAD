<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 5/17/2020
  Time: 11:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>Message : ${message}</h1>
  <div>
      <a href="<c:url value="/login"/>">Login</a>
      <a href="<spring:url value="/user/signup"/> ">Sign up </a>
  </div>
</body>
</html>
