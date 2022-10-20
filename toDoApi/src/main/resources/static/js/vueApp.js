const baseUrl = "http://localhost:8080/atividade"

const component1 = {
    template: `
        <div>
            <h1>{{ title }}</h1>
        </div>
    `,
    data() {
        return {
            title: 'Minhas atividades '
        }
    }
}

const mainContainer = {
    data() {
        return {
            atividade: '',
            atividades: []
        }
    },
    created(){
        this.obterAtividades()
    },
    components: {
        titlecomponent: component1
    },
    methods: {
        adicionarAtividade(){
            if(!this.atividade){
                toastr.error('Digite o nome da atividade', 'Atividades')
                return
            }

            const novaAtividade = {
                titulo: this.atividade
            }

            axios.post(baseUrl, novaAtividade)
                .then(response => {
                    console.log(response)
                    toastr.success('Atividade cadastrada com sucesso!', 'Atividades')
                })
                .catch(function (error) {
                    toastr.error('Não foi possível cadastrar a atividade', 'Atividades')
                })
                .then(() => {
                    this.atividade = ''
                    this.obterAtividades()
                })
        },
        remover(id){
            const url = baseUrl + '/' + id

            axios
                .delete(url)
                .then(response => {
                    toastr.success(response.data, 'Atividades')
                })
                .then(()=> {
                    this.obterAtividades()
                })
                .catch(function (error) {
                    toastr.error(error)
                })
        },
        obterAtividades(){
            this.atividades = []
            axios
                .get(baseUrl)
                .then(response => {
                    response.data.forEach(item => {
                        this.atividades.push(item)
                    })
                })
                .catch(function (error) {
                  toastr.error('Não foi possível obter as atividades', 'Atividades')
                })
        }
    }
}

Vue.createApp(mainContainer).mount('#app')
