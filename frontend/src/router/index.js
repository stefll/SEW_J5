import { createRouter, createWebHistory } from 'vue-router'
import SongHomeView from "@/views/SongHomeView.vue";
import SongView from "@/views/SongView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
      {path: '/',component: SongHomeView},
      {path: '/song', component: SongView},
      {path: '/song/:id', component: SongView},

  ]
})

export default router
