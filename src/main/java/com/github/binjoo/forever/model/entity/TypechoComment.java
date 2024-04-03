package com.github.binjoo.forever.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "typecho_comments")
public class TypechoComment implements Serializable {
    @Id
    @Column(name = "coid", nullable = false)
    private Integer coid;

    @Column(name = "cid")
    private Integer cid;

    @Column(name = "created")
    private Long created;

    @Column(name = "author", length = 150)
    private String author;

    @Column(name = "authorId")
    private Integer authorId;

    @Column(name = "ownerId")
    private Integer ownerId;

    @Column(name = "mail", length = 150)
    private String mail;

    @Column(name = "url")
    private String url;

    @Column(name = "ip", length = 64)
    private String ip;

    @Column(name = "agent", length = 511)
    private String agent;

    @Lob
    @Column(name = "text")
    private String text;

    @Column(name = "type", length = 16)
    private String type;

    @Column(name = "status", length = 16)
    private String status;

    @Column(name = "parent")
    private Integer parent;

}