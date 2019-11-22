<template>
    <div id="app">
        <button @click="increase">Add</button>
        <p>{{ counter }}</p>
    </div>
</template>

<script>
export default {
    name: 'App',

    data() {
        return{
            counter: 0
        }
    },

    methods: {
        increase () {
            this.counter = this.counter + 1

            this.$ga.event ({
                eventCategory: 'counter',
                eventAction: 'increase',
                eventValue: this.counter
            })
        }
    }
}
</script>