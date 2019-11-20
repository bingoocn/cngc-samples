package sample.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import sample.jpa.entity.SampleData;

/**
 * @author maxD
 */
public interface SampleRepository extends CrudRepository<SampleData, String> {
}
