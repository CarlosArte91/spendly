package com.ccruz.spendly.util;

import com.ccruz.spendly.exception.InvalidIdException;

public class Validation {

    public static void validateId(Long id) {
        if (id <= 0) {
            throw new InvalidIdException("The ID must be a positive number and cannot be null.");
        }
    }

}
