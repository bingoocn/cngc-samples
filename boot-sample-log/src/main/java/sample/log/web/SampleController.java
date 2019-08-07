package sample.log.web;

import com.cngc.boot.web.log.RequestLog;
import com.cngc.boot.web.log.RequestLogParam;
import org.springframework.web.bind.annotation.*;
import sample.log.entity.SampleData;

/**
 * 测试用controller.
 *
 * @author maxD
 */
@RestController
public class SampleController {

    @GetMapping("sample")
    @RequestLog("这是个查询请求,查询参数type值为#{type}")
    public SampleData queryData(@RequestLogParam("type") String type) {
        SampleData sampleData = new SampleData();
        sampleData.setTypeCode(type);
        return sampleData;
    }

    @GetMapping("sample2")
    public SampleData queryDataWithoutLog(String type) {
        SampleData sampleData = new SampleData();
        sampleData.setTypeCode(type);
        return sampleData;
    }

    @PostMapping("sample")
    @RequestLog("这是个新增请求,提交的数据中的嵌套对象的beanName为#{data.nestedBean.nestedBeanName}}")
    public SampleData createSampleData(@RequestBody @RequestLogParam("data") SampleData sampleData) {
        return sampleData;
    }
}
