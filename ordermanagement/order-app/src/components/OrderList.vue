<template>
  <div>
    <span>{{good.goodName}}</span>
    <span>{{good.createTime}}</span>
    <span>{{good.goodPrice * good.goodNumber}}</span>
    <span>
      <button @click="add()" class="numberbutton">+</button>
      {{good.goodNumber}}
      <button @click="sub()" class="numberbutton">-</button>
    </span>
    <span>
      <button @click="deleteorder()" id="deletebutton">删除</button>
    </span>
  </div>
</template>

<script>
export default {
  name: "",
  data() {
    return {
      corderitem: {
        goodName: "小米台灯",
        createTime: "2020-03-29",
        goodPrice: 500,
        goodNumber: 2
      },
      totalmoney: 0
    };
  },
  props: ["index", "good"],
  mounted: function() {
    this.corderitem.goodName = this.good.goodName;
    this.corderitem.createTime = this.good.createTime;
    this.corderitem.goodPrice = this.good.goodPrice;
    this.corderitem.goodNumber = this.good.goodNumber;
  },
  methods: {
    add() {
      this.corderitem.goodNumber++;
      this.$emit("number-add", this.index);
    },
    sub() {
      if (this.corderitem.goodNumber > 0) {
        this.corderitem.goodNumber--;
        this.$emit("number-sub", this.index);
      } else {
        alert("不能再减少了");
      }
    },
    deleteorder() {
      this.$emit("orderlist-delete", this.index);
    }
  }
};
</script>

<style lang='scss' scoped>
//@import url()
</style>