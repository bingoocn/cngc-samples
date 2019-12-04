package sample.etl;

/**
 * @author maxD
 */

import com.cngc.boot.data.etl.EnableEtl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEtl
public class SampleEtlApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleEtlApplication.class, args);
    }
}
