package com.github.binjoo.service;

import com.github.binjoo.model.entity.TypechoLink;
import com.github.binjoo.repository.TypechoLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liangj
 * @version 1.0
 * @date 2024-03-10 18:18
 */
@Service
public class TypechoLinkService {
    @Autowired
    private TypechoLinkRepository typechoLinkRepository;

    public List<TypechoLink> findByMidOrderByOrderAsc(Integer mid) {
        return typechoLinkRepository.findByMidOrderByOrderAsc(mid);
    }

}
