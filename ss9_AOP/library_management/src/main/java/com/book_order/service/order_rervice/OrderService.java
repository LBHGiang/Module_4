package com.book_order.service.order_rervice;

import com.book_order.model.BookOrder;
import com.book_order.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public List<BookOrder> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void save(BookOrder bookOrder) {
        orderRepository.save(bookOrder);
    }

    @Override
    public BookOrder findById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void update(BookOrder bookOrder) {
        orderRepository.save(bookOrder);
    }

    @Override
    public void remove(BookOrder bookOrder) {
        orderRepository.delete(bookOrder);
    }

    @Override
    public BookOrder findByOtp(String otp) {
        return orderRepository.findByOtp(otp);
    }


}
