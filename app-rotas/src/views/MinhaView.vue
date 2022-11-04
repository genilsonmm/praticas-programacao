<template>
    <div v-for="item in users" :key="item.id">
        <h2>{{ item.login }}</h2>
    </div>
</template>
<script>

    import axios from 'axios'

    export default {
        name: 'MinhaView',
        data() {
            return {
                users: []
            }
        },
        created() {
            axios
                .get("https://api.github.com/users")
                .then((response) => {
                    this.users = response.data
                })
                .catch((error) => {
                    console.log(error)
                })
        },
    }
</script>