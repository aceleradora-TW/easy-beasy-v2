package com.thoughtworks.aceleradora.validators;

import com.thoughtworks.aceleradora.domain.NetPromoterScore;
import com.thoughtworks.aceleradora.domain.User;
import com.thoughtworks.aceleradora.repository.NetPromoterScoreRepository;
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
        return nomeNaoEstaVazio(user, context);
    }

    private boolean nomeNaoEstaVazio(User user, ConstraintValidatorContext context) {
        if (user.getName().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("insira seu nome completo.")
                    .addConstraintViolation();

            return false;
        }

        return true;
    }

}
