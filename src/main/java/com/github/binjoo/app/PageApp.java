package com.github.binjoo.app;

import com.github.binjoo.model.entity.TypechoContent;
import com.github.binjoo.service.TypechoContentService;
import com.github.binjoo.service.TypechoMetaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author liangj
 * @version 1.0
 * @date 2024-03-10 18:25
 */
@Component
@Slf4j
public class PageApp extends AppInterface {
    @Autowired
    private TypechoContentService typechoContentService;
    @Autowired
    private TypechoMetaService typechoMetaService;

    @Override
    public void run() {
        String[] pages = new String[]{"about", "guestbook"};

        for (String slug : pages) {
            TypechoContent page = typechoContentService.findBySlugAndType(slug, "page");

            File path = new File("source/" + slug);
            if (!path.exists()) {
                path.mkdirs();
            }

            Integer cid = page.getCid();
            String title = page.getTitle();
            String content = page.getText();
            content = content.substring("<!--markdown-->".length());

            String md = """
                    ---
                    id: %s
                    title: %s
                    layout: %s
                    ---
                                                                                
                    %s
                    """.formatted(slug, title, slug, content);
            super.writer(md, path.getPath() + "/index.md");
        }
        log.info("独立页面 {} 篇", pages.length);
    }
}
