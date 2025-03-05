<script setup>
import Artist from "@/components/Artist.vue";
import {ref} from "vue";
import axios from "axios";
import Song from "@/components/Song.vue";

getData()
const artists = ref();

async function getData(){
  const url = "http://localhost:8080/api/artists";
  try {
    const response = await fetch(url);
    if (!response.ok) {
      throw new Error(`Response status: ${response.status}`);
    }

    const json = await response.json();
    console.log(json)
    artists.value = json;
    console.log(json);
  } catch (error) {
    console.error(error.message);
  }
}

async function deleteartist(id) {
  await axios.delete(`http://localhost:8080/api/artists/${id}`);
  console.log("Löschen erfolgreich:");

  await getData();
}


</script>

<template>
  <div class="bg-zinc-900">
  <h1 class="flex justify-center text-4xl font-bold py-4 pb-8 text-neutral-200">☆ YouArtist ☆</h1>
  <div class="mx-72 mb-5 flex flex-column gap-x-5">

    <router-link to="/" class="h-10 border-b-2 border-green-600 rounded-t-xl w-1/6 flex items-center justify-center gap-x-3 hover:bg-green-800/60">
      <i class="pi pi-sparkles text-neutral-100"></i>
      <span class="text-neutral-100">
        Songs
      </span>
    </router-link>
    <router-link to="/artists" class="h-10 border-b-2 border-green-600 rounded-t-xl w-1/6 flex items-center justify-center gap-x-3 hover:bg-green-800/60">
      <i class="pi pi-user text-neutral-100"></i>
      <span class="text-neutral-100">
        Artists
      </span>
    </router-link>
  </div>
    <div class="flex justify-between mx-72 ">
      <input
          class="border rounded-full text-neutral-100 mb-6 pl-5 h-10 w-2/3 bg-neutral-700 border-neutral-900 focus:outline-0 focus:ring-green-600 focus:ring-1"
          placeholder="search for a artist"
          v-model="searchterm"
          @input="searchForSong">
      <router-link to="/artist"
                   class="h-10 border border-green-600 rounded-xl w-1/6 flex items-center justify-center gap-x-3 hover:bg-green-800/60">
        <i class="pi pi-plus text-neutral-100"></i>
        <span class="text-neutral-100">
        Add Artist
      </span>
      </router-link>
    </div>

    <div class="flex justify-center w-full">
      <div class="flex items-center w-full justify-center">
        <div class=" flex flex-row items-center w-2/6">
          <div class="flex-grow border-t border-green-600"></div>
          <span class="mx-2 text-neutral-300 text-lg">Artistname</span>
          <div class="flex-grow border-t border-green-600 w-4/5"></div>
        </div>
      </div>
    </div>
    <div class="flex justify-center">

      <div class="flex flex-wrap justify-between mx-36 p-4 pt-2 w-2/3">
        <span v-if="artists.length===0"
              class="ml-5 text-neutral-50"> No artist can be found. Please adjust your search. </span>
        <Artist
            v-for="artist in artists"
            :key="artist.id"
            :id="artist.id"
            :artistname="artist.artistName"
            @delete="() => deleteartist(artist.id)"
        />
      </div>
    </div>
  </div>
</template>

<style scoped>

</style>