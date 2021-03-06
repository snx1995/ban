package art.banyq.platform.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import art.banyq.common.AuthorityLevel;
import art.banyq.common.ResStatus;
import art.banyq.common.annotation.AuthLV;
import art.banyq.common.exception.ReqHandleException;
import art.banyq.platform.authority.UserToken;
import art.banyq.platform.variable.SysConstVar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AuthorityInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        UserToken token = (UserToken) session.getAttribute(SysConstVar.SESSION_TOKEN);
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            AuthLV classLv = method.getBeanType().getAnnotation(AuthLV.class);
            AuthLV methodLv = method.getMethod().getAnnotation(AuthLV.class);
            if (token == null && (classLv != null || methodLv != null)) throw new ReqHandleException(ResStatus.AUTH_FAILED);
            else if (token != null) {
                AuthorityLevel userLv = token.getAuthLevel();
                if (classLv != null && userLv.higherThan(classLv.value())) throw new ReqHandleException(ResStatus.AUTH_FAILED);
                if (methodLv != null && userLv.higherThan(methodLv.value())) throw new ReqHandleException(ResStatus.AUTH_FAILED);
            }
            return true;
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
