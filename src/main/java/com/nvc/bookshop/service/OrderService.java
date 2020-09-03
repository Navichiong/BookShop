package com.nvc.bookshop.service;

import com.nvc.bookshop.pojo.Cart;
import com.nvc.bookshop.pojo.Order;
import com.nvc.bookshop.pojo.UserCartVo;

import java.util.List;

public interface OrderService {

    Integer createOrder(Order order);

    boolean buy(List<Cart> userCartVos, Integer addressId, Integer userId);

    List<Order> findOderListByUserId(Integer userId);

    Double getSignalOrderPrice(Order order);

}
