package com.example.practice;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("counter")
public class CountController {

    @ModelAttribute("counter")
    public Count init() {
        return new Count();
    }

    @GetMapping("/")
    public String get(@ModelAttribute(value = "counter") Count count) {
        count.increment();
        return "views/index";
    }

}
