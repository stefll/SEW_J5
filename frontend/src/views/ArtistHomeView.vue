<script setup>
import Artist from "@/components/Artist.vue";
import {ref} from "vue";
import axios from "axios";
import Song from "@/components/Song.vue";

const page = ref(0);
const rows = ref(5);
const totalRecords = ref(0);

getData()
const artists = ref([]);

async function getData() {
  await axios.get("http://localhost:8080/api/artists", {
    params: {
      page: page.value,
      size: rows.value
    }
  })
      .then(function (response) {
        console.log(response.data.content);
        artists.value = response.data.content;
        totalRecords.value = response.data.totalElements;
      });
}


  async function deleteartist(id) {
    await axios.delete(`http://localhost:8080/api/artists/${id}`);
    console.log("Löschen erfolgreich:");

    await getData();
  }

  function onPageChange(event) {
    page.value = event.page;
    rows.value = event.rows;
    getData();
  }


</script>

<template>
  <div class="bg-zinc-900">
    <h1 class="flex justify-center text-4xl font-bold py-4 pb-8 text-neutral-200">☆ YouArtist ☆</h1>
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
    <div class="flex w-full mt-5">
      <div class="flex items-center w-full mx-72">
        <div class=" flex flex-row items-center w-full">
          <div class="flex-grow border-t border-green-600 w-[1rem]"></div>
          <span class="mx-2 text-neutral-300 text-lg">Artistname</span>
          <div class="flex-grow border-t border-green-600 w-full"></div>
          <router-link to="/artist"
                       class="ml-5 h-10 border border-green-600 rounded-xl w-1/4 flex items-center justify-center gap-x-3 hover:bg-green-800/60">
            <i class="pi pi-plus text-neutral-100"></i>
            <span class="text-neutral-100">
        Add Artist
      </span>
          </router-link>
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
    <Paginator :pt="{root: 'bg-zinc-900 text-neutral-50'}" :rows="5" :totalRecords="totalRecords" @page="onPageChange" template="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport"
               currentPageReportTemplate="Showing {first} to {last} of {totalRecords} on page {currentPage} of {totalPages}"></Paginator>
  </div>
</template>

<style scoped>

</style>