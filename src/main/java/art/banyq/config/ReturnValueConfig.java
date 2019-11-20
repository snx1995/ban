package art.banyq.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import art.banyq.platform.handler.BanReturnValueHandler;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ReturnValueConfig implements InitializingBean {
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;
    private BanReturnValueHandler returnValueHandler;

    public ReturnValueConfig(RequestMappingHandlerAdapter requestMappingHandlerAdapter, BanReturnValueHandler returnValueHandler) {
        this.requestMappingHandlerAdapter = requestMappingHandlerAdapter;
        this.returnValueHandler = returnValueHandler;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        List<HandlerMethodReturnValueHandler> list = new ArrayList<>();
        list.add(this.returnValueHandler);
        requestMappingHandlerAdapter.setReturnValueHandlers(list);
    }
}
