package sample.validation.config;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.ServletRequestBindingException;

import java.util.List;

public class RequestParameterValidationException extends ServletRequestBindingException {

    private List<FieldError> errors;

    public RequestParameterValidationException(List<FieldError> errors) {
        super("");
        this.errors = errors;
    }

    public List<FieldError> getFieldErrors() {
        return this.errors;
    }
}
