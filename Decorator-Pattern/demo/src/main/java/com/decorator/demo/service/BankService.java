package com.decorator.demo.service;

import com.decorator.demo.model.BankAccount;
import com.decorator.demo.validator.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BankService {
    private final Map<UUID, BankAccount> bankAccounts = new HashMap<>();

    public BankAccount makeAccount(String userName, String email, String phoneNumber) throws Exception {
        BankAccount account = new BankAccount.Builder()
                .userName(userName)
                .userId(UUID.randomUUID())
                .bankBalance(0)
                .phoneNumber(phoneNumber)
                .email(email)
                .build();

        // Apply validations
        BankAccountValidator validator = new UserNameValidator(
                new EmailValidator(
                        new PhoneNumberValidator(null)
                )
        );
        validator.validate(account);

        bankAccounts.put(account.getUserId(), account);
        return account;
    }

    public void addMoney(UUID userId, int amount) throws Exception {
        BankAccount account = getBankAccount(userId);

        // Validate adding money
        BankAccountValidator validator = new AddMoneyValidator(null, amount);
        validator.validate(account);

        // Update account
        BankAccount updatedAccount = new BankAccount.Builder()
                .userName(account.getUserName())
                .userId(account.getUserId())
                .bankBalance(account.getBankBalance() + amount)
                .phoneNumber(account.getPhoneNumber())
                .email(account.getEmail())
                .build();

        bankAccounts.put(userId, updatedAccount);
    }

    public BankAccount showBankDetails(UUID userId) {
        return getBankAccount(userId);
    }

    public void withdrawMoney(UUID userId, int amount) throws Exception {
        BankAccount account = getBankAccount(userId);

        // Validate withdrawing money
        BankAccountValidator validator = new WithdrawMoneyValidator(null, amount);
        validator.validate(account);

        // Update account
        BankAccount updatedAccount = new BankAccount.Builder()
                .userName(account.getUserName())
                .userId(account.getUserId())
                .bankBalance(account.getBankBalance() - amount)
                .phoneNumber(account.getPhoneNumber())
                .email(account.getEmail())
                .build();

        bankAccounts.put(userId, updatedAccount);
    }

    private BankAccount getBankAccount(UUID userId) {
        if (!bankAccounts.containsKey(userId)) {
            throw new IllegalArgumentException("Bank account not found");
        }
        return bankAccounts.get(userId);
    }
}
