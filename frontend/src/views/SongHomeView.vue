<script setup>
import Song from "@/components/Song.vue";
import {ref} from "vue";
import axios from "axios";

getData()

const songs = ref();

async function getData() {
  const url = "http://localhost:8080/api/songs";
  try {
    const response = await fetch(url);
    if (!response.ok) {
      throw new Error(`Response status: ${response.status}`);
    }

    const json = await response.json();
    console.log(json)
    songs.value = json._embedded.songList;
    console.log(json);
  } catch (error) {
    console.error(error.message);
  }
}

async function deletesong(id) {
  await axios.delete(`http://localhost:8080/api/songs/${id}`)
  await getData()
}

</script>

<template>
  <body class="bg-zinc-900">


  <h1 class="flex justify-center text-4xl font-bold py-4 pb-8 text-neutral-200">☆ YouSong ☆</h1>
  <div class="flex justify-between mx-72">
    <input class="border rounded-full mb-6 pl-5 h-10 w-2/3 bg-neutral-700 border-neutral-900 focus:outline-0 focus:ring-green-600 focus:ring-1" placeholder="search for a song">
    <router-link to="/song" class="h-10 border border-green-600 rounded-xl w-1/6 flex items-center justify-center gap-x-3 hover:bg-green-800/60">
      <i class="pi pi-plus text-neutral-100"></i>
      <span class="text-neutral-100">
        Add Song
      </span>
    </router-link>
  </div>
  <div class="flex justify-center">
    <div class="flex items-center w-3/4 justify-center ">
      <div class=" flex flex-row items-center w-2/6">
        <div class="flex-grow border-t border-green-600"></div>
        <span class="mx-2 text-neutral-300 text-lg">Title</span>
        <div class="flex-grow border-t border-green-600 w-4/5"></div>
      </div>


      <div class=" flex flex-row items-center w-1/4">
        <div class="flex-grow border-t border-green-600"></div>
        <span class="mx-4 text-neutral-300 text-lg ">Genre</span>
        <div class="flex-grow border-t border-green-600 w-2/5"></div>
      </div>

      <div class=" flex flex-row items-center w-1/4">
        <div class="flex-grow border-t border-green-600"></div>
        <span class="mx-4 text-neutral-300 text-lg ">Length</span>
        <div class="flex-grow border-t border-green-600 w-1/3"></div>
      </div>
    </div>
  </div>

  <div class="flex justify-center">
    <div class="flex flex-wrap justify-between mx-36 p-4 pt-2 w-2/3">
      <Song
          v-for="song in songs"
          :key="song.id"
          :id="song.id"
          :title="song.title"
          :artist="song.artist"
          :length="song.length"
          :genre="song.genre"
          @delete="deletesong"
      />
    </div>
  </div>
  </body>
</template>

<style scoped>
body {
  background: rgb(24 24 27);
}
</style>