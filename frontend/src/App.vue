<template>
  <!-- 通用view -->
    <div id="app">
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <router-link class="nav-link" aria-current="page" to="/">投票系統</router-link>
              </li>
              <li class="nav-item">
                <router-link class="nav-link" to="/admin">管理頁面</router-link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
  <!-- 通用view -->

  <!-- 不同view顯示部分 -->
    <router-view />

  </div>
</template>

<script>
export default {
  name: "App"
};
</script>
