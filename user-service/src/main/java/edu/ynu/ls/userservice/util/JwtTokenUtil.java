package edu.ynu.ls.userservice.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenUtil {
    private static long ttl = 60 * 1000 * 60; // token有效时间1小时
    private SecretKey key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256); // 创建密钥，用于签发和验证token

    public String generateToken(String userId) { // 生成token
        Date expiryDate = new Date(new Date().getTime() + ttl); // 计算token的过期时间
        String jws = null;
        try {
            jws = Jwts.builder()
                    .claim("userId", userId)
                    .setExpiration(expiryDate)
                    .setIssuedAt(new Date())
                    .signWith(key)
                    .compact();
        } catch (JwtException ex) {
            ex.printStackTrace();
        }
        return jws;
    }

    public Claims getUsernameFromToken(String token) { // 从token中获取用户信息
        Claims claims = null;
        try {
            claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            System.out.println(claims.get("userId"));
        } catch (JwtException ex) {
            ex.printStackTrace();
        }
        return claims;
    }

    public boolean validateToken(String token) {
        try {
            return !isTokenExpired(token);
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    private boolean isTokenExpired(String token) throws Exception { // 判断token是否过期
        Date expiryDate = getExpirationDateFromToken(token);
        return expiryDate.before(new Date()); // 比较时间
    }

    private Date getExpirationDateFromToken(String token) throws IllegalArgumentException {
        Claims claims = null;
        try {
            claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getExpiration();
        } catch (IllegalArgumentException exception) {
            throw exception;
        }
    }
}
