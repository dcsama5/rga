<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RGA Login</title>
<link href="<c:url value='bootstrap.css'/>" rel="stylesheet">
</head>
<body>
	<form method="POST" class="form-group">
	<div class="form-group">
	<label for="username">Username</label>
	<input type="text" class="form-control" id="username" name="username" placeholder="username"/>
	</div>
	
	<div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" id="password" name="password" placeholder="password"/>
  	</div>
  	
  	<button type="submit" class="btn btn-default">Submit</button>
  	<button type="button" class="btn btn-default" onclick="window.location.href='/register';">Register</button>
	</form>
</body>
</html>