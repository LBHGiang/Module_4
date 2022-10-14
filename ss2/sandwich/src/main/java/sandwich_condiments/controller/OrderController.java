package sandwich_condiments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping
public class OrderController {

    @GetMapping
    public String showForm() {
        return "order";
    }

    @RequestMapping("save")
    public String save(@RequestParam(required = false) String condiments, Model model) {
        model.addAttribute("result", condiments);
        return "order";
    }

    @RequestMapping("save")
    public String save2(@RequestParam(required = false) String[] condiments, Model model) {
        String result = Arrays.toString(condiments);
        model.addAttribute("result", result);
        return "order";
    }
}
