package sample.jpa;

/**
 * @author maxD
 */

import com.cngc.boot.core.annotation.EnableCngcBoot;
import com.cngc.boot.web.annotation.EnableCngcWebMvc;
import com.cngc.boot.web.dictionary.translate.EnableDictTranslate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import sample.jpa.repository.MyRepositoryImpl;

@SpringBootApplication
@EnableCngcBoot
@EnableCngcWebMvc
@EnableDictTranslate
@EnableJpaRepositories(repositoryBaseClass = MyRepositoryImpl.class)
public class SampleJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleJpaApplication.class, args);
    }
}
