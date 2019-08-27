package sample.log.service;

import com.cngc.boot.web.dictionary.service.DictTranslateService;
import org.springframework.stereotype.Service;


@Service
public class DictTranslateServiceImpl implements DictTranslateService {

    @Override
    public String translateCodeToDisplayName(String type, String code) {
        return type + code;
    }
}
