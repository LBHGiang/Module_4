package com.book_order.service.book_service;


import com.book_order.model.Book;

import java.util.List;

public interface IBookService {

    List<Book> findAll();

    void save(Book book);

    Book findById(Integer id);

    void update(Book book);

    void remove(Book book);

}
