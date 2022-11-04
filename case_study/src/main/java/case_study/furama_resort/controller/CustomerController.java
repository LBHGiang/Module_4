package case_study.furama_resort.controller;

import case_study.furama_resort.model.customer.Customer;
import case_study.furama_resort.model.customer.CustomerType;
import case_study.furama_resort.service.customer_service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {


    @Autowired
    private ICustomerService customerService;

    @ModelAttribute("customerTypes")
    public List<CustomerType> getAllCategories() {
        return customerService.getCustomerTypes();
    }

    @GetMapping
    public String search(@RequestParam(value = "searchName", defaultValue = "") String name,
                         @RequestParam(value = "searchEmail", defaultValue = "") String email,
                         @RequestParam(value = "searchCustomerType", defaultValue = "") String typeName,
                         Model model,
                         @PageableDefault(value = 3) Pageable pageable) {
        Page<Customer> customers = customerService.findByNameAndEmailAndCustomerType(name, email, typeName, pageable);
        model.addAttribute("customers", customers);
        model.addAttribute("searchName", name);
        model.addAttribute("searchEmail", email);
        model.addAttribute("searchCustomerType", typeName);
        return "customers/list";
    }


    @GetMapping("/{id}/delete")
    public String remove(@PathVariable(value = "id") int id, Model model, RedirectAttributes redirect) {
        Optional<Customer> optionalCustomer = customerService.findById(id);
        if (!optionalCustomer.isPresent()) {
            redirect.addFlashAttribute("message", "Customer not found!");
            return "redirect:/customers";
        }
        model.addAttribute("customer", optionalCustomer.get());
        return "customers/delete";
    }

    @PostMapping("/delete")
    public String remove(@RequestParam(value = "id") int id, RedirectAttributes redirect) {
        Optional<Customer> optionalCustomer = customerService.findById(id);
        if (!optionalCustomer.isPresent()) {
            redirect.addFlashAttribute("message", "Customer not found!");
        } else {
            customerService.remove(id);
            redirect.addFlashAttribute("message", "Customer removed!");
        }
        return "redirect:/customers";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers/create";
    }

    @PostMapping("/create")
    public String create(@RequestParam(value = "customer") Customer customer, RedirectAttributes redirect){
        customerService.save(customer);
        redirect.addFlashAttribute("message","Customer created successfully");
        return "redirect:/customers/create";
    }


}
