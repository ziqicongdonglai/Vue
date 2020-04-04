package com.example.order.api.mapper;

import com.example.order.api.eneity.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/4/4 17:19
 * @description
 */
public interface OrderMapper {
    /**
     * 查询所有订单
     * @return List<Order>
     */
    @Select("SELECT * FROM t_order")
    List<Order> findAll();

    /**
     * 通过id查询订单
     * @param id
     * @return
     */
    @Select("SELECT * FROM t_order WHERE ord_id = #{id}")
    Order findById(Integer id);

    /**
     * 插入一条订单
     * @param order
     * @return
     */
    @Insert("INSERT INTO t_order(good_name,create_time,good_price,good_number)" +
    "values (#{goodName},#{createTime},#{goodPrice},#{goodNumber})")
    Order insert(Order order);

    /**
     * 删除一条订单
     * @param id
     * @return
     */
    @Delete("DELETE FROM t_order WHERE ord_id=#{id}")
    void delete(Integer id);

    //貌似订单没有更新这一说
//    @Update("UPDATE order SET ")
//    int update(Order order);

    //貌似也没有批量插入
//    @Insert("INSERT INTO order")
//    int[] batchInsert(List<Order> orders);
}
