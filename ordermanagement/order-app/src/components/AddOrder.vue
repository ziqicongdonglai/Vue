<template>
  <div id="addorder">
    <h4 id="addordertitle">新增订单</h4>
    <div>
      <div class="basetitle">品牌：</div>
      <input type="text" v-model="newName" placeholder="如：华为，小米" />
    </div>
    <div>
      <div class="basetitle">价格：</div>
      <input type="text" v-model="newPrice" placeholder="如：50" />
    </div>
    <div>
      <div class="basetitle">数量：</div>
      <input type="text" v-model="newNum" placeholder="如：3" />
    </div>
    <!-- <button @click="addOrder" class="basebutton">提交</button> -->
    <button class="basebutton">提交</button>
  </div>
</template>

<script>
export default {
  name: "",
  data() {
    return {
      newName: "",
      newPrice: null,
      newNum: null
    };
  },
  components: {}
};
</script>

<style lang='scss' scoped>
//@import url()
</style>