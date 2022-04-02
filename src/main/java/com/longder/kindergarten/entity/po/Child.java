package com.longder.kindergarten.entity.po;

import com.longder.kindergarten.entity.enumeration.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 娃实体
 */
@Entity
@Table(name = "CHILD")
@Getter
@Setter
public class Child extends BaseIdEntity{

    /**
     * 姓名
     */
    @Column(name = "name_")
    private String name;

    /**
     * 年龄
     */
    @Column(name = "age_")
    private Integer age;

    /**
     * 性别
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "gender_")
    private Gender gender;

    /**
     * 紧急联系人姓名
     */
    @Column(name = "emergency_contact_")
    private String emergencyContact;

    /**
     * 紧急联系人电话
     */
    @Column(name = "emergency_mobile_")
    private String emergencyMobile;

    /**
     * 关联家长
     */
    @ManyToOne
    @JoinColumn(name = "parent_id_",referencedColumnName = "id_")
    private SysUser parent;


}
