package com.github.binjoo.forever.app;

import com.alibaba.fastjson.JSONArray;
import com.github.binjoo.forever.model.entity.TypechoComment;
import com.github.binjoo.forever.model.entity.TypechoContent;
import com.github.binjoo.forever.service.TypechoCommentService;
import com.github.binjoo.forever.service.TypechoContentService;
import com.github.binjoo.forever.utils.CommentUtils;
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
public class CommentApp extends AppInterface {
    @Autowired
    private TypechoContentService typechoContentService;
    @Autowired
    private TypechoCommentService typechoCommentService;

    @Override
    public void run() {
        List<TypechoContent> posts = typechoContentService.findByTypeOrderByOrderAscCreatedAsc("post");
        File path = new File("data/comments");
        if (!path.exists()) {
            path.mkdirs();
        }

        int commentNum = 0;
        for (int i = 0; i < posts.size(); i++) {
            Integer cid = posts.get(i).getCid();
            String slug = posts.get(i).getSlug();

            List<TypechoComment> items = typechoCommentService.findByCidOrderByCreatedAsc(cid);

            List<TypechoComment> parents = items.stream().filter(c -> c.getParent().intValue() == 0).toList();

            JSONArray comments = CommentUtils.children(parents, items);

            super.writer(comments.toJSONString(), path.getPath() + "/" + slug + ".json");
            commentNum += items.size();
        }
        log.info("评论 {} 条", commentNum);
    }

}
