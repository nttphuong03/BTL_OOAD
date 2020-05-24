
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <title>Login</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Please Log In </h1>
        </div>
    </div>
</section>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please sign in</h3>
                </div>
                <div class="panel-body">
                    <c:url var="loginUrl" value="/login" />
                    <form action="${loginUrl}" method="post" class="form form-horizontal">
                        <c:if test="${param.error != null}">
                            <div class="alert alert-danger">
                                <p>Invalid username and password.</p>
                            </div>
                        </c:if>

                        <c:if test="${param.logout != null}">
                            <div class="alert alert-success">
                                <p>You have been logged out seccessfully.</p>
                            </div>
                        </c:if>

                        <c:if test="${param.accessDenied != null}">
                            <div class="alert alert-danger">
                                <p>Access Denied : You are not authorised !</p>
                            </div>
                        </c:if>

                        <div class="input-group input-sm">
                            <label for="username" class="input-group-addon">
                                <i class="fa fa-user"></i>
                            </label>
                            <input type="text" class="form-control" id="username" name="username" placeholder="Enter Username" required>
                        </div>
                        <div class="input-group input-sm">
                            <label for="password" class="input-group-addon" >
                                <i class="fa fa-lock"></i>
                            </label>
                            <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
                        </div>
                        <div class = "form-actions">
                            <input type="submit" class="btn btn-block btn-primary" value="Log in">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
