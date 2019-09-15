package top.ban.common.annotation;

import top.ban.common.AuthorityLevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface AuthLV {
    AuthorityLevel value() default AuthorityLevel.USELESS;
}
