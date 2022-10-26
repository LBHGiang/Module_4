package anh_giang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChiDoCungDuoc {
    @GetMapping
    public String ten() {
        return "/anh_giang";
    }
}
