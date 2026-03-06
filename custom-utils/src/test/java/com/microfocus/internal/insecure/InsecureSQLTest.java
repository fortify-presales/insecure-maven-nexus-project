package com.microfocus.internal.insecure;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InsecureSQLTest {
    @Test
    void buildQuery_includesUsername() {
        InsecureSQL s = new InsecureSQL();
        String q = s.buildQuery("alice");
        assertTrue(q.contains("alice"));
        assertEquals("SELECT * FROM users WHERE username = 'alice'", q);
    }
}
