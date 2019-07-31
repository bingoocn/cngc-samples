package sample.validation.web;

import com.cngc.boot.web.exception.RequestBodyValidationException;
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
    public SampleData createSample(@Valid @RequestBody SampleData sampleData, BindingResult bindingResult) throws RequestBodyValidationException {
        if (bindingResult.hasErrors()) {
            throw new RequestBodyValidationException(bindingResult.getFieldErrors());
        }
        return sampleData;

    }


    @GetMapping
    public SampleData search(@RequestParam("code") String code, @RequestParam("name") String name) {
        SampleData sampleData = new SampleData();
        sampleData.setName("alex");
        return sampleData;
    }

}
