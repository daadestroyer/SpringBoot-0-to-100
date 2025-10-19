package com.example.Springboot_CRUD.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD})
@Documented
@Constraint(validatedBy = PasswordValidator.class)
public @interface ValidPassword {
    String message() default "Password must be at least 10 characters long and contain at least one uppercase letter, one lowercase letter, and one special character.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
