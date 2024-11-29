package org.example;

import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;


import java.util.Base64;

public class HmacUtils {

    public static String generateHmac(String key, String message) {
        try {

            byte[] keyBytes = key.getBytes();
            byte[] messageBytes = message.getBytes();


            HMac hmac = new HMac(new SHA3Digest(256));
            hmac.init(new KeyParameter(keyBytes));


            hmac.update(messageBytes, 0, messageBytes.length);
            byte[] result = new byte[hmac.getMacSize()];
            hmac.doFinal(result, 0);


            return Base64.getEncoder().encodeToString(result);

        } catch (Exception e) {
            throw new RuntimeException("Error generating HMAC", e);
        }
    }
}
