<template>
    <div id="app">
        <diagnostico></diagnostico>
    </div>
</template>

<script>

    import DiagnosticoPage from "./views/DiagnosticoPage";

    export default {
        name: 'app',
        components: {
            'diagnostico': DiagnosticoPage
        }
    }
</script>
