package exercise.blog_management.controller;

import exercise.blog_management.model.Blog;
import exercise.blog_management.service.blog_service.IBlogService;
import exercise.blog_management.service.category_rervice.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping({"/blog", "/"})
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String list(Model model,
                       @PageableDefault(value = 2) Pageable pageable) {
        model.addAttribute("blogs", blogService.findAll(pageable));
        model.addAttribute("categories", categoryService.findAll());
        return "blog/list";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        return "blog/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Blog blog, RedirectAttributes redirect) {
        blogService.remove(blog);
        redirect.addFlashAttribute("message", "Successfully removed");
        return "redirect:/blog";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());
        return "blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirect) {
        blog.setTime(new Date().toString());
        blogService.save(blog);
        redirect.addFlashAttribute("message", "Successfully added");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        return "blog/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog, RedirectAttributes redirect) {
        blog.setTime(new Date().toString());
        blogService.update(blog);
        redirect.addFlashAttribute("message", "Successfully updated");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/view")
    public String details(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String searchTitle, Model model) {
        List<Blog> blogs = blogService.findByTitle(searchTitle);
        model.addAttribute("blogs", blogs);
        return "blog/list";
    }
}
