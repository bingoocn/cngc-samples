package sample.dictionary.web;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sample.dictionary.entity.SampleData;

import java.util.Date;

/**
 * 测试用controller.
 *
 * @author maxD
 */
@RestController
@RequestMapping("sample")
public class SampleController {

    @GetMapping()
    public SampleData index2() {
        SampleData sd = new SampleData();
        sd.setTypeCode("01");
        sd.setSelect("02");
        sd.setDate(new Date());
        return sd;
    }

    @PostMapping()
    public SampleData createIndex(@RequestBody SampleData sd) {
        return sd;
    }
}
