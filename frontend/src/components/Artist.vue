<script setup>

import {ref} from "vue";
const props = defineProps(['id', 'artistname'])

defineEmits(['delete'])
</script>

<template>
  <div
      class="flex flex-row justify-between px-8 p-2 rounded-xl m-2 bg-neutral-800 border-2
      border-neutral-800 hover:border-green-600 w-full hover:bg-neutral-500/20 hover:cursor-pointer text-neutral-50 py-4">
    <div class="flex flex-col w-3/6">
      <h4 class="font-semibold text-lg -mb-1">{{ artistname }}</h4>
    </div>
    <h4 class="content-center w-2/6"></h4>
    <h4 class="content-center w-1/6 pl-5"></h4>
    <div class="flex items-center gap-x-5 ">
      <div class="h-full w-px bg-neutral-400"></div>
      <div class="flex items-center gap-x-4">
        <router-link :to="'/artist/'+id" class="pi pi-pencil text-neutral-100 hover:text-green-600" />
        <i class="pi pi-trash text-neutral-100 hover:text-red-400" @click="$emit('delete', id)"></i>
      </div>
    </div>
  </div>
</template>

<style scoped>

</style>