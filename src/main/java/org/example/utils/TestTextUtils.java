package org.example.utils;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestTextUtils {
    public static String createRandomText(){
        return new Faker().lorem().sentence(150);
    }
}
