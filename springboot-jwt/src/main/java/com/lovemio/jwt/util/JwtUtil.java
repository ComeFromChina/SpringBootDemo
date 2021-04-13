package com.lovemio.jwt.util;

import com.lovemio.jwt.config.JwtConfig;
import io.jsonwebtoken.*;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liwenjin
 * @date 2021年04月13日 11:10
 */
public class JwtUtil {

    // 私钥
    private static PrivateKey privateKey = null;
    // 公钥
    private static PublicKey publicKey = null;

    static {
        try {
            // keystore文件密码、私钥密码（文件密码和私钥密码设置为相同）
            String keystorePassWord = JwtConfig.keystorePassWord;

            // 加载jwt.keystore文件
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jwt.keystore");
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(inputStream, keystorePassWord.toCharArray());
            inputStream.close();

            // 加载别名
            String keyAlias = "";
            Enumeration<String> aliasEnum = keyStore.aliases();
            while (aliasEnum.hasMoreElements()) {
                keyAlias = aliasEnum.nextElement();
            }

            privateKey = (PrivateKey) keyStore.getKey(keyAlias, keystorePassWord.toCharArray());
            publicKey = keyStore.getCertificate(keyAlias).getPublicKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String generateToken(Map<String, Object> userInfoMap, String subject) {
        if (null == userInfoMap) {
            userInfoMap = new HashMap<>();
        }
        // 过期时间，单位：秒。86400等于24小时
        long expirationSeconds = Long.parseLong(JwtConfig.expirationSeconds);
        long currentTime = System.currentTimeMillis();
         JwtBuilder builder = Jwts.builder()
                .setHeaderParam("typ", "JWT") // 设置头部信息
                .setClaims(userInfoMap) // 装入自定义的用户信息
                .setIssuedAt(new Date(currentTime)) // 签发时间
                .setSubject(subject) // 说明
                .setIssuer("qf_yyh") // 签发者信息
                .signWith(SignatureAlgorithm.RS256, privateKey); //加密方式
        if (expirationSeconds > 0) {
            //设置过期时间
            builder.setExpiration(new Date(currentTime + expirationSeconds * 1000)); //过期时间戳
        }
        return builder.compact();
    }


    /**
     * 获取body某个值
     *
     * @param token
     * @param key
     * @return
     */
    public static Object getVal(Object token, String key) {
        try {
            return getClaimsBody(token).get(key);
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 验证token是否有效
     * --过期会抛 ExpiredJwtException
     * --token缺失会抛 SignatureException
     *
     * @param token
     * @return
     */
    public static boolean isExpiration(String token) {
        try {
            return getClaimsBody(token).getExpiration().before(new Date());
        } catch (ExpiredJwtException | io.jsonwebtoken.SignatureException e) {
            return true;
        }
    }

    /**
     * 获取body
     *
     * @param token
     * @return
     */
    private static Claims getClaimsBody(Object token) {
        return Jwts.parser()
                .setSigningKey(publicKey)
                .parseClaimsJws(token.toString())
                .getBody();
    }

}
