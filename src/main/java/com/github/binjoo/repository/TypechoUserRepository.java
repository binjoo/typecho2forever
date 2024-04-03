package com.github.binjoo.repository;

import com.github.binjoo.model.entity.TypechoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TypechoUserRepository extends JpaRepository<TypechoUser, Integer>, JpaSpecificationExecutor<TypechoUser> {
}