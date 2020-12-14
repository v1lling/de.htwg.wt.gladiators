import Game from '/assets/vue/views/Game.js';
import About from '/assets/vue/views/About.js';

const routes = [
    { path: '/', component: Game },
    { path: '/about', component: About},
];

export default new VueRouter({
    routes: routes,
    mode: 'history',
    base: '/'
});