package com.company.validator;

import com.company.account.AccountType;
import org.springframework.beans.factory.annotation.Value;

public class AccountValidator extends BaseValidator {

    @Value("/^[a-zA-Z]{12}$/")
    private String retailAccountIdPattern;

    @Value("/^[a-zA-Z]{10}$/")
    private String corporateAccountIdPattern;

    public void validateAccountId(AccountType type, String accountId) {

        checkForNull(accountId, "Account Id can not be null");

        if (type == AccountType.RETAIL) {
            checkForPattern(retailAccountIdPattern, accountId, "Retail Account Id is null or in wrong format");
        } else if(type == AccountType.CORPORATE) {
            checkForPattern(corporateAccountIdPattern, accountId, "Corporate Account Id is null or in wrong format");
        }
    }

}
