package com.nvc.bookshop.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nvc.bookshop.pojo.Book;
import com.nvc.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/getData")
    public String bookData(Integer code, Model model, Integer pageNum) {
        PageHelper.startPage(pageNum, 4);
        List<Book> books = bookService.handleBooksByCategoryCode(code);
        PageInfo<Book> info = new PageInfo<>(books, 5);
        model.addAttribute("bookList", info);
        model.addAttribute("category", code);
        return "bookData";
    }

    @GetMapping("/toBookListPage")
    public String toBookListPage(Integer categoryCode, Model model) {
        model.addAttribute("categoryCode", categoryCode);
        return "books_list";
    }

    @PostMapping("/getBookListData")
    public String getBookListData(Integer categoryCode, Integer pageNum,
                                  @RequestParam(required = false, defaultValue = "4") Integer pageSize, Model model) {
        PageHelper.startPage(pageNum, pageSize);
        List<Book> books = bookService.handleBooksByCategoryCode(categoryCode);
        PageInfo<Book> info = new PageInfo<>(books, 5);
        model.addAttribute("bookListData", info);
        model.addAttribute("category", categoryCode);
        model.addAttribute("pageSize", pageSize);
        return "booksListData";
    }

    @GetMapping("/toDetailsPage")
    public String toDetailsPage(Integer id, Model model) {
        Book book = bookService.handleGetBookById(id);
        model.addAttribute("book", book);
        return "details";
    }
}
