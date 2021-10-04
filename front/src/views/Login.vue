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
            <img src="@/assets/imgs/naver_login.png" width="40px" height="40px"/>
            <img src="@/assets/imgs/kakao_login.png" width="40px" height="40px"/>
            <img src="@/assets/imgs/google_login.svg" width="40px" height="40px"/>
            <img src="@/assets/imgs/apple_login.png" width="40px" height="40px"/>
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
    created() {
        
    },
    mounted() {
        var self = this; 
        try{
            if(this.$route.query.code.length !== undefined){
                var callbackFuc = async () => {
                    const res = await fetch('https://localhost/api/sns_login_naver', { 
                        method: "POST", headers: {
                               "Content-Type": "application/json", 
                        }, body: JSON.stringify({
                               code: `${self.$route.query.code}`,
                               state: `${self.$route.query.state}`
                        }),
                    });
                    
                    const data = await res.json();
                    console.log(`네이버 로그인 : ${data.email}`)
                } 
                callbackFuc(); 
            } 
        }catch (e){ 
            console.log(e);
        }
    },
    methods: {
        async onClickLogin() {
            console.log(`로그인 ID : ${this.$store.getters.getUserId}`);
            console.log(`로그인 PWD : ${this.$store.getters.getUserPwd}`);

            const param = {
                userId: this.loginId,
                userPwd: this.loginPwd
            };

            await axios
                .post("api/authentication/login", param)
                .then((res) => {
                    console.log(res);
                })
                .catch((error) => {
                    console.log(error);
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