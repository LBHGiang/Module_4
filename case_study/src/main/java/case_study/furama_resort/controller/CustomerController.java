package case_study.furama_resort.controller;

import case_study.furama_resort.model.customer.Customer;
import case_study.furama_resort.model.customer.CustomerType;
import case_study.furama_resort.model.dto.CustomerDto;
import case_study.furama_resort.service.customer_service.ICustomerService;
import case_study.furama_resort.service.customer_service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

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
        model.addAttribute("customer", new CustomerDto());
        return "customers/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute(value = "customerDto") CustomerDto customerDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirect) {
        if (!bindingResult.hasErrors()) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            redirect.addFlashAttribute("message", "Customer created successfully");
        } else {
            redirect.addFlashAttribute("message", "Customer creation failed");
        }
        return "redirect:/customers/create";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable(value = "id") int id, Model model, RedirectAttributes redirect) {
        Optional<Customer> optionalCustomer = customerService.findById(id);
        if (!optionalCustomer.isPresent()) {
            redirect.addFlashAttribute("message", "Customer not found!");
            return "redirect:/customers/";
        }
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(optionalCustomer.get(), customerDto);
        model.addAttribute("customerDto", customerDto);
        return "customers/edit";
    }

    @PostMapping("/edit")
    public String update(@Validated @ModelAttribute(value = "customerDto") CustomerDto customerDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirect) {
        Optional<Customer> optionalCustomer = customerService.findById(customerDto.getId());
        if (!optionalCustomer.isPresent()) {
            redirect.addFlashAttribute("message", "Customer not found!");
            return "redirect:/customers/";
        }
        if (!bindingResult.hasErrors()) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            redirect.addFlashAttribute("message", "Customer saved successfully");
            return "redirect:/customers/";
        }
        redirect.addFlashAttribute("message", "Customer saved failed");
        return "redirect:/customers";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable(value = "id") int id, Model model, RedirectAttributes redirect) {
        Optional<Customer> optionalCustomer = customerService.findById(id);
        if (!optionalCustomer.isPresent()) {
            redirect.addFlashAttribute("message", "Customer not found!");
            return "redirect:/customers/";
        }
        model.addAttribute("customer", optionalCustomer.get());
        return "customers/details";
    }

    @ModelAttribute("customerTypes")
    public List<CustomerType> getAllCategories() {
        return customerTypeService.getCustomerTypes();
    }

    @ModelAttribute("genders")
    public Map<Integer, String> getGenders() {
        Map<Integer, String> genders = new HashMap<Integer, String>();
        genders.put(0, "Nam");
        genders.put(1, "Nữ");
        genders.put(2, "Khác");
        return genders;
    }
}
