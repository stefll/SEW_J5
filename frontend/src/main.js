import './assets/main.css'
import 'primeicons/primeicons.css'
import PrimeVue from "primevue/config";


import { createApp } from 'vue'
import { createPinia } from 'pinia'

import 'primevue/resources/themes/aura-light-green/theme.css'
import Toast from "primevue/toast";
import ToastService from "primevue/toastservice";

import App from './App.vue'
import router from './router'

const app = createApp(App)

app.use(createPinia())
app.use(PrimeVue)
app.use(router)
app.use(ToastService)
app.component('Toast', Toast)

app.mount('#app')
