package com.thoughtworks.aceleradora.validators.annotations;

import com.thoughtworks.aceleradora.validators.UserValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UserValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface UserValid {
    String message() default "Dados Invalidos";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}