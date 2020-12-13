<template>
    <div>
       <navbar></navbar>
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
        transition: opacity 1s, transform 1s;
    }

    .swipe-enter,
    .swipe-leave-active {
    opacity: 0;
        transform: translateX(-30%);
    }
</style>
