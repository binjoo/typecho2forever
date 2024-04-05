package com.github.binjoo.repository;

import com.github.binjoo.model.entity.TypechoMeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypechoMetaRepository extends JpaRepository<TypechoMeta, Integer>, JpaSpecificationExecutor<TypechoMeta> {
    @Query("select tm from TypechoMeta tm left join TypechoRelationship tr on tr.mid = tm.id where tr.cid = ?1 order by tm.order, tm.mid asc")
    List<TypechoMeta> findByCidOrderByOrderAscByMidAsc(Integer cid);

    List<TypechoMeta> findByTypeOrderByOrderAsc(String type);
}