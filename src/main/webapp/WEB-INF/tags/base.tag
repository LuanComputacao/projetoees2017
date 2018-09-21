<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="lc" uri="http://luancomputacao.com" %>
<%@tag description="Página Generica" pageEncoding="utf-8" %>

<%--Assets--%>
<%@attribute name="cssLinks" fragment="true" %>
<%@attribute name="jsFooter" fragment="true" %>

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

    <lc:WebpackManifest staticDistPath="/static/dist"/>
    <jsp:invoke fragment="cssLinks"/>
</head>


<body>
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 navbar-top">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="<c:url value="/"/>">
        <jsp:invoke fragment="title"/>
    </a>
    <div class="col-md-10 navbar-top__title">
        <h1 class="h2"><jsp:invoke fragment="subtitle"/></h1>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <nav id="js-sidebar" class="col-md-2 d-none d-md-block bg-light sidebar" data-navbar="<jsp:invoke fragment="navbar"/>">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link js-clientes" href="<c:url value="/professores"/>"><span data-feather="users"></span>Professores</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4" id="js-main">
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
            <div class="btn-toolbar mb-2 mb-md-0">
                <jsp:invoke fragment="btnToolbar"/>
            </div>
        </div>

        <div class="row">
            <div class="col" id="">
                <jsp:invoke fragment="body"/>
            </div>
        </div>

        <div class="row">
            <jsp:invoke fragment="footer"/>
        </div>
    </main>
</div>

<jsp:invoke fragment="jsFooter"/>
</body>
</html>