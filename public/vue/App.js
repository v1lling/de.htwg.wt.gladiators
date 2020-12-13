import Game from './views/Game.js';
import About from './views/About.js';

const routes = [
    { path: '/', component: Game },
    { path: '/about', component: About }
];

const router = new VueRouter({
    routes: routes,
    mode: 'history',
    base: '/'
});

new Vue({
    el: '#app',
    router: router,
    data: {
        logo: 'public/images/logo.png'
    }
})

export default router;