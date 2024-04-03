package com.github.binjoo.forever.repository;

import com.github.binjoo.forever.model.entity.TypechoRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TypechoRelationshipRepository extends JpaRepository<TypechoRelationship, Integer>, JpaSpecificationExecutor<TypechoRelationship> {
}