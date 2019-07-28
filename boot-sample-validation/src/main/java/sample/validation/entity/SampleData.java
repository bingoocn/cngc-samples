package sample.validation.entity;

import com.cngc.boot.web.dictionary.translate.DictTranslator;
import lombok.Data;
import sample.validation.constraints.CustomConstraintAnnotation;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * 测试用实体.
 *
 * @author maxD
 */
@Data
public class SampleData {


    @CustomConstraintAnnotation(message = "自定义的内容")
    private int num;

    @DictTranslator(value = "产品类型", serializeKeyName = "xxx",deSerializeKeyName = "xxx")
    private String typeCode;

    @DictTranslator(value = "选择类型")
    private String select;

    private Date date;

    @NotEmpty(message = "名字不能为空!")
    private String name;

    @Valid
    private NestedBean nestedBean;
}
