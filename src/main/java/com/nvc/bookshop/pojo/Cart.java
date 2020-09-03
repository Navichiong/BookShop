package com.nvc.bookshop.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 购物车实体类
 */
public class Cart {

    private Integer id;
    @NotNull
    @Min(value = 1)
    private Integer user_id;
    @NotNull
    @Min(value = 1)
    private Integer book_id;
    @NotNull
    @Min(value = 1)
    private Integer count;

    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", book_id=" + book_id +
                ", count=" + count +
                ", book=" + book +
                '}';
    }
}
