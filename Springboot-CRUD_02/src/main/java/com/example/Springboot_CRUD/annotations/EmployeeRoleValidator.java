package com.example.Springboot_CRUD.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation, String> {
    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext context) {
        if (inputRole == null)
            return false;

        List<String> roles = List.of("ADMIN", "USER");
        return roles.contains(inputRole);
    }
}
