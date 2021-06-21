<template>
    <div>
        <v-breadcrumbs
            :items="items"
            divider="|"
        ></v-breadcrumbs>
    </div>
</template>

<script>
    import SearchID from "./SearchID.vue"
    import SearchPW from "./SearchPW.vue"

    export default {
        data() {
            return {
                items: [
                    {
                        text: '아이디 찾기',
                        disabled: false,
                        href: SearchID
                    },
                    {
                        text: '비밀번호 찾기',
                        disabled: false,
                        href: SearchPW
                    }
                ]
            }
        }
    }
</script>