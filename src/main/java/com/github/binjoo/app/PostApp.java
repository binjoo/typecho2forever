package com.github.binjoo.app;

import com.github.binjoo.model.entity.TypechoContent;
import com.github.binjoo.model.entity.TypechoMeta;
import com.github.binjoo.service.TypechoContentService;
import com.github.binjoo.service.TypechoMetaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/**
 * @author liangj
 * @version 1.0
 * @date 2024-03-10 18:25
 */
@Component
@Slf4j
public class PostApp extends AppInterface {
    @Autowired
    private TypechoContentService typechoContentService;
    @Autowired
    private TypechoMetaService typechoMetaService;

    @Override
    public void run() {
        List<TypechoContent> posts = typechoContentService.findByTypeOrderByOrderAscCreatedAsc("post");

        File path = new File("source/_posts");
        if (!path.exists()) {
            path.mkdirs();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int postNum = 0;

        for (int i = 0; i < posts.size(); i++) {
            TypechoContent post = posts.get(i);
            Integer cid = post.getCid();
            String title = post.getTitle();
            String slug = post.getSlug();
            Boolean allowComment = post.getAllowComment();
            String content = post.getText();
            content = content.substring("<!--markdown-->".length());
            String created = sdf.format(post.getCreated() * 1000);
            String modified = sdf.format(post.getModified() * 1000);

            List<TypechoMeta> metas = typechoMetaService.findByCidOrderByOrderAscByMidAsc(cid);

            String[] tags = metas.stream().filter(m -> m.getType().equals("tag")).map(m -> m.getName()).toArray(size -> new String[size]);
            String[] categories = metas.stream().filter(m -> m.getType().equals("category")).map(m -> m.getName()).toArray(size -> new String[size]);

            String md = """
                    ---
                    type: post
                    id: %s
                    title: %s
                    date: %s
                    updated: %s
                    categories: %s
                    tags: %s
                    comments: %s
                    ---
                                        
                    %s
                    """.formatted(slug, title, created, modified, Arrays.toString(categories), Arrays.toString(tags), allowComment, content);
            super.writer(md, path.getPath() + "/" + post.getSlug() + ".md");
            postNum++;
        }
        log.info("日志 {} 篇", postNum);
    }
}
