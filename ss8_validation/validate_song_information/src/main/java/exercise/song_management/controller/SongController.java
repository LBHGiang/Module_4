package exercise.user_login.controller;

import exercise.user_login.dto.SongDto;
import exercise.user_login.model.Song;
import exercise.user_login.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping("/")
    public String showAll(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "song/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "song/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute SongDto songDto,
                         BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            songService.save(song);
            model.addAttribute("message", "Added song successfully");
        } else {
            model.addAttribute("message", "Add new song failure");
        }
        return "song/create";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model) {
        model.addAttribute("songDto", songService.findById(id));
        return "song/edit";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute SongDto songDto,
                       BindingResult bindingResult, Model model, RedirectAttributes redirect) {
        if (!bindingResult.hasErrors()) {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            songService.save(song);
            redirect.addFlashAttribute("message", "Edit song successfully");
            return "redirect:/";
        } else {
            model.addAttribute("message", "Edit new song failure");
            return "song/edit";
        }
    }

}
