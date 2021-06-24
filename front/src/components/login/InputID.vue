<template>
    <div class="inputId">
        <v-text-field
            label="ID"
            v-model="userId"
        ></v-text-field>
    </div>
</template>

<script>
    export default {
        name: "InputID",
        data() {
            return {
                userId: ""
            }
        },
        created() {
            this.userId = this.$store.getters.getUserId;
        },
        watch: {
            userId() {
                this.$store.dispatch("setUserId", this.userId);
            }
        }
    }
</script>