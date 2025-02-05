import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Messages from '../pages/messages/list'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import jianliList from '../pages/jianli/list'
import jianliDetail from '../pages/jianli/detail'
import jianliAdd from '../pages/jianli/add'
import qiyeList from '../pages/qiye/list'
import qiyeDetail from '../pages/qiye/detail'
import qiyeAdd from '../pages/qiye/add'
import gangweifenleiList from '../pages/gangweifenlei/list'
import gangweifenleiDetail from '../pages/gangweifenlei/detail'
import gangweifenleiAdd from '../pages/gangweifenlei/add'
import zhaopinxinxiList from '../pages/zhaopinxinxi/list'
import zhaopinxinxiDetail from '../pages/zhaopinxinxi/detail'
import zhaopinxinxiAdd from '../pages/zhaopinxinxi/add'
import qiuzhiyingpinList from '../pages/qiuzhiyingpin/list'
import qiuzhiyingpinDetail from '../pages/qiuzhiyingpin/detail'
import qiuzhiyingpinAdd from '../pages/qiuzhiyingpin/add'
import mianshitongzhiList from '../pages/mianshitongzhi/list'
import mianshitongzhiDetail from '../pages/mianshitongzhi/detail'
import mianshitongzhiAdd from '../pages/mianshitongzhi/add'
import qiyepingjiaList from '../pages/qiyepingjia/list'
import qiyepingjiaDetail from '../pages/qiyepingjia/detail'
import qiyepingjiaAdd from '../pages/qiyepingjia/add'
import xueshengpingjiaList from '../pages/xueshengpingjia/list'
import xueshengpingjiaDetail from '../pages/xueshengpingjia/detail'
import xueshengpingjiaAdd from '../pages/xueshengpingjia/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import discussqiyeList from '../pages/discussqiye/list'
import discussqiyeDetail from '../pages/discussqiye/detail'
import discussqiyeAdd from '../pages/discussqiye/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'messages',
					component: Messages
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'jianli',
					component: jianliList
				},
				{
					path: 'jianliDetail',
					component: jianliDetail
				},
				{
					path: 'jianliAdd',
					component: jianliAdd
				},
				{
					path: 'qiye',
					component: qiyeList
				},
				{
					path: 'qiyeDetail',
					component: qiyeDetail
				},
				{
					path: 'qiyeAdd',
					component: qiyeAdd
				},
				{
					path: 'gangweifenlei',
					component: gangweifenleiList
				},
				{
					path: 'gangweifenleiDetail',
					component: gangweifenleiDetail
				},
				{
					path: 'gangweifenleiAdd',
					component: gangweifenleiAdd
				},
				{
					path: 'zhaopinxinxi',
					component: zhaopinxinxiList
				},
				{
					path: 'zhaopinxinxiDetail',
					component: zhaopinxinxiDetail
				},
				{
					path: 'zhaopinxinxiAdd',
					component: zhaopinxinxiAdd
				},
				{
					path: 'qiuzhiyingpin',
					component: qiuzhiyingpinList
				},
				{
					path: 'qiuzhiyingpinDetail',
					component: qiuzhiyingpinDetail
				},
				{
					path: 'qiuzhiyingpinAdd',
					component: qiuzhiyingpinAdd
				},
				{
					path: 'mianshitongzhi',
					component: mianshitongzhiList
				},
				{
					path: 'mianshitongzhiDetail',
					component: mianshitongzhiDetail
				},
				{
					path: 'mianshitongzhiAdd',
					component: mianshitongzhiAdd
				},
				{
					path: 'qiyepingjia',
					component: qiyepingjiaList
				},
				{
					path: 'qiyepingjiaDetail',
					component: qiyepingjiaDetail
				},
				{
					path: 'qiyepingjiaAdd',
					component: qiyepingjiaAdd
				},
				{
					path: 'xueshengpingjia',
					component: xueshengpingjiaList
				},
				{
					path: 'xueshengpingjiaDetail',
					component: xueshengpingjiaDetail
				},
				{
					path: 'xueshengpingjiaAdd',
					component: xueshengpingjiaAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'discussqiye',
					component: discussqiyeList
				},
				{
					path: 'discussqiyeDetail',
					component: discussqiyeDetail
				},
				{
					path: 'discussqiyeAdd',
					component: discussqiyeAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
