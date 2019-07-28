package sample.validation.config;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ServletExceptionHandler {

    @ExceptionHandler(RequestParameterValidationException.class)
    @ResponseBody
    public ErrorMessage handle(RequestParameterValidationException exception) {
        return new ErrorMessage(exception.getFieldErrors());
    }

    @Data
    private class ErrorMessage{
        public ErrorMessage(@NotNull List<FieldError> errors) {
            this.message = "提交的数据属性值不符合要求!";
            for(FieldError error : errors) {
                this.errors.add(new Error(error));
            }
        }
        private String message;
        private List<Error> errors = new ArrayList<>();

    }
    @Data
    private class Error{
        public Error(FieldError error) {
            this.code = error.getCode();
            this.attribute = error.getField();
            this.message = error.getDefaultMessage();
        }
        private String code;
        private String attribute;
        private String message;
    }
}
