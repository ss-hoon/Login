<template>
    <div class="login">
        <Logo/>
        <InputID/>
        <InputPW/>
        <BtnLogin/>
    </div>
</template>
<script>
import Logo from '@/components/login/Logo.vue'
import InputID from '@/components/login/InputID.vue'
import InputPW from '@/components/login/InputPW.vue'
import BtnLogin from '@/components/login/BtnLogin.vue'

export default {
    name: 'Login',
    components: {
        Logo,
        InputID,
        InputPW,
        BtnLogin
    }
}
</script>