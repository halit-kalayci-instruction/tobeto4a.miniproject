package com.tobeto.miniproject.core.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {
    private final long EXPIRATION = 600000;
    private final String SECRET_KEY = "b184eccfe4b9ada4fb5ed719cd8260008868621a07513ffe14d7b9116a5474ee1892a088dfaa3ea840129e1cab9a561dd8bfe74f27b0ac1884e7544c52855777";
    public String generateToken(String userName, Map<String, Object> extraClaims) {
        return Jwts
                .builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .claims(extraClaims)
                .subject(userName)
                .signWith(getSignKey())
                .compact();
    }

    public Boolean validateToken(String token)
    {
        return getClaimsFromToken(token).getExpiration().after(new Date());
    }
    public String extractUsername(String token)
    {
        return getClaimsFromToken(token).getSubject();
    }

    private Claims getClaimsFromToken(String token)
    {
        SecretKey key = (SecretKey) getSignKey();
        return Jwts
                .parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
