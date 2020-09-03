package com.nvc.bookshop.service;

import com.nvc.bookshop.pojo.OrderItem;

import java.util.List;

public interface OrderItemService {

    Integer createOrderItem(OrderItem orderItem);

    boolean batchCreateOrderItems(List<OrderItem> orderItems);
}
