package com.company.validator;

import com.company.account.AccountType;

import java.util.regex.Pattern;

public class AccountValidator extends BaseValidator {

    public void validateAccountId(AccountType type, String accountId) {

        checkForNull(accountId, "Account Id can not be null");

        if (type == AccountType.RETAIL) {
            checkForPattern("/^[a-zA-Z]{12}$/", accountId, "RETAIL Account Id is null or in wrong format");
        } else if(type == AccountType.CORPORATE) {
            checkForPattern("/^[a-zA-Z]{10}$/", accountId, "CORPORATE Account Id is null or in wrong format");
        }
    }

}
