import Vue from 'vue';
import Vuex from 'vuex';
import {mapState} from 'vuex';
import {store} from '../stores/questao.store';

Vue.use(Vuex);

document.addEventListener("DOMContentLoaded", function () {
    let formQuestao = new Vue({
        el: document.getElementById('js-form-questao'),
        store,
        data: {
        },
        mounted() {
        },
        computed: {
            ...mapState([
                'tipos',
                'tipo',
                'enunciado',
                'disciplinas',
                'disciplina',
                'materias',
                'materia',
                'fasesDeEnsino',
                'faseDeEnsino',
                'nivel',
                'opcoes',
                'linhas'
            ])
        },
        methods: {}
    });
});
