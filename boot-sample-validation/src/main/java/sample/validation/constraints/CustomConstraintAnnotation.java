package sample.validation.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义校验注解.
 *
 * @author maxD
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomConstraintValidator.class)
public @interface CustomConstraintAnnotation {
    String message() default "内容需要时奇数!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
