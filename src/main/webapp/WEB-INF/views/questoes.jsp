<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tp" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<tp:base>
    <jsp:attribute name="body">
        <id id="js-questoes" v-model:materias="${materias}">
            <div>
                <select name="materia" id="">
                    <option v-for:=""></option>
                </select>
            </div>

            <div id="js-select-disciplinas">
            </div>
            <div id="js-select-questoes">
            </div>
        </id>
    </jsp:attribute>
</tp:base>

<script lang="text/javascript">

</script>