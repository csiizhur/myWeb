Vue.component('module', function (resolve, reject) {
    // 向 `resolve` 回调传递组件定义
    axios
        .get(webctx + 'user/module')
        .then(response => {
            console.log(response)
            resolve({
                template: response.data,
            })
        })
        .catch(error => console.log(error))
});
Vue.component('passage', function (resolve, reject) {
    // 向 `resolve` 回调传递组件定义
    axios.get(webctx + 'user/passage')
        .then(response => {
            resolve({
                template: response.data,
                data() {
                    return response.data;
                }
            })
        })
        .catch(error => console.log(error))
});
// 定义一个名为 button-counter 的新组件
Vue.component('button-counter', {
    data: function () {
        return {
            count: 0
        }
    },
    props: ['name'],
    template: '<button v-on:click="count++">You clicked me {{ count }} times. {{name}}</button>'
});

window.onload = function (ev) {
// 0. 如果使用模块化机制编程，导入Vue和VueRouter，要调用 Vue.use(VueRouter)

// 1. 定义 (路由) 组件。
// 可以从其他文件 import 进来
    const Foo = {template: '<module></module>'};

    const Bar = {template: '<div>bar</div>'};

// 2. 定义路由
// 每个路由应该映射一个组件。 其中"component" 可以是
// 通过 Vue.extend() 创建的组件构造器，
// 或者，只是一个组件配置对象。
// 我们晚点再讨论嵌套路由。
    const routes = [
        {path: '/foo/:id', name: "foo", component: Foo},
        {
            path: '/bar', component: function () {
                return {
                    component: new Promise(resolve => {
                        axios.get(webctx + 'user/passage')
                            .then(response => {
                                resolve({
                                    template: response.data,
                                    data() {
                                        return {
                                            tempStr: response.data
                                        };
                                    }
                                })
                            })
                            .catch(error => console.log(error))
                    })
                }
            }
        }
    ];

// 3. 创建 router 实例，然后传 `routes` 配置
// 你还可以传别的配置参数, 不过先这么简单着吧。
    const router = new VueRouter({
        routes // (缩写) 相当于 routes: routes
    });

    new Vue({
        router,
        el: '#app',
        data() {
            return {
                userList: null,
                museum: null,
                name: '测试用的名称.......',
                tableData: null
            }
        },
        mounted() {
            axios.get(webctx + 'user/findAll')
                .then(response => {
                    this.userList = response.data;
                }).catch(error => console.log(error))
            axios.get(webctx + 'museum/findRoot')
                .then(response => {
                    this.museum = response.data;
                    console.log(response.data)
                }).catch(error => console.log(error))
            axios.get(webctx + 'museum/findAll')
                .then(response => {
                    this.tableData = response.data
                })
        }
    })
};
