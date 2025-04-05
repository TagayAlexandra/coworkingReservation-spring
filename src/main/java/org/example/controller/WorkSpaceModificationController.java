package org.example.controller;


import org.example.dto.OnCreate;
import org.example.dto.OnUpdate;
import org.example.dto.WorkSpaceDto;
import org.example.service.WorkSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/modifyWorkSpace")
public class WorkSpaceModificationController {
    @Autowired
    private WorkSpaceService service;


    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("space", new WorkSpaceDto());
        return "createWorkSpaceForm";
    }

    @PostMapping("/create")
    public String createWorkSpace(@ModelAttribute("space") @Validated(OnCreate.class) WorkSpaceDto workSpaceDto,
                                  BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "createWorkSpaceForm";
        }
        service.create(workSpaceDto);
        return "redirect:/admin";
    }

    @GetMapping("/update")
    public String updateForm(Model model) {
        model.addAttribute("space", new WorkSpaceDto());
        return "updateWorkSpaceForm";
    }

    @PostMapping("/update")
    public String updateWorkSpace(@ModelAttribute("space") @Validated(OnUpdate.class) WorkSpaceDto workSpaceDto,
                                  BindingResult result) {
        if (result.hasErrors()) {
            return "updateWorkSpaceForm";
        }
        service.update(workSpaceDto);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/admin";

    }


}
