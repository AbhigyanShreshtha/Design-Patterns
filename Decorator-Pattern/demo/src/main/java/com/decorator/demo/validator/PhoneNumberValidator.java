package com.decorator.demo.validator;

import com.decorator.demo.model.BankAccount;
import java.util.regex.Pattern;

public class PhoneNumberValidator extends BankAccountValidator {

    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+?[0-9. ()-]{10,15}$");

    public PhoneNumberValidator(BankAccountValidator nextValidator) {
        super(nextValidator);
    }

    @Override
    public void validate(BankAccount account) throws Exception {
        if (!PHONE_PATTERN.matcher(account.getPhoneNumber()).matches()) {
            throw new Exception("Invalid phone number format.");
        }
        next(account);
    }
}
