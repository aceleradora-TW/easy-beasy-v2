<template>
  <div>
    <Diagnosis/>  
    <Solutions/>
  </div>
</template>

<script>
import Diagnosis from '@/components/Diagnosis'
import Solutions from '@/modules/Solutions/Solutions.vue'


export default {
  components:{
    Diagnosis,
    Solutions
  }
}
</script>

<style scoped>
</style>
