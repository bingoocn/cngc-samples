package sample.validation.constraints;

import org.springframework.beans.factory.annotation.Autowired;
import sample.validation.service.SampleService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义校验器.
 *
 * @author maxD
 */
public class CustomConstraintValidator implements ConstraintValidator<CustomConstraintAnnotation, Integer> {

    @Autowired
    private SampleService sampleService;

    @Override
    public void initialize(CustomConstraintAnnotation constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return sampleService.isOdd(value);
    }
}
