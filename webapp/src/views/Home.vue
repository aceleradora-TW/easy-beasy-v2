<template>
  <div>
    <Diagnosis/>  
    <Solution/>
  </div>
</template>

<script>
import Diagnosis from '@/components/Diagnosis'
import Solution from '@/modules/Solutions/Solutions.vue'


export default {
  components:{
    Diagnosis,
    Solution
  }
}
</script>

<style scoped>
</style>
