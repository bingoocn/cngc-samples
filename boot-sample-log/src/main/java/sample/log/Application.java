package sample.log;

/**
 * @author maxD
 */

import com.cngc.boot.core.annotation.EnableCngcBoot;
import com.cngc.boot.web.annotation.EnableCngcWebMvc;
import com.cngc.boot.web.dictionary.translate.EnableDictTranslate;
import com.cngc.boot.web.log.RequestLogAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableCngcBoot
@EnableCngcWebMvc
@EnableDictTranslate
@Import(RequestLogAspect.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
