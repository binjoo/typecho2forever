package com.github.binjoo.forever.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "typecho_contents")
public class TypechoContent implements Serializable {
    @Id
    @Column(name = "cid", nullable = false)
    private Integer cid;

    @Column(name = "title", length = 150)
    private String title;

    @Column(name = "slug", length = 150)
    private String slug;

    @Column(name = "created")
    private Long created;

    @Column(name = "modified")
    private Long modified;

    @Lob
    @Column(name = "text")
    private String text;

    @Column(name = "`order`")
    private Integer order;

    @Column(name = "authorId")
    private Integer authorId;

    @Column(name = "template", length = 32)
    private String template;

    @Column(name = "type", length = 16)
    private String type;

    @Column(name = "status", length = 16)
    private String status;

    @Column(name = "password", length = 32)
    private String password;

    @Column(name = "commentsNum")
    private Integer commentsNum;

    @Column(name = "allowComment")
    private Boolean allowComment;

    @Column(name = "allowPing")
    private Boolean allowPing;

    @Column(name = "allowFeed")
    private Boolean allowFeed;

    @Column(name = "parent")
    private Integer parent;

}