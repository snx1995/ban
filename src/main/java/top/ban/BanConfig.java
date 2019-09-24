package top.ban;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import top.ban.platform.component.SysEventBus;
import top.ban.platform.handler.BanArgumentsHandler;
import top.ban.platform.handler.BanReturnValueHandler;
import top.ban.platform.interceptor.AuthorityInterceptor;
import top.ban.platform.interceptor.ReqInterceptor;
import top.ban.platform.interceptor.ResInterceptor;

import java.util.List;

@Configuration
public class BanConfig implements WebMvcConfigurer {
    private ReqInterceptor reqInterceptor;
    private ResInterceptor resInterceptor;
    private BanReturnValueHandler returnValueHandler;
    private BanArgumentsHandler argumentsHandler;
    private AuthorityInterceptor authorityInterceptor;

    public BanConfig(ResInterceptor resInterceptor, BanReturnValueHandler returnValueHandler, BanArgumentsHandler argumentsHandler, AuthorityInterceptor authorityInterceptor, ReqInterceptor reqInterceptor) {
        this.resInterceptor = resInterceptor;
        this.returnValueHandler = returnValueHandler;
        this.argumentsHandler = argumentsHandler;
        this.authorityInterceptor = authorityInterceptor;
        this.reqInterceptor = reqInterceptor;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(this.argumentsHandler);
    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        handlers.add(this.returnValueHandler);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.reqInterceptor);
        registry.addInterceptor(this.authorityInterceptor);
        registry.addInterceptor(this.resInterceptor);
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
