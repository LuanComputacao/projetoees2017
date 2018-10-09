<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tp" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<tp:base>
    <jsp:attribute name="body">
        <div id="js-search-questoes">
            <div class="row pt-3 pb-3 text-center">
                <div class="col">
                    <h1>Questões</h1>
                </div>
            </div>
            <div class="row pt-3 pb-3">
                <div class="col">
                    <label for="js-disciplinas" class="sr-only">Selecione uma disciplina</label>
                    <select name="js-disciplinas" id="js-disciplinas" class="custom-select" @change="doSomething">
                        <option selected>Selecione uma disciplina</option>

                        <option v-for="disciplina in disciplinas">{{disciplina.nome}}</option>
                    </select>
                </div>

                <div class="col">
                    <label for="js-materias" class="sr-only">Selcione uma Matéria</label>
                    <select name="materias" id="js-materias" class="custom-select">
                        <option selected>Selecione uma matéria</option>
                        <option v-for="materia in materias">{{materia.nome}}</option>
                    </select>
                </div>

                <div class="col text-center">
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/questoes/procurar">Procurar</a>
                </div>

                <div class="col text-center">
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/questoes/criar/">Criar Questão</a>
                </div>
            </div>


            <div id="js-tabela-questoes" class="m3 border p-3">
                <%--<div class="row">--%>
                    <%--<div class="col form-inline">--%>
                        <%--<div class="form-group">--%>
                            <%--<label for="filter" class="sr-only">Filter</label>--%>
                            <%--<input id="filter" type="text" class="form-control" v-model="filter" placeholder="Filter">--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <%--<div class="row">--%>
                    <%--<div id="table" class="col table-responsive">--%>
                        <%--<datatable :columns="columns" :data="questoes" :filter-by="filter"></datatable>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <%--<div class="row">--%>
                    <%--<div class="col btn-toolbar">--%>
                        <%--<datatable-pager v-model="page" type="abbreviated" :per-page="per_page"></datatable-pager>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        </div>


    </jsp:attribute>
</tp:base>

<script lang="text/javascript">

</script>