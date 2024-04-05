package com.github.binjoo.repository;

import com.github.binjoo.model.entity.TypechoComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypechoCommentRepository extends JpaRepository<TypechoComment, Integer>, JpaSpecificationExecutor<TypechoComment> {
    List<TypechoComment> findByCidOrderByCreatedAsc(Integer cid);
}