<template>
    <div class="index" :class="[$isMobile ? 'mobile' : 'not-mobile']">
        <div class="backgound" :style="{backgroundImage: `url(${article.bg})`}"/>
        <div class="content">
            <div class="header">
                <img src="../../static/imgs/logo.png" alt="">
            </div>
            <div class="body">
                <Article :article="article" />
            </div>
        </div>
        <footer></footer>
    </div>
</template>
<script>
import Article from './home/Article';
export default {
    name: 'Index',
    components: {
        Article
    },
    data() {
        return {
            article: {
                bg: '../../static/imgs/1.jpg',
                art0: {
                    style: 0,
                    data: {
                        slogen: '../../static/imgs/1.jpg',
                        title: '那些最美的时光',
                        subTitle: '啊啊啊啊啊啊啊啊啊啊啊啊啊啊',
                        body: '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊'
                    }
                },
                art1: {
                    style: 1,
                    data: {
                        img: [
                            '../../static/imgs/4.jpg',
                            '../../static/imgs/2.jpg',
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
                            啊啊啊啊`,
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
    }
}
</script>
<style lang="less" scoped>
.index.not-mobile {
    width: 100%;
    height: 100%;
    position: relative;
    .backgound {
        width: 100%;
        height: 100%;
        background-position: 50% 50%;
        background-size: 100% 100%;
        position: fixed;
        top: 0;
        left: 0;
        filter: blur(10px);
    }
    .content {
        position: relative;
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
        position: relative;
        width: 100%;
        height: 200px;
        background-color: @fontBGDark;
    }
}
.mobile {
    width: 100%;
    height: 100%;
    position: relative;
    .backgound {
        width: 100%;
        height: 100%;
        background-position: 50% 50%;
        background-size: 100% 100%;
        position: fixed;
        top: 0;
        left: 0;
        filter: blur(10px);
    }
    .content {
        position: relative;
        width: 100vw;
        .header {
            img {
                margin-top: 5vh;
                width: 80vw;
            }
        }
    }
    footer {
        position: relative;
        margin-top: 5vh;
        width: 100%;
        height: 15vh;
        background-color: @fontBGDark;
    }
}
</style>