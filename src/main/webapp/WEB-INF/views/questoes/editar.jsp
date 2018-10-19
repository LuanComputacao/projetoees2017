<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tp" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<tp:base>
    <jsp:attribute name="body">
            <form action="${pageContext.request.contextPath}/questoes/editar/${questao.id}/" method="post">
                <tp:form-questao
                        questaoJSON="${questaoJSON}"
                        disciplinas="${disciplinas}"
                        materias="${materias}"
                        fasesDeEnsinoJSON="${fasesDeEnsinoJSON}"
                >
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

    </jsp:attribute>
</tp:base>

<script lang="text/javascript">
</script>