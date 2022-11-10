package case_study.furama_resort.controller;

import case_study.furama_resort.model.dto.facility_dto.FacilityDto;
import case_study.furama_resort.model.dto.facility_dto.HouseDto;
import case_study.furama_resort.model.dto.facility_dto.RoomDto;
import case_study.furama_resort.model.dto.facility_dto.VillaDto;
import case_study.furama_resort.model.facilities.Facility;
import case_study.furama_resort.model.facilities.FacilityType;
import case_study.furama_resort.model.facilities.RentType;
import case_study.furama_resort.service.facility.IFacilityService;
import case_study.furama_resort.service.facility.IFacilityTypeService;
import case_study.furama_resort.service.facility.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@Controller
@RequestMapping("/facilities")
public class FacilityController {

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping
    public String search(@RequestParam(value = "searchName", defaultValue = "") String name,
                         @RequestParam(value = "searchFacilityType", defaultValue = "") String typeName,
                         Model model,
                         @PageableDefault(value = 3) Pageable pageable) {
        Page<Facility> facilities = facilityService.findByNameAndFacilityType(name, typeName, pageable);
        model.addAttribute("facilities", facilities);
        model.addAttribute("searchName", name);
        model.addAttribute("searchFacilityType", typeName);
        return "facilities/list";
    }

    @GetMapping("/{id}/view")
    public ResponseEntity<Facility> view(@PathVariable(value = "id") int id) {
        Optional<Facility> optionalFacility = facilityService.findById(id);
        if (!optionalFacility.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Facility facility = optionalFacility.get();
        return new ResponseEntity<>(facility, HttpStatus.OK);
    }

    @GetMapping("/{id}/delete")
    public ResponseEntity<Facility> remove(@PathVariable(value = "id") int id) {
        Optional<Facility> optionalFacility = facilityService.findById(id);
        if (!optionalFacility.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Facility facility = optionalFacility.get();
        return new ResponseEntity<>(facility, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public String remove(@RequestParam(value = "id") int id, RedirectAttributes redirect) {
        Optional<Facility> optionalFacility = facilityService.findById(id);
        if (!optionalFacility.isPresent()) {
            redirect.addFlashAttribute("message", "Facility not found!");
        } else {
            facilityService.remove(id);
            redirect.addFlashAttribute("message", "Facility removed!");
        }
        return "redirect:/facilities";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("facilityDto", new FacilityDto());
        return "facilities/create";
    }

    //    Create
    @PostMapping("/create/villa")
    public String createVilla(@Validated @ModelAttribute(value = "facilityDto") VillaDto villaDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirect,
                              Model model) {
        new VillaDto().validate(villaDto, bindingResult);
        if (!bindingResult.hasErrors()) {
            Facility facility = new Facility();
            BeanUtils.copyProperties(villaDto, facility);
            facilityService.save(facility);
            redirect.addFlashAttribute("message", "Facility created successfully");
            return "redirect:/facilities/create";
        } else {
//            FacilityDto facilityDto = new FacilityDto();
//            BeanUtils.copyProperties(villaDto, facilityDto);
//            model.addAttribute("message", "Facility creation failed");
            model.addAttribute("facilityDto", villaDto);
            return "/facilities/create";
        }
    }

    @PostMapping("/create/house")
    public String createHouse(@Validated @ModelAttribute(value = "facilityDto") HouseDto houseDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirect) {
        if (!bindingResult.hasErrors()) {
            Facility facility = new Facility();
            BeanUtils.copyProperties(houseDto, facility);
            facilityService.save(facility);
            redirect.addFlashAttribute("message", "Facility created successfully");
            return "redirect:/facilities/create";
        } else {
            redirect.addFlashAttribute("message", "Facility creation failed");
            return "/facilities/create";
        }
    }

    @PostMapping("/create/room")
    public String createRoom(@Validated @ModelAttribute(value = "facilityDto") RoomDto roomDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirect) {
        if (!bindingResult.hasErrors()) {
            Facility facility = new Facility();
            BeanUtils.copyProperties(roomDto, facility);
            facilityService.save(facility);
            redirect.addFlashAttribute("message", "Facility created successfully");
            return "redirect:/facilities/create";
        } else {
            redirect.addFlashAttribute("message", "Facility creation failed");
            return "/facilities/create";
        }
    }
    //    Create

    //Edit
    @GetMapping("/{id}/edit")
    public String update(@PathVariable(value = "id") int id, Model model, RedirectAttributes redirect) {
        Optional<Facility> optionalFacility = facilityService.findById(id);
        if (!optionalFacility.isPresent()) {
            redirect.addFlashAttribute("message", "Facility not found!");
            return "redirect:/facilities";
        }
        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(optionalFacility.get(), facilityDto);
        model.addAttribute("facilityDto", facilityDto);
        return "facilities/edit";
    }

    @PostMapping("/edit/villa")
    public String update(@Validated @ModelAttribute(value = "facilityDto") VillaDto villaDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirect) {
        Optional<Facility> optionalFacility = facilityService.findById(villaDto.getId());
        if (!optionalFacility.isPresent()) {
            redirect.addFlashAttribute("message", "Facility not found!");
            return "redirect:/facilities";
        }
        if (!bindingResult.hasErrors()) {
            Facility facility = new Facility();
            BeanUtils.copyProperties(villaDto, facility);
            facilityService.save(facility);
            redirect.addFlashAttribute("message", "Facility updated successfully");
            return "redirect:/facilities";
        }
        redirect.addFlashAttribute("message", "Facility update failed");
        return "facilities/edit";
    }

    @PostMapping("/edit/house")
    public String update(@Validated @ModelAttribute(value = "facilityDto") HouseDto houseDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirect) {
        Optional<Facility> optionalFacility = facilityService.findById(houseDto.getId());
        if (!optionalFacility.isPresent()) {
            redirect.addFlashAttribute("message", "Facility not found!");
            return "redirect:/facilities";
        }
        if (!bindingResult.hasErrors()) {
            Facility facility = new Facility();
            BeanUtils.copyProperties(houseDto, facility);
            facilityService.save(facility);
            redirect.addFlashAttribute("message", "Facility updated successfully");
            return "redirect:/facilities";
        }
        redirect.addFlashAttribute("message", "Facility update failed");
        return "facilities/edit";
    }

    @PostMapping("/edit/room")
    public String update(@Validated @ModelAttribute(value = "facilityDto") RoomDto roomDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirect) {
        Optional<Facility> optionalFacility = facilityService.findById(roomDto.getId());
        if (!optionalFacility.isPresent()) {
            redirect.addFlashAttribute("message", "Facility not found!");
            return "redirect:/facilities/";
        }
        if (!bindingResult.hasErrors()) {
            Facility facility = new Facility();
            BeanUtils.copyProperties(roomDto, facility);
            facilityService.save(facility);
            redirect.addFlashAttribute("message", "Facility updated successfully");
            return "redirect:/facilities";
        }
        redirect.addFlashAttribute("message", "Facility update failed");
        return "redirect:/facilities";
    }
    //Edit (end)

//    @PostMapping("/edit")
//    public String update(@Validated @ModelAttribute(value = "facilityDto") FacilityDto facilityDto,
//                         BindingResult bindingResult,
//                         RedirectAttributes redirect) {
//        Optional<Facility> optionalFacility = facilityService.findById(facilityDto.getId());
//        if (!optionalFacility.isPresent()) {
//            redirect.addFlashAttribute("message", "Facility not found!");
//            return "redirect:/facilities/";
//        }
//        if (!bindingResult.hasErrors()) {
//            Facility facility = new Facility();
//            BeanUtils.copyProperties(facilityDto, facility);
//            facilityService.save(facility);
//            redirect.addFlashAttribute("message", "Facility updated successfully");
//            return "redirect:/facilities/";
//        }
//        redirect.addFlashAttribute("message", "Facility update failed");
//        return "redirect:/facilities";
//    }

    //    @GetMapping("/{id}/delete")
//    public String remove(@PathVariable(value = "id") int id, Model model, RedirectAttributes redirect) {
//        Optional<Facility> optionalFacility = facilityService.findById(id);
//        if (!optionalFacility.isPresent()) {
//            redirect.addFlashAttribute("message", "Facility not found!");
//            return "redirect:/facilities";
//        }
//        model.addAttribute("facility", optionalFacility.get());
//        return "facilities/list";
//    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute(value = "facilityDto") FacilityDto facilityDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirect,
                         Model model) {

        new FacilityDto().validate(facilityDto, bindingResult);
        if (!bindingResult.hasErrors()) {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            facilityService.save(facility);
            redirect.addFlashAttribute("message", "Facility created successfully");
            return "redirect:/facilities/create";
        } else {
            model.addAttribute("message", "Facility creation failed");
            model.addAttribute("facilityDto", facilityDto);
            return "facilities/create";
        }
    }

    @ModelAttribute("facilityTypes")
    public List<FacilityType> getFacilityTypes() {
        return facilityTypeService.getFacilityTypes();
    }

    @ModelAttribute("rentTypes")
    public List<RentType> getRentTypes() {
        return rentTypeService.getRentTypes();
    }
}
