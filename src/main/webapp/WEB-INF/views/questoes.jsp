<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tp" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<tp:base>
    <jsp:attribute name="body">

        <div class="row" v:model="${materias}">

        </div>
        <div class="row">
                ${disciplinas}
        </div>
        <div class="row">
                ${questoes}
        </div>
    </jsp:attribute>
</tp:base>


