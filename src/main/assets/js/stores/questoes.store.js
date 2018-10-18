import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export const SET_PAGE = 'setPage';

export const SET_MATERIA = 'setMateria';
export const SET_MATERIAS = 'setMaterias';
export const SET_QUESTOES = 'setQuestoes';
export const SET_DISCIPLINAS = 'setDisciplinas';
export const SET_DISCIPLINA = 'setDisciplina';
export const SET_QUESTOES_API = 'setQuestoesApi';

export let store = new Vuex.Store({
    state: {
        materias: [],
        materia: {},
        disciplinas: [],
        disciplina: {},
        questoes: [],
        questoesApi: "",
    },

    getters: {
        materiasDaDisciplina: state => disciplinaEscolhida => {
            return state.disciplinas.filter(disciplina => {
                return disciplina.nome === disciplinaEscolhida;
            }).map(disciplina => disciplina.materias)
        }
    },
    mutations: {
        [SET_PAGE](state, paginaSelecionada) {
            state.page = paginaSelecionada;
        },
        [SET_MATERIA](state, materiaSelecionada) {
            state.materia = materiaSelecionada;
        },
        [SET_QUESTOES](state, questoes) {
            state.questoes = questoes;
        },
        [SET_DISCIPLINAS](state, disciplinas) {
            state.disciplinas = disciplinas;
        },
        [SET_DISCIPLINA](state, event) {
            state.disciplina = state.disciplinas.find(x => x.id === parseInt(event.target.value));

            state.materias = typeof state.disciplina === 'undefined' ? [] : state.disciplina.materias;
        },
        [SET_QUESTOES_API](state, url) {
            state.questoesApi = url;
        }
    }

});

