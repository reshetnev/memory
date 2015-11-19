package com.epam.reshetnev.memory.core.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class CodecUtil {

    public static String encrypt(byte[] encryptionKey, String plainText) throws Exception {

        Cipher cipher = getCipher(encryptionKey, Cipher.ENCRYPT_MODE);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

        return Base64.encodeBase64String(encryptedBytes);
    }

    public static String decrypt(byte[] encryptionKey, String encrypted) throws Exception {

        Cipher cipher = getCipher(encryptionKey, Cipher.DECRYPT_MODE);
        byte[] plainBytes = cipher.doFinal(Base64.decodeBase64(encrypted));

        return new String(plainBytes);
    }

    private static Cipher getCipher(byte[] encryptionKey, int cipherMode) throws Exception {

        String encryptionAlgorithm = "AES";
        SecretKeySpec keySpecification = new SecretKeySpec(encryptionKey, encryptionAlgorithm);
        Cipher cipher = Cipher.getInstance(encryptionAlgorithm);
        cipher.init(cipherMode, keySpecification);

        return cipher;
    }
}
