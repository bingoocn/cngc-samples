package sample.validation.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 用于嵌套测试的类.
 *
 * @author maxD
 */
@Data
class NestedBean {
    @NotEmpty
    private String nestedBeanName;
}
