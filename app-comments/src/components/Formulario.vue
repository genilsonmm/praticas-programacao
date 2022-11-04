<template>
    <div>
        <p>
            <input v-model="name" class="form-control" type="text" placeholder="Autor" />
        </p>
        <p>
            <textarea v-model="message" class="form-control" placeholder="Comentário"></textarea>
        </p>
        <button @click="addComment" type="button"  class="btn btn-primary">Salvar</button>
    </div>
</template>
<script>
export default {
    data() {
        return {
            name: '',
            message: ''
        }
    },
    methods: {
        addComment(){
            if(this.message.trim() === ''){
                alert('Digite uma mensagem!')
                return
            }
            
            const msg = {
                name: this.name === '' ? 'Anônimo' : this.name,
                message: this.message
            }
            
            this.$emit('add-comment', msg)

            this.clear()
        },
        clear(){
            
            this.name = ''
            this.message = ''
        }
    }
}
</script>
<style lang="">
    
</style>