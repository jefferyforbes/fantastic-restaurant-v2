package com.example.fantasticrestaurantv1.users.validation;

import java.util.function.Function;
import com.example.fantasticrestaurantv1.users.domain.User;


import static com.example.fantasticrestaurantv1.users.validation.UserValidationResult.*;

public interface UserValidator extends Function<User, UserValidationResult> {

    static UserValidator isUsername() {
        return user -> user.getUsername().length() >= 10 ? SUCCESS : USERNAME_LENGTH_TOO_SHORT;
    }

    static UserValidator isEmailValid() {
        return user -> user.getEmail().contains("@") && user.getEmail().endsWith(".com") ? SUCCESS : EMAIL_NOT_VALID;
    }

    static UserValidator isPhoneNumberValid() {
        return user -> user.getPhoneNumber().startsWith("+44")
                || user.getPhoneNumber().startsWith("07") ? SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    default UserValidator and (UserValidator other) {
        return user -> {
            UserValidationResult result = this.apply(user);
            return result.equals(SUCCESS) ? other.apply(user) : result;
        };
    }
}