<template>
  <div class>
    <!-- 顶部 -->
    <!-- <div>
      <div id="title">订单管理</div>
      <div id="searchbox">
        <span class="basetitle">品牌：</span>
        <input type="text" placeholder="要搜索的品牌" />
        <button class="basebutton">查询</button>
      </div>
    </div>-->
    <order-header></order-header>

    <!-- 全部订单列表 -->
    <div id="allorders">
      <div id="ultitle">
        <span class="basetitle">品牌</span>
        <span class="basetitle">订单日期</span>
        <span class="basetitle">订单价格</span>
        <span class="basetitle">购买数量</span>
        <span class="basetitle">操作</span>
      </div>
      <ul>
        <li v-for="(item, index) in orders" :key="index">
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
        </li>
      </ul>
      <span class="basetitle">订单总额：{{totalmoney}}元</span>
    </div>

    <!-- 新增订单 -->
    <add-order></add-order>
  </div>
</template>

<script>
import OrderHeader from "@/components/OrderHeader.vue";
// import OrderList from '@/components/OrderList.vue'
import AddOrder from "@/components/AddOrder.vue";
export default {
  name: "Order",
  data() {
    return {
      orders: [],
      totalmoney: 0
      //   newName: "",
      //   newPrice: null,
      //   newNum: null
    };
  },
  components: {
    OrderHeader,
    //   OrderList,
    AddOrder
  },
  created() {
    this.axios.get("http://localhost:8080/order").then(res => {
      console.log(res.data);
      this.orders = res.data;
    });
  }
};
</script>

<style lang='scss' >
//@import url()
* {
  margin: 0;
  padding: 0;
}

button {
  border: 0;
}

li {
  list-style: none;
}

input {
  border: 1px solid #d4d4d4;
  border-radius: 3px;
}

/* 顶部 标题及搜索部分 */
#title {
  background-color: #337ab7;
  color: #f4f4f4;
  line-height: 30px;
  height: 30px;
  padding-left: 10px;
}

#searchbox {
  height: 60px;
  border-bottom: 2px solid #337ab7;
  padding-left: 20px;
  padding-top: 10px;
  box-sizing: border-box;
}

.basetitle {
  font-size: 14px;
  font-weight: 600;
}

.basebutton {
  color: #f4f4f4;
  background-color: #337ab7;
  width: 55px;
  height: 25px;
  line-height: 25px;
  border-radius: 10%;
}

#searchbox .basebutton {
  margin-left: 50px;
}

/* 全部订单 */
#allorders {
  margin: 15px;
  float: left;
  width: 62%;
  box-sizing: border-box;
}

#ultitle {
  width: 100%;
}

#ultitle span {
  width: 20%;
  display: block;
  float: left;
  text-align: center;
  height: 30px;
  line-height: 30px;
}

#allorders ul {
  width: 100%;
}

#allorders ul li {
  width: 100%;
  height: 30px;
  line-height: 30px;
  border-bottom: 1px solid #d4d4d4;
}

#allorders ul li > div span {
  display: block;
  width: 20%;
  height: 30px;
  line-height: 30px;
  float: left;
  text-align: center;
}

span .numberbutton {
  width: 20px;
  background-color: #fff;
  border: 1px solid #d4d4d4;
}

span #deletebutton {
  width: 40px;
  background-color: #fff;
  border: 1px solid #d4d4d4;
}

/* 新增订单部分 */
#addorder {
  margin-top: 15px;
  float: right;
  width: 33.33%;
}

#addordertitle {
  border-bottom: 1px solid #d4d4d4;
}

#addorder h4 {
  font-weight: 400;
}

#addorder > div {
  margin: 10px;
  margin-left: 0;
}

#addorder > div input {
  width: 100%;
}
</style>