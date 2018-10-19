<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="lc" uri="http://luancomputacao.com" %>
<%@tag description="Formulário de Questões" pageEncoding="utf-8" %>

<%@attribute name="questao" type="com.luancomputacao.domain.Questao" %>
<%@attribute name="questaoJSON" %>
<%@attribute name="disciplinas" %>
<%@attribute name="materias" %>
<%@attribute name="fasesDeEnsinoJSON" %>

<div id="js-form-questao"
     data-questao="<lc:PrintSafe json="${questaoJSON}"/>"
     data-disciplinas="<lc:PrintSafe json="${disciplinas}"/>"
     data-materias="<lc:PrintSafe json="${materias}"/>"
     data-fases-de-ensino="<lc:PrintSafe json="${fasesDeEnsinoJSON}"/>"
>
    <div class="row">
        {{fasesDeEnsino}}
    </div>
    <div class="row">
        <div class="col-auto">
            <div class="alert alert-dark">
                <div class="row">
                    <strong class="text-info">Invalidada:</strong>
                    <span v-if="questao.invalidada">SIM</span>
                    <span v-else>NÃO</span>
                </div>
                <div class="row"><strong class="text-info">Autor:</strong>{{questao.autor.nome}}</div>
                <div class="row"><strong class="text-info">Data de criação:</strong>{{questao.criado}}</div>
                <div class="row"><strong class="text-info">Data de atualização:</strong>{{questao.atualizado}}</div>

            </div>
        </div>

    </div>
    <div class="row">
        <div class="col">
            <div class="row mb-3">
                <div class="col-auto">
                    Tipo de Questão:
                </div>
                <div class="col">
                    <div class="custom-control custom-radio">
                        <input type="radio" id="tipo-objetiva" name="tipo-de-questao"
                               class="custom-control-input"
                               :value="tipos.objetiva"
                               v-model="tipo"
                        >
                        <label class="custom-control-label" for="tipo-objetiva">Objetiva</label>
                    </div>
                    <div class="custom-control custom-radio">
                        <input type="radio" id="tipo-discursiva" name="tipo-de-questao"
                               class="custom-control-input"
                               :value="tipos.discursiva"
                               v-model="tipo"
                        >
                        <label class="custom-control-label" for="tipo-discursiva">Discursiva</label>
                    </div>
                </div>
            </div>


            <div class="row mb-3">
                <div class="col-auto">
                    Disciplina:
                </div>
                <div class="col">
                    <select class="custom-select" @change="setDisciplina">
                        <option selected>Selecione uma Disciplina</option>
                        <option v-for="disciplina in disciplinas" :value="disciplina.id">{{disciplina.nome}}</option>
                    </select>
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-auto">
                    Matéria:
                </div>
                <div class="col">
                    <select class="custom-select" @change="setMateria">
                        <option selected>Selecione uma Disciplina</option>
                        <option v-for="materia in disciplina.materias" :value="materia.id">{{materia.nome}}</option>
                    </select>
                </div>
            </div>


            <div class="row mb-3">
                <div class="col">
                    <label for="fase-de-ensino-da-questao">
                        Fase de ensino:
                    </label>
                    <select class="custom-select" id="fase-de-ensino-da-questao" @change="setFaseDeEnsino">
                        <option selected>Selecione uma Fase de Ensino</option>
                        <option v-for="fase in fasesDeEnsino" :value="fase.id">{{fase.nome}}</option>
                    </select>
                </div>

                <div class="col">
                    <div class="col-auto">
                        <label for="nivel-da-questao">
                            Nível da Questão:
                        </label>
                    </div>
                    <div class="col">
                        <input type="number" id="nivel-da-questao" name="nivel-da-questao" class="form-control"
                               :value="questao.nivel"
                               max="10" min="0" step="0.25">
                    </div>
                </div>
            </div>

        </div>
        <%-- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - --%>
        <div class="col">

            <div class="row mb-3">
                <div class="form-group col">
                    <label for="enunciado-da-questao">
                        Enunciado:
                    </label>
                    <textarea id="enunciado-da-questao" name="enunciado-da-questao" class="form-control"
                              rows="5" v-model="enunciado">{{enunciado}}</textarea>
                </div>
                {{enunciado}}
            </div>


            <div v-if="tipo == tipos.discursiva" class="row mb-3">
                <div class="col-auto pt-1">
                    <label for="espacos-da-questao">Espaços:</label>
                </div>
                <div class="col-auto">
                    <input type="number" id="espacos-da-questao" name="nivel-da-questao" class="form-control"
                           :value="questao.nivel" max="10" min="0">
                </div>
                <div class="col pt-1">
                    linha(s)
                </div>
            </div>

            <div v-else-if="tipo == tipos.objetiva" class="js-opcoes-questao-objetiva">
                <div class="row mb-3">
                    <div class="col">Opções</div>
                </div>

                <div class="row  mb-3">
                    <div class="col-auto">
                        <div class="custom-control custom-radio">
                            <input type="radio"
                                   id="radio-opcao-1"
                                   name="opcao-de-questao"
                                   class="custom-control-input"
                            >
                            <label class="custom-control-label" for="radio-opcao-1"></label>
                        </div>
                    </div>
                    <div class="col">
                        <input type="text" name="texto-opcao-1" class="form-control" value="opcao.texto">
                    </div>
                </div>

            </div>

        </div>
    </div>
</div>