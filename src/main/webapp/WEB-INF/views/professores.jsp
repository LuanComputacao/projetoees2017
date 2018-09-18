<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="func" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="tp" tagdir="/WEB-INF/tags" %>

<tp:base>

    <jsp:attribute name="navbar">professores</jsp:attribute>

    <jsp:attribute name="title">
        Mr. Xavier - Banco de Questões
    </jsp:attribute>
    <jsp:attribute name="subtitle">
        Professores
    </jsp:attribute>


    <jsp:attribute name="btnToolbar">
        <div class="btn-group mr-2">
            <c:if test="${professores != null}">
                <a href="/professor" class="btn btn-sm btn-outline-primary">Adicionar Professor</a>
            </c:if>
            <c:if test="${professores == null}">
                <a href="/professores" class="btn btn-sm btn-outline-primary">Listar</a>
            </c:if>
        </div>
    </jsp:attribute>

    <jsp:attribute name="body">

    </jsp:attribute>

    <jsp:attribute name="jsFooter">
        <script src="/static/js/professores.js"></script>
    </jsp:attribute>

</tp:base>