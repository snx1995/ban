<template>
    <article class="article" :class="[$isMobile ? 'mobile' : 'not-mobile']">
        <section  v-for="(art, index) in article" :key="index">
            <div class="style style-0" v-if="art.style == 0">
                <div class="slogan">
                    <img :src="art.data.slogen">
                </div>
                <div class="title-content">
                    <h1 class="title">{{art.data.title}}</h1>
                    <h4 class="subtitle">{{art.data.subTitle}}</h4>
                </div>
                <p>{{art.data.body}}</p>
            </div>
            <div class="style style-1" v-if="art.style == 1">
                <div class="content">
                    <div v-for="(img, index) in art.data.img" :key="index" class="img-content">
                        <img :src="img">
                    </div>
                </div>
                <p>{{art.data.body}}</p>
            </div>
            <div class="style style-2" v-if="art.style == 2">
                <div class="content">
                    <div class="sub-content">
                        <img :src="art.data.img[0]" alt="">
                    </div>
                    <div class="sub-content">
                        <div class="text-content">
                            <h1>{{art.data.title[0]}}</h1>
                            <p>{{art.data.body[0]}}</p>
                        </div>
                    </div>
                    <div class="sub-content">
                        <div class="text-content">
                            <h1>{{art.data.title[1]}}</h1>
                            <p>{{art.data.body[1]}}</p>
                        </div>
                    </div>
                    <div class="sub-content">
                        <img :src="art.data.img[1]" alt="">
                    </div>
                    <div class="sub-content">
                        <img :src="art.data.img[2]" alt="">
                    </div>
                    <div class="sub-content">
                        <div class="text-content">
                            <h1>{{art.data.title[2]}}</h1>
                            <p>{{art.data.body[2]}}</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </article>
</template>
<script>
export default {
    name: 'Article',
    props: {
        article: {
            type: Object,
            default () {
                return []
            }
        }
    },
    data() {
        return {

        }
    }
}
</script>
<style lang="less" scoped>
.mobile {
    .style-0 {
        .slogan {
            width: 100vw;
            height: 20vh;
        }
        .title-content {
            padding: 5vw;
            .title {
                font-size: 8vw;
            }
            .subtitle {
                font-size: 16px;
            }
        }
        p {
            padding: 5vw;
        }
    }
    .style-1 {
        padding: 2vh;
        p {
            padding-top: 2vh;
        }
    }
    .style-2 {
        .text-content {
            padding: 2vw;
            h1 {
                padding-bottom: 2vh;
                font-size: 4vw;
            }
            p {
                font-size: 3vw;
            }
        }
    }
}
.not-mobile {
    .style-0 {
        .slogan {
            width: 100%;
            height: 350px;
        }
        .title-content {
            .title {
                height: 100px;
                line-height: 100px;
            }
            .title {
                font-size: 40px;
            }
            .subtitle {
                font-size: 12px;
            }
        }
        p {
            padding: 40px;
        }
    }
    .style-1 {
        padding: 100px;
        p {
            padding-top: 50px;
        }
    }
    .style-2 {
        .text-content {
            padding: 30px;
            h1 {
                padding: 20px 0;
                font-size: 36px;
            }
        }
    }
}
.article {
    position: relative;
    width: 100%;
    .style {
        width: 100%;
        p {
          white-space: pre-wrap;
        }
        &.style-0 {
            .slogan {
                overflow: hidden;
                position: relative;
                img {
                    position: absolute;
                    top: 50%;
                    left: 50%;
                    transform: translate(-50%, -50%);
                    width: 100%;
                }
            }
            .title-content {
                background: #fff;
                .title {
                    .borderBox();
                }
                .subtitle {
                    color: @fontColorGrey;
                }
            }
            p {
                text-align: center;
                background-color: @fontBGLight;
                color: @fontColorDarkGrey;
            }
        }
        &.style-1 {
            .borderBox();
            background-color: @fontBGDark;
            .content {
                width: 100%;
                display: flex;
                flex-wrap: wrap;
                .img-content {
                    width: 50%;
                    img {
                        display: block;
                        width: 100%;
                    }
                }
            }
            p {
                color: @fontColorGrey;
                // text-indent: 1em;
            }
        }
        &.style-2 {
            .content {
                width: 100%;
                display: flex;
                flex-wrap: wrap;
                background-color: @fontBGLight;
                .sub-content {
                    width: 50%;
                    text-align: left;
                    &:nth-child(3) {
                        background-color: @fontBGDark;
                        color: @fontColorLight;
                        text-align: right;
                    }
                    .text-content {
                        .borderBox();
                        width: 100%;
                        height: 100%;
                    }
                    img {
                        width: 100%;
                        display: block;
                    }
                }
            }
        }
    }
}
</style>
