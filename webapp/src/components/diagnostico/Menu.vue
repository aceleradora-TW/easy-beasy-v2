<template>
    <div class="side-bar">
        <md-toolbar class="md-transparent" md-elevation="0">
            <img src="../../assets/avatar.png" alt="Avatar" class="avatar-exemplo">
        </md-toolbar>

        <md-list>
            <md-list-item>
                <md-icon>move_to_inbox</md-icon>
                <span class="md-list-item-text">Diagnóstico</span>
            </md-list-item>

            <md-list-item>
                <md-icon>send</md-icon>
                <span class="md-list-item-text">Soluções</span>
            </md-list-item>

            <md-list-item>
                <md-icon>delete</md-icon>
                <span class="md-list-item-text">Consultor</span>
            </md-list-item>

        </md-list>
        <md-toolbar class="md-transparent" md-elevation="0">
            <img src="../../assets/logo_green.png" alt="Logo EasyBeasy" class="logo-exemplo">
        </md-toolbar>
    </div>
</template>

<style lang="scss" scoped>

    .side-bar {
        background-color: #00d0c8;
    }

    .avatar-exemplo {
        border: 2px solid #ffffff;
        border-radius: 50%;
        width: 100px;
        height: 100px;
        position: absolute;
        left: 50%;
        margin-left: -50px;
        margin-top: 50px;
    }

    .logo-exemplo{
        border-radius: 50%;
        width: 100px;
        height: 100px;
        position: absolute;
        left: 50%;
        margin-left: -50px;
        margin-top: 400px;
    }

    .md-list.md-theme-default {
        background-color: #00d0c8;
        color: #ffffff;
        margin-top: 100px;

        span {
            color: #ffffff;
        }

        i {
            color: #ffffff;
        }
    }
</style>

<script>
    export default {
        name: 'diagnostico-menu'
    }
</script>