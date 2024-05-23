package com.metropolitan.it355.IT355PZ.services.impl;

import com.metropolitan.it355.IT355PZ.services.TokenBlackListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
@AllArgsConstructor
public class TokenBlackListServiceImpl implements TokenBlackListService {

    private final Set<String> blackList = ConcurrentHashMap.newKeySet();

    @Override
    public void blacklistToken(String token) {
        System.err.println("Blacklisted token : " + token);
        blackList.add(token);

    }

    @Override
    public boolean isTokenBlacklisted(String token) {
        return blackList.contains(token);
    }
}
