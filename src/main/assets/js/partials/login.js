import Vue from 'vue';
import Vuex from 'vuex';
import {mapState, mapMutations} from 'vuex';
import axios from 'axios';
import {store} from '../stores/user.store'
import {SET_AUTHTOKEN, SET_USERNAME} from '../stores/user.store';

Vue.use(Vuex);

document.addEventListener('DOMContentLoaded', function () {
    let loginPage = new Vue({
        el: document.getElementById('js-login-form'),
        store,
        data: {
            url: "",
            urlTest: "",
            senha: "",
            authenticated: false
        },
        mounted() {
            this.url = this.$el.dataset.url;
            this.urlTest = this.$el.dataset.urlTest;
        },
        computed: {
            ...mapState([
                'authToken',
                'username'
            ])
        },
        methods: {
            ...mapMutations([SET_AUTHTOKEN, SET_USERNAME]),
            updateUsername(e) {
                this[SET_USERNAME](e);
            },
            realizaLogin(event) {
                let that = this;
                event.preventDefault();
                axios
                    .post(
                        this.url,
                        {cpf: this.username, senha: this.senha}
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
                    })
            },
            saveCookie() {
                let date = new Date(0);
                let jwt_claims = jwt_decode(this.authToken);
                if (typeof jwt_claims.exp !== 'undefined') date.setUTCSeconds(jwt_claims.exp/1000);
                let cookie_str = "mr_xavier_k=" + this.authToken.slice(7) + ';expiration=' + date;
                document.cookie = cookie_str;
            },

            testAuth() {
                let axiosConfig = {
                    url: this.urlTest,
                    headers: {'Authorization': this.authToken}
                };

                axios(axiosConfig)
                    .then(response => {
                        this.redirectHome()
                    })
                    .catch(error => {
                        console.log(error);
                    });
            },

            redirectHome() {
                window.location = "/";
            }

        },
    });
});