<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tp" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://luancomputacao.com" %>


<tp:base>
    <jsp:attribute name="body">
        <div id="js-search-questoes"
             data-questoes="<ct:PrintSafe json="${questoes}"/>"
             data-disciplinas="<ct:PrintSafe json="${disciplinas}"/>"
        >
            <div class="row pt-3 pb-3 text-center">
                <div class="col">
                    <h1>Questões</h1>
                </div>
            </div>
            <div class="row pt-3 pb-3">

                <div class="col">
                    <label for="js-disciplinas" class="sr-only">Selecione uma disciplina</label>
                    <select name="js-disciplinas" id="js-disciplinas" class="custom-select" @change="setDisciplina">
                        <option selected>Selecione uma disciplina</option>

                        <option v-for="disciplina in disciplinas" :value="disciplina.id">{{disciplina.nome}}</option>
                    </select>
                </div>

                <div class="col">
                    <label for="js-materias" class="sr-only">Selcione uma Matéria</label>
                    <select name="materias" id="js-materias" class="custom-select">

                        <option selected v-if="materias.length">Selecione uma matéria</option>
                        <option selected v-else="materias.length">---</option>
                        <option v-for="materia in materias" :value="materia.id">{{materia.nome}}</option>
                    </select>
                </div>

                <div class="col text-center">
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/questoes/procurar">Procurar</a>
                </div>

                <div class="col text-center">
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/questoes/criar/">Criar
                        Questão</a>
                </div>
            </div>


            <div id="js-tabela-questoes" class="m3 border p-3">

            </div>
        </div>


    </jsp:attribute>
</tp:base>

<script lang="text/javascript">

</script>