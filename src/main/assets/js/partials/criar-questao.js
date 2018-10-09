import Vue from 'vue';
import Vuex from 'vuex';

document.addEventListener("DOMContentLoaded", function () {
    if (document.getElementById('js-form-questao') != null) {
        let formQuestao = new Vue({
            el: '#js-form-questao',
            data: {
                tipoDeQuestao: 'objetiva'
            }
        });
    }
});
