import { createRouter, createWebHistory } from 'vue-router'
import SongHomeView from "@/views/SongHomeView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
      {path: '/',component: SongHomeView}
  ]
})

export default router
