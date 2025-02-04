import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import discussqiye from '@/views/modules/discussqiye/list'
    import qiyepingjia from '@/views/modules/qiyepingjia/list'
    import qiye from '@/views/modules/qiye/list'
    import qiuzhiyingpin from '@/views/modules/qiuzhiyingpin/list'
    import forum from '@/views/modules/forum/list'
    import zhaopinxinxi from '@/views/modules/zhaopinxinxi/list'
    import xueshengpingjia from '@/views/modules/xueshengpingjia/list'
    import yonghu from '@/views/modules/yonghu/list'
    import gangweifenlei from '@/views/modules/gangweifenlei/list'
    import messages from '@/views/modules/messages/list'
    import config from '@/views/modules/config/list'
    import jianli from '@/views/modules/jianli/list'
    import mianshitongzhi from '@/views/modules/mianshitongzhi/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '网站公告',
        component: news
      }
      ,{
	path: '/discussqiye',
        name: '企业评论',
        component: discussqiye
      }
      ,{
	path: '/qiyepingjia',
        name: '企业评价',
        component: qiyepingjia
      }
      ,{
	path: '/qiye',
        name: '企业',
        component: qiye
      }
      ,{
	path: '/qiuzhiyingpin',
        name: '求职应聘',
        component: qiuzhiyingpin
      }
      ,{
	path: '/forum',
        name: '论坛交流',
        component: forum
      }
      ,{
	path: '/zhaopinxinxi',
        name: '招聘信息',
        component: zhaopinxinxi
      }
      ,{
	path: '/xueshengpingjia',
        name: '学生评价',
        component: xueshengpingjia
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/gangweifenlei',
        name: '岗位分类',
        component: gangweifenlei
      }
      ,{
	path: '/messages',
        name: '投诉建议',
        component: messages
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/jianli',
        name: '简历',
        component: jianli
      }
      ,{
	path: '/mianshitongzhi',
        name: '面试通知',
        component: mianshitongzhi
      }
      ,{
	path: '/newstype',
        name: '网站公告分类',
        component: newstype
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
