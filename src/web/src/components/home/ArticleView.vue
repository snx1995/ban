<template>
    <div class="article-view">
        <div class="background" :style="{'backgroundImage': `url(${article.bg})`}"/>
        <Article :article="article" />
    </div>
</template>
<script>
import Article from './Article';
export default {
    name: 'ArticleView',
    components: {
        Article
    },
    data() {
        return {
            
        }
    },
    mounted() {
        // this.$net.post('/test/uploadArticle', this.article).then(res => {
        //     console.log(res);
        // })
    }
}
</script>
<style lang="less" scoped>
.article-view {
    width: 100%;
    .background {
        z-index: -1;
        width: 100%;
        height: 100%;
        background-size: 100% 100%;
        background-position: 50% 50%;
        position: fixed;
        top: 0;
        left: 0;
        filter: blur(10px);
    }
}
</style>
