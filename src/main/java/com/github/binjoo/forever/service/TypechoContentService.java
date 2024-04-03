package com.github.binjoo.forever.service;

import com.github.binjoo.forever.model.entity.TypechoContent;
import com.github.binjoo.forever.repository.TypechoContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liangj
 * @version 1.0
 * @date 2024-03-10 18:18
 */
@Service
public class TypechoContentService {
    @Autowired
    private TypechoContentRepository typechoContentRepository;

    public List<TypechoContent> findByTypeOrderByOrderAscCreatedAsc(String type) {
        return typechoContentRepository.findByTypeOrderByOrderAscCreatedAsc(type);
    }

    public List<TypechoContent> findByTypeOrderByCreatedDesc(String type) {
        return typechoContentRepository.findByTypeOrderByCreatedDesc(type);
    }

    public TypechoContent findBySlugAndType(String slug, String type) {
        return typechoContentRepository.findBySlugAndType(slug, type);
    }
}
