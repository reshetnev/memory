package com.epam.reshetnev.memory.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.reshetnev.memory.core.entity.Code;
import com.epam.reshetnev.memory.core.repository.CodeRepository;
import com.epam.reshetnev.memory.core.service.CodeService;
import com.epam.reshetnev.memory.core.service.CodecService;

@Service
public class CodeServiceImpl implements CodeService {

    private static final Logger LOG = Logger.getLogger(CodeServiceImpl.class);

    @Autowired
    private CodeRepository codeRepository;

    @Autowired
    private CodecService codecService;

    @Override
    public List<Code> getAll() {
        return codeRepository.findAll();
    }

    @Override
    @Transactional
    public Code add(Code code) throws Exception {

        Code savedCode = codeRepository.save(code);

        codecService.encrypt(savedCode);

        LOG.info("New code: [{}] successfully created " + savedCode.toString());

        return savedCode;
    }

    @Override
    public Code getById(Integer id) throws Exception {

        Code code = codeRepository.findOne(id);

        codecService.decrypt(code);

        return code;
    }

    @Override
    public Code getByName(String name) {
        return codeRepository.findByName(name);
    }

    @Override
    @Transactional
    public Code update(Integer id, Code newCode) throws Exception {

        Code code = codeRepository.findOne(id);
        code.setName(newCode.getName());
        code.setPassword(newCode.getPassword());

        codecService.encrypt(code);

        LOG.info("Code: [{}] successfully updated " + code.toString());

        return code;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        codeRepository.delete(id);
    }

}
