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
        
        <ul class="SNSLogin">
            <li>
                <div class="naverLogin">
                    <img src="@assets/imgs/naverLogin.png" alt="네이버 로그인"/>
                </div>
            </li>
            <li>
                <div class="kakaoLogin">
                    <img src="@assets/imgs/kakaoLogin.png" alt="카카오 로그인"/>
                </div>
            </li>
            <li>
                <div class="googleLogin">
                    <img src="@assets/imgs/googleLogin.png" alt="구글 로그인"/>
                </div>
            </li>
        </ul>
    </div>
</template>
<script>
import axios from "axios";

export default {
    name: 'Login',
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
        if(this.$cookies.isKey("saveId")){
            this.loginId = this.$cookies.get("saveId");
            this.chkSaveId = true;
        }
    },
    methods: {
        async onClickLogin() {

            if(this.chkSaveId)
                this.$cookies.set("saveId", this.$store.getters.getUserId, "7d");
            else
                this.$cookies.remove("saveId");

            const param = {
                userId: this.$store.getters.getUserId,
                userPwd: this.$store.getters.getUserPwd
            };

            await axios
                .post("/api/authentication/login", param)
                .then((res) => {
                    console.log(res);
                })
                .catch((error) => {
                    alert(error.response.data.message || "서버가 작동하지 않습니다.");
                })
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