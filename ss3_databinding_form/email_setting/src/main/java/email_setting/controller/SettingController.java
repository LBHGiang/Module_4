package email_setting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import email_setting.model.Setting;
import email_setting.service.ISettingService;

@Controller
@RequestMapping()
public class SettingController {

    @Autowired
    private ISettingService service;

    @ModelAttribute
    public Setting setting() {
        return service.getSetting();
    }

    @GetMapping("/setting")
    public String showSetting(Model model) {
        model.addAttribute("languages", service.getLanguages());
        model.addAttribute("pageSizes", service.getPageSizes());
        return "setting";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("setting") Setting setting,
                         RedirectAttributes redirect) {
        service.updateSetting(setting);
        redirect.addFlashAttribute("message", "Setting updated successfully");
        return "redirect:/setting";
    }
}
