package com.company.validator;

import java.util.regex.Pattern;

public class BaseValidator {

    public void checkForNull(Object aObject, String errorMessage) {
        if (aObject == null) {
            throw new NullPointerException(errorMessage);
        }
    }

    public void checkForNull(Object aObject) {
        checkForNull(aObject, "Value ca not be null");
    }

    public void checkForPattern(String pattern, String value, String errorMessage) {
        if(!Pattern.matches(pattern, value)) {
            throw new RuntimeException(errorMessage);
        }
    }

    public void checkForPattern(String pattern, String value) {
        checkForPattern(pattern, value, "Invalid Format");
    }
}
