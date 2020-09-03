package com.nvc.bookshop.pojo;

/**
 * 用户购物车描述信息
 */
public class UserCartVo {

    private Integer bookId;
    private Integer num;
    private Double totalPrice;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "UserCartVo{" +
                "bookId=" + bookId +
                ", num=" + num +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
