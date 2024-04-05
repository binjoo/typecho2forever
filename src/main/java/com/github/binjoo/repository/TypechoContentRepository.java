package com.github.binjoo.repository;

import com.github.binjoo.model.entity.TypechoContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypechoContentRepository extends JpaRepository<TypechoContent, Integer>, JpaSpecificationExecutor<TypechoContent> {
    List<TypechoContent> findByTypeOrderByOrderAscCreatedAsc(String type);

    List<TypechoContent> findByTypeOrderByCreatedDesc(String type);

    TypechoContent findBySlugAndType(String slug, String type);
}
