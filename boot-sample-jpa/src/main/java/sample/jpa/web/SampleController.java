package sample.jpa.web;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.jpa.entity.SampleData;
import sample.jpa.service.SampleService;

import java.util.Date;

/**
 * 测试用controller.
 *
 * @author maxD
 */
@RestController
@RequestMapping("sample")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @PostMapping()
    public SampleData createIndex(@RequestBody SampleData sd) {
        sampleService.save(sd);
        return sd;
    }

    @PutMapping()
    public SampleData update(@RequestBody SampleData sd) {
        sampleService.save(sd);
        return sd;
    }
}
