package com.epam.reshetnev.memory.core.service.impl;

import org.springframework.stereotype.Service;

import com.epam.reshetnev.memory.core.entity.Code;
import com.epam.reshetnev.memory.core.service.CodecService;
import com.epam.reshetnev.memory.core.util.CodecUtil;
import com.epam.reshetnev.memory.core.util.MD5Util;

@Service
public class CodecServiceImpl implements CodecService {

    @Override
    public Code encrypt(Code code) throws Exception {

        byte[] encryptionKey = getEncryptionKey(code);
        String encryptedPsw = CodecUtil.encrypt(encryptionKey, code.getPassword());
        code.setPassword(encryptedPsw);

        return code;
    }

    @Override
    public Code decrypt(Code code) throws Exception {

        byte[] encryptionKey = getEncryptionKey(code);
        String decryptedPsw = CodecUtil.decrypt(encryptionKey, code.getPassword());
        code.setPassword(decryptedPsw);

        return code;
    }

    private byte[] getEncryptionKey(Code code) {

        String key = code.getName();
        byte[] encryptionKey = MD5Util.md5Apache(key);

        return encryptionKey;
    }

}
