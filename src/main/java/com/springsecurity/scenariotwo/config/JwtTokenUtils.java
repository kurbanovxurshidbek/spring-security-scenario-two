package com.springsecurity.scenariotwo.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenUtils {
    long expireTime = 36_000_000;
    String secretKey = "442A462D4A614E645267556B58703273357638792F423F4528482B4B62506553";

    public String generate(String username) {
        Date expireDate = new Date(System.currentTimeMillis() + expireTime);

        return Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .setSubject(username)
                .signWith(getSigningKey())
                .compact();
    }

    public boolean validate(String token) {
        return getUsername(token) != null && isExpired(token);
    }

    public String getUsername(String token) {
        Claims claims = getClaims(token);
        return claims.getSubject();
    }

    public boolean isExpired(String token) {
        Claims claims = getClaims(token);
        return claims.getExpiration().after(new Date(System.currentTimeMillis()));
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private java.security.Key getSigningKey() {
        var decoded = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(decoded);
    }
}
