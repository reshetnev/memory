package com.epam.reshetnev.memory.core.service;

import com.epam.reshetnev.memory.core.entity.Code;

public interface CodecService {

    public Code encrypt(Code code) throws Exception;

    public Code decrypt(Code code) throws Exception;
}
