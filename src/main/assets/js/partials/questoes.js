import Vue from 'vue';
import Vuex from 'vuex';
import {mapState, mapGetters, mapMutations} from 'vuex';
import {store} from "../stores/questoes.store";
import {
    SET_PAGE,
    SET_MATERIA,
    SET_QUESTOES,
    SET_DISCIPLINAS,
    SET_DISCIPLINA
} from "../stores/questoes.store";

Vue.use(Vuex);


document.addEventListener("DOMContentLoaded", function () {
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

        mounted() {
            this[SET_QUESTOES](JSON.parse(this.$el.dataset.questoes));
            this[SET_DISCIPLINAS](JSON.parse(this.$el.dataset.disciplinas));
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
        },
        methods: {
            ...mapMutations([
                SET_PAGE,
                SET_MATERIA,
                SET_QUESTOES,
                SET_DISCIPLINAS,
                SET_DISCIPLINA
            ]),
        }
    });
});
