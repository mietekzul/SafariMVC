package com.infiniteskills.mvc.controllers;

import com.infiniteskills.mvc.data.entities.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String goHome(Model model) {
        Project project = new Project();

        project.setName("First project");
        project.setSponsor("NASA");
        project.setDescription("Simple project sponsored by NASA");

        model.addAttribute("currentProject", project);
        return "home";
    }


}
