package com.nvc.bookshop.service.impl;

import com.nvc.bookshop.mapper.BookMapper;
import com.nvc.bookshop.pojo.Book;
import com.nvc.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> handleBooks() {
        return bookMapper.findAll();
    }

    @Override
    public List<Book> handleBooksBySuitCode(Integer code) {
        return bookMapper.findBooksBySuitCode(code);
    }

    @Override
    public List<Book> handleBooksByCategoryCode(Integer code) {
        return bookMapper.findBooksByCategoryCode(code);
    }

    @Override
    public Book handleGetBookById(Integer id) {
        return bookMapper.findBookById(id);
    }
}
