package case_study.furama_resort.controller;

import case_study.furama_resort.model.contract.Contract;
import case_study.furama_resort.model.customer.Customer;
import case_study.furama_resort.model.dto.ContractDto;
import case_study.furama_resort.model.dto.CustomerDto;
import case_study.furama_resort.service.contract.IContractService;
import case_study.furama_resort.service.contract.IEmployeeService;
import case_study.furama_resort.service.customer.ICustomerService;
import case_study.furama_resort.service.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@CrossOrigin("*")
@Controller
@RequestMapping("/contracts")
public class ContractController {

//    @Autowired
//    private ICustomerService customerService;

    @Autowired
    private IContractService contractService;

//    @Autowired
//    private IEmployeeService employeeService;
//
//    @Autowired
//    private IFacilityService facilityService;

    @GetMapping
    public String list(Model model,
                       @PageableDefault(value = 3) Pageable pageable) {
        model.addAttribute("contracts", contractService.findAll(pageable));
        return "contracts/list";
    }

    @GetMapping("/{id}/delete")
    public ResponseEntity<Contract> remove(@PathVariable(value = "id") int id) {
        Optional<Contract> optionalContract = contractService.findById(id);
        if (!optionalContract.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalContract.get(), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public String remove(@RequestParam(value = "id") int id, RedirectAttributes redirect) {
        Optional<Contract> optionalContract = contractService.findById(id);
        if (!optionalContract.isPresent()) {
            redirect.addFlashAttribute("message", "Contract not found!");
        } else {
            contractService.remove(id);
            redirect.addFlashAttribute("message", "Contract removed!");
        }
        return "redirect:/contracts";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        return "contracts/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute(value = "contractDto") ContractDto contractDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirect) {
        if (!bindingResult.hasErrors()) {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            contractService.save(contract);
            redirect.addFlashAttribute("message", "Contract created successfully");
        } else {
            redirect.addFlashAttribute("message", "Contract creation failed");
            System.out.println(bindingResult.toString());
        }
        return "redirect:/contracts/create";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable(value = "id") int id, Model model, RedirectAttributes redirect) {
        Optional<Contract> optionalContract = contractService.findById(id);
        if (!optionalContract.isPresent()) {
            redirect.addFlashAttribute("message", "Contract not found!");
            return "redirect:/contracts";
        }
        ContractDto contractDto = new ContractDto();
        BeanUtils.copyProperties(optionalContract.get(), contractDto);
        model.addAttribute("contractDto", contractDto);
        return "contracts/edit";
    }

    @PostMapping("/edit")
    public String update(@Validated @ModelAttribute(value = "contractDto") ContractDto contractDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirect) {
        Optional<Contract> optionalContract = contractService.findById(contractDto.getId());
        if (!optionalContract.isPresent()) {
            redirect.addFlashAttribute("message", "Contract not found!");
            return "redirect:/contracts";
        }
        if (!bindingResult.hasErrors()) {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            contractService.save(contract);
            redirect.addFlashAttribute("message", "Contract updated successfully");
            return "redirect:/contracts";
        }
        redirect.addFlashAttribute("message", "Contract update failed");
        return "/contracts/edit";
    }

    //    @GetMapping("/{id}/delete")
//    public String remove(@PathVariable(value = "id") int id, Model model, RedirectAttributes redirect) {
//        Optional<Customer> optionalCustomer = customerService.findById(id);
//        if (!optionalCustomer.isPresent()) {
//            redirect.addFlashAttribute("message", "Customer not found!");
//            return "redirect:/customers";
//        }
//        model.addAttribute("customer", optionalCustomer.get());
//        return "customers/list";
//    }

}
