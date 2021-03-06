package com.epam.reshetnev.memory.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epam.reshetnev.memory.core.entity.Code;

@Repository
public interface CodeRepository extends JpaRepository<Code, Integer> {

    @Query("select code from Code code where code.name = :name")
    public Code findByName(@Param("name") String name);

}
