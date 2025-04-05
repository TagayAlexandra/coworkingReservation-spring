package org.example.controller;

import org.example.service.WorkSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/readWorkSpace")
public class WorkSpaceReadOperationController {


    @Autowired
    private WorkSpaceService service;

    @GetMapping("/{id}")
    public String getWorkSpaceById(@PathVariable Long id) {
        return "";
    }

    @GetMapping("/available")
    public String getAllAvailableWorkSpaces(Model model) {
        model.addAttribute("spaces", service.readAllAvailableWorkSpaces());
        return "showWorkSpaces";
    }

    @GetMapping("/booking")
    public String getBookedWorkSpaces(Model model) {
        model.addAttribute("spaces", service.readAllAvailableWorkSpaces());
        return "showWorkSpaces";
    }
}
