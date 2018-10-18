import axios from 'axios';
import Vue from 'vue';
import Vuex from 'vuex';
import {mapState, mapGetters, mapMutations} from 'vuex';
import {store} from "../stores/questoes.store";
import {
    SET_DISCIPLINA,
    SET_DISCIPLINAS,
    SET_MATERIA,
    SET_PAGE,
    SET_QUESTOES,
    SET_QUESTOES_API,
} from "../stores/questoes.store";
import {SET_AUTHTOKEN} from "../stores/user.store";

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
            this[SET_DISCIPLINAS](JSON.parse(this.$el.dataset.disciplinas));
            this[SET_QUESTOES](JSON.parse(this.$el.dataset.questoes));
            this[SET_QUESTOES_API](this.$el.dataset.questoesApi)
        },

        computed: {
            ...mapState([
                'materias',
                'materia',
                'disciplinas',
                'disciplina',
                'questoes',
                'questoesApi'
            ]),
            ...mapGetters(['materiasDaDisciplina']),
        },

        methods: {
            ...mapMutations([
                SET_DISCIPLINA,
                SET_DISCIPLINAS,
                SET_MATERIA,
                SET_PAGE,
                SET_QUESTOES,
                SET_QUESTOES_API
            ]),

            retriveQuestions() {
                axios
                    .get(
                        this.questoesApi
                    )
                    .then(response => {
                        let authToken = typeof response.headers.authorization !== 'undefined' ? response.headers.authorization : "";
                        this[SET_AUTHTOKEN](authToken);
                        localStorage.setItem('mr_xavier_k', authToken);
                        that.saveCookie();
                        that.testAuth();
                    })
                    .catch(error => {
                        console.log(error)
                    });
                console.log("oi");
            }
        }
    });
});
