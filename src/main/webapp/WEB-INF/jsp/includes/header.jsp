<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value='bootstrap.css'/>" rel="stylesheet">
        <title>Home</title>
        <security:authentication property="principal.username" var="username"/>
        <style> 
            body {
                padding-top: 100px;
            }
        </style>
    </head>
    <body>
        <div id="nav-bar" class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container" align="center">
                    <c:url var="welcomeUrl" value="/home"/>
                    <a class="brand" href="${welcomeUrl}">Home</a>
                    <c:url var="Entry" value="/update"/>
                    <a class="brand" href="${Entry}">Update User</a>
                    <c:url var="List" value="/list"/>
                    <a class="brand" href="${List}">List Users</a>
                    <c:url var="Logout" value="/logout"/>
                    <a class="brand" href="${Logout}">Logout</a>
                    <div class="nav-collapse" align="right">
                    	<p class="navbar-text navbar-right">${username}</p> 
                    </div>
                </div>  
            </div>
        </div>
                   <!--      <div class="container">
                            <c:if test="${message != null}">
                                <div class="alert alert-success" id="message"><c:out value="${message}"/></div>
                           </c:if>
                                </div>-->
    </body>
</html>