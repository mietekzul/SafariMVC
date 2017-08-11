package pl.raziel.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.raziel.mvc.data.entities.Project;

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
