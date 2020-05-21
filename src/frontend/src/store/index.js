import Vue from 'vue'
import Vuex from 'vuex'
import counter from './counter'
import player from './player'
Vue.use(Vuex)


export const store = new Vuex.Store({
    modules : {
        player, counter
    }
})
