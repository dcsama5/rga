<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="./includes/header.jsp"/>
<security:authentication property="principal.authorities" var="authority"/>
${authority}
<jsp:include page="./includes/footer.jsp"/>