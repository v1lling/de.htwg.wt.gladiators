<template>
    <div class="defClass">
        <nav class="navbar navbar-expand-lg py-3 navbar-dark bg-dark shadow-sm">
            <div class="container">
                <a id="idNavbarBrand" class="navbar-brand">
                    <img id="idLogo" src="assets/images/logo.png" width="60" alt="" class="d-inline-block align-middle mr-2">
                    <span id="idTitle">Gladiators</span>
                </a>
                <!--<button @click="$router.go(-1)">back</button>-->
                <button type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler"><span class="navbar-toggler-icon"></span></button>

                <div id="navbarSupportedContent" class="collapse navbar-collapse">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <router-link class="nav-link" to="/">Game</router-link>
                        </li>
                        <li class="nav-item">
                            <router-link class="nav-link" to="/about">About</router-link>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</template>

<script>
    import Vue from 'vue';
    export default Vue.component('nav-bar', {});
</script>

<style scoped lang="scss">
    #idLogo {
        border: 3px solid lightgrey;
        border-radius: 13px;
    }
    #idTitle {
        font-family: MoonFlower;
        line-height: normal;
        font-size: 3rem;
    }
    #idNavbarBrand {
        display: flex;
        align-items: center;
    }
</style>
