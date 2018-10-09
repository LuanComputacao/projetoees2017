<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tp" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<tp:base>
    <jsp:attribute name="body">
        <div class="row">
            <div class="col">
                <label for="proposta-de-invalidacao">Proposta:</label>
                <div>
                    <textarea name="proposta-de-invalidacao" id="proposta-de-invalidacao" rows="5"
                              class="form-control"></textarea>
                </div>
            </div>

            <div class="col">
                <label for="justificativa-de-invalidacao">Justificativa:</label>
                <div>
                    <textarea name="justificativa-de-invalidacao" id="justificativa-de-invalidacao" rows="5"
                              class="form-control"></textarea>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col text-center">
                <a class="btn btn-secondary m-3" href="${pageContext.request.contextPath}/propostas-de-invalidacao/">Cancel</a>
                <input class="btn btn-primary m-3" type="button" value="Enviar">
            </div>
        </div>
    </jsp:attribute>
</tp:base>

<script lang="text/javascript"></script>