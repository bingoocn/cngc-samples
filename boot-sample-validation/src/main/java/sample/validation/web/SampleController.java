package sample.validation.web;

import com.cngc.boot.web.constant.RequestBodyErrorCode;
import com.cngc.boot.web.exception.RequestBodyValidationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import sample.validation.entity.SampleData;

import javax.validation.Valid;
import java.util.Arrays;

/**
 * 测试用controller.
 *
 * @author maxD
 */
@RestController
@RequestMapping("sample")
public class SampleController {

    @PutMapping
    public SampleData updateSample(@Valid @RequestBody SampleData sampleData) {
        return sampleData;
    }

    @PostMapping
    public SampleData createSample(@Valid @RequestBody SampleData sampleData, BindingResult bindingResult) throws RequestBodyValidationException {
        // 手动进行请求体数据校验,抛出异常.
        FieldError fieldError = new FieldError("", "id", null, false,
                new String[]{RequestBodyErrorCode.ALREADY_EXISTS}, null, "新增资源已存在");
        throw new RequestBodyValidationException(Arrays.asList(new FieldError[]{fieldError}));
    }


    @GetMapping
    public SampleData search(@RequestParam("code") String code, @RequestParam("name") String name) {
        SampleData sampleData = new SampleData();
        sampleData.setName("alex");
        return sampleData;
    }

}
