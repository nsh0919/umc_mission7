package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.validation.annotation.CheckChallenge;

@Component
@RequiredArgsConstructor
public class CheckChallengeValidator implements ConstraintValidator<CheckChallenge, MissionStatus> {


    @Override
    public void initialize(CheckChallenge constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MissionStatus status, ConstraintValidatorContext context) {

        boolean result=false;

        if (status == MissionStatus.CHALLENGING) {
            result = true;
        }
        else if (status == MissionStatus.COMPLETE) {
            result = false;
        }

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(ErrorStatus.ALREADY_COMPLETED.toString()).addConstraintViolation();

        return result;
    }
}
