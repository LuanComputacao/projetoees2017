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

Vue.use(Vuex);


document.addEventListener("DOMContentLoaded", function () {
    let selectorDeMateria = new Vue({
        el: document.getElementById('js-search-questoes'),
        store,
        data: {
            api: {
                byDisciplina: "search/findByDisciplinaId/?id=",
                byMateria: "search/findByMateriasId/?id="
            }
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

            retriveQuestions(event) {
                if (typeof this.disciplina.id !== 'undefined' && typeof this.materia.id === 'undefined') {
                    this.retrieveByDisciplina();
                    console.log('retrieveByDisciplina');
                } else if (typeof this.materia.id !== 'undefined') {
                    this.retrieveByMateria();
                    console.log('retrieveByMateria');
                }
            },
            retrieveByDisciplina() {
                axios
                    .get(
                        this.questoesApi + this.api.byDisciplina + this.disciplina.id
                    )
                    .then(response => {
                        if (typeof response.data.content[0].id !== 'undefined')
                            this[SET_QUESTOES](response.data.content);
                        else
                            this[SET_QUESTOES]([]);
                    })
                    .catch(error => {
                        console.log(error)
                    });
            },
            retrieveByMateria() {
                axios
                    .get(
                        this.questoesApi + this.api.byMateria + this.materia.id
                    )
                    .then(response => {
                        if (typeof response.data.content[0].id !== 'undefined')
                            this[SET_QUESTOES](response.data.content);
                        else
                            this[SET_QUESTOES]([]);
                    })
                    .catch(error => {
                        console.log(error)
                    });
            }
        }
    });
});
