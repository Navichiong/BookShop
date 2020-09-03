package com.nvc.bookshop.mapper;

import com.nvc.bookshop.pojo.Order;

import java.util.List;

public interface OrderMapper {

    Integer addOrder(Order order);

    List<Order> findDetailOrderListByUserId(Integer userId);

    Double getOrderTotalPriceByUserIdAndOrderId(Order order);
}
