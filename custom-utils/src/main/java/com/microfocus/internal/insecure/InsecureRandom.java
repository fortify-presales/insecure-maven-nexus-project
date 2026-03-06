package com.microfocus.internal.insecure;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Example: uses java.util.Random instead of SecureRandom for token generation.
 */
public class InsecureRandom {
    private static final Logger log = LogManager.getLogger(InsecureRandom.class);

    public static int weakToken() {
        Random r = new Random();
        int token = r.nextInt();
        log.warn("Generated weak token (java.util.Random): {}", token);
        return token;
    }
}
