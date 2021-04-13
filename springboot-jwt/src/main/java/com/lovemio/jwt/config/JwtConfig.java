package com.lovemio.jwt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author liwenjin
 * @date 2021年04月13日 11:23
 */
@Component
public class JwtConfig {


    /**
     * header参数名
     */
    public static String headerKey;

    /**
     * 过期时间，86400等于24小时
     */
    public static String expirationSeconds;

    /**
     * token开头值
     */
    public static String tokenHeader;

    /**
     * 文件密码
     */
    public static String keystorePassWord;

    @Value("${jwt.headerKey}")
    public void setHeaderKey(String headerKey) {
        JwtConfig.headerKey = headerKey;
    }

    @Value("${jwt.tokenHeader}")
    public void setTokenHeader(String tokenHeader) {
        JwtConfig.tokenHeader = tokenHeader;
    }

    @Value("${jwt.expirationSeconds:86400}")
    public void setExpirationSeconds(String expirationSeconds) {
        JwtConfig.expirationSeconds = expirationSeconds;
    }

    @Value("${jwt.keystorePassWord}")
    public void setKeystorePassWord(String keystorePassWord) {
        JwtConfig.keystorePassWord = keystorePassWord;
    }


}