<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RGA Register</title>
<link href="<c:url value='bootstrap.css'/>" rel="stylesheet">
</head>
<body>
	<form:form method="POST" class="form-group" modelAttribute="customer">
	<c:choose>
		<c:when test="${not empty exception}">
		<div class="alert alert-error">
		${exception}
		</div>
		</c:when>
		<c:when test="${not empty success}">
		<div class="alert alert-success">
		Registered User
		</div>
		</c:when>
	</c:choose>
	
	<div class="form-group">
	<label for="username">Username</label>
	<input type="text" class="form-control" id="username" name="username" placeholder="username"/>
	</div>
	
	<div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" id="password" name="password" placeholder="password"/>
  	</div>
  	
  	<div class="form-group">
  	<label for="email">Email Address</label>
  	<input type="email" class="form-control" id="email" name="email" placeholder="Email Address"/>
  	</div>
  	
  	<button type="submit" class="btn btn-default">Submit</button>
  	</form:form>
  	<a href="/">return to login</a>
  	
</body>
</html>