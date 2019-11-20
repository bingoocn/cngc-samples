package sample.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import sample.jpa.entity.SampleData;
import sample.jpa.entity.SubEntity;
import sample.jpa.repository.SampleRepository;
import sample.jpa.repository.SubEntityRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maxD
 */
@Service
public class SampleService {

    @Autowired
    private SampleRepository sampleRepository;

    @Autowired
    private SubEntityRepository subEntityRepository;

    public SampleData save(SampleData sampleData) {
        SampleData result = sampleRepository.save(sampleData);
        List<SubEntity> subEntities = new ArrayList<>();
        if(!CollectionUtils.isEmpty(sampleData.getModifiedSubEntities())) {
            for(SubEntity subEntity : sampleData.getModifiedSubEntities()) {
                subEntity.setMainId(sampleData.getId());
                subEntities.add(subEntityRepository.save(subEntity));
            }
        }
        result.setModifiedSubEntities(subEntities);
        return result;
    }
}
