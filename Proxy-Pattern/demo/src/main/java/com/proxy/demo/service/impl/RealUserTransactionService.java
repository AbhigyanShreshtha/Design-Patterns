package com.proxy.demo.service.impl;

import com.proxy.demo.model.UserTransaction;
import com.proxy.demo.service.UserTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealUserTransactionService implements UserTransactionService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String QUERY = "SELECT userId, timestamp, amount, method FROM user_transactions WHERE userId = ? ORDER BY timestamp DESC LIMIT ? OFFSET ?";

    @Override
    public List<UserTransaction> getTransactions(String userId, int offset, int limit) {
        return jdbcTemplate.query(QUERY, (rs, rowNum) -> {
            UserTransaction transaction = new UserTransaction();
            transaction.setUserId(rs.getString("userId"));
            transaction.setTimestamp(rs.getLong("timestamp"));
            transaction.setAmount(rs.getDouble("amount"));
            transaction.setMethod(rs.getString("method"));
            return transaction;
        }, userId, limit, offset); // Parameters passed directly as varargs
    }
}