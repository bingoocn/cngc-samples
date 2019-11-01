package sample.admin.config;

import com.cngc.admin.resource.server.client.TokenKeyClient;
import com.cngc.admin.resource.server.domain.TokenKey;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

/**
 * token解析所需客户端.
 *
 * @author duanyl
 */
@Component
public class TokenClient implements TokenKeyClient {

    private final static String ALG = "SHA256withRSA";

    @Override
    public TokenKey tokenKey() {
        Resource resource = new ClassPathResource("public.cert");
        String publicKey ;
        try {
            publicKey = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TokenKey key = new TokenKey();
        key.setAlg(ALG);
        key.setValue(publicKey);
        return key;
    }
}
