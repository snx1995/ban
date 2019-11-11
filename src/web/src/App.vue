<template>
    <div id="app">
        <router-view/>
    </div>
</template>
<script>
export default {
    name: 'App'
}
</script>
<style>
@import url(../static/style.css);
@import url(../static/animate.css);
* {
    padding: 0;
    margin: 0;
}
body, html {
    width: 100%;
    height: 100%;
    background-image: url('../static/imgs/bg.jpg');
    background-size: 100%;
    background-attachment: fixed;
}
#app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
}
</style>
