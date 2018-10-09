<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tp" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<tp:base>
    <jsp:attribute name="body">
        <form action="${pageContext.request.contextPath}/propostas-de-invalidacao/criar/" method="post">
            <div class="row">
                <div class="col">
                    Proposta:
                    <div class="alert alert-secondary">

                    </div>
                </div>

                <div class="col">
                    Justificativa:
                    <div class="alert alert-secondary">

                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col text-center">
                    <a class="btn btn-secondary m-3"
                       href="${pageContext.request.contextPath}/propostas-de-invalidacao/">Cancel</a>
                    <input class="btn btn-primary m-3" type="submit" value="Enviar">
                </div>
            </div>
        </form>
    </jsp:attribute>
</tp:base>

<script lang="text/javascript"></script>