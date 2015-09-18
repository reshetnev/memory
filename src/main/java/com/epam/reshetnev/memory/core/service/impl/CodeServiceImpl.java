package com.epam.reshetnev.memory.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.reshetnev.memory.core.entity.Code;
import com.epam.reshetnev.memory.core.repository.CodeRepository;
import com.epam.reshetnev.memory.core.service.CodeService;

@Service
public class CodeServiceImpl implements CodeService {

    private static final Logger LOG = Logger.getLogger(CodeServiceImpl.class);

    @Autowired
    private CodeRepository codeRepository;

    @Override
    @Transactional
    public List<Code> getAll() {
        return codeRepository.findAll();
    }

    @Override
    @Transactional
    public Code add(Code code) {

        Code savedCode = codeRepository.save(code);

        LOG.info("New code: [{}] successfully created " + savedCode.toString());

        return savedCode;
    }

    @Override
    @Transactional
    public Code getById(Integer id) {
        return codeRepository.findOne(id);
    }

    @Override
    @Transactional
    public Code getByName(String name) {
        return codeRepository.findByName(name);
    }

    @Override
    @Transactional
    public Code update(Integer id, Code newCode) {

        Code code = codeRepository.getOne(id);
        code.setName(newCode.getName());
        code.setPassword(newCode.getPassword());

        Code updatedCode = codeRepository.save(code);

        LOG.info("Code: [{}] successfully updated " + updatedCode.toString());

        return updatedCode;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        codeRepository.delete(id);
    }

}
