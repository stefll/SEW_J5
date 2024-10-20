<script setup>
defineProps(['title', 'artist', 'genre', 'length'])
</script>

<template>

  <div
      class="flex flex-row justify-between px-8 p-2 rounded-xl m-2 bg-neutral-800 border-2
      border-neutral-800 hover:border-green-600 w-full hover:bg-green-500/20 hover:cursor-pointer text-neutral-50">
    <div class="flex flex-col w-1/3">
      <h4 class="font-bold text-lg -mb-1">{{ title }}</h4>
      <h4 class="font-basic"> {{ artist }}</h4>
    </div>
    <h4 class="content-center w-1/6">{{ genre }}</h4>
    <h4 class="content-center">{{ length }}</h4>
  </div>
</template>

<style scoped>

</style>