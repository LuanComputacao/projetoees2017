<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tp" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://luancomputacao.com" %>


<tp:base>
    <jsp:attribute name="body">
        <div id="js-search-questoes"
             data-questoes="<ct:PrintSafe json="${questoes}"/>"
             data-disciplinas="<ct:PrintSafe json="${disciplinas}"/>"
             data-questoes-api="${pageContext.request.contextPath}/api/questoes/"
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
                    <select name="materias" id="js-materias" class="custom-select" @change="setMateria">

                        <option selected v-if="materias.length">Selecione uma matéria</option>
                        <option selected v-else="materias.length">---</option>
                        <option v-for="materia in materias" :value="materia.id">{{materia.nome}}</option>
                    </select>
                </div>

                <div class="col text-center">
                    <button class="btn btn-primary" @click="retriveQuestions">Procurar</button>
                </div>

                <div class="col text-center">
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/questoes/criar/">
                        Criar Questão
                    </a>
                </div>
            </div>

            <div v-if="questoes.length < 1" class="alert alert-info text-center">
                Nenhuma questão encontrada para seleção
            </div>
            <div v-else id="js-tabela-questoes" class="m3 border p-3">
                <tp:table_dark>
                    <jsp:attribute name="header">
                        <td>ID</td>
                        <td>Pública</td>
                        <td>Invalidada</td>
                        <td>Enunciado</td>
                        <td>Tipo</td>
                        <td>Nível</td>
                        <td>Visualizar</td>
                        <td>Editar</td>
                        <td>Apagar</td>
                    </jsp:attribute>

                    <jsp:attribute name="content">
                        <tr v-for="questao in questoes">
                            <td>{{questao.id}}</td>
                            <td>
                                <span v-if="questao.publica">Sim</span>
                                <span v-else>Não</span>
                            </td>
                            <td>
                                <span v-if="questao.invalidada">Sim</span>
                                <span v-else>Não</span>
                            </td>
                            <td>{{questao.enunciado}}</td>
                            <td>{{questao.tipoDeQuestaoEnum}}</td>
                            <td>{{questao.nivel}}</td>
                            <td class="text-center text-success">
                                <a :href="'${pageContext.request.contextPath}/questoes/'+questao.id+'/'">
                                    <span class="fas fa-external-link-alt"></span>
                                </a>
                            </td>
                            <td class="text-center text-info">
                                <a :href="'${pageContext.request.contextPath}/questoes/editar/'+questao.id+'/'">
                                    <span class="fas fa-pencil-alt"></span>
                                </a>
                            </td>
                            <td class="text-center text-warning">
                                <span class="fas fa-eraser pointer" :id="'js-apaga-questao-'+questao.id"></span>
                            </td>
                        </tr>

                    </jsp:attribute>
                </tp:table_dark>
            </div>
        </div>


    </jsp:attribute>
</tp:base>

<script lang="text/javascript">

</script>