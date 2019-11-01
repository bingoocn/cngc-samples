package sample.admin;

import com.cngc.boot.core.annotation.EnableCngcBoot;
import com.cngc.boot.security.annotation.EnableCngcSecurity;
import com.cngc.boot.web.annotation.EnableCngcWebMvc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author maxD
 */
@SpringBootApplication
@EnableCngcBoot
@EnableCngcWebMvc
@EnableCngcSecurity
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
