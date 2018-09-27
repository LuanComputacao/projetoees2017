<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tp" tagdir="/WEB-INF/tags" %>


<tp:base>
    <jsp:attribute name="body">
        <%--Se não estiver autenticado--%>
        <c:if test=" ${!professor}">
            <jsp:include page="partials/professor/login.jsp"/>
        </c:if>

        <%--Se estiver autenticado como professor--%>
        <c:if test="${true}">
        </c:if>

        <%--Se estiver autenticado como professor moderador--%>
        <c:if test="${true}">
        </c:if>
    </jsp:attribute>
</tp:base>


