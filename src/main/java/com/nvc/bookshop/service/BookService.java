package com.nvc.bookshop.service;

import com.nvc.bookshop.pojo.Book;

import java.util.List;

public interface BookService {

    List<Book> handleBooks();

    List<Book> handleBooksBySuitCode(Integer code);

    List<Book> handleBooksByCategoryCode(Integer code);

    Book handleGetBookById(Integer id);
}
