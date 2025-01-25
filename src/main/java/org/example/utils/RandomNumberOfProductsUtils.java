package org.example.utils;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RandomNumberOfProductsUtils {

    public static Integer getRandomNumberOfProducts() {
        return new Faker().random().nextInt(1, 5);
    }
}
