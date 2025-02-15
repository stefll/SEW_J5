<script setup>
import {ref} from "vue";
import axios from "axios";
import {useToast} from "primevue/usetoast";
import {useRoute} from "vue-router";

const route = useRoute()
console.log(route);
const id = ref(Number(route.params.id))

const songname = ref();
const artist = ref();
const genre = ref();
const length = ref();
const toast = useToast()

if (id) {
  axios.get(`http://localhost:8080/api/songs/${id.value}`).then(function (response) {
    songname.value = response.data.title;
    artist.value = response.data.artist;
    genre.value = response.data.genre;
    length.value = response.data.length
  })

}

async function save() {
  axios.put('http://localhost:8080/api/songs', {
    id: id.value,
    title: songname.value,
    artist: artist.value,
    genre: genre.value,
    length: length.value,
  })
      .then(function (response) {
        console.log(response);
        toast.add({
          severity: 'success',
          summary: 'Success',
          detail: 'You successfully saved a song! yay :)',
          life: 3000
        })
      })
      .catch(function (error) {

      })
}
</script>

<template>

  <div class="flex h-full justify-center mt-10">
    <Toast/>
    <div class="w-1/4">
      <form class="bg-neutral-800 border-neutral-600 border-2 shadow-md rounded-xl text-neutral-50 px-8 pb-8 mb-4"
            @submit.prevent="save">
        <div class=" flex flex-row items-center">
          <h1 class="text-2xl font-medium my-5 mr-2">{{ id ? 'Edit Song ' : 'Create Song ' }}</h1>
          <div class="flex-grow border-t border-green-600"></div>
        </div>
        <div class="mb-4">
          <label class="block  text-sm font-medium mb-2" for="songname">
            Title
          </label>
          <input v-model="songname"
                 class="shadow appearance-none border border-neutral-600  rounded w-full py-2 px-3 text-neutral-100 bg-neutral-700 leading-tight focus:outline-none focus:border-green-600 focus:shadow-outline"
                 id="songname" type="text" placeholder="Title">
        </div>
        <div class="mb-4">
          <label class="block text-sm font-medium mb-2" for="artist">
            Artist
          </label>
          <input v-model="artist"
                 class="shadow appearance-none border border-neutral-600  rounded w-full py-2 px-3 text-neutral-100 bg-neutral-700 leading-tight focus:outline-none focus:border-green-600 focus:shadow-outline"
                 id="artist" type="text" placeholder="Artist">
        </div>
        <div class="mb-4">
          <label class="block  text-sm font-medium mb-2" for="genre"> Genre
          </label>
          <input v-model="genre"
                 class="shadow appearance-none border border-neutral-600  rounded w-full py-2 px-3 text-neutral-100 bg-neutral-700 leading-tight focus:outline-none focus:border-green-600 focus:shadow-outline"
                 id="genre" type="text" placeholder="Genre">
        </div>
        <div class="mb-4">
          <label class="block text-sm font-medium mb-2" for="length">
            Length
          </label>
          <input v-model="length"
                 class="shadow appearance-none border border-neutral-600  rounded w-full py-2 px-3 text-neutral-100 bg-neutral-700 leading-tight focus:outline-none focus:border-green-600 focus:shadow-outline"
                 id="length" type="text" placeholder="Length">
        </div>
        <div class="flex items-center justify-between mt-8">
          <router-link to="/"
                       class="border-2 border-neutral-700 hover:bg-neutral-700 hover:border-neutral-600 hover:text-white font-medium py-2 px-4 rounded-lg focus:outline-none focus:shadow-outline"
                       type="button">
            <i class="pi pi-angle-left"/>
            Back
          </router-link>
          <button
              class="bg-neutral-800 border-2 border-green-600 hover:bg-green-700 hover:border-green-400 text-white font-medium py-2 px-4 rounded-lg focus:outline-none focus:shadow-outline"
              type="submit">
            <i class="pi pi-save"></i>
            Save
          </button>
        </div>
      </form>
    </div>
  </div>

</template>

<style scoped>

</style>