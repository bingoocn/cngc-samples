package sample.log.web;

import org.springframework.web.bind.annotation.*;
import sample.log.entity.SampleData;

/**
 * 测试用controller.
 *
 * @author maxD
 */
@RestController
@RequestMapping("sample")
public class SampleController {

    @GetMapping
    public SampleData queryData(String type) {
        SampleData sampleData = new SampleData();
        sampleData.setTypeCode(type);
        return sampleData;
    }
}
