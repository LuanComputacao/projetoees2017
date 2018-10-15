import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);
export let store = new Vuex.Store({
    state: {
        materias: [],
        materia: {},
        disciplinas: [],
        disciplina: {},
        questoes: [],
    },

    getters: {
        materiasDaDisciplina: state => disciplinaEscolhida => {
            return state.disciplinas.filter(disciplina => {
                return disciplina.nome === disciplinaEscolhida;
            }).map(disciplina => disciplina.materias)
        }
    },
    mutations: {
        setPage: state => paginaSelecionada => {
            state.page = paginaSelecionada
        },
        setMateria: state => materiaSelecionada => {
            state.materia = materiaSelecionada;
        }
    }

});

