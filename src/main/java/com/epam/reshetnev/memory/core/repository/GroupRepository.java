package com.epam.reshetnev.memory.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epam.reshetnev.memory.core.entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

    @Query("select group from Group group where group.name = :name")
    public Group findByName(@Param("name") String name);

}
