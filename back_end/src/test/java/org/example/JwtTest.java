package org.example;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGen() {
        Map<String , Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "张三");
        // 生成 jwt 的代码
        String token = JWT.create()
                .withClaim("user", claims) // 添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12)) // 添加过期时间
                .sign(Algorithm.HMAC256("Jing")); // 指定算法，配置密钥
        System.out.println(token);
    }

    @Test
    public void testParse() {
        // 定义字符串，模拟用户传过来的 token
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9." +
                "eyJleHAiOjE2OTk5OTQ2NTEsInVzZXIiOnsiaWQiOjEsInVzZXJuYW1lIjoi5byg5LiJIn19." +
                "GcUlw4U70jF84MaRiF4peNo20WGHlZGHiJPiLrECjVo";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("Jing")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token); // 验证 token，生成一个解析后的 jwt 对象
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));
    }
}
