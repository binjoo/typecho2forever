package com.github.binjoo.forever.repository;

import com.github.binjoo.forever.model.entity.TypechoField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TypechoFieldRepository extends JpaRepository<TypechoField, Integer>, JpaSpecificationExecutor<TypechoField> {
}