<script setup>
import Song from "@/components/Song.vue";
import {ref} from "vue";
import axios from "axios";


const page = ref(0);
const rows = ref(5);
const totalRecords = ref(0);
const searchterm = ref("");

getData()
const songs = ref([]);

async function getData() {
  await axios.get("http://localhost:8080/api/songs", {
    params: {
      page: page.value,
      size: rows.value
    }
  })
      .then(function (response) {
        console.log(response.data.content);
        songs.value = response.data.content;
        totalRecords.value = response.data.totalElements;
      });
}

async function deletesong(id) {
  await axios.delete(`http://localhost:8080/api/songs/${id}`)
  await getData()
}

function searchForSong() {
  axios.get("http://localhost:8080/api/songs/search", {
    params: {
      query: searchterm.value,
      page: page.value,
      size: rows.value
    }})
        .then(async function (response) {
          songs.value = response.data.content;
          totalRecords.value = response.data.totalElements;
        })
}

function onPageChange(event) {
  page.value = event.page;
  rows.value = event.rows;
  getData();
}

</script>

<template>
  <div class="bg-zinc-900">
    <h1 class="flex justify-center text-4xl font-bold py-4 pb-8 text-neutral-200">☆ YouSong ☆</h1>
    <div class="mx-72 mb-5 flex flex-column gap-x-5">

      <router-link to="/"
                   class="h-10 border-b-2 border-green-600 rounded-t-xl w-1/6 flex items-center justify-center gap-x-3 hover:bg-green-800/60">
        <i class="pi pi-sparkles text-neutral-100"></i>
        <span class="text-neutral-100">
        Songs
      </span>
      </router-link>
      <router-link to="/artists"
                   class="h-10 border-b-2 border-green-600 rounded-t-xl w-1/6 flex items-center justify-center gap-x-3 hover:bg-green-800/60">
        <i class="pi pi-user text-neutral-100"></i>
        <span class="text-neutral-100">
        Artists
      </span>
      </router-link>
    </div>

    <div class="flex justify-between mx-72 ">
      <input
          class="border rounded-full text-neutral-100 mb-6 pl-5 h-10 w-2/3 bg-neutral-700 border-neutral-900 focus:outline-0 focus:ring-green-600 focus:ring-1"
          placeholder="search for a song"
          v-model="searchterm"
          @input="searchForSong">
      <router-link to="/song"
                   class="h-10 border border-green-600 rounded-xl w-1/6 flex items-center justify-center gap-x-3 hover:bg-green-800/60">
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
        <span v-if="songs.length===0"
              class="ml-5 text-neutral-50"> No songs can be found. Please adjust your search. </span>
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
    <Paginator :pt="{root: 'bg-zinc-900 text-neutral-50'}" :rows="5" :totalRecords="totalRecords" @page="onPageChange"
               template="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport"
               currentPageReportTemplate="Showing {first} to {last} of {totalRecords} on page {currentPage} of {totalPages}"></Paginator>

  </div>
</template>

<style scoped>

</style>