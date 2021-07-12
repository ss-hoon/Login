<template>
    <div class="btnLogin">
        <b-button variant="secondary" id="btnLogin" @click="test">로그인</b-button>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                id: "",
                pw: ""
            }
        },
        created() {
            this.id = $store.getters.getUserId
            this.pw = this.$store.getters.getUserPwd
        },
        methods: {
            test() {
                console.log(this.id);
                console.log(this.pw);
            }
        }
    }
</script>