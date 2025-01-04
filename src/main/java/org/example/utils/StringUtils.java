package org.example.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtils {

     public static String removeRoundBrackets(String text) {
        return text.replaceAll("[()]", "");
    }
}
