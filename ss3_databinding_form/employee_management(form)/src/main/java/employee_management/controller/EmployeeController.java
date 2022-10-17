package employee_management.controller;

import employee_management.model.Employee;
import employee_management.service.IConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private IConversionService service;

    @GetMapping("/showform")
    public String showForm(Model model){
        model.addAttribute("employee", new Employee());
        return "create";
    }

    @PostMapping(value="/addEmployee")
    public String submit(@ModelAttribute("employee") Employee employee, Model model) {
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
        return "info";
    }
}
