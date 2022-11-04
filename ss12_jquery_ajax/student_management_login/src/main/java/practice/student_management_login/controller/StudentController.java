package practice.student_management_login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import practice.student_management_login.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students/list";
    }
}
