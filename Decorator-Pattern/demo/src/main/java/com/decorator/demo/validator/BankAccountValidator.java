package com.decorator.demo.validator;

import com.decorator.demo.model.BankAccount;

public abstract class BankAccountValidator {//Decorator Pattern
    protected BankAccountValidator nextValidator;

    public BankAccountValidator(BankAccountValidator nextValidator) {
        this.nextValidator = nextValidator;
    }

    public abstract void validate(BankAccount account) throws Exception;

    protected void next(BankAccount account) throws Exception {
        if (nextValidator != null) {
            nextValidator.validate(account);
        }
    }
}