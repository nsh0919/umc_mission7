package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.validation.annotation.CheckStore;

@Component
@RequiredArgsConstructor
public class StoresExistValidator implements ConstraintValidator <CheckStore, Long> {

    private StoreRepository storeRepository;

    @Override
    public void initialize(CheckStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {

        boolean isValid = storeRepository.existsById(id);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
