package org.example.utils;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PasswordUtils {

    public static String createRandomPassword() {
        return new Faker().internet().password();
    }
}
