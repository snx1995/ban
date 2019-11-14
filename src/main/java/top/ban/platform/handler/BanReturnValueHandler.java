package top.ban.platform.handler;

import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import top.ban.common.ReqResult;

import java.io.IOException;
import java.util.List;

@Component
public class BanReturnValueHandler extends RequestResponseBodyMethodProcessor {
    public BanReturnValueHandler(List<HttpMessageConverter<?>> converters) {
        super(converters);
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return true;
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws IOException, HttpMediaTypeNotAcceptableException, HttpMessageNotWritableException {
        if (!(returnValue instanceof ReqResult)) {
            returnValue = new ReqResult().succeeded(returnValue);
        }
        super.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
    }
}
