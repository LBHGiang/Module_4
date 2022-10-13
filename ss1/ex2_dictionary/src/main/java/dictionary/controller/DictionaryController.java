package dictionary.controller;

import dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/search")
public class DictionaryController {

    @Autowired
    private IDictionaryService service;

    @GetMapping
    public String showForm() {
        return "dict";
    }

    @PostMapping
    public ModelAndView search(@RequestParam String word) {
        return new ModelAndView("dict", "vietnamese", service.search(word));
    }

}
