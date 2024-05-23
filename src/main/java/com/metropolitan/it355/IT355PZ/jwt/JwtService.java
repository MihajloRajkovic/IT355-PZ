package com.metropolitan.it355.IT355PZ.jwt;

import com.metropolitan.it355.IT355PZ.entity.Korisnici;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

    private final long EXPIRATION_MINUTES=30;


    private final String SECRET_KEY = "dGhpcyBpcyBteSBzZWN1cmUga2V5IGFuZCB5b3UgY2Fubm90IGhhY2sgaXQ=";


    public String generateToken(Korisnici user, Map<String, Object> extraClaims) {
        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiration = new Date(issuedAt.getTime() + (EXPIRATION_MINUTES * 60 * 1000));
        return Jwts.builder()
                .setClaims(extraClaims)
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)
                .signWith(generateKey(), SignatureAlgorithm.HS256)
                .compact();
    }


    private Key generateKey(){
        byte[] secreateAsBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(secreateAsBytes);
    }

    public String extractUsername(String jwt) {
        return extractAllClaims(jwt).get("Korisnicko_Ime", String.class);
    }

    private Claims extractAllClaims(String jwt) {
        return Jwts.parserBuilder().setSigningKey(generateKey()).build()
                .parseClaimsJws(jwt).getBody();
    }
}
