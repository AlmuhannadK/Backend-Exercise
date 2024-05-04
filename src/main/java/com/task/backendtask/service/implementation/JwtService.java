package com.task.backendtask.service.implementation;

import com.task.backendtask.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    private final String SECRET_KEY = "785c843b9b8c1386a990234f3556daff044165a94b81897b7d337f5433d1d6ff";


    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public boolean isValid(String token, UserDetails user) {
        String username = extractUsername(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // extracting specific property from token payload (func interface)
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }


    private Claims extractAllClaimsFromToken(String token) {
        return Jwts
                .parser()
                .verifyWith(getSinginKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }


    public String generateToken(User user) {
        String token = Jwts
                .builder()
                .subject(user.getUsername())
                .claim("role", user.getRole())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 24*60*60*1000 ))
                .signWith(getSinginKey())
                .compact();
        return token;
    }



    private SecretKey getSinginKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
