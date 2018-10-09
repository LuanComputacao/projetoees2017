<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tp" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<tp:base>
    <jsp:attribute name="body">

        <div id="js-form-questao">
            <form action="${pageContext.request.contextPath}/questoes/editar/${questao.id}/" method="post">
                <tp:form-questao questao_tipo="${questao.tipoDeQuestaoEnum}">
                </tp:form-questao>

                <div class="row">
                    <div class="col text-center">
                            <%-- - - - - - -  Botões end - - - - - - - --%>
                        <input type="button" class="btn btn-secondary m-3" value="Cancelar"/>
                        <input type="button" class="btn btn-primary m-3" value="Gravar"/>
                            <%-- - - - - - -  Botões end - - - - - - - --%>
                    </div>
                </div>

            </form>
        </div>

    </jsp:attribute>
</tp:base>

<script lang="text/javascript">
</script>