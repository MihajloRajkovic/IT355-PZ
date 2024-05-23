package com.metropolitan.it355.IT355PZ.services;

public interface TokenBlackListService {
    void blacklistToken(String token);

    boolean isTokenBlacklisted(String token);
}
