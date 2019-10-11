package sample.jpa.repository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.beans.FeatureDescriptor;
import java.util.Arrays;

/**
 * @author maxD
 */
public class MyRepositoryImpl<T, ID>
        extends SimpleJpaRepository<T, ID> {

    private final EntityManager entityManager;
    private final JpaEntityInformation<T, ID> jpaEntityInformation;

    MyRepositoryImpl(JpaEntityInformation entityInformation,
                     EntityManager entityManager) {
        super(entityInformation, entityManager);

        this.entityManager = entityManager;
        this.jpaEntityInformation = entityInformation;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public <S extends T> S save(S entity) {
        if (jpaEntityInformation.isNew(entity)) {
            entityManager.persist(entity);
            return entity;
        } else {
            S oriEntity = (S) super.findById(jpaEntityInformation.getId(entity)).get();
            BeanWrapper dataWrapper = new BeanWrapperImpl(entity);
            String[] nullPropertyName = Arrays.stream(dataWrapper.getPropertyDescriptors())
                    .map(FeatureDescriptor::getName)
                    .filter(name -> dataWrapper.getPropertyValue(name) == null)
                    .toArray(String[]::new);
            BeanUtils.copyProperties(entity, oriEntity, nullPropertyName);
            return entityManager.merge(oriEntity);
        }
    }
}
