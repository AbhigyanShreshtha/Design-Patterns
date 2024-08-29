package com.decorator.demo.validator;

import com.decorator.demo.model.BankAccount;

public class AddMoneyValidator extends BankAccountValidator {

    private final int amount;

    public AddMoneyValidator(BankAccountValidator nextValidator, int amount) {
        super(nextValidator);
        this.amount = amount;
    }

    @Override
    public void validate(BankAccount account) throws Exception {
        if (amount < 0) {
            throw new Exception("Amount to add cannot be negative.");
        }
        next(account);
    }
}
