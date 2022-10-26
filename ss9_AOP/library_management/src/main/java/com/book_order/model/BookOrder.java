package com.book_order.model;

import javax.persistence.*;

@Entity
public class BookOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer otp;
    private String orderDate;

    @Column
    private String returnDate;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;



    public BookOrder() {
    }

    public BookOrder(Integer id, Integer otp, String orderDate, String returnDate, Book book) {
        this.id = id;
        this.otp = otp;
        this.orderDate = orderDate;
        this.returnDate = returnDate;
        this.book = book;
    }

    public BookOrder(Integer otp, String orderDate, String returnDate, Book book) {
        this.otp = otp;
        this.orderDate = orderDate;
        this.returnDate = returnDate;
        this.book = book;
    }

    public BookOrder(Integer otp, String orderDate, Book book) {
        this.otp = otp;
        this.orderDate = orderDate;
        this.book = book;
    }

    public Integer getOtp() {
        return otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
