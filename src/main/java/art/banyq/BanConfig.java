package art.banyq;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import art.banyq.platform.config.SysConfig;
import art.banyq.platform.interceptor.AuthorityInterceptor;
import art.banyq.platform.interceptor.ReqInterceptor;


@Configuration
public class BanConfig implements WebMvcConfigurer {
    private ReqInterceptor reqInterceptor;
    private AuthorityInterceptor authorityInterceptor;

    public BanConfig(AuthorityInterceptor authorityInterceptor, ReqInterceptor reqInterceptor) {
        this.authorityInterceptor = authorityInterceptor;
        this.reqInterceptor = reqInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.reqInterceptor);
        registry.addInterceptor(this.authorityInterceptor);
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
