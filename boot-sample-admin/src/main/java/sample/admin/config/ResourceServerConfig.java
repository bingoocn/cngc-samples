package sample.admin.config;

import com.cngc.admin.resource.server.config.ResourceServerConfigAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * 访问权限控制
 *
 * @author guorun
 * @date 2019年7月17日
 */
@Configuration
public class ResourceServerConfig extends ResourceServerConfigAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .authorizeRequests()
                .anyRequest().authenticated();
    }
}
