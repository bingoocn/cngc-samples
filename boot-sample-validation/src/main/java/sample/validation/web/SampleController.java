package sample.validation.web;

import com.cngc.boot.web.exception.RequestParameterValidationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sample.validation.entity.SampleData;

import javax.validation.Valid;

/**
 * 测试用controller.
 *
 * @author maxD
 */
@RestController
@RequestMapping("sample")
public class SampleController {

    @PostMapping
    public SampleData createSample(@Valid @RequestBody SampleData sampleData, BindingResult bindingResult) throws RequestParameterValidationException {
        if (bindingResult.hasErrors()) {
            throw new RequestParameterValidationException(bindingResult.getFieldErrors());
        }
        return sampleData;

    }

}
