package com.github.binjoo.forever.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "typecho_fields")
@IdClass(TypechoField.class)
public class TypechoField implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Lob
    @Column(name = "str_value")
    private String strValue;

    @Column(name = "int_value")
    private Integer intValue;

    @Column(name = "float_value")
    private Float floatValue;

}