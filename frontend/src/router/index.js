import { createRouter, createWebHistory } from 'vue-router'
import SongHomeView from "@/views/SongHomeView.vue";
import SongView from "@/views/SongView.vue";
import ArtistHomeView from "@/views/ArtistHomeView.vue";
import ArtistView from "@/views/ArtistView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
      {path: '/',component: SongHomeView},
      {path: '/song', component: SongView},
      {path: '/song/:id', component: SongView},
      {path: '/artists', component: ArtistHomeView},
      {path: '/artist', component: ArtistView},
      {path: '/artist/:id', component: ArtistView}

  ]
})

export default router
