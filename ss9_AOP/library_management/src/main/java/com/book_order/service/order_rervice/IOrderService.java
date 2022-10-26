package com.book_order.service.order_rervice;

import com.book_order.model.BookOrder;

import java.util.List;

public interface IOrderService {
    List<BookOrder> findAll();

    void save(BookOrder bookOrder);

    BookOrder findById(Integer id);

    void update(BookOrder bookOrder);

    void remove(BookOrder bookOrder);

    BookOrder findByOtp(int otp);

}
