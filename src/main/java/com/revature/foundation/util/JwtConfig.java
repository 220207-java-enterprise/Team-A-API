package com.revature.foundation.util;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.persistence.Entity;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
@ComponentScan

@Component
public class JwtConfig {

    private final String salt = "dont-hard-code-salt-values"; // use a Properties file instead
    private int expiration = 60 * 60 * 1000; // number of milliseconds in an hour
    private final SignatureAlgorithm sigAlg = SignatureAlgorithm.HS256;
    private final Key signingKey;

    public JwtConfig() {
        byte[] saltyBytes = DatatypeConverter.parseBase64Binary(salt);
        signingKey = new SecretKeySpec(saltyBytes, sigAlg.getJcaName());
    }

    public int getExpiration() {
        System.out.println("but i did not get here");
        System.out.println(expiration);
        return expiration;
    }

    public SignatureAlgorithm getSigAlg() {
        return sigAlg;
    }

    public Key getSigningKey() {
        return signingKey;
    }
}
