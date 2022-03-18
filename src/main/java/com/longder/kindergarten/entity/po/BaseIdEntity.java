package com.longder.kindergarten.entity.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 带主键标识的实体父类
 */
@MappedSuperclass
@Getter
@Setter
public class BaseIdEntity extends BaseEntity{

    @Id
    @Column(name = "id_")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
}
