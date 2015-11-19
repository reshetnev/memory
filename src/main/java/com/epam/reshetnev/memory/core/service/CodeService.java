package com.epam.reshetnev.memory.core.service;

import java.util.List;

import com.epam.reshetnev.memory.core.entity.Code;

public interface CodeService {

    public List<Code> getAll();

    public Code getById(Integer id) throws Exception;

    public Code add(Code code) throws Exception;

    public Code getByName(String name);

    public Code update(Integer id, Code newCode) throws Exception;

    public void delete(Integer id);

}
