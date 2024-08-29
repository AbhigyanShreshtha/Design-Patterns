package com.decorator.demo.validator;

import com.decorator.demo.model.BankAccount;

public class UserNameValidator extends BankAccountValidator {

    public UserNameValidator(BankAccountValidator nextValidator) {
        super(nextValidator);
    }

    @Override
    public void validate(BankAccount account) throws Exception {
        if (!account.getUserName().matches("[A-Za-z ]+")) {
            throw new Exception("Invalid user name. Only English letters and spaces allowed.");
        }
        next(account);
    }
}
