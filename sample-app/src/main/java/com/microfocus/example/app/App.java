package com.microfocus.example.app;

import com.microfocus.internal.StringHelper;
import com.microfocus.internal.SecurityExamples;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

    private static final Logger log = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        log.info("Starting app...");

        // Install insecure TLS settings for demo/SAST only (trusts all certs)
        try {
            InsecureTrustAllSsl.installTrustAll();
            log.warn("Installed insecure trust-all SSL manager (demo only)");
        } catch (Exception e) {
            log.error("Failed to install insecure SSL manager", e);
        }

        String message = StringHelper.shout("hello custom library");
        System.out.println(message);

        // Demonstrate security example facades (for testing / demo only)
        String query = SecurityExamples.buildInsecureQuery("alice");
        String creds = SecurityExamples.hardcodedCredentials();
        int token = SecurityExamples.weakToken();
        String hash = "";
        try {
            hash = SecurityExamples.md5("a");
        } catch (Exception e) {
            log.error("MD5 computation failed", e);
        }

        log.info("Result: {}", message);
        log.info("Insecure query: {}", query);
        log.info("Hardcoded creds: {}", creds);
        log.info("Weak token: {}", token);
        log.info("MD5('a'): {}", hash);
        log.info("Finished.");
    }
}
