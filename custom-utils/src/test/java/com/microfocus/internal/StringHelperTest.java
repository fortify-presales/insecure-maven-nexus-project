package com.microfocus.internal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {

    @Test
    void shout_shouldUppercaseAndAddBang() {
        assertEquals("HELLO!", StringHelper.shout("hello"));
    }

    @Test
    void containsIgnoreCase_trueWhenPresent() {
        assertTrue(StringHelper.containsIgnoreCase("Hello Kevin", "kevin"));
    }
}
