<template>
    <div>
        <Formulario @add-comment="addComment" />
        <hr />

        <h2 v-show="false">Teste</h2>

        <p v-if="comments.length == 0">Sem comentários</p>
        <div v-else>
            <h2>Comentários</h2>
            <div  class="card mt-4" v-for="(item, index) in comments" :key="index">

                <div class="card-body">
                    <p>
                        <b><span>Nome: </span></b> <span>{{ item.name }}</span>
                    </p>
                    <p>
                        <b><span>Mensagem: </span></b> <br>
                        <span>{{ item.message }}</span>

                    </p>
                    <button type="button" @click="removeComment" class="btn btn-danger">Remover</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

    import Formulario from '@/components/Formulario'

    export default {
        data() {
            return {
                comments: []
            }
        },
        components: {
            Formulario
        },
        methods: {
            removeComment(index) {
                //remove de index até 1, ou seja 1 
                this.comments.splice(index, 1)
            },
            addComment(comentario) {
                this.comments.push(comentario)
            }
        },
    }
</script>

<style scoped>

</style>