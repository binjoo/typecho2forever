package com.github.binjoo.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "typecho_relationships")
@IdClass(TypechoRelationship.class)
public class TypechoRelationship implements Serializable {
    @Id
    @Column(name = "cid", nullable = false)
    private Integer cid;

    @Id
    @Column(name = "mid", nullable = false)
    private Integer mid;
}