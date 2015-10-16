<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="./includes/header.jsp"/>
<ul>
<c:forEach var="customer" items="${customers}">
<li><c:out value="${customer.username}"/>
<c:out value="${customer.password}"/>
<c:out value="${customer.email}"/>
</li>
</c:forEach>
</ul>
<jsp:include page="./includes/footer.jsp"/>