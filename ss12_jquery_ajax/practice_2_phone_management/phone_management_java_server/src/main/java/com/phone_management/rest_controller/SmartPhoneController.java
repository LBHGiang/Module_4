package com.phone_management.rest_controller;

import com.phone_management.model.SmartPhone;
import com.phone_management.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/smartphones")
public class SmartPhoneController {

    @Autowired
    private ISmartPhoneService SmartPhoneService;

    @PostMapping
    public ResponseEntity<SmartPhone> createSmartPhone(@RequestBody SmartPhone SmartPhone) {
        SmartPhoneService.save(SmartPhone);
        return new ResponseEntity<>(SmartPhone, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> allPhones() {
        return new ResponseEntity<>(SmartPhoneService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartPhonePage() {
        ModelAndView modelAndView = new ModelAndView("/views/list");
        modelAndView.addObject("smartphones", SmartPhoneService.findAll());
        return modelAndView;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> deleteSmartPhone(@PathVariable Long id) {
        Optional<SmartPhone> SmartPhoneOptional = SmartPhoneService.findById(id);
        if (!SmartPhoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        SmartPhoneService.remove(id);
        return new ResponseEntity<>(SmartPhoneOptional.get(), HttpStatus.NO_CONTENT);
    }
}
