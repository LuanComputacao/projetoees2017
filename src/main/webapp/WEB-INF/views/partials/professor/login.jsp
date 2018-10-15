<div class="form-signin mt-3">

    <div class="row">
        <div class="col text-center">
            Insira seus dados para realizar o login
        </div>
    </div>

    <div class="row">
        <div class="col">
            <form id="js-login-form"
                  data-url="${pageContext.request.contextPath}/login"
                  data-url-test="${pageContext.request.contextPath}/test-login"
                  class="form-group mt-4"
            >
                <div class="input-group">
                    <div class="input-group-prepend">
                        <div class="input-group-text">CPF</div>
                    </div>

                    <input type="number" maxlength="11" class="form-control" id="inlineFormInputGroupUsername"
                           placeholder="00000000000"
                           :value="username"
                           @input="updateUsername"
                    >
                </div>
                <div class="input-group mt-1">
                    <div class="input-group-prepend">
                        <div class="input-group-text"><span class="fas fa-key"></span></div>
                    </div>
                    <input type="password" class="form-control" id="inlineFormInputGroupPasswd" placeholder="*******" v-model="senha">
                </div>

                <div class="input-group text-center mt-3">
                    <button v-on:click="realizaLogin" class="col btn btn-success">Entrar</button>
                </div>
            </form>
        </div>
    </div>
</div>
