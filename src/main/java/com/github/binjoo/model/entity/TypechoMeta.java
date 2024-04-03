package com.github.binjoo.model.entity;

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
@Table(name = "typecho_metas")
public class TypechoMeta implements Serializable {
    @Id
    @Column(name = "mid", nullable = false)
    private Integer mid;

    @Column(name = "name", length = 150)
    private String name;

    @Column(name = "slug", length = 150)
    private String slug;

    @Column(name = "type", nullable = false, length = 32)
    private String type;

    @Column(name = "description", length = 150)
    private String description;

    @Column(name = "count")
    private Integer count;

    @Column(name = "`order`")
    private Integer order;

    @Column(name = "parent")
    private Integer parent;

}