package pl.raziel.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.raziel.mvc.data.entities.Project;
import pl.raziel.mvc.data.entities.Sponsor;
import pl.raziel.mvc.data.services.ProjectService;

@Controller
public class HomeController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/", params = "projectId")
    public String goHomeAgain(Model model, @RequestParam("projectId") Long projectId) {
        model.addAttribute("currentProject", projectService.find(projectId));
        return "home";
    }

    @RequestMapping("/")
    public String goHome(Model model) {
        Project project = new Project();

        project.setName("First project");
        project.setSponsor(new Sponsor("NASA", "0700700700", "email@email.com"));
        project.setDescription("Simple project sponsored by NASA");

        model.addAttribute("currentProject", project);
        return "welcome";
    }


}
