package com.github.binjoo.repository;

import com.github.binjoo.model.entity.TypechoContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypechoContentRepository extends JpaRepository<TypechoContent, Integer>, JpaSpecificationExecutor<TypechoContent> {
    public List<TypechoContent> findByTypeOrderByOrderAscCreatedAsc(String type);

    public List<TypechoContent> findByTypeOrderByCreatedDesc(String type);

    public TypechoContent findBySlugAndType(String slug, String type);
}
