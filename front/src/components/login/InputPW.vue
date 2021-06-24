<template>
    <div class="inputPw">
        <v-text-field
            label="Password"
            v-model="userPwd"
        ></v-text-field>
    </div>
</template>

<script>
    export default {
        name: "InputPW",
        data() {
            return {
                userPwd: ""
            }
        },
        created() {
            this.userPwd = this.$store.getters.getUserId;
        },
        watch: {
            userId() {
                this.$store.dispatch("setUserPwd", this.userPwd);
            }
        }
    }
</script>