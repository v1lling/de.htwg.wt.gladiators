<template>
    <div class="gladiatorinfo">
        <div class="gladiatorinfo-image" :class="getClass()"/>
        <div>AP: <span>
            {{ gladiator && gladiator.attackPoints || "-" }}
        </span></div>
        <div>HP: <span>
            {{ gladiator && gladiator.healthPoints || "-" }}
        </span></div>
        <div>MP: <span>
            {{ gladiator && gladiator.movementPoints || "-" }}
        </span></div>
    </div>
</template>

<script>
    import Vue from 'vue';
    export default Vue.component('gladiator-info', {
        props: {
            gladiator: Object
        },
        methods: {
            getClass() {
                if (this.gladiator) {
                    return 'glad' + this.gladiator.gladiatorType;
                }
            }
        }
    });
</script>

<style scoped lang="scss">
    .gladiatorinfo {
        width: 100%;
        border: 1px solid black;
        border-radius: 5px;
        width: 100%;
        background-color: ivory;
        box-shadow: 0 10px 20px rgba(0, 0, 0, 0.19), 0 6px 6px rgba(0, 0, 0, 0.23);
        position: relative;
        display: flex;
        flex-direction: column;
        .playerinfo-row {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
        }
        &.active {
            animation: pulse 1s linear infinite;
            &.player1 {
                border: 2px solid #2525b5;
            }
            &.player2 {
                border: 2px solid #f13737;;
            }
        }
    }
    .gladiatorinfo-image {
        background-position: center;
        background-repeat: no-repeat;
        position: absolute;
        width: 100%;
        height: 100%;
        opacity: 0.1;
        &.gladKnight {
            background-image: url("/assets/images/gladiators/sword.png");
        }
        &.gladArcher {
            background-image: url("/assets/images/gladiators/bow.png"); 
        }
        &.gladTank {
            background-image: url("/assets/images/gladiators/shield.png"); 
        }
    }
</style>
