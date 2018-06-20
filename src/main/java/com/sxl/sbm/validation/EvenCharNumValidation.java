package com.sxl.sbm.validation;

import org.everit.json.schema.FormatValidator;

import java.util.Optional;

/**
 * @author SxL
 * Created on 6/20/2018 3:46 PM.
 */
public class EvenCharNumValidation implements FormatValidator {
    @Override
    public Optional<String> validate(String s) {
        if (s.length() % 2 == 0) {
            return Optional.empty();
        } else {
            return Optional.of(String.format("the length of string \"%s\" is odd", s));
        }
    }
}
