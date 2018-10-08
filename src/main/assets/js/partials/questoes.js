import DatatableFactory from 'vuejs-datatable';
import {mapState, mapGetters, mapMutations} from 'vuex';


document.addEventListener("DOMContentLoaded", function () {

    let selectorDeMateria;
    selectorDeMateria = new Vue({
        el: '#js-search-questoes',
        store,
        data: {

        },

        computed: {
            page: {
                get () {
                    return this.$store.state.page;
                },
                set (value) {
                    this.$store.commit('setPage', value)
                }
            },
            ...mapState([
                'materias', 'materiasSelecionadas',
                'disciplinas', 'disciplinaSelecionada',
                'questoes',

                'columns', 'rows', 'page', 'per_page', 'filter']),
            ...mapGetters(['materiasDaDisciplina']),
            ...mapMutations({})
        },
        methods: {
            setPaginaAtual: page => {
                this.$store.commit('setPage', page)
            },
            doSomething: function () {
                console.log('clicked');
            }
        }
    });
});