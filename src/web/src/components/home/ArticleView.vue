<template>
    <div class="article-view">
        <img :src="article.bg" alt="" class="backgroud">
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
            article: {
                bg: '../../static/imgs/1.JPG',
                art0: {
                    style: 0,
                    data: {
                        slogen: '../../static/imgs/1.JPG',
                        title: '啊啊啊啊啊啊啊啊啊啊啊',
                        subTitle: '啊啊啊啊啊啊啊啊啊啊啊啊啊啊',
                        body: '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊'
                    }
                },
                art1: {
                    style: 1,
                    data: {
                        img: [
                            '../../static/imgs/4.JPG',
                            '../../static/imgs/2.JPG',
                            '../../static/imgs/9.JPG',
                            '../../static/imgs/8.JPG'
                        ],
                        body: '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊'
                    }
                },
                art2: {
                    style: 2,
                    data: {
                        title: [
                            '啊啊啊啊啊啊啊啊啊啊啊',
                            '啊啊啊啊啊啊啊啊啊啊啊',
                            '啊啊啊啊啊啊啊啊啊啊啊'
                        ],
                        body: [
                            '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊',
                            `啊啊啊啊啊啊啊
                            啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                            啊啊`,
                            '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊'
                        ],
                        img: [
                            '../../static/imgs/11.JPG',
                            '../../static/imgs/5.JPG',
                            '../../static/imgs/10.JPG'
                        ]
                    }
                }
            }
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
    .backgroud {
        z-index: -1;
        width: 100%;
        height: 100%;
        position: fixed;
        top: 0;
        left: 0;
        filter: blur(10px);
    }
}
</style>
