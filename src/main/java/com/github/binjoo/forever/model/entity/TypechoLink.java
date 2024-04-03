package com.github.binjoo.forever.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "typecho_links")
public class TypechoLink implements Serializable {
    @Id
    @Column(name = "lid", nullable = false)
    private Integer lid;

    @Column(name = "mid")
    private Integer mid;

    @Column(name = "title", length = 128)
    private String title;

    @Column(name = "url", length = 256)
    private String url;

    @Column(name = "icon", length = 256)
    private String icon;

    @Column(name = "description", length = 256)
    private String description;

    @Column(name = "status")
    private Integer status;

    @Column(name = "`order`")
    private Integer order;

}