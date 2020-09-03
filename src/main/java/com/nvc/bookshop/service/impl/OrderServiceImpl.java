package com.nvc.bookshop.service.impl;

import com.nvc.bookshop.mapper.OrderMapper;
import com.nvc.bookshop.pojo.Cart;
import com.nvc.bookshop.pojo.Order;
import com.nvc.bookshop.pojo.OrderItem;
import com.nvc.bookshop.pojo.UserCartVo;
import com.nvc.bookshop.service.CartService;
import com.nvc.bookshop.service.OrderItemService;
import com.nvc.bookshop.service.OrderService;
import com.nvc.bookshop.utils.OrderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private CartService cartService;

    @Override
    public Integer createOrder(Order order) {
        return orderMapper.addOrder(order);
    }

    @Transactional
    @Override
    public boolean buy(List<Cart> cartList, Integer addressId, Integer userId) {
        // 1.生产订单表记录
        Order order = new Order(OrderUtils.createOrderNum(), new Date(), userId, addressId, false);
        Integer i1 = orderMapper.addOrder(order);
        if (i1 <= 0) {
            throw new RuntimeException("生产订单表记录失败");
        }
        // 2. 生成订单明细表记录
        List<Integer> cartIds = new LinkedList<>();
        List<OrderItem> orderItems = new LinkedList<>();
        for (Cart cart : cartList) {
            OrderItem orderItem = new OrderItem(order.getId(), cart.getBook_id(), cart.getCount());
            cartIds.add(cart.getId());
            orderItems.add(orderItem);
        }
        boolean b = orderItemService.batchCreateOrderItems(orderItems);
        if (!b) {
            throw new RuntimeException("生成订单明细表记录失败");
        }
        // 3. 删除购物车表中记录
        for (Integer cartId : cartIds) {
            Integer i2 = cartService.deleteCartById(cartId);
            if (i2 <= 0) {
                throw new RuntimeException("删除购物车表中记录时失败");
            }
        }
        return true;
    }

    @Override
    public List<Order> findOderListByUserId(Integer userId) {
        if (userId != null) {
            return orderMapper.findDetailOrderListByUserId(userId);
        }
        return new LinkedList<>();
    }

    @Override
    public Double getSignalOrderPrice(Order order) {
        return orderMapper.getOrderTotalPriceByUserIdAndOrderId(order);
    }
}
