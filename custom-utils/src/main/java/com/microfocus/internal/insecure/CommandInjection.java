package com.microfocus.internal.insecure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Example: demonstrates executing external commands using untrusted input.
 * WARNING: this is intentionally insecure and should NOT be invoked in production.
 */
public class CommandInjection {
    private static final Logger log = LogManager.getLogger(CommandInjection.class);

    public static void run(String cmd) throws Exception {
        // Intentional insecure call: executing user-provided command
        log.warn("Executing external command (INSECURE): {}", cmd);
        Runtime.getRuntime().exec(cmd);
    }
}
