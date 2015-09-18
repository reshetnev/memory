package com.epam.reshetnev.memory.core.service;

import java.util.List;

import com.epam.reshetnev.memory.core.entity.Code;

public interface CodeService {

    public List<Code> getAll();

    public Code getById(Integer id);

    public Code add(Code code);

    public Code getByName(String name);

    public Code update(Integer id, Code newCode);

    public void delete(Integer id);

}
