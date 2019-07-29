package sample.validation;

/**
 * @author maxD
 */

import com.cngc.boot.core.annotation.EnableCngcBoot;
import com.cngc.boot.web.annotation.EnableCngcWebMvc;
import com.cngc.boot.web.dictionary.translate.EnableDictTranslate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCngcBoot
@EnableCngcWebMvc
@EnableDictTranslate
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
