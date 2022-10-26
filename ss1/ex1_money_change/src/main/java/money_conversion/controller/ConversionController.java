package money_conversion.controller;

import money_conversion.service.IConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/conversion")
public class ConversionController {

    @Autowired
    private IConversionService service;

    @GetMapping
    public String showForm() {
        return "list";
    }

    @PostMapping
    public ModelAndView change(@RequestParam String usd, String rate) {
        return new ModelAndView("list", "vnd", service.change(usd, rate));
    }


}
