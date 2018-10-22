<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="lc" uri="http://luancomputacao.com" %>
<%@tag description="Página Generica" pageEncoding="utf-8" %>

<%--Assets--%>
<%@attribute name="cssLinks" fragment="true" %>
<%@attribute name="jsFooter" fragment="true" %>

<%--User variables--%>
<%@attribute name="professor" type="java.lang.Boolean" %>
<%@attribute name="moderador" type="java.lang.Boolean" %>


<%--Contents--%>
<%@attribute name="title" fragment="true" %>
<%@attribute name="subtitle" fragment="true" %>
<%@attribute name="navbar" fragment="true" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="body" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="btnToolbar" fragment="true" %>

<html lang="pt-br">
<head>

    <title>
        <jsp:invoke fragment="title"/>
    </title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <script lang="text/javascript" src="https://cdn.jsdelivr.net/npm/es6-promise@4/dist/es6-promise.auto.js"></script>

    <lc:WebpackManifest staticDistPath="/static/dist"/>
    <jsp:invoke fragment="cssLinks"/>
</head>


<body>
<div class="container-fluid">
    <c:if test="${professor}">
        <div class="row">
            <nav class="navbar navbar-expand-md navbar-dark bg-dark col">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/">Mr. Xavier - Banco de Questões</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04"
                        aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <c:if test="${professor}">
                    <div class="collapse navbar-collapse" id="navbarsExample04">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="${pageContext.request.contextPath}/">Home<span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/questoes/">Questões</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/">Testes</a>
                            </li>
                            <c:if test="${moderador}">
                                <li class="nav-item dropdown">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/propostas-de-invalidacao/">Propostas de Invalidações</a>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </c:if>
            </nav>
        </div>
    </c:if>

    <main role="main" class="row" id="js-main">
        <div class="col pt-3">
            <jsp:invoke fragment="body"/>
        </div>

        <div class="row">
            <jsp:invoke fragment="footer"/>
        </div>
    </main>
</div>

<jsp:invoke fragment="jsFooter"/>
</body>
</html>