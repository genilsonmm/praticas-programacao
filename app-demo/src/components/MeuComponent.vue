<template>
    <div>
        <h1>Meu compomente</h1>
        <h3>{{ msg }}</h3>
    </div>
</template>

<script>
export default {
    name: 'MeuComponent',
    props: ['msg'],
    data() {
        return {
            outraMensagem : 'Outra mensagem'
        }
    },
    created(){
        alert(this.msg)
        alert(this.outraMensagem)
    }
}
</script>