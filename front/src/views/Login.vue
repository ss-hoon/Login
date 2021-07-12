<template>
    <div class="login">
        <div class="logo">
            <img src="@assets/imgs/logo.png" alt="로고"/>
        </div>

        <div class="inputId">
            <v-text-field
                label="ID"
                type="text"
                v-model="loginId"
            ></v-text-field>
        </div>

        <div class="inputPw">
            <v-text-field
                label="Password"
                type="password"
                v-model="loginPwd"
            ></v-text-field>
        </div>

        <div class="option">
            <v-checkbox
                id="chkSaveId"
                v-model="chkSaveId"
                :label="`아이디 저장`"
            ></v-checkbox>
            
            <v-breadcrumbs
                :items="items"
                divider="|"
            ></v-breadcrumbs>
        </div>

        <div class="btnLogin">
            <b-button variant="secondary" id="btnLogin" @click="onClickLogin">로그인</b-button>
        </div>
        
        <div class="signUp">
            <v-btn id="signUp">회원가입</v-btn>
        </div>
    </div>
</template>
<script>
export default {
    name: 'Login',
    components: {

    },
    data() {
        return {
            loginId : "",
            loginPwd: "",
            chkSaveId: false,
            items: [
                {
                    text: '아이디 찾기',
                    disable: false,
                    href: '/searchId'
                },
                {
                    text: '비밀번호 찾기',
                    disable: false,
                    href: '/searchPwd'
                }
            ]
        }
    },
    created() {
        
    },
    methods: {
        onClickLogin() {
            console.log(`로그인 ID : ${this.$store.getters.getUserId}`);
            console.log(`로그인 PWD : ${this.$store.getters.getUserPwd}`);
        }
    },
    watch: {
        loginId(payload) {
            this.$store.dispatch('setUserId', payload);
        },
        loginPwd(payload) {
            this.$store.dispatch('setUserPwd', payload);
        }
    }
}
</script>