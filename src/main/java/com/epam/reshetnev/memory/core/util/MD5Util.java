package com.epam.reshetnev.memory.core.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

    public static byte[] md5Apache(String st) {

        byte[] hash = DigestUtils.md5(st);

        return hash;
    }
}
