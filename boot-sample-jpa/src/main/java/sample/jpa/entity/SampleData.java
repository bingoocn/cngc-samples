package sample.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

/**
 * 测试用实体.
 *
 * @author maxD
 */
@Data
@Entity
public class SampleData {
    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String id;

    private String typeCode;

    private String name;

    @Transient
    private List<SubEntity> modifiedSubEntities;
}
