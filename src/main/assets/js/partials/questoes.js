import Vue from 'vue';
import Vuex from 'vuex';
import {mapState, mapGetters, mapMutations} from 'vuex';

Vue.use(Vuex);

document.addEventListener("DOMContentLoaded", function () {

    const store = new Vuex.Store({
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

    let selectorDeMateria = new Vue({
        el: document.getElementById('js-search-questoes'),
        store,
        data: {
            filter: '',
            page: 1,
            per_page: 1,
            columns: [
                {label: 'ID', field: 'id', align: 'center', filterable: false},
                {label: 'Invalidada', field: 'invalidada', filterable: true},
                {label: 'Públicada', field: 'publica'},
                {label: 'Enunciado', field: 'enunciado'},
                {label: 'Nível', field: 'nivel', align: 'center', sortable: false},
                {label: 'Disciplina', field: 'disciplina.nome', align: 'right', sortable: false}
            ],
            rows: []
        },

        computed: {
            ...mapState([
                'materias',
                'materia',
                'disciplinas',
                'disciplina',
                'questoes'
            ]),
            ...mapGetters(['materiasDaDisciplina']),
            ...mapMutations({})
        },
        methods: {
            setPaginaAtual: page => {
                this.$store.commit('setPage', page)
            },
            doSomething: function () {

            }
        }
    });
});
