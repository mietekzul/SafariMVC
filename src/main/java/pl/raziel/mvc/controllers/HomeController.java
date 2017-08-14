package pl.raziel.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.raziel.mvc.data.entities.Project;
import pl.raziel.mvc.data.entities.Sponsor;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String goHome(Model model) {
        Project project = new Project();

        project.setName("First project");
        project.setSponsor(new Sponsor("NASE", "0700700700", "email@email.com"));
        project.setDescription("Simple project sponsored by NASA");

        model.addAttribute("currentProject", project);
        return "home";
    }


}
