package com.example.api.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.*;

public class TokenUtils {

    private final static String ACCESS_TOKEN_SECRET = "12345ASFAsdasjdAHDJHSDAHJAhd&&/sdasd%asd12tgew4dvs";
    private final static long ACCESS_TOKEN_VALIDITY_SECONDS = 600L;

    public static String createToken (String id, String name, String lastname){
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
        Map<String, Object> extra = new HashMap<>();
        extra.put("name", name);
        extra.put("lastname",lastname);

        return Jwts.builder()
                .setSubject(id)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String id = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(Long.parseLong(id), null, Collections.emptyList());
        } catch (JwtException jwtException){
            System.out.println("Error token utils get autentication");
            return null;
        }
    }


}
