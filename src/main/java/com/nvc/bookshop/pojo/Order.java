package com.nvc.bookshop.pojo;

import java.util.Date;
import java.util.List;

public class Order {

    private Integer id;
    private String order_num;
    private Date create_date;
    private Integer user_id;
    private Integer address_id;
    private boolean order_status;

    //用户信息
    private User user;
    //地址信息
    private Address address;
    //订单明细信息
    private List<OrderItem> orderItems;

    public Order() {
    }

    public Order(String order_num, Date create_date, Integer user_id, Integer address_id, boolean order_status) {
        this.order_num = order_num;
        this.create_date = create_date;
        this.user_id = user_id;
        this.address_id = address_id;
        this.order_status = order_status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder_num() {
        return order_num;
    }

    public void setOrder_num(String order_num) {
        this.order_num = order_num;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public boolean getOrder_status() {
        return order_status;
    }

    public void setOrder_status(boolean order_status) {
        this.order_status = order_status;
    }

    public boolean isOrder_status() {
        return order_status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order_num='" + order_num + '\'' +
                ", create_date=" + create_date +
                ", user_id=" + user_id +
                ", address_id=" + address_id +
                ", order_status=" + order_status +
                ", user=" + user +
                ", address=" + address +
                ", orderItems=" + orderItems +
                '}';
    }
}
