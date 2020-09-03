package com.nvc.bookshop.service.impl;

import com.nvc.bookshop.mapper.OrderItemMapper;
import com.nvc.bookshop.pojo.OrderItem;
import com.nvc.bookshop.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public Integer createOrderItem(OrderItem orderItem) {
        return orderItemMapper.addOrderItemMapper(orderItem);
    }

    @Override
    public boolean batchCreateOrderItems(List<OrderItem> orderItems) {
        boolean success = false;
        if (!CollectionUtils.isEmpty(orderItems)) {
            for (OrderItem orderItem : orderItems) {
                Integer integer = createOrderItem(orderItem);
                if (integer <= 0) {
                    throw new RuntimeException("生成订单明细表失败");
                }
            }
            success = true;
        }
        return success;
    }
}
