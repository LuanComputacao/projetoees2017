<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tp" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<tp:base>
    <jsp:attribute name="body">

        <div class="row">

            <div class="col">
                <div class="row mb-3">
                    <div class="col-auto">Tipo:</div>
                    <div class="col">${questao.tipoDeQuestaoEnum}</div>
                </div>

                <div class="row mb-3">
                    <div class="col-auto">Disciplina:</div>
                    <div class="col">${questao.disciplina.nome}</div>
                </div>

                <div class="mb-3">
                    <div class="row">
                        <div class="col">Matérias:</div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <ul>
                                <c:forEach items="${questao.materias}" var="materia">
                                    <li>${materia.nome}</li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-auto">Fase de ensino:</div>
                    <div class="col">${questao.faseDeEnsino.nome}</div>
                </div>

                <div class="row mb-3">
                    <div class="col-auto">Nível:</div>
                    <div class="col">${questao.nivel}</div>
                </div>

            </div>

                <%-- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - --%>

            <div class="col">

                <div class="row">
                    <div class="col">
                        Enunciado:
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col">
                        <div class="alert alert-secondary">
                                ${questao.enunciado}
                        </div>
                    </div>
                </div>

                <c:if test="${questao.tipoDeQuestaoEnum == 'DISCURSIVA'}">
                <%-- - - - - - -  Discursiva  - - - - - - - --%>
                    <div class="row mb-3">
                        <div class="col-auto">Espaço:</div>
                        <div class="col">${questao.espacos} linha(s)</div>
                    </div>
                    <%-- - - - - - -  Discursiva end - - - - - - - --%>
                </c:if>

                <c:if test="${questao.tipoDeQuestaoEnum == 'OBJETIVA'}">
                <div class="row mb-3">
                    <c:forEach items="${questao.opcoesDeQuestao}" var="opcao">
                    <div class="custom-control custom-radio">

                        <c:choose>
                            <c:when test="${opcao.value}">
                                <span class="fas fa-check-square"></span>
                            </c:when>
                            <c:when test="${!opcao.value}">
                                <span class="fas fa-square"></span>
                            </c:when>
                        </c:choose>
                        - ${opcao.texto}
                    </div>
                    </c:forEach>
                </div>
                </c:if>

            </div>

        </div>

        <div class="row">
            <div class="col text-right"><a href="${pageContext.request.contextPath}/questoes/" class="btn btn-primary">Voltar</a></div>
        </div>

    </jsp:attribute>
</tp:base>

<script lang="text/javascript">

</script>