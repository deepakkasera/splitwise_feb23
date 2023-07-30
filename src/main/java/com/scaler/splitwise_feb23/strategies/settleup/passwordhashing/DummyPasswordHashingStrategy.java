package com.scaler.splitwise_feb23.strategies.settleup.passwordhashing;

import org.springframework.stereotype.Service;

@Service
public class DummyPasswordHashingStrategy implements PasswordHashingStrategy {
    @Override
    public String hash(String originalPassword) {
        return originalPassword + "hashed";
    }


    //BCrypt.
}
