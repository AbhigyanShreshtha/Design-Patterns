package com.decorator.demo.validator;

import com.decorator.demo.model.BankAccount;

public class WithdrawMoneyValidator extends BankAccountValidator {

    private final int amount;

    public WithdrawMoneyValidator(BankAccountValidator nextValidator, int amount) {
        super(nextValidator);
        this.amount = amount;
    }

    @Override
    public void validate(BankAccount account) throws Exception {
        if (amount < 0) {
            throw new Exception("Amount to withdraw cannot be negative.");
        }
        if (amount > account.getBankBalance()) {
            throw new Exception("Cannot withdraw more than the current balance.");
        }
        next(account);
    }
}
