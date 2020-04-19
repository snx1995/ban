package art.banyq.platform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:system.properties")
public class SysConfig {
    
    @Value("${token.password}")
    private String tokenPassword;

    @Value("${resource.root}")
    private String resourceRoot;
    

    public String getTokenPassword() {
        return tokenPassword;
    }

    public String getResourceRoot() {
        return resourceRoot;
    }
}