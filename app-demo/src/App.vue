<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <HelloWorld msg="Welcome to Your Vue.js App"/>
  <MeuComponent msg="Mensagem do App.vue" />
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import MeuComponent from '@/components/MeuComponent'

export default {
  name: 'App',
  components: {
    HelloWorld,
    MeuComponent
  }, 
  data() {
    return {
      
    }
  },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
