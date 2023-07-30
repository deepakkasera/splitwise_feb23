package com.scaler.splitwise_feb23.strategies.settleup.passwordhashing;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordHashingStrategy implements PasswordHashingStrategy {
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public BCryptPasswordHashingStrategy(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public String hash(String originalPassword) {
        return bCryptPasswordEncoder.encode(originalPassword);
    }
}
