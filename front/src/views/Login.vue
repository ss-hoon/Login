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

        <div class="hr-sns">소셜 로그인</div>

        <div class="snsLogin">
            <router-link to="/naverLoginProc"><img src="@/assets/imgs/naver_login.png" width="40px" height="40px"/></router-link>
            <router-link to="/api/snsLogin/getAuthPage"><img src="@/assets/imgs/kakao_login.png" width="40px" height="40px"/></router-link>
            <router-link to="/googleLoginProc"><img src="@/assets/imgs/google_login.svg" width="40px" height="40px"/></router-link>
            <router-link to="/appleLoginProc"><img src="@/assets/imgs/apple_login.png" width="40px" height="40px"/></router-link>
        </div>
    </div>
</template>
<script>
import axios from "axios";

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
    methods: {
        onClickLogin() {
            axios
                .post("api/authentication/login", {
                    userId: this.loginId,
                    userPwd: this.loginPwd
                })
                .then((res) => {
                    const { resultCode } = res.data

                    switch(resultCode) {
                        case 10:
                            alert('로그인 완료')
                            break
                        case 31:
                            alert('아이디 또는 비밀번호가 다릅니다.')
                            break
                    }
                })
                .catch(() => {
                    alert('Server Error')
                })
        },

        doKakaoLogin() {

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