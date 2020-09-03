package com.nvc.bookshop.mapper;

import com.nvc.bookshop.pojo.OrderItem;

import java.util.List;

public interface OrderItemMapper {

    Integer addOrderItemMapper (OrderItem orderItem);

    List<OrderItem> findOrderItemMapperListByOrderId(Integer orderId);
}
