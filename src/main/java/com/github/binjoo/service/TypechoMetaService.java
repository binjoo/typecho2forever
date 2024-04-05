package com.github.binjoo.service;

import com.github.binjoo.model.entity.TypechoMeta;
import com.github.binjoo.repository.TypechoMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liangj
 * @version 1.0
 * @date 2024-03-10 18:18
 */
@Service
public class TypechoMetaService {
    @Autowired
    private TypechoMetaRepository typechoMetaRepository;

    public List<TypechoMeta> findByCidOrderByOrderAscByMidAsc(Integer cid) {
        return typechoMetaRepository.findByCidOrderByOrderAscByMidAsc(cid);
    }

    public List<TypechoMeta> findByTypeOrderByOrderAsc(String type) {
        return typechoMetaRepository.findByTypeOrderByOrderAsc(type);
    }
}
