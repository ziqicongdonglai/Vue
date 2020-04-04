package com.example.order.api.eneity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author ke_zhang
 * @create 2020/4/4 15:36
 * @description
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer ordId;
    private String goodName;
    private String createTime;
    private Double goodPrice;
    private Integer goodNumber;
}
