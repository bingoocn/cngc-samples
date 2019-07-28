package sample.validation.web;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sample.validation.config.RequestParameterValidationException;
import sample.validation.entity.SampleData;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * 测试用controller.
 *
 * @author maxD
 */
@RestController
@RequestMapping("sample")
public class SampleController {

    @PostMapping
    public SampleData createSample(@Valid @RequestBody SampleData sampleData, BindingResult result) throws RequestParameterValidationException {
        List<FieldError> errors =  result.getFieldErrors();
        if(errors.size() != 0) {
            throw new RequestParameterValidationException(errors);
        }
        return sampleData;

    }

}
