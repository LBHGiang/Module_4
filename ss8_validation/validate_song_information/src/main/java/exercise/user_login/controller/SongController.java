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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
