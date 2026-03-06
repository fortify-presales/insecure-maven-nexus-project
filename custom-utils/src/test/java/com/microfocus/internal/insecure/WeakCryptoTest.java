package com.microfocus.internal.insecure;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WeakCryptoTest {
    @Test
    void md5_knownValue() throws Exception {
        assertEquals("0cc175b9c0f1b6a831c399e269772661", WeakCrypto.md5("a"));
    }
}
