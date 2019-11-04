<template>
    <div class="article-view">
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
                art0: {
                    style: 0,
                    data: {
                        slogen: '../../static/imgs/bg.jpg',
                        title: '啊啊啊啊啊啊啊啊啊啊啊',
                        subTitle: '啊啊啊啊啊啊啊啊啊啊啊啊啊啊',
                        body: '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊'
                    }
                },
                art1: {
                    style: 1,
                    data: {
                        imgs: [
                            '../../static/imgs/1.jpg',
                            '../../static/imgs/2.jpg',
                            '../../static/imgs/3.jpg',
                            '../../static/imgs/4.jpg'
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
                            '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊',
                            '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊'
                        ],
                        img: [
                            '../../static/imgs/1.jpg',
                            '../../static/imgs/2.jpg',
                            '../../static/imgs/3.jpg'
                        ]
                    }
                }
            }
        }
    }
}
</script>
<style lang="less" scoped>
.article-view {
    width: 100%;
}
</style>