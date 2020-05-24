<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 5/17/2020
  Time: 12:18 PM
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
<body >
<section class="container">

    <h1>HOME PAGE </h1>
    <h2> Hi ${currentUser.username}  </h2>
    <section class="jumbotron">
        <div class=" container">
            <a href="<spring:url value="/fundManager/addFund"/>" class="btn btn-primary">Add Fund</a>
        </div>
    </section>
    <section class="container">
        <c:forEach items="${currentUser.fundList}" var="fund">
            <div>
                <p>${fund.fund.fundName} ngay tham gia: ${fund.ngaythamgia}</p>
            </div>
        </c:forEach>
    </section>
</section>
</body>
</html>
