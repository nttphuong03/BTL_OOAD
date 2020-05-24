<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 5/17/2020
  Time: 5:05 PM
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
            <p>Add Product</p>
        </div>
    </div>
</section>
<section>
    <spring:url value="/user/signup" var="signupURL"/>
    <form:form  action="${signupURL}" method="post" modelAttribute="userForm" class="form-horizontal">
        <div class="top-row">
            <div class="field-wrap">
                <label > First Name <span class="req">*</span> </label>
                <form:input type="text" path="firstName"  autocomplete="off" />
                <form:errors path="firstName" />
            </div>
            <div class="field-wrap">
                <label > Last Name <span class="req">*</span> </label>
                <form:input type="text" path="lastName"  autocomplete="off" />
                <form:errors path="lastName" />

            </div>
        </div>
        <div class="field-wrap">
            <label>
                Username<span class="req">*</span>
            </label>
            <form:input type="text" path="username" autocomplete="off"/>
            <form:errors path="username" />
        </div>

        <div class="field-wrap">
            <label>
                Email Address<span class="req">*</span>
            </label>
            <form:input type="email" path="email"  autocomplete="off"/>
            <form:errors path="email" />
        </div>
        <div class="field-wrap">
            <label>
                Phone Number<span class="req">*</span>
            </label>
            <form:input type="text" path="phone"  autocomplete="off"/>
            <form:errors path="phone"/>
        </div>
        <div class="field-wrap">
            <label>
                Set A Password<span class="req">*</span>
            </label>
            <form:input type="password" path="password" autocomplete="off"/>
            <form:errors path="password" />
        </div>
        <div class="field-wrap">
            <label>
                Confirm Password<span class="req">*</span>
            </label>
            <form:input type="password" path="confirmPassword" autocomplete="off"/>
            <form:errors path="confirmPassword" />
        </div>
        <div class="field-wrap">
            <button type="submit" class="button button-block"/>Get Started</button>
            <button class="btn btn-secondary" value="Log in"> <a href="<spring:url value="/login"/> "></a>  </button>
        </div>
    </form:form>
</section>
</body>
</html>
