package com.proxy.demo.service;

import com.proxy.demo.model.UserTransaction;

import java.util.List;

public interface UserTransactionService {
    List<UserTransaction> getTransactions(String userId, int offset, int limit);
}