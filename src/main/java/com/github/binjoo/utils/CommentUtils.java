package com.github.binjoo.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.binjoo.model.entity.TypechoComment;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author liangj
 * @version 1.0
 * @date 2024-04-02 17:16
 */
public class CommentUtils {

    public static JSONArray children(List<TypechoComment> parents, List<TypechoComment> items) {
        JSONArray comments = new JSONArray();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < parents.size(); i++) {
            TypechoComment parent = parents.get(i);
            JSONObject comment = (JSONObject) JSONObject.toJSON(parent);
            comment.remove("authorId");
            comment.remove("ownerId");
            comment.remove("cid");
            comment.remove("type");
            comment.remove("status");
            comment.remove("parent");
            comment.remove("ip");
            comment.remove("agent");

            comment.put("created", sdf.format(parent.getCreated() * 1000));
            // comment.put("ua", UserAgentUtils.parseUserAgent(parent.getAgent()));
            comment.put("region", QQWryUtils.parseIp(parent.getIp()));
            comment.put("mailMd5", MD5Utils.encrypt(parent.getMail()));
            comment.put("mod", parent.getOwnerId() == 1);

            List<TypechoComment> childrens = items.stream().filter(c -> c.getParent().intValue() == parent.getCoid().intValue()).toList();

            JSONArray childComments = children(childrens, items);
            if (childComments != null && childComments.size() > 0) {
                comment.put("children", children(childrens, items));
            }
            comments.add(comment);
        }
        return comments;
    }
}
