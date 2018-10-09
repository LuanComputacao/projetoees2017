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
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/questoes/criar/">Criar
                        Questão</a>
                </div>
            </div>


            <div id="js-tabela-questoes" class="m3 border p-3">
                <tp:table_dark>
                    <jsp:attribute name="header">
                        <td>ID</td>
                        <td>Pública</td>
                        <td>Invalidada</td>
                        <td>Enunciado</td>
                        <td>Tipo</td>
                        <td>Nível</td>
                        <td>Editar</td>
                        <td>Apagar</td>
                    </jsp:attribute>

                    <jsp:attribute name="content">
                        <c:forEach items="${questoes}" var="questao">
                            <tr>
                                <td>${questao.id}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${questao.publica}">
                                            Sim
                                        </c:when>
                                        <c:otherwise>
                                            Não
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${questao.invalidada}">
                                            Sim
                                        </c:when>
                                        <c:otherwise>
                                            Não
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>${questao.enunciado}</td>
                                <td>${questao.tipoDeQuestaoEnum}</td>
                                <td>${questao.nivel}</td>
                                <td class="text-center text-info">
                                    <a href="${pageContext.request.contextPath}/questoes/editar/${questao.id}/">
                                        <span class="fas fa-pencil-alt"></span>
                                    </a>
                                </td>
                                <td class="text-center text-warning">
                                    <span class="fas fa-eraser" id="js-apaga-questao-${questao.id}"></span>
                                </td>
                            </tr>
                        </c:forEach>
                    </jsp:attribute>
                </tp:table_dark>
            </div>
        </div>


    </jsp:attribute>
</tp:base>

<script lang="text/javascript">

</script>