package com.decorator.demo.controller;

import com.decorator.demo.model.BankAccount;
import com.decorator.demo.service.BankService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/bank")
public class BankController {

    private final BankService bankService = new BankService();

    @PostMapping("/makeAccount")
    public ResponseEntity<?> makeAccount(@RequestParam String userName, @RequestParam String email, @RequestParam String phoneNumber) {
        try {
            BankAccount account = bankService.makeAccount(userName, email, phoneNumber);
            return ResponseEntity.ok(account);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/addMoney")
    public ResponseEntity<?> addMoney(@RequestParam UUID userId, @RequestParam int amount) {
        try {
            bankService.addMoney(userId, amount);
            return ResponseEntity.ok("Money added successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/showBankDetails")
    public ResponseEntity<?> showBankDetails(@RequestParam UUID userId) {
        try {
            BankAccount account = bankService.showBankDetails(userId);
            return ResponseEntity.ok(account);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/withdrawMoney")
    public ResponseEntity<?> withdrawMoney(@RequestParam UUID userId, @RequestParam int amount) {
        try {
            bankService.withdrawMoney(userId, amount);
            return ResponseEntity.ok("Money withdrawn successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
