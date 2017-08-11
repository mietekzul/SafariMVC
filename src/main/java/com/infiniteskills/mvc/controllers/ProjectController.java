package com.infiniteskills.mvc.controllers;

import com.infiniteskills.mvc.data.entities.Project;
import com.infiniteskills.mvc.data.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

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
    public String addProject(HttpSession session) {
        session.setAttribute("token", "12345");
        System.out.println("invoking addProject");
        return "project_add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveProject(@ModelAttribute Project project) {
        System.out.println("invoking saveProject");
        System.out.println(project);
        return "project_add";
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
