package com.github.binjoo.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "typecho_users")
public class TypechoUser implements Serializable {
    @Id
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "name", length = 32)
    private String name;

    @Column(name = "password", length = 64)
    private String password;

    @Column(name = "mail", length = 150)
    private String mail;

    @Column(name = "url", length = 150)
    private String url;

    @Column(name = "screenName", length = 32)
    private String screenName;

    @Column(name = "created")
    private Long created;

    @Column(name = "activated")
    private Integer activated;

    @Column(name = "logged")
    private Integer logged;

    @Column(name = "`group`", length = 16)
    private String group;

    @Column(name = "authCode", length = 64)
    private String authCode;

}