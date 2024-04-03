package com.github.binjoo.forever.service;

import com.github.binjoo.forever.model.entity.TypechoComment;
import com.github.binjoo.forever.repository.TypechoCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liangj
 * @version 1.0
 * @date 2024-03-10 18:18
 */
@Service
public class TypechoCommentService {
    @Autowired
    private TypechoCommentRepository typechoCommentRepository;

    public List<TypechoComment> findByCidOrderByCreatedAsc(Integer cid) {
        return typechoCommentRepository.findByCidOrderByCreatedAsc(cid);
    }
}
