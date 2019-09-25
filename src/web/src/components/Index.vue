<template>
    <div class="index">
        <h1>{{title}}</h1>
        <Button>Test</Button>
    </div>
</template>
<script>
import Button from './common/button'
export default {
    components: {
        Button
    },
    data() {
        return {
            title: 'It works!'
        }
    }    
}
</script>
<style lang="less" scoped>

</style>