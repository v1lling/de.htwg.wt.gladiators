import router from "./router/index.js";

new Vue({
    el: '#app',
    router: router,
    data: {
        logo: 'public/images/logo.png'
    }
})

export default router;