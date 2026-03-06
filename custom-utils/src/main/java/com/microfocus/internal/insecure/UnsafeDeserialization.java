package com.microfocus.internal.insecure;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Example: deserializes untrusted data using ObjectInputStream.
 */
public class UnsafeDeserialization {
    private static final Logger log = LogManager.getLogger(UnsafeDeserialization.class);

    public static Object deserialize(byte[] data) throws Exception {
        log.warn("Deserializing untrusted data (INSECURE)");
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object obj = ois.readObject();
        log.debug("Deserialized object of type: {}", obj == null ? "null" : obj.getClass().getName());
        return obj;
    }
}
