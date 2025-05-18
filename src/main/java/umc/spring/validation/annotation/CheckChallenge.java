package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.CheckChallengeValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckChallengeValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckChallenge {

    String message() default "해당 미션은 이미 진행중입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
