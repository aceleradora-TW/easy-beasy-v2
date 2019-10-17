<template>
  <div>
    <h3>{{ message }}</h3>
  </div>
</template>

<script>
import CategoryService from '@/services/category.service'
export default {
  name: 'Category',
  props: {},
  
  data: () => ({ 
    message: 'Hello World'  
  }),
  
  async created() {
    const {data} = await CategoryService.getAll(); 
    // eslint-disable-next-line quotes
    console.log(data);
  },

  mounted() {},
  
  methods: {}
}
</script>

<style scoped>
h3 {
  margin: 40px 0 0;
}
</style>
