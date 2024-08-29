package com.decorator.demo.validator;

import com.decorator.demo.model.BankAccount;
import java.util.regex.Pattern;

public class EmailValidator extends BankAccountValidator {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public EmailValidator(BankAccountValidator nextValidator) {
        super(nextValidator);
    }

    @Override
    public void validate(BankAccount account) throws Exception {
        if (!EMAIL_PATTERN.matcher(account.getEmail()).matches()) {
            throw new Exception("Invalid email format.");
        }
        next(account);
    }
}
