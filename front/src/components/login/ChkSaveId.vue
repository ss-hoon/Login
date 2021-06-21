<template>
    <div class="chkSaveId">
        <v-checkbox
            id="chkSaveId"
            v-model="chkSaveId"
            :label="`아이디 저장`"
        ></v-checkbox>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                chkSaveId: false
            }
        }
    }
</script>