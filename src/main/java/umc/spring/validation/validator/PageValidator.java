package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.spring.validation.annotation.ValidPage;

public class PageValidator implements ConstraintValidator<ValidPage, Integer> {

    @Override
    public void initialize(ValidPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        boolean isValid=true;

        if (value <= 0) {isValid = false;}
        else if (value > 0) {isValid = true;}

        return isValid;
    }
}
