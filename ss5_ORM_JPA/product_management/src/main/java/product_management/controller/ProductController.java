package product_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import product_management.model.Product;
import product_management.service.IProductService;

import java.util.List;

@Controller
@RequestMapping({"/product","/"})
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/list";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Product product, RedirectAttributes redirect) {
        productService.remove(product);
        redirect.addFlashAttribute("message", "Successfully removed");
        return "redirect:/product";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product, RedirectAttributes redirect) {
        productService.save(product);
        redirect.addFlashAttribute("message", "Successfully added");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product, RedirectAttributes redirect) {
        productService.update(product);
        redirect.addFlashAttribute("message", "Successfully updated");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String details(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String searchName, Model model) {
        List<Product> products = productService.findByName(searchName);
        model.addAttribute("products", products);
        return "product/list";
    }
}
