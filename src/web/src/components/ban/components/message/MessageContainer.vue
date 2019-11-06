<template>
    <div class="ban-message-container">
        <transition-group>
            <BMessage v-for="msg in msgs" :key="msg.id" :option="msg"/>
        </transition-group>
    </div>
</template>
<script>
import BMessage from './BMessage';
export default {
    name: 'BMessageContainer',
    data() {
        return {
            msgs: []
        }
    }    
}
</script>
<style lang="less" scoped>

</style>