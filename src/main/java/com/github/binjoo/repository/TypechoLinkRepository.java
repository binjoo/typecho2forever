package com.github.binjoo.repository;

import com.github.binjoo.model.entity.TypechoLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypechoLinkRepository extends JpaRepository<TypechoLink, Integer>, JpaSpecificationExecutor<TypechoLink> {
    public List<TypechoLink> findByMidOrderByOrderAsc(Integer mid);
}