<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tp" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<tp:base>
    <jsp:attribute name="body">
        <form action="${pageContext.request.contextPath}/propostas-de-invalidacao/criar/" method="post">
            <input type="hidden" name="questao-id" value="${questao.id}">
            <input type="hidden" name="professor-id" value="${professor.id}">
            <div class="row">
                <div class="col">
                    <label for="proposta-de-invalidacao">Proposta:</label>
                    <div>
                    <textarea name="proposta-de-invalidacao" id="proposta-de-invalidacao" rows="5"
                              class="form-control"
                              placeholder="Descreva o que deve ser modificado e como, de forma clara e objetiva."
                    ></textarea>
                    </div>
                </div>

                <div class="col">
                    <label for="justificativa-de-invalidacao">Justificativa:</label>
                    <div>
                    <textarea name="justificativa-de-invalidacao"
                              id="justificativa-de-invalidacao"
                              rows="5"
                              class="form-control"
                              placeholder="Descreva o motivo pelo qual a modificação deve ser realizada"></textarea>
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