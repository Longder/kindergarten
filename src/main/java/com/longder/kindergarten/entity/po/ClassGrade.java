package com.longder.kindergarten.entity.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 班级实体
 */
@Entity
@Table(name = "CLASS_GRADE")
@Getter
@Setter
public class ClassGrade extends BaseIdEntity{
    /**
     * 班级名称
     */
    @Column(name = "name_")
    private String name;

    /**
     * 创建日期
     */
    @Column(name = "create_date_")
    private LocalDate createDate;

    /**
     * 负责老师
     */
    @ManyToOne
    @JoinColumn(name = "teacher_id_",referencedColumnName = "id_")
    private SysUser teacher;

    /**
     * 不持久化，前端传递id
     */
    @Transient
    private Long teacherId;
}
