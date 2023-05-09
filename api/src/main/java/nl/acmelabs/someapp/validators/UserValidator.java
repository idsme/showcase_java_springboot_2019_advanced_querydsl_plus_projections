package nl.acmelabs.someapp.validators;

import nl.acmelabs.someapp.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("beforeCreateUserValidator")
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {

        User user = (User) obj;
        // TODO IDSME Implement validation here.. Look above this happens if description is not filled in.. Ofcourse descriptions are not mandatory... but good test
        if (checkInputString(user.getDescription())) {
            errors.rejectValue("description", "description.empty");
        }
    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
}
