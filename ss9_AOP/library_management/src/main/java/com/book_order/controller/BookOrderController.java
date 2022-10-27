package com.book_order.controller;

import com.book_order.model.Book;
import com.book_order.model.BookOrder;
import com.book_order.service.book_service.IBookService;
import com.book_order.service.order_rervice.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@RequestMapping({"/", "/book"})
public class BookOrderController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private IOrderService orderService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "book/list";
    }

    @GetMapping("/{id}/order")
    public String showOrderConfirmForm(@PathVariable("id") int id, Model model) {

        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book/order_form";
    }

    @PostMapping("/order")
    public String order(@RequestParam Integer id, Model model) {

        int otp = (int) (Math.random() * (99999 - 10000) + 10000);
        Book book = bookService.findById(id);
        String orderDate = String.valueOf(new Date(System.currentTimeMillis()));

        BookOrder bookOrder = new BookOrder(otp, orderDate, book);
        orderService.save(bookOrder);

        book.setStock(book.getStock() - 1);
        bookService.save(book);

        model.addAttribute("message",
                "Successfully order! Your order OTP is: " + otp);
        return "book/notification";
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam int otp, RedirectAttributes redirect) {
        BookOrder bookOrder = orderService.findByOtp(otp);

        String returnDate = String.valueOf(new Date(System.currentTimeMillis()));
        bookOrder.setReturnDate(returnDate);
        orderService.save(bookOrder);

        Book book = bookOrder.getBook();
        book.setStock(book.getStock() + 1);
        bookService.save(book);

        redirect.addFlashAttribute("message", "Return book successful! Thank you!");
        return "redirect:/book";
    }

    @ExceptionHandler
    public String handleException(Exception e, Model model) {
        model.addAttribute("message", "OTP is invalid!");
        return "error";
    }

//    @GetMapping("/{id}/view")
//    public String details(@PathVariable int id, Model model) {
//        model.addAttribute("book", bookService.findById(id));
//        return "book/view";
//    }
//
//    @GetMapping("/{id}/delete")
//    public String delete(@PathVariable int id, Model model) {
//        model.addAttribute("book", bookService.findById(id));
//        return "book/delete";
//    }
//
//    @PostMapping("/delete")
//    public String delete(@RequestParam Integer id, RedirectAttributes redirect) {
//        bookService.remove(bookService.findById(id));
//        redirect.addFlashAttribute("message", "Successfully removed");
//        return "redirect:/book";
//    }
//
//    @GetMapping("/create")
//    public String create(Model model) {
//        model.addAttribute("book", new Book());
//        return "book/create";
//    }
//
//    @PostMapping("/create")
//    public String create(@ModelAttribute Book book, RedirectAttributes redirect) {
//        bookService.save(book);
//        redirect.addFlashAttribute("message", "Successfully added");
//        return "redirect:/book";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(@PathVariable int id, Model model) {
//        model.addAttribute("book", bookService.findById(id));
//        return "book/edit";
//    }
//
//    @PostMapping("/edit")
//    public String edit(@ModelAttribute Book book, RedirectAttributes redirect) {
//        bookService.update(book);
//        redirect.addFlashAttribute("message", "Successfully updated");
//        return "redirect:/book";
//    }
}
