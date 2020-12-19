<template>
    <div>
        <nav-bar></nav-bar>
        <transition name="swipe" mode="out-in">
            <router-view></router-view>
        </transition>
    </div>
</template>

<script>
  import Vue from 'vue';
  export default Vue.component('App', {});
</script>

<style scoped lang="scss">
    // Transition for Vue Router
    .swipe-enter-active,
    .swipe-leave-active {
        transition: opacity 0.7s, transform 0.7s;
    }

    .swipe-enter,
    .swipe-leave-active {
        opacity: 0;
        transform: scale(0);
    }
</style>
