import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Messages from '../pages/messages/list'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import fenleiList from '../pages/fenlei/list'
import fenleiDetail from '../pages/fenlei/detail'
import fenleiAdd from '../pages/fenlei/add'
import zhaolingqishiList from '../pages/zhaolingqishi/list'
import zhaolingqishiDetail from '../pages/zhaolingqishi/detail'
import zhaolingqishiAdd from '../pages/zhaolingqishi/add'
import shiwuqishiList from '../pages/shiwuqishi/list'
import shiwuqishiDetail from '../pages/shiwuqishi/detail'
import shiwuqishiAdd from '../pages/shiwuqishi/add'
import renlingxinxiList from '../pages/renlingxinxi/list'
import renlingxinxiDetail from '../pages/renlingxinxi/detail'
import renlingxinxiAdd from '../pages/renlingxinxi/add'

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
					path: 'messages',
					component: Messages
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
					path: 'fenlei',
					component: fenleiList
				},
				{
					path: 'fenleiDetail',
					component: fenleiDetail
				},
				{
					path: 'fenleiAdd',
					component: fenleiAdd
				},
				{
					path: 'zhaolingqishi',
					component: zhaolingqishiList
				},
				{
					path: 'zhaolingqishiDetail',
					component: zhaolingqishiDetail
				},
				{
					path: 'zhaolingqishiAdd',
					component: zhaolingqishiAdd
				},
				{
					path: 'shiwuqishi',
					component: shiwuqishiList
				},
				{
					path: 'shiwuqishiDetail',
					component: shiwuqishiDetail
				},
				{
					path: 'shiwuqishiAdd',
					component: shiwuqishiAdd
				},
				{
					path: 'renlingxinxi',
					component: renlingxinxiList
				},
				{
					path: 'renlingxinxiDetail',
					component: renlingxinxiDetail
				},
				{
					path: 'renlingxinxiAdd',
					component: renlingxinxiAdd
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
