package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.PageValidator;
import umc.spring.validation.validator.StoreExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPage {

    String message() default "page는 1 이상의 정수여야 합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
