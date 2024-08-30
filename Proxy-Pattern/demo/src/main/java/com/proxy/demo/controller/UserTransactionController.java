package com.proxy.demo.controller;

import com.proxy.demo.model.UserTransaction;
import com.proxy.demo.service.UserTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserTransactionController {

    @Autowired
    private UserTransactionService userTransactionService;

    @GetMapping("/transactions")
    public List<UserTransaction> getUserTransactions(
            @RequestParam("userId") String userId,
            @RequestParam("page") int page,
            @RequestParam("size") int size) {
        int offset = (page - 1) * size;
        return userTransactionService.getTransactions(userId, offset, size);
    }
}
