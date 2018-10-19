import Vuex from 'vuex';


export const OBJETIVA = "OBJETIVA";
export const DISCURSIVA = "DISCURSIVA";

export let store = new Vuex.Store({
    state: {
        tipos: {objetiva: OBJETIVA, discursiva: DISCURSIVA},
        tipo: OBJETIVA,
        enunciado: "",
        disciplinas: [],
        disciplina: [],
        materias: [],
        materia: [],
        fasesDeEnsino: [],
        faseDeEnsino: [],
        nivel: 0,
        opcoes:[],
        linhas: 0
    },
    getters: {},
    mutations: {}
});