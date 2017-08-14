package pl.raziel.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.raziel.mvc.data.entities.Resource;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/resource")
public class ResourceController {

    @RequestMapping("/add")
    public String add(Model model) {
        System.out.println("Invoking add()");
        return "resource_add";
    }

    @RequestMapping("/save")
    public String save(@ModelAttribute Resource resource) {
        System.out.println("Invoking save()");
        System.out.println(resource);
        return "redirect:/resource/add";
    }

    @ModelAttribute
    public Resource getResource() {
        System.out.println("Adding a new resource to the model.");
        return new Resource();
    }

    @ModelAttribute("typeOptions")
    public List<String> getOptions() {
        return new LinkedList<>(Arrays.asList("Material", "Other stuff", "Technical equipment"));
    }

    @ModelAttribute("radioOptions")
    public List<String> getRadios() {
        return new LinkedList<>(Arrays.asList("Hours", "Piece", "Tons"));
    }

    @ModelAttribute("checkOptions")
    public List<String> getChecks() {
        return new LinkedList<>(Arrays.asList("Lead Time", "Special Rate", "Requires Approval"));
    }
}
