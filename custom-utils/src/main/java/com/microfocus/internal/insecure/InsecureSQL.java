package com.microfocus.internal.insecure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Example: SQL built via string concatenation (SQL injection risk).
 */
public class InsecureSQL {

    private static final Logger log = LogManager.getLogger(InsecureSQL.class);

    public String buildQuery(String username) {
        // Intentional insecure pattern: concatenating user input into SQL
        String q = "SELECT * FROM users WHERE username = '" + username + "'";
        log.warn("Built insecure SQL query: {}", q);
        return q;
    }
}
