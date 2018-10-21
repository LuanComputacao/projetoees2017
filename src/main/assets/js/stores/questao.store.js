let moment = require('momentjs');
import Vuex from 'vuex';

export const OBJETIVA = "OBJETIVA";
export const DISCURSIVA = "DISCURSIVA";

export const SET_DISCIPLINAS = "setDisciplinas";
export const GET_DISCIPLINA = "getDisciplina";
export const SET_DISCIPLINA = "setDisciplina";
export const GET_FASE_DE_ENSINO = "getFaseDeEnsino";
export const SET_FASES_DE_ENSINO = "getFasesDeEnsino";
export const SET_FASE_DE_ENSINO = "setFaseDeEnsino";
export const SET_MATERIA = "setMateria";
export const GET_MATERIA = "getMateria";
export const SET_QUESTAO = "setQuestao";
export const SET_QUESTAO_DISCIPLINA = "setQuestaoDisciplina";
export const SET_QUESTAO_ENUNCIADO = "setQuestaoEnunciado";
export const SET_QUESTAO_ESPACOS = "setQuestaoEspacos";
export const SET_QUESTAO_NIVEL = "setQuestaoNivel";
export const SET_QUESTAO_TIPO = "setQuestaoTipo";

export let store = new Vuex.Store({
    state: {
        fasesDeEnsino:[],
        disciplina: {},
        disciplinas: {},
        materia: {},
        materias:{},
        tipos: {objetiva: OBJETIVA, discursiva: DISCURSIVA},
        questao: {
            id: 0,
            criado: '',
            atualizado: '',
            enunciado: '',
            espacos: 0,
            invalidada: false,
            nivel: 0.0,
            publica: false,
            autor: '',
            disciplina: '',
            materias: {},
            faseDeEnsino: '',
            tipo: '',
        }
    },
    getters: {
        [GET_DISCIPLINA](state) {
            return state.disciplina;
        },
        [GET_MATERIA](state) {
            return state.materia
        },
        [GET_FASE_DE_ENSINO](state) {
            return state.questao.faseDeEnsino
        }
    },
    mutations: {
        [SET_DISCIPLINA](state, event) {
            let disciplinaId = parseInt(event.target.value);
            if (!isNaN(disciplinaId)) {
                let disciplina = state.disciplinas.find(x => x.id === disciplinaId);
                state.disciplina = disciplina;
                state.materias = state.disciplina.materias;
                state.questao.disciplina = disciplina;
            } else {
                state.disciplina = {};
                state.questao.disciplina = {};
            }
        },
        [SET_DISCIPLINAS](state, disciplinas) {
            state.disciplinas = disciplinas;
        },
        [SET_MATERIA](state, materia) {
            state.materia = materia;
            state.questao.materia = materia;
        },
        [SET_QUESTAO](state, questao) {
            state.questao.id = questao.id;
            state.questao.criado = moment(questao.criadoEm, 'DD-MM-YYYY hh:mm:ss').format('LL');
            state.questao.atualizado = moment(questao.atualizadoEm, 'DD-MM-YYYY hh:mm:ss').format('LL');
            state.questao.enunciado = questao.enunciado;
            state.questao.espacos = questao.espacos;
            state.questao.invalidada = questao.invalidada;
            state.questao.nivel = parseFloat(questao.nivel);
            state.questao.publica = questao.publica;
            state.questao.autor = questao.autor;
            state.questao.disciplina = questao.disciplina;
            state.questao.materias = questao.materias;
            state.questao.faseDeEnsino = questao.faseDeEnsino;
            state.questao.tipo = questao.tipoDeQuestaoEnum;
        },
        [SET_QUESTAO_ENUNCIADO](state, enunciado) {
            state.questao.enunciado = enunciado
        },
        [SET_QUESTAO_ESPACOS](state, espacos) {
            state.questao.espacos = espacos;
        },
        [SET_QUESTAO_DISCIPLINA](state, disciplina) {
            console.log(disciplina);
            state.disciplina = disciplina;
            state.questao.disciplina = disciplina;
        },
        [SET_QUESTAO_NIVEL](state, nivel) {
            state.questao.nivel = nivel;
        },
        [SET_QUESTAO_TIPO](state, tipo) {
            state.questao.tipo = tipo;
        },
        [SET_FASE_DE_ENSINO](state, faseDeEnsino) {
            state.questao.faseDeEnsino = faseDeEnsino;
        },
        [SET_FASES_DE_ENSINO](state, fasesDeEnsino) {
            console.log(fasesDeEnsino);
            state.fasesDeEnsino = fasesDeEnsino;
        }
    }
});