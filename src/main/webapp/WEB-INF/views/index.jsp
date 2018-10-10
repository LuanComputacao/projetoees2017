<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tp" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<tp:base professor="${professor}" moderador="${moderador}">
    <jsp:attribute name="body">
        <div class="row">
            <div class="col text-center">
                <h1>Mr. Xavier</h1><br>
                <h2>Banco de Questões</h2>
            </div>
        </div>
        <%--Se não estiver autenticado--%>
        <c:if test="${!professor}">
            <jsp:include page="partials/professor/login.jsp"/>
        </c:if>

        <%--Se estiver autenticado como professor--%>
        <c:if test="${professor}">
            <jsp:include page="partials/professor/_professor-principal.jsp"/>
        </c:if>

    </jsp:attribute>
</tp:base>


