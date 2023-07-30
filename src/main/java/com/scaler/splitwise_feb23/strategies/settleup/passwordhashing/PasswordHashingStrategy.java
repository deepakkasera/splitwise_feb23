package com.scaler.splitwise_feb23.strategies.settleup.passwordhashing;

public interface PasswordHashingStrategy {
    String hash(String originalPassword);
}
