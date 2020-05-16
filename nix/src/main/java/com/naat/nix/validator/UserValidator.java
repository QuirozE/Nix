package com.naat.nix.validator;

import com.naat.nix.user.controller.UserService;
import com.naat.nix.user.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate (Object o, Errors errors) {
        User user = (User) o;

        if (user.getUsername() == null || user.getUsername().length() == 0) {
            errors.rejectValue("username", "NotEmpty");
        }
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }
        if (userService.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.userForm.email");
        }
        if (user.getEmail() == null || user.getEmail().length() == 0 ) {
            errors.rejectValue("email", "NotEmptyEmail");
        }
        if (user.getPassword() == null || user.getPassword().length() == 0) {
            errors.rejectValue("password", "NotEmptyPassword");
        }
        if (user.getPasswordConfirm() == null || user.getPasswordConfirm().length() == 0) {
            errors.rejectValue("passwordConfirm", "NotEmptyPassword");
        }
        if (user.getPassword().length() < 7 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}
