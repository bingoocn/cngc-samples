package sample.validation.constraints;

import com.cngc.boot.web.constant.RequestBodyErrorCode;

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

    String code() default RequestBodyErrorCode.INVALID_FORMAT;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
