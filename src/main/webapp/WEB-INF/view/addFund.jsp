<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 5/19/2020
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=ISO-8859-1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>addProduct</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class = "container">
            <h1>Products</h1>
            <p>Add Fund</p>
        </div>
    </div>
</section>
<section>
    <spring:url value="/fundManager/addFund" var="addFundURL"/>
    <form:form  action="${addFundURL}" method="post" modelAttribute="newFund" class="form-horizontal">
        <div class="top-row">
            <div class="field-wrap">
                <label >Name <span class="req">*</span> </label>
                <form:input type="text" path="fundName"  autocomplete="off" />
                <form:errors path="fundName" />
            </div>
            <div class="field-wrap">
                <label > Money Init: <span class="req">*</span> </label>
                <form:input type="text" path="moneyOfFund"  autocomplete="off" />
                <form:errors path="moneyOfFund" />

            </div>
        </div>
        <div class="field-wrap">
            <label>
                Description<span class="req">*</span>
            </label>
            <form:input type="text" path="description" autocomplete="off"/>
            <form:errors path="description" />
        </div>

        <div class="field-wrap">
            <button type="submit" class="button button-block"/>Add</button>
        </div>
    </form:form>
</section>
</body>
</html>
