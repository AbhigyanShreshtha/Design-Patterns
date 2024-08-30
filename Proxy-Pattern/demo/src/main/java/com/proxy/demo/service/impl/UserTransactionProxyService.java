package com.proxy.demo.service.impl;

import com.proxy.demo.model.UserTransaction;
import com.proxy.demo.service.UserTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserTransactionProxyService implements UserTransactionService {

    private static final int CACHE_LIMIT = 200; // Number of transactions to cache
    private static final String CACHE_KEY_PREFIX = "user_transactions:";

    @Autowired
    private RedisTemplate<String, List<UserTransaction>> redisTemplate;

    @Autowired
    private RealUserTransactionService realUserTransactionService;

    @Override
    public List<UserTransaction> getTransactions(String userId, int offset, int limit) {
        String cacheKey = CACHE_KEY_PREFIX + userId;
        ValueOperations<String, List<UserTransaction>> operations = redisTemplate.opsForValue();

        List<UserTransaction> cachedTransactions = operations.get(cacheKey);

        if (cachedTransactions == null || cachedTransactions.size() < offset + limit) {
            // Fetch from PostgreSQL and cache
            int dbOffset = offset / CACHE_LIMIT * CACHE_LIMIT;
            cachedTransactions = realUserTransactionService.getTransactions(userId, dbOffset, CACHE_LIMIT);
            operations.set(cacheKey, cachedTransactions, 10, TimeUnit.MINUTES);
        }

        // Calculate the start and end index for the paginated response
        int start = offset % CACHE_LIMIT;
        int end = Math.min(start + limit, cachedTransactions.size());

        return cachedTransactions.subList(start, end);
    }
}
