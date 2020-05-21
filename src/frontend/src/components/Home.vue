<template>
    <div id="app">
        <div v-if=auth>
            <Layout>
                <template #header="self">
                    <router-link to="/"><h1 class="title">{{self.title}}</h1></router-link>
                    <router-link to="/mypage"><span class="join">{{self.mypage}}</span></router-link>
                    <span @click="logout" class="login">{{self.logout}}</span>
                </template>
                <template #sidebar>
                    <ul class="menu">
                        <li v-for="i of sidebars" :key="i.menu">
                            <router-link :to="i.link">{{i.menu}}</router-link>
                            <!--<a @click="menu(i.menu)">{{i.menu}}</a>-->
                        </li>
                    </ul>
                </template>
                <template #content>
                    <router-view/>
                </template>
                <template #footer="self" >
                    <h3 id="footer">{{self.footer}}</h3>
                </template>
            </Layout>
        </div> <!-- v-if END -->
            <!--로그인 성공화면-->
        <div v-else>
            <Layout>
            <template #header="self">
                <router-link to="/"><h1 class="title">{{self.title}}</h1></router-link>
                <router-link to="/join"><span class="join">{{self.join}}</span></router-link>
                <router-link to="/login"><span class="login">{{self.login}}</span></router-link>
            </template>
            <template #sidebar>
                <h3>광고판</h3>
            </template>
            <template #content>
                <router-view/>
            </template>
        </Layout>
        </div>
    </div>
</template>

<script>
import Layout from "../components/common/Layout.vue"
import {mapState} from "vuex";
export default {
    components : {Layout},
    computed : {
        ...mapState(
            {
                auth : state => state.player.auth
            }

        )
    },
    data(){

        return {
            sidebars: [
                {menu: '등록', link:'/register'},
                {menu: '목록', link:'/list'},
                {menu: '검색', link:'/search'},
                {menu: '수정', link:'/update'},
                {menu: '삭제', link:'/delete'},
                {menu: '회원수', link:'/vuexCounter'}
            ]

        }

    },

    created () {
        //can use Data(this.title, this.titleComputed ...), events(vm.$on, vm.$once, vm.$off, vm.$emit)
        //don't use $el
    },
    methods:{
        logout(){
            this.$store.dispatch('player/logout')
        },
        menu(i){
            switch (i) {
                case '쓰기':
                    alert('0')
                    break;
                case '목록':
                    alert('1')
                    break;
                case '검색':
                    alert('2')
                    break;
                case '수정':
                    alert('3')
                    break;
                case '회원수':
                    alert('4')
                    break;
                case '삭제':
                    alert('5')
                    break;
            }
        }
    }
}
</script>
<style scoped>
    ul.menu{
        position: relative;
        padding: 5px;
        list-style: none;
        font-style: italic;
    }
    .title{width: 300px;margin: 0 auto}
    .login{margin-right: 50px; float: right}
    .join{margin-right: 50px; float: right}
    .footer{width: 300px; margin: 0 auto}
</style>
