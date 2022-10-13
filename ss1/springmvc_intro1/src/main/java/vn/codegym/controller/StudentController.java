package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService service;

    @GetMapping
    public ModelAndView showList() {
        return new ModelAndView("list", "studentList", service.findAll());
    }


}
