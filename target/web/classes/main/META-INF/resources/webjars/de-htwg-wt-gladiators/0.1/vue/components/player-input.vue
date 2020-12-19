<template>
    <!--Modal: Login with Avatar Form-->
    <div class="modal fade" id="idModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog cascading-modal modal-avatar modal-sm" role="document">
            <!--Content-->
            <div class="modal-content">

                <!--Header-->
                <div class="modal-header">
                    <div class="avatar"></div>
                </div>
                <!--Body-->
                <div class="modal-body text-center mb-1">

                    <h5 id="idModalHeader" class="mt-1 mb-2"> Player {{ playerId }}</h5>

                    <div class="md-form ml-0 mr-0">
                    <input v-model="name" type="text" class="form-control form-control-sm validate ml-0">
                    <label for="form29" class="ml-0">Enter name</label>
                    </div>

                    <div class="text-center mt-4">
                    <button @click="submitModal()" class="btn btn-success">CONNECT<i class="fas fa-sign-in ml-1"></i></button>
                    </div>
                </div>

            </div>
        </div>
    </div>
</template>

<script>
    import Vue from 'vue';
    export default Vue.component('player-input', {
        data: {
            name: ''
        },
        props: {
            playerId: Number
        },
        methods: {
            submitModal() {
                this.$store.dispatch({type: "connectPlayer", name: this.name, id: this.playerId});
            }
        }
    });
</script>

<style scoped lang="scss">
    .modal {
        .form-control {
            font-family: 'Arial';
        }
        .modal-header {
            justify-content: center;
        }
        .modal-dialog {
            top: 30%;
        }
        .avatar {
            height: 5rem;
            width: 5rem;
            border-radius: 10px;
            background-repeat: no-repeat;
            background-position: center;
        }
        &.player-one .avatar {
            background-image: url("/assets/images/board/temple.png");
        }
        &.player-two .avatar {
            background-image: url("/assets/images/board/colloseum.png");
        }
    }
    #idModalHeader {
        font-size: 3rem;
    }
</style>
