package org.example.utils;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtils {

    public static String getRandomDate() {
        Faker faker = new Faker();
        int year = faker.number().numberBetween(1980, 2000);
        int month = faker.number().numberBetween(1, 12);
        int day = faker.number().numberBetween(1, 28); // assuming you don't want to handle leap years

        String monthStr = String.format("%02d", month); // pad with leading zero if necessary
        String dayStr = String.format("%02d", day); // pad with leading zero if necessary

        return String.format("%d-%s-%s", year, monthStr, dayStr);
    }
}
