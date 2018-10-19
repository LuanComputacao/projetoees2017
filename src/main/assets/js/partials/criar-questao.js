import Vue from 'vue';
import Vuex, {mapMutations, mapState} from 'vuex';
import {
    GET_FASE_DE_ENSINO,
    SET_FASE_DE_ENSINO,
    SET_FASES_DE_ENSINO,
    SET_DISCIPLINA,
    GET_MATERIA,
    SET_MATERIA,
    SET_DISCIPLINAS,
    SET_QUESTAO,
    SET_QUESTAO_DISCIPLINA,
    SET_QUESTAO_ENUNCIADO,
    SET_QUESTAO_TIPO,
    store,
} from '../stores/questao.store';

Vue.use(Vuex);

document.addEventListener("DOMContentLoaded", function () {
    let formQuestao = new Vue({
        el: document.getElementById('js-form-questao'),
        store,
        data: {},
        mounted() {
            this[SET_QUESTAO](JSON.parse(this.$el.dataset.questao));
            this[SET_DISCIPLINAS](JSON.parse(this.$el.dataset.disciplinas));
            this[SET_FASES_DE_ENSINO](JSON.parse(this.$el.dataset.fasesDeEnsino));
        },
        computed: {
            ...mapState([
                'disciplina',
                'disciplinas',
                'fasesDeEnsino',
                'materias',
                'materia',
                'questao',
                'tipos'
            ]),
            tipo: {
                get() {
                    return this.questao.tipo
                }, set(tipo) {
                    this[SET_QUESTAO_TIPO](tipo);
                }
            },
            enunciado: {
                get() {
                    return this.questao.enunciado
                }, set(enunciado) {
                    this[SET_QUESTAO_ENUNCIADO](enunciado)
                }
            },
        },
        methods: {
            ...mapMutations([
                SET_DISCIPLINA,
                SET_FASE_DE_ENSINO,
                SET_FASES_DE_ENSINO,
                SET_MATERIA,
                SET_QUESTAO,
                SET_QUESTAO_TIPO,
                SET_QUESTAO_ENUNCIADO,
                SET_QUESTAO_DISCIPLINA,
                SET_DISCIPLINAS,
            ]),
        }
    });
});
