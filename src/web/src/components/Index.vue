<template>
    <div class="index">
        <div class="content">
            <div class="header">
                <img src="../../static/imgs/logo.png" alt="">
            </div>
            <div class="body">
                <ArticleView />
            </div>
        </div>
        <footer></footer>
    </div>
</template>
<script>
import ArticleView from './home/ArticleView';
export default {
    name: 'Index',
    components: {
        ArticleView
    },
    data() {
        return {

        }
    },
    mounted() {
        this.$msg.success('success');
        this.$msg.info('info');
        this.$msg.warning('warning');
        this.$msg.error('error');
    }
}
</script>
<style lang="less" scoped>
.index {
    width: 100%;
    .content {
        width: 80%;
        max-width: 1200px;
        min-width: 800px;
        margin: 0 auto;
        padding-bottom: 50px;
        .header {
            padding-top: 50px;
            width: 100%;
            text-align: center;
            img {
                width: 800px;
            }
        }
        .body {
            width: 100%;
        }
    }
    footer {
        width: 100%;
        height: 200px;
        background-color: @fontBGDark;

    }
}
</style>