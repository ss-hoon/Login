<template>
    <div class="login">
        <Logo/>
        <InputID/>
        <InputPW/>
        <div class="option">
            <ChkSaveId/>
            <SearchAccount/>
        </div>
        <BtnLogin/>
    </div>
</template>
<script>
import Logo from '@/components/login/Logo.vue'
import InputID from '@/components/login/InputID.vue'
import InputPW from '@/components/login/InputPW.vue'
import ChkSaveId from '@/components/login/ChkSaveId.vue'
import SearchAccount from '@/components/login/SearchAccount.vue'
import BtnLogin from '@/components/login/BtnLogin.vue'

export default {
    name: 'Login',
    components: {
        Logo,
        InputID,
        InputPW,
        ChkSaveId,
        SearchAccount,
        BtnLogin
    }
}
</script>