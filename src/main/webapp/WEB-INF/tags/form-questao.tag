<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="lc" uri="http://luancomputacao.com" %>
<%@tag description="Formulário de Questões" pageEncoding="utf-8" %>

<%@attribute name="questao" type="com.luancomputacao.domain.Questao" %>
<%@attribute name="disciplinas" type="java.util.List" %>
<%@attribute name="materias" type="java.util.List" %>
<%@attribute name="fasesDeEnsino" type="java.util.List" %>

<div class="row">
    <div class="col">

        <div class="row mb-3">
            <div class="col-auto">
                Tipo de Questão:
            </div>
            <div class="col">
                <div class="custom-control custom-radio">
                    <input type="radio" id="tipo-objetiva" name="tipo-de-questao"
                           class="custom-control-input"
                        <c:if test="${questao.tipoDeQuestaoEnum.toString() == 'OBJETIVA'}">checked</c:if>
                    >
                    <label class="custom-control-label" for="tipo-objetiva">Objetiva</label>
                </div>
                <div class="custom-control custom-radio">
                    <input type="radio" id="tipo-discursiva" name="tipo-de-questao"
                           class="custom-control-input"
                           <c:if test="${questao.tipoDeQuestaoEnum.toString()== 'DISCURSIVA'}">checked</c:if>
                    >
                    <label class="custom-control-label" for="tipo-discursiva">Discursiva</label>
                </div>
            </div>
        </div>


        <div class="row mb-3">
            <div class="col-auto">
                Disciplina:
            </div>
            <div class="col">
                <select class="custom-select">
                    <option selected>Selecione uma Disciplina</option>
                    <c:forEach items="${disciplinas}" var="disciplina">
                        <option
                                value="${disciplina.id}"
                                <c:if test="${questao.disciplina == disciplina}">
                                    selected
                                </c:if>
                            >
                                ${disciplina.nome}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>


        <div class="row">
            <div class="col">
                Matérias:
            </div>
        </div>
        <div class="row mb-3">

            <div class="col">
                <div class="border p-3">
                    <c:forEach items="${questao.materias}" var="materia">
                        <div class="badge badge-pill badge-primary p-2" id="materia-selecionada-${materia.id}">
                                ${materia.nome}
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>


        <div class="row mb-3">
            <div class="col">
                <label for="fase-de-ensino-da-questao">
                    Fase de ensino:
                </label>
                <select class="custom-select" id="fase-de-ensino-da-questao">
                    <option selected>Selecione uma Disciplina</option>
                    <c:forEach items="${fasesDeEnsino}" var="faseDeEnsino">
                        <option value="${faseDeEnsino.id}">${faseDeEnsino.nome}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="col">
                <div class="col-auto">
                    <label for="nivel-da-questao">
                        Nível da Questão:
                    </label>
                </div>
                <div class="col">

                    <input type="number" id="nivel-da-questao" name="nivel-da-questao" class="form-control"
                           <c:choose>
                                <c:when test="${questao.nivel > 0}">
                                    value="${questao.nivel}"
                                </c:when>
                                <c:when test="${questao.nivel == null}">
                                    value="0"
                                </c:when>
                           </c:choose>

                           max="10" min="0" step="0.25">
                </div>
            </div>
        </div>

    </div>
    <%-- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - --%>
    <div class="col">
        <div class="row mb-3">
            <div class="form-group col">
                <label for="enunciado-da-questao">
                    Enunciado:
                </label>
                <textarea id="enunciado-da-questao" name="enunciado-da-questao" class="form-control"
                          rows="5">${questao.enunciado}</textarea>
            </div>
        </div>


        <c:choose>
            <c:when test="${questao.tipoDeQuestaoEnum == 'DISCURSIVA'}">
                <div class="row mb-3">
                    <div class="col-auto pt-1">
                        <label for="espacos-da-questao">Espaços:</label>
                    </div>
                    <div class="col-auto">
                        <input type="number" id="espacos-da-questao" name="nivel-da-questao" class="form-control"
                               value="0" max="10" min="0">
                    </div>
                    <div class="col pt-1">
                        linha(s)
                    </div>
                </div>
            </c:when>
            <c:when test="${questao.tipoDeQuestaoEnum == 'OBJETIVA'}">
                <div class="js-opcoes-questao-objetiva">
                    <div class="row mb-3">
                        <div class="col">Opções</div>
                    </div>

                    <c:forEach items="${questao.opcoesDeQuestao}" var="opcao">
                        <div class="row  mb-3">
                            <div class="col-auto">
                                <div class="custom-control custom-radio">
                                    <input type="radio"
                                           id="radio-opcao-1"
                                           name="opcao-de-questao"
                                           class="custom-control-input"
                                            <c:if test="${opcao.value}">checked</c:if>
                                    >
                                    <label class="custom-control-label" for="radio-opcao-1"></label>
                                </div>
                            </div>
                            <div class="col">
                                <input type="text" name="texto-opcao-1" class="form-control" value="${opcao.texto}">
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </c:when>
        </c:choose>

    </div>
</div>