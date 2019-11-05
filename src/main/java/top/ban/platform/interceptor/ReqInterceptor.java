package top.ban.platform.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import top.ban.platform.authority.UserToken;
import top.ban.platform.authority.UserTokenService;
import top.ban.platform.variable.SysConstVar;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class ReqInterceptor extends HandlerInterceptorAdapter {
    private static final String AUTHORIZATION_HEADER = "Authorization";

    private UserTokenService tokenService;

    public ReqInterceptor(UserTokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tokenStr = request.getParameter(SysConstVar.TOKEN_KEY);
        if (tokenStr == null) tokenStr = request.getHeader(AUTHORIZATION_HEADER);
        if (tokenStr != null) {
            HttpSession session = request.getSession();
            UserToken token = (UserToken) session.getAttribute(SysConstVar.SESSION_TOKEN);
            if (token == null || !token.toString().equals(tokenStr)) {
                token = tokenService.decode(tokenStr);
                session.setAttribute(SysConstVar.SESSION_TOKEN, token);
            }
        }
        return true;
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
