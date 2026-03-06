package com.microfocus.internal;

import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Simple internal utility class.
 */
public class StringHelper {

    private static final Logger log = LogManager.getLogger(StringHelper.class);

    /**
     * Returns input uppercased with an exclamation.
     * For null input, returns empty string.
     */
    public static String shout(String input) {
        if (input == null) {
            log.warn("shout called with null input");
            return "";
        }
        String result = input.toUpperCase() + "!";
        log.debug("shout: input='{}' result='{}'", input, result);
        return result;
    }

    /**
     * Returns true if text contains the token (case-insensitive).
     */
    public static boolean containsIgnoreCase(String text, String token) {
        if (Objects.isNull(text) || Objects.isNull(token)) {
            log.debug("containsIgnoreCase called with nulls: text={}, token={}", text, token);
            return false;
        }
        boolean found = text.toLowerCase().contains(token.toLowerCase());
        log.debug("containsIgnoreCase: text='{}' token='{}' -> {}", text, token, found);
        return found;
    }
}
