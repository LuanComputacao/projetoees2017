import Vue from 'vue';

const OBJETIVA = "OBJETIVA";
const DISCURSIVA = "DISCURSIVA";
document.addEventListener("DOMContentLoaded", function () {
    let formQuestao = new Vue({
        el: document.getElementById('js-form-questao'),
        data: {
            autor: "",
            fasesDeEnsino: [],
            meteriasSelecionadas: [],
            questao: {
                id: 0,
                atualizado: '',
                autor: '',
                criado: '',
                disciplina: '',
                enunciado: '',
                espacos: 0,
                faseDeEnsino: '',
                invalidada: false,
                materias: [],
                nivel: 0.0,
                opcoes: {},
                publica: false,
                tipo: '',
            },
            disciplinas: [],
            lDisciplina: {
                materias: []
            },
            tipos: {
                objetiva: OBJETIVA,
                discursiva: DISCURSIVA
            },
        },
        mounted() {
            try {
                let questao = (JSON.parse(this.$el.dataset.questao));
                this.questao.id = questao.id;
                this.questao.atualizado = moment(questao.atualizadoEm, 'DD-MM-YYYY hh:mm:ss').format('LL');
                this.questao.autor = questao.autor;
                this.questao.criado = moment(questao.criadoEm, 'DD-MM-YYYY hh:mm:ss').format('LL');
                this.questao.disciplina = questao.disciplina;
                this.questao.enunciado = questao.enunciado;
                this.questao.espacos = questao.espacos;
                this.questao.faseDeEnsino = questao.faseDeEnsino;
                this.questao.invalidada = questao.invalidada;
                this.questao.materias = questao.materias;
                this.questao.nivel = parseFloat(questao.nivel);
                this.questao.opcoes = questao.opcoes;
                this.questao.publica = questao.publica;
                this.questao.tipo = questao.tipoDeQuestaoEnum;
            } catch (e) {
            }
            try {
                this.disciplinas = (JSON.parse(this.$el.dataset.disciplinas))
            } catch (e) {
                this.disciplinas = {}
            }
            try {
                this.fasesDeEnsino = (JSON.parse(this.$el.dataset.fasesDeEnsino))
            } catch (e) {
                this.fasesDeEnsino = {}
            }
            this.meteriasSelecionadas = this.questao.materias.map(x => x.id);
            this.lDisciplina = this.questao.disciplina;
            this.autor = this.questao.autor;
        },

        methods: {
            setFaseDeEnsino(event) {
                let faseDeEnsinoId = parseInt(event.target.value);
                this.questao.faseDeEnsino = this.fasesDeEnsino.find(x => x.id === faseDeEnsinoId);
            },
            setLDisciplina(event) {
                let disciplina = this.disciplinas.find(x => x.id === parseInt(event.target.value));
                this.questao.disciplina = disciplina;
                this.lDisciplina = disciplina;
            },
            setMaterias(event) {
                let materiasIds = [];
                let opcoesSelecionadas = event.target.selectedOptions;
                for (let i = 0; i < opcoesSelecionadas.length; i++) {
                    let selectedValue = parseInt(opcoesSelecionadas.item(i).value);
                    if (!isNaN(selectedValue)) {
                        materiasIds.push(selectedValue);
                    }
                }
                this.questao.materias = this.lDisciplina.materias.filter(x => materiasIds.indexOf(x.id) > -1);
            },
            setOpcao() {
                this.questao.opcoes = this.questao.opcoes.map(x => {
                    x.value = (x.id === parseInt(event.target.value));
                    return x;
                });
            }
        }
    });
});
