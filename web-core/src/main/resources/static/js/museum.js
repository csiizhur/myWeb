/**
 * 侧边栏组件
 */
Vue.config.devtools = true
// 不要忘了调用此方法
Vue.component('side-muse', {
    props: ['museum'],
    watch: {
        museum(newValue, oldValue) {
            console.log(newValue);
        }
    },
    template: `<el-menu v-if="museum && museum.children ">
                    <template  v-for="sub  in museum.children">
                        <sub-museum v-if="sub" v-bind:sub="sub"></sub-museum>
                    </template>
                </el-menu>`,

    components: {
        "sub-museum": {
            name: 'sub-museum',
            props: ['sub'],
            watch: {
                sub(newVal, oldVal) {
                    console.log(newVal)
                }
            },
            methods: {
                goTo(path) {
                    console.log(this.$router)
                    let router = this.$router.currentRoute
                    if (router.path === '/foo') {
                        this.$router.push('bar')
                    } else {
                        this.$router.push('foo')
                    }
                }
            },
            template: `
        <!--if-->
            <el-submenu  v-if="sub && sub.children  " v-bind:index="sub.id" :key="sub.id" >
                <template v-if="sub.name" slot="title">
                    <i v-if="sub.icon" :class="sub.icon"></i>
                    <span>{{sub.name}}</span>
                </template>
                <el-menu-item-group >
                    <template v-if="sub.groupTitle" slot="title">
                        <i v-if="sub.groupIcon" :class="sub.groupIcon"></i>
                        <span>{{sub.groupTitle}}</span>
                    </template>
                    <!--<span v-if="sub.title" slot="title">{{sub.title}}</span>-->
                    <sub-museum v-for="(subS,index) in sub.children" :sub="subS" :key="index+'sub_' + sub.id"></sub-museum>
                </el-menu-item-group>
            </el-submenu>
            <!--else-->
            <el-menu-item v-else-if="sub" b-bind:index="sub.id" :key="sub.id" @click="goTo(sub.id)">
                <template slot="title">
                    <i v-if="sub.icon" :class="sub.icon"></i>
                    {{sub.name}}
                </template>
            </el-menu-item>
        `
        }
    }
})

