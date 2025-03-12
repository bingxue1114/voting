<template>
  <div id="app">
    <nav>
      <router-link to="/">首頁</router-link> |
      <router-link to="/admin">管理頁面</router-link>
    </nav>
    <router-view />  <!-- 這行很重要 -->
  </div>
</template>

<script>
export default {
  name: "App"
};
</script>
