package pl.raziel.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.raziel.mvc.data.entities.Project;
import pl.raziel.mvc.data.services.ProjectService;
import pl.raziel.mvc.data.validators.ProjectValidator;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "find/{projectId}")
    public @ResponseBody
    Project findProjectObject(Model model, @PathVariable("projectId") Long projectId) {
        return projectService.find(projectId);
    }

    @RequestMapping(value = "/{projectId}")
    public String findProject(Model model, @PathVariable("projectId") Long projectId) {
        model.addAttribute("project", this.projectService.find(projectId));
        return "project";
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String find(Model model) {
        System.out.println("invoking find");
        model.addAttribute("projects", this.projectService.findAll());
        return "projects";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addProject(Model model) {
        model.addAttribute("types", new ArrayList<>(Arrays.asList("", "Single Year", "Multi Year")));

        model.addAttribute("project", new Project());

        return "project_add";
    }

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String saveProject(@Valid @ModelAttribute Project project, Errors errors) {
//        if (!errors.hasErrors()) {
//            System.out.println("The Project validated");
//        } else {
//            System.out.println("The project did not validate");
//            return "project_add";
//        }
//
//        System.out.println(project);
//        return "project_add";
//    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveProject(@Valid @ModelAttribute Project project, Errors errors, RedirectAttributes attributes) {
        project.setProjectId(55L);
        projectService.save(project);
        attributes.addFlashAttribute("project", project);
        return "redirect:/";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new ProjectValidator());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, params = {"type=multi"})
    public String saveMultiYearProject() {
        System.out.println("invoking saveMultiYearProject");
        return "project_add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, params = {"type=multi", "special"})
    public String saveSpecialProject() {
        System.out.println("invoking saveSpecialProject");
        return "project_add";
    }
}
