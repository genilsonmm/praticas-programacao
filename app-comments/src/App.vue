<template>
  <div>
    <Artigo />
    <Comentarios />
  </div>
</template>

<script>

import Artigo from '@/components/Artigo'
import Comentarios from '@/components/Comentarios'

export default {
  name: 'App',
  components: {
    Artigo,
    Comentarios
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
  width: 80%;
  margin: auto;
}
</style>
