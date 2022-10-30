package com.example.practice.controller;

import com.example.practice.dto.CartDto;
import com.example.practice.dto.ProductDto;
import com.example.practice.model.Product;
import com.example.practice.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequestMapping("/")
@SessionAttributes("cart")
public class ProductController {

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @Autowired
    private IProductService productService;

    @GetMapping
    public String listProduct(Model model, @CookieValue(value = "idProduct", defaultValue = "-1")
            Long id) {

        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product.get(), productDto);
            model.addAttribute("historyProduct", productDto);
        }

        model.addAttribute("products", productService.findAll());
        return "views/list";
    }

    @GetMapping("/{id}/details")
    public String details(@PathVariable Long id, Model model, HttpServletResponse response) {
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);

        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product.get(), productDto);
            model.addAttribute("product", productDto);
        }
        return "views/details";
    }

    @GetMapping("/{id}/add")
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute("cart") CartDto cart) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product.get(), productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }
}