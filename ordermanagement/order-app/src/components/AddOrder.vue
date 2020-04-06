<template id="addorderlist">
  <div id="addorder">
    <h4 id="addordertitle">新增订单</h4>
    <div>
      <div class="basetitle">商品名称：</div>
      <!-- <input type="text" v-model="newName" placeholder="如：华为，小米" /> -->
      <el-input size="mini" placeholder="如：华为，小米" v-model="newName"></el-input>
    </div>
    <div>
      <div class="basetitle">价格：</div>
      <!-- <input type="text" v-model="newPrice" placeholder="如：50" /> -->
      <el-input size="mini" placeholder="50" v-model="newPrice"></el-input>
    </div>
    <div>
      <div class="basetitle">数量：</div>
      <!-- <input type="text" v-model="newNum" placeholder="如：3" /> -->
      <el-input size="mini" placeholder="3" v-model="newNum"></el-input>
    </div>
    <button @click="addOrder" class="basebutton">提交</button>
  </div>
</template>

<script>
import { formatDate } from "../assets/js/date";
export default {
  name: "",
  data: function() {
    return {
      newName: "",
      newPrice: null,
      newNum: null
    };
  },
  methods: {
    addOrder: function() {
      this.$emit("addorder-list", {
        goodName: this.newName,
        createTime: formatDate(new Date(), "yyyy-MM-dd hh:mm:ss"),
        goodPrice: this.newPrice,
        goodNumber: this.newNum
      });
    }
  }
};
</script>

<style lang='scss' scoped>
//@import url()
.el-input {
  width: 400px;
}
</style>