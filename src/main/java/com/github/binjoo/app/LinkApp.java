package com.github.binjoo.app;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.binjoo.model.entity.TypechoLink;
import com.github.binjoo.model.entity.TypechoMeta;
import com.github.binjoo.service.TypechoLinkService;
import com.github.binjoo.service.TypechoMetaService;
import com.github.binjoo.utils.MD5Utils;
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
public class LinkApp extends AppInterface {
    @Autowired
    private TypechoLinkService typechoLinkService;
    @Autowired
    private TypechoMetaService typechoMetaService;

    @Override
    public void run() {
        File path = new File("data");
        if (!path.exists()) {
            path.mkdirs();
        }

        List<TypechoMeta> typechoMetas = typechoMetaService.findByTypeOrderByOrderAsc("link");

        JSONArray datas = new JSONArray();
        int linkNum = 0;
        for (int i = 0; i < typechoMetas.size(); i++) {
            TypechoMeta typechoMeta = typechoMetas.get(i);
            JSONObject meta = new JSONObject();
            meta.put("name", typechoMeta.getName());
            meta.put("description", typechoMeta.getDescription());

            List<TypechoLink> typechoLinks = typechoLinkService.findByMidOrderByOrderAsc(typechoMeta.getMid());
            JSONArray links = new JSONArray();
            for (int j = 0; j < typechoLinks.size(); j++) {
                TypechoLink typechoLink = typechoLinks.get(j);
                JSONObject link = new JSONObject();
                link.put("name", typechoLink.getTitle());
                link.put("url", typechoLink.getUrl());
                link.put("mail", typechoLink.getIcon());
                link.put("mailMd5", MD5Utils.encrypt(typechoLink.getIcon()));
                link.put("description", typechoLink.getDescription());
                link.put("status", typechoLink.getStatus());
                links.add(link);
                linkNum++;
            }
            meta.put("links", links);
            datas.add(meta);
        }

        super.writer(datas.toJSONString(), path.getPath() + "/friends.json");
        log.info("链接 {} 条", linkNum);
    }
}
