package com.phone_management.controller;

import com.phone_management.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SmartPhoneController {

    @Autowired
    private ISmartPhoneService smartPhoneService;


    @GetMapping
    public String showIndex() {
        return "smart_phone/index";
    }

}
