package com.nvc.bookshop.pojo;

import com.nvc.bookshop.pojo.enums.Category;
import com.nvc.bookshop.pojo.enums.Suit;

import java.util.Date;

/**
 * 图书实体类
 */
public class Book {

    private Integer id;
    private String isbn;
    private String name;
    private String author;
    private String publisher;
    private Date publish_date;
    private Double old_price;
    private Double new_price;
    private String author_loc;
    private Suit suit;
    private Category category;
    private String info;
    private String img_url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public Double getOld_price() {
        return old_price;
    }

    public void setOld_price(Double old_price) {
        this.old_price = old_price;
    }

    public Double getNew_price() {
        return new_price;
    }

    public void setNew_price(Double new_price) {
        this.new_price = new_price;
    }

    public String getAuthor_loc() {
        return author_loc;
    }

    public void setAuthor_loc(String author_loc) {
        this.author_loc = author_loc;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publish_date=" + publish_date +
                ", old_price=" + old_price +
                ", new_price=" + new_price +
                ", author_loc='" + author_loc + '\'' +
                ", suit=" + suit +
                ", category=" + category +
                ", info='" + info + '\'' +
                ", img_url='" + img_url + '\'' +
                '}';
    }
}
