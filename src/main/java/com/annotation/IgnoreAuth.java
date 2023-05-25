package com.annotation;

import java.lang.annotation.*;

/**
 * 忽略Token验证,身份标识，每次请求都会带上验证，登录时不需要验证，其他时候都需要
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreAuth {

}
