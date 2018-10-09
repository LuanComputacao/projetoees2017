<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tp" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<tp:base>
    <jsp:attribute name="body">
        <div class="row">
            <div class="col text-center">
                <h1>Propostas de Invalidação</h1>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <tp:table_dark>
                    <jsp:attribute name="header">
                        <th>ID</th>
                        <th>Questão ID</th>
                        <th>Questão Enunciado</th>
                        <th>Proposta</th>
                        <th>Justificativa</th>
                        <th>Avaliar</th>
                    </jsp:attribute>

                    <jsp:attribute name="content">
                        <c:forEach items="${propostas}" var="proposta">
                            <tr>
                                <td>${proposta.id}</td>
                                <td>${proposta.questao.id}</td>
                                <td>${proposta.questao.enunciado}</td>
                                <td>${proposta.proposta}</td>
                                <td>${proposta.justificativa}</td>
                                <td class="text-center text-info">
                                    <a href="${pageContext.request.contextPath}/propostas-de-invalidacao/${proposta.id}/">
                                        <span class="fas fa-external-link-alt"></span>
                                    </a>
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