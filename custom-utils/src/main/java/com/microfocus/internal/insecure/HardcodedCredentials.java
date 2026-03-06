package com.microfocus.internal.insecure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Example: hardcoded credentials (will be flagged by SAST).
 */
public class HardcodedCredentials {
    private static final Logger log = LogManager.getLogger(HardcodedCredentials.class);

    private static final String USER = "admin";
    private static final String PASS = "P@ssw0rd!"; // intentional insecure example

    public String getCredentials() {
        String creds = USER + ":" + PASS;
        log.warn("Returning hardcoded credentials: {}", creds);
        return creds;
    }
}
