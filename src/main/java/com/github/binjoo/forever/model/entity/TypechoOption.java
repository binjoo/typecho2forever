package com.github.binjoo.forever.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "typecho_options")
@IdClass(TypechoOption.class)
public class TypechoOption implements Serializable {
    @Id
    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "user")
    private Integer user;

    @Lob
    @Column(name = "value")
    private String value;

}