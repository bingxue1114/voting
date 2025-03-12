import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '@/views/HomePage.vue';
import AdminDashboard from '@/views/AdminDashboard.vue';

const routes = [
    { path: '/', name: 'Home', component: HomePage },
    { path: '/admin', name: 'AdminDashboard', component: AdminDashboard }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;