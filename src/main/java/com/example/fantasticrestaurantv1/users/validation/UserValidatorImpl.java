package com.example.fantasticrestaurantv1.users.validation;

import com.example.fantasticrestaurantv1.users.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserValidatorImpl implements UserValidator {
    @Override
    public UserValidationResult apply(User user) {
        return UserValidator.isUsername()
                .and(UserValidator.isEmailValid())
                .and(UserValidator.isPhoneNumberValid())
                .apply(user);
    }
}