<template>
    <div id="wrapper">
        <header>
            <slot name="header"
                  :title="title"
                  :login="login"
                  :join="join"
            :mypage="mypage" :logout="logout"></slot>
        </header>
        <aside id="sidebar">
            <slot name="sidebar"></slot>
        </aside>
        <section id="content">
            <slot name="content">

            </slot>
        </section>
        <footer>
            <slot name="footer" :footer="footer"></slot>
        </footer>
    </div>
</template>

<script>
export default {
    name: "Layout",
    data(){
        return {
            title : '축구정보 시스템',
            login : '로그인',
            join : '회원가입',
            footer : '(사)축구선수협회',
            logout : '로그아웃',
            mypage : '마이페이지'
        }
    },
    methods: {

    }
}
</script>

<style scoped>
    /* 전체 구조 */
    #wrapper {
        padding: 5px;
        width: 960px;
        margin: 20px auto;
    }
    header {
        height: 100px;
        padding: 0 15px;
    }
    #content {
        width: 696px;
        float: left;
        padding: 5px 15px;
        min-height: 300px;
    }
    #sidebar {
        width: 200px;
        padding: 5px 15px;
        float: left;
    }
    footer {
        clear: both;
        padding: 0 15px;
    }
    /* 가로폭 980보다 작을 때 사용할 @media query */
    @media screen and (max-width: 980px) {
        #pagewrap {
            width: 94%;
        }
        #content {
            clear: both;
            padding: 1% 4%;
            width: auto;
            float: none;
        }
        #sidebar {
            clear: both;
            padding: 1% 4%;
            width: auto;
            float: none;
        }
        header, footer {
            padding: 1% 4%;
        }
    }
    /* 공통 */
    #content {
        background: #f8f8f8;
    }
    #sidebar {
        background: #f0efef;
    }
    header, #content, #middle, #sidebar {
        margin-bottom: 5px;
    }
    #pagewrap, header, #content, #middle, #sidebar, footer {
        border: solid 1px #ccc;
    }

</style>