package com.microfocus.internal;

import com.microfocus.internal.insecure.CommandInjection;
import com.microfocus.internal.insecure.HardcodedCredentials;
import com.microfocus.internal.insecure.InsecureRandom;
import com.microfocus.internal.insecure.InsecureSQL;
import com.microfocus.internal.insecure.UnsafeDeserialization;
import com.microfocus.internal.insecure.WeakCrypto;

/**
 * Public facade exposing (intentionally insecure) examples for external use.
 * These delegate to the examples in `com.microfocus.internal.insecure`.
 */
public class SecurityExamples {

    public static String buildInsecureQuery(String username) {
        InsecureSQL s = new InsecureSQL();
        return s.buildQuery(username);
    }

    public static String hardcodedCredentials() {
        HardcodedCredentials c = new HardcodedCredentials();
        return c.getCredentials();
    }

    public static String md5(String input) throws Exception {
        return WeakCrypto.md5(input);
    }

    public static int weakToken() {
        return InsecureRandom.weakToken();
    }

    public static void runCommand(String cmd) throws Exception {
        CommandInjection.run(cmd);
    }

    public static Object unsafeDeserialize(byte[] data) throws Exception {
        return UnsafeDeserialization.deserialize(data);
    }
}
