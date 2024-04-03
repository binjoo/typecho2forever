package com.github.binjoo.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.binjoo.model.entity.TypechoContent;
import com.github.binjoo.service.TypechoContentService;
import com.github.binjoo.service.TypechoMetaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author liangj
 * @version 1.0
 * @date 2024-03-10 18:25
 */
@Component
@Slf4j
public class SayApp extends AppInterface {
    @Autowired
    private TypechoContentService typechoContentService;
    @Autowired
    private TypechoMetaService typechoMetaService;

    @Override
    public void run() {
        List<TypechoContent> says = typechoContentService.findByTypeOrderByCreatedDesc("say");

        File path = new File("data");
        if (!path.exists()) {
            path.mkdirs();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        JSONArray datas = new JSONArray();
        for (int i = 0; i < says.size(); i++) {
            TypechoContent say = says.get(i);
            JSONObject data = new JSONObject();
            data.put("type", say.getTitle());
            data.put("slug", say.getSlug());
            data.put("text", JSON.parseObject(say.getText()));
            data.put("source", say.getTemplate());
            data.put("created", sdf.format(say.getCreated() * 1000));
            datas.add(data);
        }
        super.writer(datas.toJSONString(), path.getPath() + "/says.json");
        log.info("碎语 {} 条", says.size());
    }
}
