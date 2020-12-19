import router from "./router.js";
import store from "./store.js";

new Vue({
    el: '#app',
    router: router,
    store: store,
    data: {
        logo: 'public/images/logo.png'
    }
})

export default router;