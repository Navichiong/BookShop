package com.nvc.bookshop.mapper;

import com.nvc.bookshop.pojo.Book;

import java.util.List;

/**
 * 图书接口
 */
public interface BookMapper {

    List<Book> findAll();

    List<Book> findBooksBySuitCode(Integer code);

    List<Book> findBooksByCategoryCode(Integer code);

    Book findBookById(Integer id);
}
