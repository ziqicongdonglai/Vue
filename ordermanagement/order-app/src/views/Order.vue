<template>
  <div class>
    <!-- 顶部 -->
    <order-header @searchOrder-list="goods"></order-header>

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
        <li v-for="(good, index) in goods" :key="index">
          <order-list
            :good="good"
            :index="index"
            @number-add="addnum"
            @number-sub="subnum"
            @orderlist-delete="deletegood"
          ></order-list>
        </li>
      </ul>
      <span class="basetitle">订单总额：{{totalmoney}}元</span>
    </div>

    <!-- 新增订单 -->
    <add-order @addorder-list="addOrder"></add-order>
  </div>
</template>

<script>
import OrderHeader from "@/components/OrderHeader.vue";
import OrderList from "@/components/OrderList.vue";
import AddOrder from "@/components/AddOrder.vue";
export default {
  name: "Order",
  data() {
    return {
      goods: [],
      totalmoney: 0
    };
  },
  components: {
    OrderHeader,
    OrderList,
    AddOrder
  },
  created(good) {
    this.axios.get("http://localhost:8080/order").then(res => {
      console.log(res.data);
      this.goods = res.data;
      let totalmoney = 0;
      for (good of this.goods) {
        totalmoney += good.goodPrice * good.goodNumber;
      }
      this.goodsMoney = totalmoney;
    });
  },
  methods: {
    // 商品数量改变
    addnum: function(index) {
      // this.goods[index].number++;
      this.$set(
        this.goods[index],
        this.goods[index].goodNumber,
        this.goods[index].goodNumber++
      );
    },
    subnum: function(index) {
      // this.goods[index].number--;
      this.$set(
        this.goods[index],
        this.goods[index].goodNumber,
        this.goods[index].goodNumber--
      );
    },
    // 删除一条订单
    deletegood: function(index) {
      console.log("Order里的index" + index);
      console.log("index的good" + this.goods[index]);
      let oId = this.goods[index].ordId;
      this.axios.delete('http://localhost:8080/order/' + oId)
      .then(ret => {
        console.log(ret.data);
         this.goods.splice(index, 1);
      })
    },
    // 新增一条订单
    addOrder: function(data) {
      // 因为后端插入语句有问题 所以 把push写在外面
      this.goods.push(data);
      this.axios.post("http://localhost:8080/order", data).then(ret => {
        console.log(ret);
      });
    }
    //  searchGoods: function(data) {
    //   let sres = data;
    //   // console.log(data);
    //   if (typeof sres == "") {
    //     return this.goods;
    //   } else {
    //     return this.goods.filter(good => !good.goodName.indexOf(sres))
    //   }
    // }
  },
  // computed: {
  //   searchGoods: function(data) {
  //     let sres = data;
  //     // console.log(data);
  //     if (typeof sres == "") {
  //       return this.goods;
  //     } else {
  //       return this.goods.filter(good => !good.goodName.indexOf(sres))
  //     }
  //   }
  // },
  watch: {
    goods: function(good) {
      let totalmoney = 0;
      if (this.goods.length == 0) {
        this.totalmoney = 0;
      } else {
        for (good of this.goods) {
          totalmoney += good.goodPrice * good.goodNumber;
          // this.orderprice = good.price * good.number;
        }
        this.totalmoney = totalmoney;
      }
    }
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
  cursor: pointer;
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
  text-align: center;
  border-radius: 10%;
}

#searchbox {
  .basebutton {
    margin-left: 50px;
  }
}

/* 全部订单 */
#allorders {
  margin: 15px;
  float: left;
  width: 62%;
  box-sizing: border-box;
  #ultitle {
    width: 100%;
    span {
      width: 20%;
      display: block;
      float: left;
      text-align: center;
      height: 30px;
      line-height: 30px;
    }
  }
  ul {
    width: 100%;
    li {
      width: 100%;
      height: 30px;
      line-height: 30px;
      box-sizing: border-box;
      border-bottom: 1px solid #d4d4d4;
      & > div {
        span {
          display: block;
          width: 20%;
          height: 30px;
          line-height: 30px;
          float: left;
          text-align: center;
          .numberbutton {
            width: 20px;
            background-color: #fff;
            border: 1px solid #d4d4d4;
          }
          #deletebutton {
            width: 40px;
            background-color: #fff;
            border: 1px solid #d4d4d4;
          }
        }
      }
    }
  }
}

/* 新增订单部分 */
#addorder {
  margin-top: 24px;
  float: right;
  width: 33.33%;
  #addordertitle {
    border-bottom: 1px solid #d4d4d4;
    font-weight: 400;
  }
  & > div {
    margin: 10px;
    margin-left: 0;
    input {
      width: 100%;
    }
  }
}
</style>