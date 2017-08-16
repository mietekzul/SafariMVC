package pl.raziel.mvc.data.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.raziel.mvc.data.entities.Project;

public class ProjectValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Project.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Project project = (Project) object;

        if (project.getName().length() < 5) {
            errors.rejectValue("name", "project.name", "The name is too short");
        }
    }
}
