package com.github.binjoo.repository;

import com.github.binjoo.model.entity.TypechoField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TypechoFieldRepository extends JpaRepository<TypechoField, Integer>, JpaSpecificationExecutor<TypechoField> {
}