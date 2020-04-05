<template>
  <div>
    <div id="title">订单管理</div>
    <div id="searchbox">
      <span class="basetitle">品牌：</span>
      <input type="text" v-model="enterSearch" placeholder="要搜索的品牌" />
      <button class="basebutton" @click="searchOrder">查询</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "",
  data() {
    return {
      enterSearch: ""
    };
  },
  methods: {
    searchOrder: function() {
      this.$emit("searchOrder-list",{
        searchName: this.enterSearch
      });
    }
  },
  components: {}
};
</script>

<style lang='scss' scoped>
//@import url()
</style>