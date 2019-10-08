package sample.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import sample.jpa.entity.SubEntity;

/**
 * @author maxD
 */
public interface SubEntityRepository extends CrudRepository<SubEntity, String> {
}
