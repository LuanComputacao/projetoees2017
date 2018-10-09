<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tp" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<tp:base>
    <jsp:attribute name="body">
        <div class="row">
            <div class="col">
                ${questao}
            </div>
        </div>

        <hr>

        <div class="row">
            <div class="col">
                Proposta:
                <div class="alert alert-secondary">
                        ${proposta.proposta}
                </div>
            </div>

            <div class="col">
                Justificativa:
                <div class="alert alert-secondary">
                        ${proposta.justificativa}
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col">

            </div>
        </div>
    </jsp:attribute>
</tp:base>

<script lang="text/javascript">

</script>