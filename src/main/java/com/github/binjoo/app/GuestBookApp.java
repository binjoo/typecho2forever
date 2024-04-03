package com.github.binjoo.app;

import com.alibaba.fastjson.JSONArray;
import com.github.binjoo.model.entity.TypechoComment;
import com.github.binjoo.model.entity.TypechoContent;
import com.github.binjoo.service.TypechoCommentService;
import com.github.binjoo.service.TypechoContentService;
import com.github.binjoo.utils.CommentUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * @author liangj
 * @version 1.0
 * @date 2024-03-10 18:25
 */
@Component
@Slf4j
public class GuestBookApp extends AppInterface {
    @Autowired
    private TypechoContentService typechoContentService;
    @Autowired
    private TypechoCommentService typechoCommentService;

    @Override
    public void run() {
        TypechoContent page = typechoContentService.findBySlugAndType("guestbook", "page");

        File path = new File("data");
        if (!path.exists()) {
            path.mkdirs();
        }

        Integer cid = page.getCid();
        String slug = page.getSlug();

        List<TypechoComment> items = typechoCommentService.findByCidOrderByCreatedAsc(cid);

        List<TypechoComment> parents = items.stream().filter(c -> c.getParent().intValue() == 0).toList();

        JSONArray guestbook = CommentUtils.children(parents, items);

        super.writer(guestbook.toJSONString(), path.getPath() + "/guestbook.json");

        log.info("留言 {} 条", items.size());
    }

}
