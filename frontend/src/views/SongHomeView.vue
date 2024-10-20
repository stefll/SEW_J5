<script setup>
import Song from "@/components/Song.vue";
import {ref} from "vue";

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
    songs.value = json;
    console.log(json);
  } catch (error) {
    console.error(error.message);
  }
}

</script>

<template>
  <body class="bg-zinc-900">


  <h1 class="flex justify-center text-4xl font-bold py-4 pb-8 text-neutral-200">YouSong</h1>
  <div class="flex justify-center">
    <div class="flex items-center w-2/3 justify-center mx-44">
      <div class=" flex flex-row items-center w-2/4">
        <div class="flex-grow border-t border-green-600"></div>
        <span class="mx-4 text-neutral-300 text-lg">Title</span>
        <div class="flex-grow border-t border-green-600 w-3/4"></div>
      </div>


      <div class=" flex flex-row items-center w-1/4">
        <div class="flex-grow border-t border-green-600"></div>
        <span class="mx-4 text-neutral-300 text-lg ">Genre</span>
        <div class="flex-grow border-t border-green-600 w-1/3"></div>
      </div>

      <div class=" flex flex-row items-center w-1/4">
        <div class="flex-grow border-t border-green-600 w-3/6"></div>
        <span class="mx-4 text-neutral-300 text-lg ">Length</span>
        <div class="flex-grow border-t border-green-600"></div>
      </div>
    </div>
  </div>

  <div class="flex justify-center">
    <div class="flex flex-wrap justify-between  rounded-lg mx-36 p-4 w-2/3">
      <Song
          v-for="song in songs"
          :key="song.id"
          :title="song.title"
          :artist="song.artist"
          :length="song.length"
          :genre="song.genre"/>
    </div>
  </div>
  </body>
</template>

<style scoped>
body {
  background: rgb(24 24 27);
}
</style>