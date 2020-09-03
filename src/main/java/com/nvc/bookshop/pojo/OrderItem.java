package com.nvc.bookshop.pojo;

/**
 * 订单明细
 */
public class OrderItem {

    private Integer id;
    private Integer order_id;
    private Integer book_id;
    private Integer count;

    private Book book;

    public OrderItem() {
    }

    public OrderItem(Integer order_id, Integer book_id, Integer count) {
        this.order_id = order_id;
        this.book_id = book_id;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", order_id=" + order_id +
                ", book_id=" + book_id +
                ", count=" + count +
                ", book=" + book +
                '}';
    }
}
