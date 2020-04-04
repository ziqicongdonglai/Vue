<template>
  <div>
    <span>{{item.goodName}}</span>
    <span>{{item.createTime}}</span>
    <span>{{item.goodPrice * item.goodNumber}}</span>
    <span>
      <button class="numberbutton">+</button>
      {{item.goodNumber}}
      <button class="numberbutton">-</button>
    </span>
    <span>
      <button id="deletebutton">删除</button>
    </span>
  </div>
</template>

<script>
export default {
  name: "",
  data() {
    return {};
  },
  props: ['index', 'good'],
  components: {}
};
</script>

<style lang='scss' scoped>
//@import url()
</style>