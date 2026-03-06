package com.microfocus.internal.insecure;

import java.security.MessageDigest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Example: uses MD5 which is considered weak for cryptographic purposes.
 */
public class WeakCrypto {
    private static final Logger log = LogManager.getLogger(WeakCrypto.class);

    public static String md5(String input) throws Exception {
        log.warn("Using weak MD5 hashing for input (demo only)");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) sb.append(String.format("%02x", b));
        String out = sb.toString();
        log.debug("MD5('{}') = {}", input, out);
        return out;
    }
}
