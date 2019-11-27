package com.thoughtworks.aceleradora.validators;

import com.thoughtworks.aceleradora.domain.User;
import com.thoughtworks.aceleradora.repository.UserRepository;
import com.thoughtworks.aceleradora.validators.annotations.UserValid;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserValidator implements ConstraintValidator<UserValid, User> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void initialize(UserValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        return isNameValid(user, context) &&
                isEmailValid(user, context);
    }

    private boolean isNameValid(User user, ConstraintValidatorContext context) {
        if (user.getName().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("Insira seu nome completo.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

    private boolean isEmailValid(User user, ConstraintValidatorContext context) {
        if (user.getEmail().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("Insira seu email completo.")
                    .addConstraintViolation();

            return false;
        }
        return true;
    }

}
