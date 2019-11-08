<template>
    <div class="ban-message-container">
        <transition-group tag="div" name="message-list">
            <BMessage v-for="msg in msgs" :key="msg.id" :option="msg" @close="handleMsgClose"/>
        </transition-group>
    </div>
</template>
<script>
import Vue from 'vue';
import BMessage from './Message';
export default {
    name: 'BMessageContainer',
    components: {
        BMessage
    },
    data() {
        return {
            msgs: []
        }
    },
    methods: {
        handleMsgClose(id) {
            for (let i in this.msgs) {
                if (this.msgs[i].id == id) {
                    this.msgs.splice(i, 1);
                    break;
                }
            }
        }
    }
}
</script>
<style lang="less" scoped>
.ban-message-container {
    .borderBox();
    position: fixed;
    top: 0;
    right: 0;
    width: 300px;
    max-height: 100%;
    padding-right: 10px;
}
.message-list-enter-active, .message-list-leave-active {
    @aniDur: .3s;
    transition: opacity @aniDur, transform @aniDur;
    opacity: 1;
    transform: translateX(0);
}
.message-list-enter, .message-list-leave-to {
    opacity: 0;
    transform: translateX(100%);
}
.message-list-move {
    transition: transform .2s;
}
</style>